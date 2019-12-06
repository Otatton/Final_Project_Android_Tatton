package e.otatt.finalproject;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static e.otatt.finalproject.DetailActivity.CART;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyCartFragment extends Fragment {
    public static final String OWNED_ITEMS = "Owned items";

    private ArrayList<CartItem> cartItems;
    private View view;
    private RecyclerView recyclerView;
    private ExampleAdapter2 exampleAdapter;
    private TextView textTotal;




    public MyCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_cart, container, false);
//        clearData();

        loadData();
        setTotal();
        buildRecyclerView();
        Button button = view.findViewById(R.id.payButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent= new Intent(getActivity(), PaypalActivity.class);

                startActivity(paymentIntent);
//                saveData();

            }
        });


        return view;
    }

    private void setTotal() {
        textTotal = view.findViewById(R.id.text_cart_total);
        int temp = 0;

        for (int i = 0; i < cartItems.size(); i++){
            temp = temp + cartItems.get(i).getPrice();
        }
        textTotal.setText("Total in cart: $" + temp);



    }

    private void saveData(){

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        loadData();
        String json1 = sharedPreferences.getString(OWNED_ITEMS, null);
        Type type = new TypeToken<ArrayList<CartItem>>(){}.getType();

        ArrayList<CartItem> tempList = gson.fromJson(json1, type);
        for(CartItem e : cartItems){
            tempList.add(e);
        }

        String json2 =  gson.toJson(tempList);
        editor.putString(OWNED_ITEMS, json2);
        editor.apply();

        clearData();

    }

    private void loadData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(CART, null);
        Type type = new TypeToken<ArrayList<CartItem>>(){}.getType();
        cartItems = gson.fromJson(json, type);

        if(cartItems == null){
            cartItems = new ArrayList<>();
        }

        Log.d("JSON", "Cart Json array size: " + cartItems.size());
    }

    private void buildRecyclerView(){
        recyclerView = view.findViewById(R.id.cartRecyclerView);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        exampleAdapter = new ExampleAdapter2(getContext(), cartItems);
        recyclerView.setAdapter(exampleAdapter);

    }

    private void clearData(){

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        cartItems = null;
        String json =  gson.toJson(cartItems);
        editor.putString(CART, json);
        editor.apply();


    }

}
