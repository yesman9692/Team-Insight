package com.example.chenlian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class conven extends AppCompatActivity {

    int button_arr[] = {R.id.con_natu, R.id.con_clc,
                        R.id.con_dormi, R.id.con_seven};

    Button btn_refresh;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conven);

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
                    case R.id.con_natu:
                        btn_in.setText("자연대 편의점\nNo Data!");
                        break;
                    case R.id.con_clc:
                        btn_in.setText("CLC 편의점\nNo Data!");
                        break;
                    case R.id.con_dormi:
                        btn_in.setText("기숙사 편의점\nNo Data!");
                        break;
                    case R.id.con_seven:
                        btn_in.setText("세븐일레븐\nNo Data!");
                        break;
                }
            }
        };

        for (int i : button_arr) {
            findViewById(i).setOnClickListener(listener);
        }

    }
}
