package com.example.daraz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daraz.R;
import com.example.daraz.Url.Url;
import com.example.daraz.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.itemAdapterViewHolder> {

    private Context context;
    private List<Item> itemlist;

    public ItemAdapter(Context context, List<Item> itemsList) {
        this.context = context;
        this.itemlist = itemsList;
    }

    @NonNull
    @Override
    public itemAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, null);
        return new itemAdapterViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapterViewHolder holder, int position) {

        final Item items=itemlist.get(position);
        Picasso.get().load(Url.base_url_image+itemlist.get(position).getItemImage()).into(holder.imgitem);
        holder.tvitemdesc.setText(items.getItemName());
        holder.tvitemprice.setText("Rs. "+items.getPrice()+" /-");

    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class itemAdapterViewHolder extends RecyclerView.ViewHolder{

        ImageView imgitem;
        TextView tvitemdesc,tvitemprice;

        public itemAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgitem=itemView.findViewById(R.id.imgitem);
            this.tvitemdesc=itemView.findViewById(R.id.tvitemdesc);
            this.tvitemprice=itemView.findViewById(R.id.tvitemprice);
        }
    }
}
