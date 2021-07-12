package com.gomsinpark.makeeat_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(), 3000); // 1초 후에 hd handler 실행  3000ms = 3초







    }

    private class splashhandler implements Runnable{
        public void run(){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            //첫화면이 로그인 상태가 아니면 홈화면이 아닌 로그인화면으로 이동
            if ( user == null ) {
                startActivity(new Intent(getApplication(), Login_Activity.class)); //로딩이 끝난 후, ChoiceFunction 이동
                Splash_Activity.this.finish(); // 로딩페이지 Activity stack에서 제거
            }else {
                //로그인상태면 홈화면으로 이동
                startActivity(new Intent(getApplication(), HomeFrame_Activity.class));
                Splash_Activity.this.finish();
            }
        }
    }//핸들러


    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }





}