package com.example.myrecyclerview;

public class Item {

    private String mContent;
    private int mImage;
    private String mTime;
    private boolean isHeader = false;
    private boolean withoutImage = false;
    private boolean withImage = false;
    private boolean isFooter = false;

    public Item(String mContent, int mImage, String mTime, boolean withImage) {
        this.mContent = mContent;
        this.mImage = mImage;
        this.mTime = mTime;
        this.withImage = withImage;
    }

    public Item(String mContent, String mTime) {
        this.mContent = mContent;
        this.mTime = mTime;
        withoutImage = true;
    }

    public Item(String mTime) {
        this.mContent = null;
        this.mImage = -1;
        this.mTime = mTime;
        isHeader = true;
    }

    public Item() {
        this.mContent = null;
        this.mImage = -1;
        this.mTime = null;
        isFooter = true;
    }

    public String getContent() {
        return mContent;
    }

    public int getImage() {
        return mImage;
    }

    public String getTime() {
        return mTime;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public boolean isWithoutImage() {
        return withoutImage;
    }

    public boolean isWithImage() {
        return withImage;
    }

    public boolean isFooter() {
        return isFooter;
    }
}
