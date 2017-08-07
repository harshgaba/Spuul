package com.harshgaba.spuul.Screens.list;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.videos.Video;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedViewHolder extends RecyclerView.ViewHolder {

    View view;

    @BindView(R.id.txt_category_name)
    TextView nameCategoryMovie;
    @BindView(R.id.linearlayout_movies)
    LinearLayout layoutMovies;



    public FeedViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);

    }

    void bind(FeedData feedData) {

        if (feedData != null) {
            if (feedData.getPick() != null) {
                nameCategoryMovie.setText(feedData.getPick().getTitle());
            }

            if (layoutMovies.getChildCount()>0){
                layoutMovies.removeAllViews();
            }
            for (int i = 0; i < feedData.getVideos().size(); i++) {
                if (i == 2)
                    break;

                LayoutInflater vi = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View v = vi.inflate(R.layout.feed_movie_collection_view, null);

                LinearLayout containerMovie = (LinearLayout) v.findViewById(R.id.rly_movie);
                TextView titleMovie = (TextView) v.findViewById(R.id.textview_movie_title);
                titleMovie.setText(feedData.getVideos().get(i).getTitle());
                ImageView imageMovie = (ImageView) v.findViewById(R.id.imageview_movie);
                if (feedData.getVideos().get(i).getCover() != null) {
                    Glide.with(view.getContext()).load(feedData.getVideos().get(i).getCover().getSmall().trim().replace("https", "http")).fitCenter().into(imageMovie);
                }
                final int[] displayHeight = {0};
                layoutMovies.post(new Runnable() {
                    @Override
                    public void run() {
                        displayHeight[0] = layoutMovies.getWidth();
                        imageMovie.getLayoutParams().height = displayHeight[0] / 4;
                        imageMovie.requestLayout();
                        containerMovie.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 0.5f));
                        layoutMovies.addView(v);
                    }
                });

            }
        }
    }
}
