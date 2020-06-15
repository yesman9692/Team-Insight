package com.example.chenlian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class conven extends AppCompatActivity {

    int button_arr[] = {R.id.con_natu, R.id.con_clc,
                        R.id.con_dormi, R.id.con_seven};

    Button btn_refresh;
    Button btn_back;

    String datas[];

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

        Intent r_data = getIntent();

        String data = r_data.getExtras().getString("data");
        datas = data.split("/");

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
                        String sevText = "";
                        sevText += "세븐일레븐\n";

                        String con_seven_data[] = datas[1].split(" ");
                        sevText += con_seven_data[1];

                        btn_in.setText(sevText);
                        break;
                }
            }
        };

        for (int i : button_arr) {
            findViewById(i).setOnClickListener(listener);
        }

    }
}
