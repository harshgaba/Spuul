package com.harshgaba.spuul.Screens.list;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.FeedData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedViewHolder extends RecyclerView.ViewHolder {

    View view;

    @BindView(R.id.txt_category_name)
    TextView nameCategoryMovie;
    @BindView(R.id.recyclerview_movies_list)
    RecyclerView listMovies;

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
        }
    }
}
