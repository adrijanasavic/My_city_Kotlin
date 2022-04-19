package com.example.mycitynovisad.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycitynovisad.R;
import com.example.mycitynovisad.activities.DetailActivity;
import com.example.mycitynovisad.objects.Food;


import java.util.List;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private final Context mContext;
    private final List<Food> mFoods;

    private final int mCategory;

    public FoodAdapter(Context context, List<Food> foods, int category) {
        mContext = context;
        mFoods = foods;
        mCategory = category;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.card_item_food, parent, false );
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mFoods.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView nameTextView;
        private final CardView cardView;

        ViewHolder(View itemView) {
            super( itemView );
            imageView = itemView.findViewById( R.id.food_image_card );
            nameTextView = itemView.findViewById( R.id.food_name_card );
            cardView = itemView.findViewById( R.id.cardview_food );
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Food attraction = mFoods.get( position );
        Drawable drawable = ContextCompat.getDrawable( mContext, attraction.getFoodImageId() );
        holder.imageView.setBackground( drawable );
        holder.nameTextView.setText( attraction.getFoodName() );
        holder.cardView.setOnClickListener(view -> {

            Intent detailIntent = new Intent( mContext, DetailActivity.class );

            detailIntent.putExtra( mContext.getString( R.string.category ), mCategory );

            detailIntent.putExtra( mContext.getString( R.string.image_id ),
                    attraction.getFoodImageId() );
            detailIntent.putExtra( mContext.getString( R.string.name ),
                    attraction.getFoodName() );
            detailIntent.putExtra( mContext.getString( R.string.description ),
                    attraction.getFoodDescription() );
            detailIntent.putExtra( mContext.getString( R.string.address ),
                    attraction.getFoodAddress() );
            detailIntent.putExtra( mContext.getString( R.string.transport ),
                    attraction.getFoodTransportation() );
            detailIntent.putExtra( mContext.getString( R.string.phone ),
                    attraction.getFoodPhone() );
            detailIntent.putExtra( mContext.getString( R.string.web ),
                    attraction.getFoodWeb() );
            detailIntent.putExtra( mContext.getString( R.string.hours ),
                    attraction.getFoodHours() );
            detailIntent.putExtra( mContext.getString( R.string.fee ),
                    attraction.getFoodFee() );

            mContext.startActivity( detailIntent );
        });
    }
}
