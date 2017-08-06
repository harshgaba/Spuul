package com.harshgaba.spuul.Screens.list.categorized_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.videos.Video;

import java.util.ArrayList;

/**
 * Created by harshgaba on 06/08/17.
 */

public class FeedCategorizeMoviesAdapter extends RecyclerView.Adapter<BannerViewHolder> {

    ArrayList<Video> videos = new ArrayList<>();

    public void swapAdapter(ArrayList<Video> videos) {
        this.videos = new ArrayList<>();
        this.videos.addAll(videos);
        notifyDataSetChanged();
    }

    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_list_item_view, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BannerViewHolder holder, int position) {

        Video video = videos.get(position);
//        holder.bind(video);
    }

    @Override
    public int getItemCount() {
        if (videos != null && videos.size() > 0)
            return videos.size();
        else
            return 0;
    }
}
