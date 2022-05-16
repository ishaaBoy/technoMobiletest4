package com.example.technomobiletest4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewPhoneAdapter extends FirebaseRecyclerAdapter<com.example.technomobiletest4.ViewPhoneModel, ViewPhoneAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ViewPhoneAdapter(@NonNull FirebaseRecyclerOptions<ViewPhoneModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull ViewPhoneModel model) {
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
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_phone_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView brand,pmodel,price,storage;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (CircleImageView)itemView.findViewById(R.id.img01);
            brand = (TextView) itemView.findViewById(R.id.brandtext1);
            pmodel = (TextView) itemView.findViewById(R.id.pmodeltext1);
            price = (TextView) itemView.findViewById(R.id.pricetext1);
            storage = (TextView) itemView.findViewById(R.id.storagetext1);
        }
    }
}
