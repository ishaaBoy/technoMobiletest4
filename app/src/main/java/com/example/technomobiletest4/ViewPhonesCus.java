package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewPhonesCus extends AppCompatActivity {

    RecyclerView recyclerView;
    ViewPhoneAdapter viewPhoneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_phones_cus);

        recyclerView = (RecyclerView) findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<com.example.technomobiletest4.ViewPhoneModel> options =
                new FirebaseRecyclerOptions.Builder<com.example.technomobiletest4.ViewPhoneModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("mobile phones"), com.example.technomobiletest4.ViewPhoneModel.class)
                        .build();

        viewPhoneAdapter = new ViewPhoneAdapter(options);
        recyclerView.setAdapter(viewPhoneAdapter);
    }
}