package com.userInteractionsAndAndroidResourse.dogsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.userInteractionsAndAndroidResourse.dogsapp.R;
import com.userInteractionsAndAndroidResourse.dogsapp.model.FavoriteDog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DoggyAdapter extends RecyclerView.Adapter<DoggyAdapter.ViewHolder> {


    private LayoutInflater mLayoutInflater;
    private ArrayList<String> dogs;
    private Context mContext;
    FirebaseFirestore db;

    public DoggyAdapter(ArrayList<String> dogs, Context mContext) {
        this.dogs = dogs;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        db = FirebaseFirestore.getInstance();
        View view = mLayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_breed_image_list, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String breedImageListResponse = dogs.get(position);
        Glide.with(holder.imageView.getContext()).load(breedImageListResponse).into(holder.imageView);
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FavoriteDog favdog = new FavoriteDog(dogs.get(position), Timestamp.now());
                try {
                    db.collection("favs").add(favdog);
                    Toast.makeText(mContext, "Foto guardada", Toast.LENGTH_SHORT).show();
                    return true;
                } catch(Exception e) {
                    Toast.makeText(mContext, "Inténtelo en otro momento", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        dogs.size();
        return dogs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        imageView = itemView.findViewById(R.id.vistaforDogs);

        }
    }
    public int getItemCount(ArrayList<String> dogs) {
        return dogs.size();
    }
}
