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

public class Login_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login).setOnClickListener(onClickListener);
        findViewById(R.id.go_sign_up).setOnClickListener(onClickListener);
        findViewById(R.id.password_reset_text).setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.login:
                    login();
                    break;
                case R.id.go_sign_up:
                    StartActivity(Sign_up_Activity.class);
                    break;
                case R.id.password_reset_text:
                    StartActivity(PasswordReset_Activity.class);
                    break;
            }
        }
    };

    private void login(){
        String email = ((EditText)findViewById(R.id.Email)).getText().toString();
        String password = ((EditText)findViewById(R.id.pwd)).getText().toString();



        if (email.length() > 0 && password.length() > 0 ){ //유효성 검사
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeFrame_Activity.class);
                                //뒤로가기방지
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);

                            } else {
                                if (task.getException() != null){
                                    Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다",
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                    });

        }else {
            Toast.makeText(this, "이메일 또는 비밀번호를 입력해 주세요",
                    Toast.LENGTH_SHORT).show();
        }



    }//signup

    private void StartActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}