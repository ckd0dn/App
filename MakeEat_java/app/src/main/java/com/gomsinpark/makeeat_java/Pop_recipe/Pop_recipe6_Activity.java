package com.gomsinpark.makeeat_java.Pop_recipe;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gomsinpark.makeeat_java.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Pop_recipe6_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Recipe> arrayList1;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private DatabaseReference databaseReference1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_recipe6);

        recyclerView = findViewById(R.id.pop_recipe_recyclerview6); // 아이디 연결
        recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList1 = new ArrayList<>(); // User 객체를 담을 어댑터 리스트 (어댑터쪽으로)
        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("popular_recipe"); // DB 테이블 연결 -> FB Realtimebase를 말 함.
        databaseReference.child("찌개").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳.
                arrayList1.clear(); // 기존 배열리스트가 존재하지 않게 초기화.
                for (DataSnapshot snapshot : datasnapshot.getChildren()){ // 반복문으로 데이터 List를 추출해냄
                    Recipe user1 = snapshot.getValue(Recipe.class); // 만들어뒀던 User 객체에 데이터를 담는다.
                    arrayList1.add(user1); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던 중 에러 발생 시
                Log.e("Taste_recipe_Activity",String.valueOf(databaseError.toException()));
            }
        });

        adapter = new CustomAdapter6(arrayList1,this);
        recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결


    }





}
