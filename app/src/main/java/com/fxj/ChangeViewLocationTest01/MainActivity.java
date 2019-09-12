package com.fxj.ChangeViewLocationTest01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =MainActivity.class.getSimpleName();
    private TextView tv;
    private Button btn;

    private int screenWidth;
    private Handler mHandler;

    private static final int MSG_CHANGE_LOCATION=0X01;
    private static final long DELAY_MILLIS=500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        screenWidth =DisplayUtils.getScreenWidth(this);
        tv.setX(screenWidth);

        this.mHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int msgCode=msg.what;
                switch (msgCode){
                    case MSG_CHANGE_LOCATION:
                        String msgStr="handleMessage tv.getX()="+tv.getX();
                        Log.d(TAG,msgStr);
                        float x =tv.getX()-50;
                        if(x<-tv.getWidth()){
                            x =screenWidth;
                        }
                        tv.setX(x);
                        sendEmptyMessageDelayed(MSG_CHANGE_LOCATION,DELAY_MILLIS);
                        break;
                    default:
                        break;
                }
            }
        };

        this.mHandler.sendEmptyMessageDelayed(MSG_CHANGE_LOCATION,DELAY_MILLIS);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String msg="Button Click screenWidth="+ screenWidth +",tv.getX()="+tv.getX();
                Log.d(TAG,msg);
                float x =tv.getX()-50;
                if(x<-tv.getWidth()){
                    x =DisplayUtils.getScreenWidth(v.getContext());
                }
                tv.setX(x);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"TextView被点击了!");
            }
        });

    }
}
