package e.otatt.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

//import static e.otatt.finalproject.MainActivity.EXTRA_CREATOR;
//import static e.otatt.finalproject.MainActivity.EXTRA_LIKES;
//import static e.otatt.finalproject.MainActivity.EXTRA_URL;

import static e.otatt.finalproject.ProductsFragment.EXTRA_CREATOR;
import static e.otatt.finalproject.ProductsFragment.EXTRA_LIKES;
import static e.otatt.finalproject.ProductsFragment.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {
    private static final int LOW_PRICE = 5;
    private static final int HIGH_PRICE = 10;
    private static final int SALE_PRICE = 3;
    public static final String CART = "Items in Cart";
    private ArrayList<CartItem> cartItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String creatorName = intent.getStringExtra(EXTRA_CREATOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewCreator = findViewById(R.id.text_view_creator_detail);
        TextView textViewLikes = findViewById(R.id.text_view_likes_detail);
        TextView textViewPrice = findViewById(R.id.text_view_price_detail);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewCreator.setText(creatorName);
        textViewLikes.setText("Likes: " + likeCount);

        int currentPrice;

        if (likeCount == 0){
            currentPrice = SALE_PRICE;

        }else if (likeCount > 0 && likeCount < 50){
            currentPrice = LOW_PRICE;
        }else{
            currentPrice = HIGH_PRICE;
        }
        textViewPrice.setText("Price: $" + currentPrice);

        final CartItem cartItem = new CartItem(imageUrl, creatorName, likeCount, currentPrice);

        Button button = findViewById(R.id.button_cart_detail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
                Log.d("JSON", "Json array size: " + cartItems.size());
                cartItems.add(cartItem);
                saveData();
                Log.d("JSON", "Json array size: " + cartItems.size());
                finish();
            }
        });
    }

    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json =  gson.toJson(cartItems);
        editor.putString(CART, json);
        editor.apply();


    }

    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(CART, null);
        Type type = new TypeToken<ArrayList<CartItem>>(){}.getType();
        cartItems = gson.fromJson(json, type);

        if(cartItems == null){
            cartItems = new ArrayList<>();
        }
    }
}