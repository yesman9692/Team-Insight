package com.example.chenlian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bookcafe extends AppCompatActivity {

    // 버튼 목록
    int button_arr[] = {R.id.bc_mid, R.id.bc_left};

    Button btn_refresh;
    Button btn_back;

    String datas[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookcafe);

        btn_refresh = findViewById(R.id.refresh);
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate(); // 앱 재시작
            }
        });

        btn_back = findViewById(R.id.back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent r_data = getIntent();

        String data = r_data.getExtras().getString("data");
        datas = data.split("/");

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_in = (Button) v;

                switch (v.getId()) {
                    case R.id.bc_mid:
                        btn_in.setText("공대 중앙\n북카페\nNo Data!");
                        break;
                    case R.id.bc_left:
                        String blText = "";
                        blText+= "공대 좌측\n북카페\n";

                        String bc_left_data[] = datas[0].split(" ");
                        blText += bc_left_data[1];

                        btn_in.setText(blText);
                        break;
                }
            }
        };


        for (int i : button_arr) {
            findViewById(i).setOnClickListener(listener);
        }
    }
}
