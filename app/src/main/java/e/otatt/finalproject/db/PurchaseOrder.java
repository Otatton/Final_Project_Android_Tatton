package e.otatt.finalproject.db;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PurchaseOrder {

    @PrimaryKey(autoGenerate = true)
    private String order_id;
    String purchaseTotal;
}
