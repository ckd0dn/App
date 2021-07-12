package com.gomsinpark.makeeat_java;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView tv;
    public Button button;

    ViewHolder(final Context context, View view){
        super(view);

        tv = view.findViewById(R.id.Rbutton);
        button = view.findViewById(R.id.Rbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strText = tv.getText().toString();
                Toast.makeText(context.getApplicationContext(), strText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
