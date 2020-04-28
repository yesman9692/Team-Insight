package com.example.chenlian;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    // 버튼 목록
    int button_arr[] = {R.id.conven, R.id.bookcafe,
                        R.id.library, R.id.restaurant};

    Button btn_refresh;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_refresh = findViewById(R.id.refresh);
        btn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate(); // 앱 재시작
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn_in = (Button) v;

                switch (v.getId()) {
                    case R.id.conven:
                        Intent con_intent = new Intent(MainActivity.this, conven.class);
                        startActivity(con_intent);
                        break;
                    case R.id.bookcafe:
                        Intent bc_intent = new Intent(MainActivity.this, bookcafe.class);
                        startActivity(bc_intent);
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
    }

}
