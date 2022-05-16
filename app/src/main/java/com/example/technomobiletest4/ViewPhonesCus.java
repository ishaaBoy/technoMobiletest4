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

        FirebaseRecyclerOptions<ViewPhoneModel> options =
                new FirebaseRecyclerOptions.Builder<ViewPhoneModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("mobile phones"), ViewPhoneModel.class)
                        .build();

        viewPhoneAdapter = new ViewPhoneAdapter(options);
        recyclerView.setAdapter(viewPhoneAdapter);
    }
}