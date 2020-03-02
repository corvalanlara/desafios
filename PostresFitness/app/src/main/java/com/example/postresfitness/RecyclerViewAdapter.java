package com.example.postresfitness;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private List<DessertFit> mDessertFit;
    private Context mContext;

    public RecyclerViewAdapter(List<DessertFit> mDessertFits, Context mContext) {
        this.mDessertFit = mDessertFits;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_in_list, parent, false);
        ViewHolder mViewHolder = new ViewHolder(view);
        return mViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        final DessertFit dessertFit = mDessertFit.get(position);
        holder.mTextView.setText(dessertFit.getNombre());
        Glide.with(mContext)
                .load(dessertFit.getImagen())
                .centerCrop()
                .into(holder.mImageView);

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("ID", dessertFit.getId());
                intent.putExtra("TITULO", dessertFit.getNombre());
                intent.putExtra("IMAGEN", dessertFit.getImagen());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDessertFit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextView;
        LinearLayout mLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imagen_postre);
            mTextView = itemView.findViewById(R.id.nombre_postre);
            mLayout = itemView.findViewById(R.id.layout_itemlist);
        }
    }
}
