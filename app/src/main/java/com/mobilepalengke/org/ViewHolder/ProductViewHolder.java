package com.mobilepalengke.org.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilepalengke.org.Interface.ItemClickListener;
import com.mobilepalengke.org.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView product_name, product_price;
    public ImageView product_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }
    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        product_name = (TextView) itemView.findViewById(R.id.product_name);
        product_price = (TextView) itemView.findViewById(R.id.product_price);
        product_image = (ImageView) itemView.findViewById(R.id.product_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v, getAdapterPosition(),false);
    }
}