package e.otatt.finalproject.db;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(indices = {@Index(("order_id"))},
        foreignKeys = @ForeignKey(entity = Movies.class,
        parentColumns = "movie_id",
        childColumns = "order_id",
        onDelete = CASCADE))
public class History {

    @PrimaryKey(autoGenerate = true)
    private int purchase_id;
    private String id, name, order_id;

    public History(String id, String name, String order_id) {
        this.id = id;
        this.name = name;
        this.order_id = order_id;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
