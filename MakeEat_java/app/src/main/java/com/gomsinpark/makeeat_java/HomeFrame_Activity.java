package com.gomsinpark.makeeat_java;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseUser;

public class HomeFrame_Activity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Home_Activity activity_home;
    private Star_Activity activity_star;
    private Person_Activity activity_person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_frame_);

        bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){ // ItemId 가져오기
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_star:
                        setFrag(1);
                        break;
                    case R.id.action_person:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });

        activity_star = new Star_Activity(); // 객체 생성
        activity_person = new Person_Activity();
        activity_home = new Home_Activity();
        setFrag(0); // 첫 프래그먼트 화면 지정



        findViewById(R.id.logout).setOnClickListener(onClickListener);


    }

    // 프래그먼트 교체가 일어나는 실행문.
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction(); //프레그먼트 교체
        switch(n){
            case 0:
                ft.replace(R.id.main_frame, activity_home);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, activity_star);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, activity_person);
                ft.commit();
                break;
        }
    }

    //로그아웃 클릭 리스너
    View.OnClickListener onClickListener = new View.OnClickListener() { //로그아웃 버튼 클릭시 로그아웃되고 로그인 화면으로 이동
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.logout:
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                    //무한 뒤로가기 방지
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
            }
        }
    };
}