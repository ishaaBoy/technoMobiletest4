package com.example.technomobiletest4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewPhoneByCus extends AppCompatActivity {

    RecyclerView recyclerView;
    ViewPhoneAdapter viewPhoneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_phone_by_cus);

        recyclerView = (RecyclerView) findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ViewPhoneModel> options =
                new FirebaseRecyclerOptions.Builder<ViewPhoneModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("mobile phones"), ViewPhoneModel.class)
                        .build();

    }

    @Override
    protected void onStart() {
        super.onStart();
        viewPhoneAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewPhoneAdapter.stopListening();

    }
}