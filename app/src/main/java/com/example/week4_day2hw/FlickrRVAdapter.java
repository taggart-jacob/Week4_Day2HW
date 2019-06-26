package com.example.week4_day2hw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class FlickrRVAdapter extends RecyclerView.Adapter<FlickrRVAdapter.ViewHolder> {

    List<Item> resultList;

    public FlickrRVAdapter(List<Item> results){
        this.resultList = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flickr_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Item itemFlickr = resultList.get(position);
        final String flickrTitle = itemFlickr.getTitle();
        final String flickrLink = itemFlickr.getLink();
        final String imageURL = itemFlickr.getMedia().getM();

        holder.tvFlickrTitle.setText(flickrTitle);
        holder.tvFlickrLink.setText(flickrLink);
        Glide.with(holder.imgFlickr).load(imageURL).into(holder.imgFlickr);

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFlickr;
        TextView tvFlickrTitle;
        TextView tvFlickrLink;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFlickr = itemView.findViewById(R.id.imgFlickr);
            tvFlickrTitle = itemView.findViewById(R.id.tvFlickrTitle);
            tvFlickrLink = itemView.findViewById(R.id.tvFlickrLink);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View view) {
                    FlickrDialog flickrDialog = new FlickrDialog();
                    return true;
                }
            });
        }
    }
}
