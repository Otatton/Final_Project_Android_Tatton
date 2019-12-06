package e.otatt.finalproject.db;

import androidx.room.PrimaryKey;

public class OwnedItems {

    @PrimaryKey(autoGenerate = true)
    private int o_id;
    private String imageUrl, creatorName, likeCount, order_ID;

}
