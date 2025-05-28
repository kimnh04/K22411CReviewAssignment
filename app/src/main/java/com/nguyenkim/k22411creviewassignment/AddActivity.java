package com.nguyenkim.k22411creviewassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.nguyenkim.k22411creviewassignment.models.ListProduct;
import com.nguyenkim.k22411creviewassignment.models.Product;

public class AddActivity extends AppCompatActivity {

    private EditText edtProductName, edtUnitPrice;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtProductName = findViewById(R.id.edtProductName);
        edtUnitPrice = findViewById(R.id.edtUnitPrice);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = edtProductName.getText().toString().trim();
                String unitPriceStr = edtUnitPrice.getText().toString().trim();
                double unitPrice = 0;
                if (!unitPriceStr.isEmpty()) {
                    try {
                        unitPrice = Double.parseDouble(unitPriceStr);
                    } catch (NumberFormatException e) {
                        unitPrice = 0;
                    }
                }
                int id = ListProduct.getProductList().size() + 1;
                String productCode = "P" + String.format("%03d", id);
                String imageLink = "";

                Product product = new Product(id, productCode, productName, unitPrice, imageLink);
                Intent intent = new Intent();
                intent.putExtra("product", product);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}