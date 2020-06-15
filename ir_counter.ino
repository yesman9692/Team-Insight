#include <string.h>
#include "ESP8266.h"
#include <SoftwareSerial.h>

#define SSID        "AndroidHotspot8709"
#define PASSWORD    "kuroneko"
#define HOST_NAME   "115.31.121.82"
#define HOST_PORT   (80)

// LED Number
#define R 5 // Red
#define G 6 // Green
#define B 7 // Blues
#define out 2 // Out
#define in 3 // in

// Timer
int timer = 0;
int setTime = 7; // seconds

// #1. IR 센서 초기 변수(Parameter) 설정
int sensorPin01 = A0;   // IR Sensor01 PIN Number
int sensorPin02 = A1;   // IR Sensor02 PIN Number
int sensorValue01 = 0;  // Sensor Value Parameter
int sensorValue02 = 0;

int counter = 0;        // Person Counter
int s1 = 0;             // Sensor01 Temporary Value
int s2 = 0;             // Sensor02 Temporary Value
int s_time = 0;         // Temporary Value Time

SoftwareSerial mySerial(10, 9); /* TX:D10, RX:D9 */
ESP8266 wifi(mySerial);

void setup(void)
{
  // OUTPUT MODE SETTING
  pinMode(5, OUTPUT); // Red
  pinMode(6, OUTPUT); // Green
  pinMode(7, OUTPUT); // Blue
  pinMode(2, OUTPUT); // out
  pinMode(3, OUTPUT); // in

  Serial.begin(9600);
  Serial.print("setup begin\r\n");

  // ir
  pinMode(sensorPin01, INPUT);    // sensorPin01 is Input
  pinMode(sensorPin02, INPUT);    // sensorPin02 is Input
  pinMode(LED_BUILTIN, OUTPUT);     // When an object is detected, LED on

  // wifi
  Serial.println("ESP8266 connect");
  boolean connected = false;
  
  for(;;) {
    if(connectWiFi()) {
      connected = true;
      break;
    }
  }
  
  if (!connected) {while(1);}  
  delay(5000);  
  mySerial.println("AT+CIPMUX=0");  
    
  Serial.print("setup end\r\n");
  pinMode(LED_BUILTIN, OUTPUT);
}

void loop(void) {
  if ( (timer % (10 * 1 * 25)) == 0) sendValue(counter);
  ir_led();
  
  timer++; // timer add
  Serial.print("Tiemr : ");
  Serial.println(timer);

  delay(200);
}

// ir_func
void ir_led() {
  digitalWrite(G, HIGH);
  digitalWrite(R, LOW);
  
  ir_counter();
}

// ir_counter_func
void ir_counter() {
  Serial.println("ir_counter Start!");
  
  // IR Sensor READ
  sensorValue01 = analogRead(sensorPin01);  // 
  sensorValue02 = analogRead(sensorPin02);  // 

  if ( (sensorValue01 < 800 && sensorValue02 < 800)  ) {
    Serial.println("[Alert] Both Input!");
//    digitalWrite(in, HIGH);
//    digitalWrite(out, HIGH);
  } else if (sensorValue01 < 800) {      // 센서01(외부) 물체 감지 (적외선 신호 없을 때)
//    digitalWrite(out, HIGH);
//    digitalWrite(in, LOW);
    if (s2 == 1) {       // 안쪽 센서에서 먼저 인식된 경우
      counter--;        // 카운터 빼기
      s2 = 0;           // 안쪽 센서 초기화
      s_time = 0;       // 센서 값 임시 저장 타이머 초기화
      digitalWrite(LED_BUILTIN, HIGH);  // 보드 
      delay(2000);       // 입장 카운터 올라가는 거 방지
      digitalWrite(LED_BUILTIN, LOW);
    } else {
      s1 = 1;           // 내부 센서 인식
      s_time = setTime;
    }
  } else if (sensorValue02 < 800) {      // 센서02(내부) 물체 감지
//    digitalWrite(in, HIGH);
//    digitalWrite(out, LOW);
    if (s1 == 1) {
      counter++;
      s1 = 0;
      s_time = 0;
      digitalWrite(LED_BUILTIN, HIGH);
      delay(2000);
      digitalWrite(LED_BUILTIN, LOW);
    } else {
      s2 = 1;
      s_time = setTime;
    }
  } else {
//    digitalWrite(in, LOW);
//    digitalWrite(out, LOW);
  }

  // 이미 끝난 시점에서 센서에 중복 입력되는 것을 방지하기 위한 타이머
  if (s_time > 0) {
    if (s_time == 1) {
      s1 = 0;
      s2 = 0;
    }
    s_time--;
  }
  
  // #4. Output to Computer
  Serial.print("Counter: ");
  Serial.print(counter);
  
  Serial.print("\ts1: ");
  Serial.print(s1);
  Serial.print("\ts2: ");
  Serial.print(s2);
  
  Serial.print("\tsensorValue01: ");
  Serial.print(sensorValue01);
  Serial.print("\tsensorValue02: ");
  Serial.print(sensorValue02);

  Serial.print("\ts_time: ");
  Serial.println(s_time);

  // #5. delay
  delay(200); // System delay

  Serial.println("ir_counter End!");
}

