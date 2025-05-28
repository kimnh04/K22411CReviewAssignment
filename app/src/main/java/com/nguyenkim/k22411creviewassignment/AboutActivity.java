package com.nguyenkim.k22411creviewassignment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Lấy tham chiếu các view
        TextView tvStudentId = findViewById(R.id.tvStudentId);
        TextView tvStudentName = findViewById(R.id.tvStudentName);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvClassName = findViewById(R.id.tvClassName);
        ImageView ivAvatar = findViewById(R.id.ivAvatar);

        // Gán dữ liệu (có thể lấy từ intent hoặc hardcode)
        tvStudentId.append("K22411452");
        tvStudentName.append("Nguyen Hoang Kim");
        tvEmail.append("kimnh22411c@st.uel.edu.vn");
        tvClassName.append("K22411C");
        ivAvatar.setImageResource(R.drawable.avatar); // ảnh avatar bạn cần thêm vào drawable
    }
}