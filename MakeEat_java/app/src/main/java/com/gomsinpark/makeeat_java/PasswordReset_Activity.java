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

public class PasswordReset_Activity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        findViewById(R.id.sendButton).setOnClickListener(onClickListener);

    }



    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.sendButton:
                    send();
                    break;

            }
        }
    };

    //보내기 버튼
    private void send(){
        String email = ((EditText)findViewById(R.id.Email)).getText().toString();


        if (email.length() > 0  ){ //유효성 검사

            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                startToast("이메일을 보냈습니다");
                                StartActivity(Login_Activity.class);
                            }
                        }
                    });


        }else {
            startToast("이메일을 입력해주세요");
        }



    }//signup

    private void startToast(String msg){Toast.makeText(this, msg, Toast.LENGTH_LONG).show();}

    private void StartActivity(Class c){
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}