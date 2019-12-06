package e.otatt.finalproject.db;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CurrentCart {

    @PrimaryKey(autoGenerate = true)
    private int c_id;
    private String imageUrl, creatorName, likeCount, order_ID;


    public CurrentCart(String imageUrl, String creatorName, String likeCount, String order_ID) {
        this.imageUrl = imageUrl;
        this.creatorName = creatorName;
        this.likeCount = likeCount;
        this.order_ID = order_ID;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }
}
