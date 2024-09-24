package com.example.tugas4pam;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugas4pam.ItemAdapter;
import com.example.tugas4pam.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemAdapter adapter;
    private List<ItemModel> itemList;

    private EditText inputField1, inputField2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize EditTexts
        inputField1 = findViewById(R.id.inputField1);
        inputField2 = findViewById(R.id.inputField2);

        // Initialize data list and adapter
        itemList = new ArrayList<>();
        adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Set up button click listener to add data
        findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1 = inputField1.getText().toString();
                String data2 = inputField2.getText().toString();

                if (!data1.isEmpty() && !data2.isEmpty()) {
                    // Add data to the adapter
                    adapter.addItem(new ItemModel(data1, data2));

                    // Clear the input fields
                    inputField1.setText("");
                    inputField2.setText("");
                } else {
                    // Show a message if fields are empty
                    Toast.makeText(MainActivity.this, "Please fill both spaces", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
