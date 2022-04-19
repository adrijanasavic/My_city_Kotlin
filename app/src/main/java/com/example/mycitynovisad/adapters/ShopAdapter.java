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
import com.example.mycitynovisad.objects.Attraction;


import java.util.List;


public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {
    private final Context mContext;
    private final List<Attraction> mAttractions;

    private final int mCategory;

    public ShopAdapter(Context context, List<Attraction> attractions, int category) {
        mContext = context;
        mAttractions = attractions;
        mCategory = category;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.card_item_shop, parent, false );
        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return mAttractions.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView nameTextView;
        private final CardView cardView;

        ViewHolder(View itemView) {
            super( itemView );
            imageView = itemView.findViewById( R.id.shop_image_card );
            nameTextView = itemView.findViewById( R.id.shop_name_card );
            cardView = itemView.findViewById( R.id.cardview_shop );
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Attraction attraction = mAttractions.get( position );
        Drawable drawable = ContextCompat.getDrawable( mContext, attraction.getAttractionImageId() );
        holder.imageView.setBackground( drawable );
        holder.nameTextView.setText( attraction.getAttractionName() );
        holder.cardView.setOnClickListener(view -> {
            Intent detailIntent = new Intent( mContext, DetailActivity.class );

            detailIntent.putExtra( mContext.getString( R.string.category ), mCategory );

            detailIntent.putExtra( mContext.getString( R.string.image_id ),
                    attraction.getAttractionImageId() );
            detailIntent.putExtra( mContext.getString( R.string.name ),
                    attraction.getAttractionName() );
            detailIntent.putExtra( mContext.getString( R.string.description ),
                    attraction.getAttractionDescription() );
            detailIntent.putExtra( mContext.getString( R.string.address ),
                    attraction.getAttractionAddress() );
            detailIntent.putExtra( mContext.getString( R.string.transport ),
                    attraction.getAttractionTransportation() );
            detailIntent.putExtra( mContext.getString( R.string.phone ),
                    attraction.getAttractionPhone() );
            detailIntent.putExtra( mContext.getString( R.string.web ),
                    attraction.getAttractionWeb() );
            detailIntent.putExtra( mContext.getString( R.string.hours ),
                    attraction.getAttractionHours() );
            detailIntent.putExtra( mContext.getString( R.string.fee ),
                    attraction.getAttractionFee() );

            mContext.startActivity( detailIntent );
        });
    }
}