// wifi_func
void wifi_connection() {
  Serial.println("wifi_connection Start!");
  connectWiFi();
  Serial.println("wifi_connection End!");
}

char * floatToString(char * outstr, double val, byte precision, byte widthp){  
  char temp[16]; //increase this if you need more digits than 15  
  byte i;  
  
  temp[0]='\0';  
  outstr[0]='\0';  
  
  if(val < 0.0){  
    strcpy(outstr,"-\0");  //print "-" sign  
    val *= -1;  
  }  
  
  if( precision == 0) {  
    strcat(outstr, ltoa(round(val),temp,10));  //prints the int part  
  } else {  
    unsigned long frac, mult = 1;
    byte padding = precision-1;

    while (precision--) mult *= 10;
    val += 0.5/(float)mult;      // compute rounding factor  
     
    strcat(outstr, ltoa(floor(val),temp,10));  //prints the integer part without rounding  
    strcat(outstr, ".\0"); // print the decimal point  
  
    frac = (val - floor(val)) * mult;  
    unsigned long frac1 = frac;  
    
    while(frac1 /= 10) padding--;
    while(padding--) strcat(outstr,"0\0");    // print padding zeros  
    strcat(outstr,ltoa(frac,temp,10));  // print fraction part  
  }  
  
 // generate width space padding   
  if ((widthp != 0)&&(widthp >= strlen(outstr))){  
    byte J=0;  
    J = widthp - strlen(outstr);  
  
    for (i=0; i< J; i++) {  
      temp[i] = ' ';  
    }  
  
    temp[i++] = '\0';  
    strcat(temp, outstr);  
    strcpy(outstr, temp);  
  }  
  return outstr;  
}

void sendValue(int value) {
  digitalWrite(G, LOW);
  digitalWrite(R, HIGH);
  
  Serial.print("\nValue : ");
  Serial.print(value);

  char s[80];
  sprintf(s, "문자 = %0.3f\n", value);
  
  String cmd = "AT+CIPSTART=\"TCP\",\"";  
  cmd += HOST_NAME;  
  cmd += "\",80";
  Serial.println(cmd);
  mySerial.println(cmd);
  
  if(mySerial.find("Error"))  {  
    Serial.println( "TCP connect error" );  
    return;  
  }  

  char test[20];  
  String temp(floatToString(test, value, 2, 0));\
      
  cmd = "GET /insert_data2.php?num="+temp+"\r\n";  
  mySerial.print("AT+CIPSEND=");  
  mySerial.println(cmd.length());  
             
  Serial.println(cmd);  
  if(mySerial.find(">")) {
    Serial.print(">");
  } else {
    mySerial.println("AT+CIPCLOSE");  
    Serial.println("connect timeout");
    delay(1000);  
    return;
  }  
         
  mySerial.print(cmd);  
  delay(2000);  
  
  while (Serial.available()) {
    char c = Serial.read();  
    mySerial.write(c);  
    if(c=='\r') mySerial.print('\n');  
  }  
  Serial.println("====");  
  delay(1000);
}

//와이파이연결
boolean connectWiFi() { 
//  mySerial.println("AT+CWMODE=1");
  
  String cmd="AT+CWJAP=\"";
  cmd+=SSID;
  cmd+="\",\"";
  cmd+= PASSWORD;
  cmd+="\"";
  mySerial.println(cmd);
  Serial.println(cmd);
  delay(3000);

  if(mySerial.find("OK")) {
    Serial.println("OK, Connected to WiFi.");
    digitalWrite(B, HIGH);
    return true;
  } else {
    Serial.println("Can not connect to the WiFi.");
    return false;
  }
}
