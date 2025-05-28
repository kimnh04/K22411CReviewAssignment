package com.nguyenkim.k22411creviewassignment.models;

import java.util.ArrayList;
import java.util.List;

public class ListProduct {
    private static List<Product> mockProducts = new ArrayList<>();

    private ListProduct() {}

    static {
        mockProducts.add(new Product(1, "P001", "Silver Hoop", 9.99, "https://picsum.photos/200/200?random=1"));
        mockProducts.add(new Product(2, "P002", "Gold Stud", 12.49, "https://picsum.photos/200/200?random=2"));
        mockProducts.add(new Product(3, "P003", "Titanium Nose Ring", 14.99, "https://picsum.photos/200/200?random=3"));
        mockProducts.add(new Product(4, "P004", "Ear Cuff", 7.50, "https://picsum.photos/200/200?random=4"));
        mockProducts.add(new Product(5, "P005", "Helix Piercing", 11.25, "https://picsum.photos/200/200?random=5"));
        mockProducts.add(new Product(6, "P006", "Tragus Stud", 10.00, "https://picsum.photos/200/200?random=6"));
        mockProducts.add(new Product(7, "P007", "Barbell Eyebrow", 13.45, "https://picsum.photos/200/200?random=7"));
        mockProducts.add(new Product(8, "P008", "Circular Barbell", 15.00, "https://picsum.photos/200/200?random=8"));
        mockProducts.add(new Product(9, "P009", "Stud with Gem", 16.80, "https://picsum.photos/200/200?random=9"));
        mockProducts.add(new Product(10, "P010", "Captive Bead Ring", 9.20, "https://picsum.photos/200/200?random=10"));
        mockProducts.add(new Product(11, "P011", "Snakebite Labret", 18.60, "https://picsum.photos/200/200?random=11"));
        mockProducts.add(new Product(12, "P012", "Spiked Stud", 8.99, "https://picsum.photos/200/200?random=12"));
        mockProducts.add(new Product(13, "P013", "Heart Nose Ring", 17.30, "https://picsum.photos/200/200?random=13"));
        mockProducts.add(new Product(14, "P014", "Gem Helix", 19.45, "https://picsum.photos/200/200?random=14"));
        mockProducts.add(new Product(15, "P015", "Floral Ear Climber", 21.00, "https://picsum.photos/200/200?random=15"));
        mockProducts.add(new Product(16, "P016", "Gold Daith Hoop", 13.70, "https://picsum.photos/200/200?random=16"));
        mockProducts.add(new Product(17, "P017", "Pearl Stud", 11.90, "https://picsum.photos/200/200?random=17"));
        mockProducts.add(new Product(18, "P018", "Chain Dangle", 22.40, "https://picsum.photos/200/200?random=18"));
        mockProducts.add(new Product(19, "P019", "Minimalist Ring", 10.50, "https://picsum.photos/200/200?random=19"));
        mockProducts.add(new Product(20, "P020", "Twisted Bar", 14.60, "https://picsum.photos/200/200?random=20"));
    }

    public static void addProduct(Product product) {
        mockProducts.add(product);
    }

    public static List<Product> getProductList() {
        return new ArrayList<>(mockProducts);
    }
}