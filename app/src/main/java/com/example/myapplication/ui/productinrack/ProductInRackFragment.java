package com.example.myapplication.ui.productinrack;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentProductinrackBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductInRackFragment extends Fragment {

    private FragmentProductinrackBinding binding;
    private TableLayout tableLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProductInRackViewModel slideshowViewModel =
                new ViewModelProvider(this).get(ProductInRackViewModel.class);

        View view = inflater.inflate(R.layout.fragment_productinrack, container, false);

        binding = FragmentProductinrackBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        tableLayout = (TableLayout) view.findViewById(R.id.tableLayoutProduct);
        loadData();
        return view;
    }



    private void loadData() {
//        List<Product> products = new ArrayList<Product>();
        List<Product> products = new ArrayList<Product>();



        products.add(new Product("p02", "Name 2",  1, "Description for Product 2",  R.drawable.ic_launcher_background));
        products.add(new Product("p03", "Name 3",  2, "Description for Product 3",  R.drawable.ic_launcher_background));
        products.add(new Product("p04", "Name 4",  3, "Description for Product 4",   R.drawable.ic_launcher_background));
        products.add(new Product("p05", "Name 5",  4, "Description for Product 5",  R.drawable.ic_launcher_background));
        products.add(new Product("p06", "Name 6",  4, "Description for Product 6",  R.drawable.ic_launcher_background));
        products.add(new Product("p07", "Name 7",  4, "Description for Product 7",   R.drawable.ic_launcher_background));
        products.add(new Product("p09", "Name 9",  4, "Description for Product 9",   R.drawable.ic_launcher_background));

        createColumns();

        fillData(products);

    }

    private void createColumns() {
        TableRow tableRow = new TableRow(this.getContext());
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Id Column
        TextView textViewId = new TextView(this.getContext());
        textViewId.setText("Id");
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewId.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewId);

        // Name Column
        TextView textViewName = new TextView(this.getContext());
        textViewName.setText("Name");
        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewName.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewName);

        // Price Column
        TextView textViewPrice = new TextView(this.getContext());
        textViewPrice.setText("Price");
        textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPrice.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewPrice);

        // Photo Column
        TextView textViewPhoto = new TextView(this.getContext());
        textViewPhoto.setText("Photo");
        textViewPhoto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPhoto.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewPhoto);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Add Divider
        tableRow = new TableRow(this.getContext());
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        // Id Column
        textViewId = new TextView(this.getContext());
        textViewId.setText("-----------");
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewId.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewId);

        // Name Column
        textViewName = new TextView(this.getContext());
        textViewName.setText("-----------");
        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewName.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewName);

        // Price Column
        textViewPrice = new TextView(this.getContext());
        textViewPrice.setText("-----------");
        textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPrice.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewPrice);

        // Photo Column
        textViewPhoto = new TextView(this.getContext());
        textViewPhoto.setText("-------------------------");
        textViewPhoto.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPhoto.setPadding(5, 5, 5, 0);
        tableRow.addView(textViewPhoto);

        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.FILL_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

    }

    private void fillData(List<Product> products) {
        for (Product product : products) {
            TableRow tableRow = new TableRow(this.getContext());
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow currentRow = (TableRow) view;
                    TextView textViewId = (TextView) currentRow.getChildAt(0);
                    String id = textViewId.getText().toString();
                    Toast.makeText(getContext(), id, Toast.LENGTH_LONG).show();
                }
            });

            // Id Column
            TextView textViewId = new TextView(this.getContext());
            textViewId.setText(product.getId());
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewId.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewId);

            // Name Column
            TextView textViewName = new TextView(this.getContext());
            textViewName.setText(product.getName());
            textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewName.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewName);

            // Price Column
            TextView textViewPrice = new TextView(this.getContext());
//            textViewPrice.setText(getText(R.string.usd) + String.valueOf(product.getPrice()));
            textViewPrice.setText("$" + String.valueOf(product.getPrice()));
            textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewPrice.setPadding(5, 5, 5, 0);
            tableRow.addView(textViewPrice);

            // Photo Column
            ImageView imageViewPhoto = new ImageView(this.getContext());
            imageViewPhoto.setImageResource(product.getPhoto());
            tableRow.addView(imageViewPhoto);

            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.FILL_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }

//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        ProductInRackViewModel slideshowViewModel =
//                new ViewModelProvider(this).get(ProductInRackViewModel.class);
//
////        DataTable dataTable = binding.dataTable;
//        View view = inflater.inflate(R.layout.fragment_productinrack, container, false);
//
//
//        binding = FragmentProductinrackBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//        DataTable imageView = (DataTable) view.findViewById(R.id.data_table);
//
////        final TextView textView = binding.tx;
////        FragmentProductinrackBinding.getText().observe(getViewLifecycleOwner(), textView::setText);
//        DataTableHeader header = new DataTableHeader.Builder()
//                .item("#", 1)
//                .item("Product Code", 1)
//                .item("Lot No", 2)
//                .item("Qty", 3)
//                .item("In Date", 5)
//    .build();
//
//        ArrayList<DataTableRow> rows = new ArrayList<>();
//        // define 200 fake rows for table
//        for(int i=0;i<200;i++) {
//            Random r = new Random();
//            int random = r.nextInt(i+1);
//            int randomDiscount = r.nextInt(20);
//            DataTableRow row = new DataTableRow.Builder()
//                    .value("#" + i)
//                    .value(String.valueOf(random))
//                    .value(String.valueOf(random))
//                    .value(String.valueOf(random*1000).concat("$"))
//                    .value(String.valueOf(randomDiscount).concat("%"))
//            .build();
//            rows.add(row);
//        }
//
////        imageView.setTypeface(typeface);
//        imageView.setHeader(header);
//        imageView.setHeaderTextSize(12);
//        imageView.setRowTextSize(14);
//
//        imageView.setRows(rows);
//        imageView.inflate(this.getContext());
//        return view;
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}



//import java.io.Serializable;

class Product implements Serializable {

    private String id;

    private String name;

    private double price;

    private String description;

    private int photo;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoto() {
        return this.photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public Product() {
    }

    public Product(String id, String name, double price, String description, int photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.photo = photo;
    }
}