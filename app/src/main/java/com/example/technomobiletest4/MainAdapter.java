package com.example.technomobiletest4;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<com.example.technomobiletest4.MainModel,MainAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<com.example.technomobiletest4.MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull com.example.technomobiletest4.MainModel model) {
        holder.brand.setText(model.getBrand());
        holder.pmodel.setText(model.getPmodel());
        holder.price.setText(model.getPrice());
        holder.storage.setText(model.getStorage());

        Glide.with(holder.img.getContext())
                .load(model.getMpurl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);

        holder.btnEditItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1250)
                        .create();

                //dialogPlus.show();

                View view = dialogPlus.getHolderView();

                EditText brand = view.findViewById(R.id.txtBrand);
                EditText pmodel = view.findViewById(R.id.txtPmodel);
                EditText price = view.findViewById(R.id.txtPrice);
                EditText storage = view.findViewById(R.id.txtStorage);
                EditText mpurl = view.findViewById(R.id.txtImageURL);

                Button btnUpdate = view.findViewById(R.id.btnUpdateItem);

                brand.setText(model.getBrand());
                pmodel.setText((model.getPmodel()));
                price.setText(model.getPrice());
                storage.setText(model.getStorage());
                mpurl.setText(model.getMpurl());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("brand",brand.getText().toString());
                        map.put("pmodel",pmodel.getText().toString());
                        map.put("price",price.getText().toString());
                        map.put("storage",storage.getText().toString());
                        map.put("mpurl",mpurl.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("mobile phones")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.brand.getContext(), "Updated Successfully.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.brand.getContext(), "Error While Updating.", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });


            }
        });

        holder.btnDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.brand.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Delete data can't be undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        FirebaseDatabase.getInstance().getReference().child("mobile phones")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(holder.brand.getContext(), "cancelled.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView brand,pmodel,price,storage;

        Button btnEditItem,btnDeleteItem;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img1);
            brand = (TextView) itemView.findViewById(R.id.brandtext);
            pmodel = (TextView) itemView.findViewById(R.id.pmodeltext);
            price = (TextView) itemView.findViewById(R.id.pricetext);
            storage = (TextView) itemView.findViewById(R.id.storagetext);

            btnEditItem =(Button)itemView.findViewById(R.id.btnEditItem);
            btnDeleteItem =(Button)itemView.findViewById(R.id.btnDeleteItem);
        }
    }
}
