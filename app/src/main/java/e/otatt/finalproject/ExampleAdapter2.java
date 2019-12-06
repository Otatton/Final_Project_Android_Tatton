package e.otatt.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleAdapter2 extends RecyclerView.Adapter<ExampleAdapter2.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<CartItem> mExampleList;
//    private OnItemClickListener mListener;

//    public interface OnItemClickListener{
//        void onItemClick(int position);
//    }
//
//    public void setOnItemClickListener (OnItemClickListener listener) {
//        mListener = listener;
//    }

    public ExampleAdapter2(Context mContext, ArrayList<CartItem> mExampleList) {
        this.mContext = mContext;
        this.mExampleList = mExampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.cart_item, parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        CartItem currentItem = mExampleList.get(position);
        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikes();
        int price = currentItem.getPrice();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes: " + likeCount);
        holder.mTextViewPrice.setText("Price: $"+price);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);


    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;
        public TextView mTextViewPrice;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView =  itemView.findViewById(R.id.image_view2);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator2);
            mTextViewLikes = itemView.findViewById(R.id.text_view_likes2);
            mTextViewPrice = itemView.findViewById(R.id.text_view_cost2);


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (mListener != null){
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION){
//                            mListener.onItemClick(position);
//                        }
//                    }
//                }
//            });


        }
    }


}
