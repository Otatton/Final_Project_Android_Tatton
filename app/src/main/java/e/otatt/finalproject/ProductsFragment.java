package e.otatt.finalproject;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubePlayerFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment implements ExampleAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_CREATOR = "creatorName";
    public static final String EXTRA_LIKES = "likeCount";

    private View view;
    private RecyclerView recyclerView;
//    private List list;
//    private ArrayList arrayList;

    private ExampleAdapter exampleAdapter;
    private ArrayList<ExampleItem> exampleItems;
    private RequestQueue requestQueue;
//    private OpenDetailView listener;
//
//    interface OpenDetailView {
//        void openDetail(String imageUrl, String creatorName, int likeCount);
//    }


    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_products, container, false);

        recyclerView = view.findViewById(R.id.prodRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        exampleItems = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(getActivity());
        parseJSON();


        return view;
    }



    private void parseJSON() {
        String url = "https://pixabay.com/api/?key=14504298-27803d4aa0c763df358187d5d&q=kung+fu&image_type=photo&pretty=true";
//        String url = "https://pixabay.com/api/?key=14504298-27803d4aa0c763df358187d5d&q=kung+fu&image_type=photo";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");
                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likeCount = hit.getInt("likes");
                                exampleItems.add(new ExampleItem(imageUrl, creatorName, likeCount));
                                Log.d("Array: ", exampleItems.toString());

                            }

                            exampleAdapter = new ExampleAdapter(getContext(), exampleItems);
                            recyclerView.setAdapter(exampleAdapter);
                            exampleAdapter.setOnItemClickListener(ProductsFragment.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
        ExampleItem clickedItem = exampleItems.get(position);
//        listener.openDetail(clickedItem.getImageUrl(), clickedItem.getCreator(), clickedItem.getLikes());

        detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_CREATOR, clickedItem.getCreator());
        detailIntent.putExtra(EXTRA_LIKES, clickedItem.getLikes());

        startActivity(detailIntent);

    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        listener = (OpenDetailView) context;
//    }
}
