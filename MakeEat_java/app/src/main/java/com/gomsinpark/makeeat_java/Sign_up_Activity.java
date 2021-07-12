package com.gomsinpark.makeeat_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_up_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static final String TAG = "SignUpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        findViewById(R.id.Signup_Button).setOnClickListener(onClickListener);
        findViewById(R.id.go_login).setOnClickListener(onClickListener);
    }



    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.Signup_Button:
                    signUp();
                    break;
                case R.id.go_login:
                    Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                    //무한 뒤로가기 방지
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    break;
            }
        }
    };

    private void signUp(){
        String email = ((EditText)findViewById(R.id.edit_email)).getText().toString();
        String password = ((EditText)findViewById(R.id.edit_password)).getText().toString();
        String password_check = ((EditText)findViewById(R.id.edit_password_check)).getText().toString();


        if (email.length() > 0 && password.length() > 0 && password_check.length() > 0){ //유효성 검사
            if(password.equals(password_check)){ //비밀번호 일치 확인
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(getApplicationContext(), "회원가입이 성공했습니다",
                                            Toast.LENGTH_SHORT).show();
                                    StartActivity(Login_Activity.class);//회원가입후 로그인 창으로 이동
                                    //성공
                                } else {
                                    if (task.getException() != null){
                                        Toast.makeText(getApplicationContext(), task.getException().toString(),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                    //실패
                                }
                            }
                        });
            }else {
                Toast.makeText(this, "비밀번호가 일치하지 않습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(this, "이메일 또는 비밀번호를 입력해 주세요",
                    Toast.LENGTH_SHORT).show();
        }



    }//signup

    private void StartActivity(Class c){
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}