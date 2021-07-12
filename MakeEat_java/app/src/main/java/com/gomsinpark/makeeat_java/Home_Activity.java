package com.gomsinpark.makeeat_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.gomsinpark.makeeat_java.Pop_recipe.Pop_recipe_category_Activity;

public class Home_Activity extends Fragment {

    private View view;
    private Button button1;
    private Button button2;
    private Button button3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_home, container, false); // person.xml 파일과 연결

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() { // 나의 냉장고로 이동
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),Refrigerator_Activity.class);//냉장고
                startActivity(i);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() { // 나의 냉장고로 이동
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Tas_recipe_Activity.class);//취향저격레시피
                startActivity(i);
                // overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() { // 나의 냉장고로 이동
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Pop_recipe_category_Activity.class);//인기레시피
                startActivity(i);

            }
        });

        return view;
    }

    private void overridePendingTransition(int fadein, int fadeout) {
    }


}