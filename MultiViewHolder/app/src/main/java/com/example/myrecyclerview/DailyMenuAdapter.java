package com.example.myrecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DailyMenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "DailyMenuAdapter";

    private LayoutInflater mLayoutInflater;
    private ArrayList<Item> mItems;
    public static final int HEADER = 1;
    public static final int NORMAL_WITHOUT_IMAGE = 2;
    public static final int NORMAL_WITH_IMAGE = 3;
    public static final int FOOTER = 4;

    public DailyMenuAdapter(Context context, ArrayList<Item> items) {
        mLayoutInflater = LayoutInflater.from(context);
        mItems = items;
    }

    public class ItemWithoutImage extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mContent;
        private TextView mTime;

        public ItemWithoutImage(View itemView) {
            super(itemView);
            mIcon = itemView.findViewById(R.id.icon);
            mContent = itemView.findViewById(R.id.content_item_sin);
            mTime = itemView.findViewById(R.id.time_item_sin);
        }

        public void setIcon(int image) {
            mIcon.setImageResource(image);
        }

        public void setContent(String text) {
            mContent.setText(text);
        }

        public void setTime(String text) {
            mTime.setText(text);
        }
    }

    public class ItemWithImage extends RecyclerView.ViewHolder {
        private TextView mContent;
        private TextView mTime;
        private ImageView mImage;

        public ItemWithImage(View itemView) {
            super(itemView);
            mContent = itemView.findViewById(R.id.content_item);
            mTime = itemView.findViewById(R.id.time_item);
            mImage = itemView.findViewById(R.id.image);
        }

        public void setContent(String text) {
            mContent.setText(text);
        }

        public void setTime(String text) {
            mTime.setText(text);
        }

        public void setImage(int image) {
            mImage.setTag(image);
            mImage.setImageResource(image);
        }
    }

    public class ItemHeader extends RecyclerView.ViewHolder {
        private TextView mTime;

        public ItemHeader(View itemView) {
            super(itemView);
            mTime = itemView.findViewById(R.id.content_header);
        }

        public void setTime(String text) {
            mTime.setText(text);
        }

    }

    public class ItemFooter extends RecyclerView.ViewHolder {

        public ItemFooter(View itemView) {
            super(itemView);

        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView;
        switch (i) {
            case NORMAL_WITHOUT_IMAGE:
                mItemView = mLayoutInflater.inflate(R.layout.item_list_without_image, viewGroup, false);
                return new ItemWithoutImage(mItemView);
            case NORMAL_WITH_IMAGE:
                mItemView = mLayoutInflater.inflate(R.layout.item_list_with_image, viewGroup, false);
                return new ItemWithImage(mItemView);
            case HEADER:
                mItemView = mLayoutInflater.inflate(R.layout.item_list_header, viewGroup, false);
                return new ItemHeader(mItemView);
            case FOOTER:
                mItemView = mLayoutInflater.inflate(R.layout.item_list_footer, viewGroup, false);
                return new ItemFooter(mItemView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case NORMAL_WITHOUT_IMAGE:
                ItemWithoutImage mItemWithout = (ItemWithoutImage) viewHolder;
                mItemWithout.setContent(mItems.get(i).getContent());
                mItemWithout.setTime(mItems.get(i).getTime());
                break;
            case NORMAL_WITH_IMAGE:
                ItemWithImage mItemWith = (ItemWithImage) viewHolder;
                mItemWith.setContent(mItems.get(i).getContent());
                mItemWith.setTime(mItems.get(i).getTime());
                mItemWith.setImage(mItems.get(i).getImage());
                break;
            case HEADER:
                ItemHeader mItemHeader = (ItemHeader) viewHolder;
                Log.d(TAG, "onBindViewHolder: " + mItemHeader.toString());
                mItemHeader.setTime(mItems.get(i).getTime());
                break;
            case FOOTER:
                ItemFooter mItemFooter = (ItemFooter) viewHolder;
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position).isWithImage()) {
            return NORMAL_WITH_IMAGE;
        } else if (mItems.get(position).isWithoutImage()){
            return NORMAL_WITHOUT_IMAGE;
        } else if (mItems.get(position).isHeader()) {
            return HEADER;
        } else {
            return FOOTER;
        }
    }
}
