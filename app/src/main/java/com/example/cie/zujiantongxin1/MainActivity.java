package com.example.cie.zujiantongxin1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Button mButtonExplicit, mButtonimplicit, mButtonExplicit2;
    TextView view;
    final int SUBACTIVITY1=1, SUBACTIVITY2=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mButtonExplicit = (Button)findViewById(R.id.button);
        mButtonExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivityForResult(intent, SUBACTIVITY1);
            }
        });

        mButtonimplicit = (Button)findViewById(R.id.button2);
        mButtonimplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        mButtonExplicit2 = findViewById(R.id.button4);
        mButtonExplicit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewwActivity2.class);
                startActivityForResult(intent, SUBACTIVITY2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        view = findViewById(R.id.textView3);
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case SUBACTIVITY2:
                if(resultCode==RESULT_OK){
                    Uri uriData = data.getData();
                    System.out.println(uriData.toString());
                    view.setText(uriData.toString());
                }
                break;
            case SUBACTIVITY1:
                break;
        }
    }
}
