package com.example.chenlian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bookcafe extends AppCompatActivity {

    // 버튼 목록
    int button_arr[] = {R.id.bc_mid, R.id.bc_left};

    Button btn_refresh;
    Button btn_back;

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

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_in = (Button) v;

                switch (v.getId()) {
                    case R.id.bc_mid:
                        btn_in.setText("공대 중앙\n북카페\nNo Data!");
                        break;
                    case R.id.bc_left:
                        btn_in.setText("공대 좌측\n북카페\nNo Data!");
                        break;
                }
            }
        };


        for (int i : button_arr) {
            findViewById(i).setOnClickListener(listener);
        }
    }
}
