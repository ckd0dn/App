package com.gomsinpark.makeeat_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gomsinpark.makeeat_java.Pop_recipe.StarAdapter;
import com.gomsinpark.makeeat_java.Pop_recipe.StarRecipe;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Star_Activity extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<StarRecipe> arrayList1;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();//유저 정보

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_star, container, false); // star.xml 파일과 연결



        recyclerView = view.findViewById(R.id.star_recipe_recyclerview); // 아이디 연결
        recyclerView.setHasFixedSize(true); // 리사이클러뷰 기존성능 강화
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList1 = new ArrayList<>(); // User 객체를 담을 어댑터 리스트 (어댑터쪽으로)
        database = FirebaseDatabase.getInstance(); // 파이어베이스 데이터베이스 연동




        databaseReference = database.getReference("popular_recipe"); // DB 테이블 연결 -> FB Realtimebase를 말 함.
        databaseReference.child("즐겨찾기").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳.
                arrayList1.clear(); // 기존 배열리스트가 존재하지 않게 초기화.

                for (DataSnapshot snapshot : datasnapshot.getChildren()){ // 반복문으로 데이터 List를 추출해냄

                    StarRecipe user = snapshot.getValue(StarRecipe.class); // 만들어뒀던 User 객체에 데이터를 담는다.
                    arrayList1.add(user); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비

                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        adapter = new StarAdapter(arrayList1,view.getContext());
        recyclerView.setAdapter(adapter); // 리사이클러뷰에 어댑터 연결

        return view;

    }


}