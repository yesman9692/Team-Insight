package com.example.chenlian;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // 버튼 목록
    int button_arr[] = {R.id.conven, R.id.bookcafe,
                        R.id.library, R.id.restaurant};

    Button btn_refresh;

    // 웹 파싱을 위한 변수
    private String URL = "http://115.31.121.82/toAndroid.php";
    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat;
    Button htmlTitleButton;
    JsuopAsyncTask jsuopAsyncTask;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webParse();

        btn_refresh = findViewById(R.id.refresh);
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate(); // 앱 재시작 (새로고침 역할로 사용하는 중)
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_in = (Button) v;

                switch (v.getId()) {
                    case R.id.conven:
                        Intent con_data = new Intent(getApplicationContext(), conven.class);
                        con_data.putExtra("data", htmlContentInStringFormat);
                        startActivity(con_data);
                        break;
                    case R.id.bookcafe:
                        Intent bc_data = new Intent(getApplicationContext(), bookcafe.class);
                        bc_data.putExtra("data", htmlContentInStringFormat);
                        startActivity(bc_data);
                        break;
                    case R.id.library:
                        btn_in.setText("도서관\nNo Data!");
                        break;
                    case R.id.restaurant:
                        btn_in.setText("학생식당\nNo Data!");
                        break;
                }
            }
        };

        for (int ar : button_arr) {
            findViewById(ar).setOnClickListener(listener);
        }

        // 웹 파싱 시작 - 테스트용
//        textviewHtmlDocument = findViewById(R.id.testt);
//        textviewHtmlDocument.setMovementMethod(new ScrollingMovementMethod());
//
//        htmlTitleButton = findViewById(R.id.btn_testt);
//        htmlTitleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                webParse();
//                Log.d("wpp", "onClick Working!");
//            }
//        });

    }

    // 웹 파싱 메서드
    private void webParse() {
        jsuopAsyncTask = new JsuopAsyncTask();
        jsuopAsyncTask.execute();
        Log.d("wpp", "webParse func working!");
    }

    private class JsuopAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            Log.d("wpp", "onPreExecute Working!");
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            Log.d("wpp", "doInBackground Working!");
            try {
                Document doc = Jsoup.connect(URL).timeout(5000).get();
                htmlContentInStringFormat = doc.text();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("wpp", e.toString());
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.d("wpp", "onPostExecute Working!");
//            textviewHtmlDocument.setText(htmlContentInStringFormat + " ");
        }
    }
}


// 참고자료 : https://webnautes.tistory.com/784