package com.mobilepalengke.org;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobilepalengke.org.Interface.ItemClickListener;
import com.mobilepalengke.org.Model.Product;
import com.mobilepalengke.org.ViewHolder.ProductViewHolder;
import com.squareup.picasso.Picasso;

public class MP_ProductSelection extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference productList;

    String categoryId = "";

    FirebaseRecyclerAdapter<Product,ProductViewHolder> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_productselection);

        ImageButton ibReturn = findViewById(R.id.nav_return);

        ibReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //Init firebase
        database = FirebaseDatabase.getInstance();
        productList = database.getReference("Products");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_products);
        layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        if(getIntent() != null)
            categoryId = getIntent().getStringExtra("CategoryId");
        if(!categoryId.isEmpty() && categoryId != null)
        {
            loadListProduct(categoryId);
        }
    }

    private void loadListProduct(String categoryID)
    {
       adapter = new FirebaseRecyclerAdapter<Product, ProductViewHolder>(Product.class,
               R.layout.product_item,
               ProductViewHolder.class,
               productList.orderByChild("MenuId").equalTo(categoryId)){
           @Override
           protected void populateViewHolder(ProductViewHolder productViewHolder, Product product, int i) {
                productViewHolder.product_name.setText(product.getName());
                Picasso.get().load(product.getImage())
                        .into(productViewHolder.product_image);

                final Product local = product;
                productViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent productDetail = new Intent(MP_ProductSelection.this, MP_ProductPage.class);
                        productDetail.putExtra("MenuId",adapter.getRef(position).getKey());
                        startActivity(productDetail);
                    }
                });
           }
       };
       recyclerView.setAdapter(adapter);

    }
}