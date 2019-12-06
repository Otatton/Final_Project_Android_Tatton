package e.otatt.finalproject;

import androidx.annotation.NonNull;

public class ExampleItem {
    private String mImageUrl, mCreator;
    private int mLikes;


    public ExampleItem(String mImageUrl, String mCreator, int mLikes) {
        this.mImageUrl = mImageUrl;
        this.mCreator = mCreator;
        this.mLikes = mLikes;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public int getLikes() {
        return mLikes;
    }

    @NonNull
    @Override
    public String toString() {
        return "ExampleItem: " + getCreator() + " " + getLikes();
    }
}
