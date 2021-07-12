package com.gomsinpark.makeeat_java.Pop_recipe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gomsinpark.makeeat_java.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter4 extends RecyclerView.Adapter<CustomAdapter4.CustomViewHolder> {

    private ArrayList<Recipe> arrayList1;
    private Context context;


    public CustomAdapter4(ArrayList<Recipe> arrayList1, Context context ) {
        this.arrayList1 = arrayList1;
        this.context = context;
    }



    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_pop_recipe_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, int position) {


        holder.title.setText(arrayList1.get(position).getTitle());
        holder.cooking_time.setText(arrayList1.get(position).getCooking_time());
        holder.chef.setText(arrayList1.get(position).getChef());
        holder.views.setText(arrayList1.get(position).getViews());
        holder.rank.setText(String.valueOf(arrayList1.get(position).getRank()));

        //이미지 다운로드해서 가져오기 메서드

        FirebaseStorage storage = FirebaseStorage.getInstance(); //스토리지 인스턴스를 만들고 다운로드는 주소를 넣는다
        StorageReference storageRef = storage.getReference(); //스토리지를 참조한다


        storageRef.child("img_folder/" + arrayList1.get(position).getFilename()).getDownloadUrl().
                addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        //성공시
                        Glide.with(holder.itemView)
                                .load(uri)
                                .into(holder.card_img);

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                //실패시
            }
        });



    }

    @Override
    public int getItemCount() {
        return (arrayList1
                != null ? arrayList1
                .size() : 0);
    }




    public class CustomViewHolder extends RecyclerView.ViewHolder {


        // ImageView ab_profile;
        TextView title;
        TextView cooking_time;
        TextView chef;
        TextView views;
        TextView rank;
        //
        ImageView card_img;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            // this.ab_profile = itemView.findViewById(R.id.ab_profile);
            this.title = itemView.findViewById(R.id.recipe_name);
            this.cooking_time = itemView.findViewById(R.id.recipe_time);
            this.chef = itemView.findViewById(R.id.recipe_writer);
            this.views = itemView.findViewById(R.id.recipe_viewer);
            this.rank = itemView.findViewById(R.id.recipe_rank);
            //
            this.card_img = itemView.findViewById(R.id.card_img);








            //아이템뷰 클릭리스너
            itemView.setClickable(true);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int pos = getAbsoluteAdapterPosition();




                    if (pos != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(context, Pop_recipe_next_Activity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


                        intent.putExtra("title", arrayList1.get(pos).getTitle());
                        intent.putExtra("Cooking_difficulty", arrayList1.get(pos).getCooking_difficulty());
                        intent.putExtra("Servings", arrayList1.get(pos).getServings());
                        intent.putExtra("Material", arrayList1.get(pos).getMaterial());
                        intent.putExtra("Tag", arrayList1.get(pos).getTag());
                        intent.putExtra("Tip", arrayList1.get(pos).getTip());
                        intent.putExtra("Cook_Step", arrayList1.get(pos).getCook_Step());
                        intent.putExtra("Filename", arrayList1.get(pos).getFilename());







                        context.startActivity(intent);
                    }

                }


            });


        }
    }
}