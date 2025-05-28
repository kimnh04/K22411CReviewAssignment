package com.nguyenkim.k22411creviewassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nguyenkim.k22411creviewassignment.adapters.ProductAdapter;
import com.nguyenkim.k22411creviewassignment.models.ListProduct;
import com.nguyenkim.k22411creviewassignment.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Product> products;
    private ProductAdapter adapter;
    private static final int REQUEST_CODE_ADD_PRODUCT = 1001;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//
//        final android.view.View mainView = findViewById(R.id.main);
//        if (mainView != null) {
//            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
//                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//                return insets;
//            });
//        }
//
//        // Tích hợp Toolbar
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        ListView productListView = findViewById(R.id.productListView);
//        List<Product> products = ListProduct.getMockProducts();
//        ProductAdapter adapter = new ProductAdapter(this, products);
//        productListView.setAdapter(adapter);
//
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);

    final android.view.View mainView = findViewById(R.id.main);
    if (mainView != null) {
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Tích hợp Toolbar
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ListView productListView = findViewById(R.id.productListView);
    products = new ArrayList<>(ListProduct.getProductList());
    adapter = new ProductAdapter(this, products);
    productListView.setAdapter(adapter);
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            Intent intent = new Intent(this, AddActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_PRODUCT);
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD_PRODUCT && resultCode == RESULT_OK && data != null) {
            Product newProduct = (Product) data.getSerializableExtra("product");
            if (newProduct != null) {
                products.add(newProduct);
                adapter.notifyDataSetChanged();
            }
        }
    }

}