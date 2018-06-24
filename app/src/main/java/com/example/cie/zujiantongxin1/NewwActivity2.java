package com.example.cie.zujiantongxin1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewwActivity2 extends AppCompatActivity {
    Button save, cancle;
    EditText infor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);

        save = findViewById(R.id.save);
        cancle = findViewById(R.id.cancle);
        infor = findViewById(R.id.editText);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = infor.getText().toString();
                System.out.println(info);
                Uri data = Uri.parse(info);
                Intent result = new Intent(null, data);
                setResult(RESULT_OK, result);
                finish();
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }
}
