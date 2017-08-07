package com.harshgaba.spuul.Screens.list.categorized_list;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harshgaba on 07/08/17.
 */

public class SliderAdapter extends PagerAdapter {
    List<Banner> banners;
    Context context;
    LayoutInflater mLayoutInflater;


    public SliderAdapter(List<Banner> banners, Context context) {
        this.banners = banners;
        this.context = context;
        mLayoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.banner_sub_view, container, false);
        ImageView iv_main_image = (ImageView) itemView.findViewById(R.id.imageview_banner_movie);
        Glide.with(context).load(banners.get(position).getImage().getMedium().trim().replace("https", "http")).fitCenter().into(iv_main_image);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
