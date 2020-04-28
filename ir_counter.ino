/* 
  IR sensor - WPS-SMVN 
  Detector distance : 1.5[m]
  Output : NPN Current
*/ 


// #1. 초기 변수(Parameter) 설정
int sensorPin01 = A0;   // IR Sensor01 PIN Number
int sensorPin02 = A1;   // IR Sensor02 PIN Number
int sensorValue01 = 0;  // Sensor Value Parameter
int sensorValue02 = 0;

int counter = 0;        // Person Counter
int s1 = 0;             // Sensor01 Temporary Value
int s2 = 0;             // Sensor02 Temporary Value
int s_time = 0;         // Temporary Value Time


// #2. Setup
void setup() {
  Serial.begin(9600);             // Computer Serial Strat
  pinMode(sensorPin01, INPUT);    // sensorPin01 is Input
  pinMode(sensorPin02, INPUT);    // sensorPin02 is Input
  pinMode(LED_BUILTIN, OUTPUT);     // When an object is detected, LED on
}


// #3. Loop문
void loop() {

  // IR Sensor READ
  sensorValue01 = analogRead(sensorPin01);  // 
  sensorValue02 = analogRead(sensorPin02);  // 

  if ( (sensorValue01 < 800 && sensorValue02 < 800)  ) {
    Serial.println("[Alert] Both Input!");
  } else if (sensorValue01 < 800) {      // 센서01(외부) 물체 감지 (적외선 신호 없을 때)
    if (s2 == 1) {       // 안쪽 센서에서 먼저 인식된 경우
      counter--;        // 카운터 빼기
      s2 = 0;           // 안쪽 센서 초기화
      s_time = 0;       // 센서 값 임시 저장 타이머 초기화
      digitalWrite(LED_BUILTIN, HIGH);  // 보드 
      delay(2000);       // 입장 카운터 올라가는 거 방지
      digitalWrite(LED_BUILTIN, LOW);
    } else {
      s1 = 1;           // 내부 센서 인식
      s_time = 3 * 10;
    }
  } else if (sensorValue02 < 800) {      // 센서02(내부) 물체 감지
    if (s1 == 1) {
      counter++;
      s1 = 0;
      s_time = 0;
      digitalWrite(LED_BUILTIN, HIGH);
      delay(2000);
      digitalWrite(LED_BUILTIN, LOW);
    } else {
      s2 = 1;
      s_time = 3 * 10;
    }
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
  Serial.println(counter);
  
  Serial.print("s1: ");
  Serial.print(s1);
  Serial.print("\ts2: ");
  Serial.println(s2);
  
  Serial.print("sensorValue01: ");
  Serial.print(sensorValue01);
  Serial.print("\tsensorValue02: ");
  Serial.println(sensorValue02);

  Serial.print("s_time: ");
  Serial.println(s_time);

  // #5. delay
  delay(500); // System delay
}
