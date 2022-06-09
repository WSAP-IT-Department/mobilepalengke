package com.mobilepalengke.org;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobilepalengke.org.Model.Product;
import com.squareup.picasso.Picasso;

public class MP_ProductPage extends AppCompatActivity {

    TextView product_name, product_price, product_description;
    ImageView product_image;
    Button addtoCart;

    String productId="";

    FirebaseDatabase database;
    DatabaseReference products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productpage);

        //init database
        database = FirebaseDatabase.getInstance();
        products = database.getReference("Products");

        //init view
        product_image = (ImageView)findViewById(R.id.image_product);
        product_name = (TextView)findViewById(R.id.name_product);
        product_price = (TextView)findViewById(R.id.price_product);
        product_description = (TextView)findViewById(R.id.description_product);

        Button addtoCart = (Button) findViewById(R.id.addToCart);

        if(getIntent() != null)
            productId = getIntent().getStringExtra("MenuId");
        if(!productId.isEmpty())
        {
            getDetailProduct(productId);
        }

        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MP_ProductPage.this,"Added to Cart",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDetailProduct(String productId) {
        products.child(productId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Product product = snapshot.getValue(Product.class);

                Picasso.get().load(product.getImage())
                        .into(product_image);
                product_name.setText(product.getName());
                product_price.setText(product.getPrice());
                product_description.setText(product.getDescription());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}