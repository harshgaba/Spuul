package com.harshgaba.spuul.Screens.list.categorized_list;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class BannerPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    private ArrayList<Banner> banners;

    public BannerPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        if (banners == null)
            return 0;
        return banners.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
//        mContext=view.getContext();
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.banner_sub_view, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageview_banner_movie);
        Glide.with(mContext).load(banners.get(position).getImage().getMedium().trim().replace("https", "http")).fitCenter().into(imageView);

        Log.e("hereistheitem",banners.get(position).getImage().getMedium().trim());
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    public void swapAdapter(List<Banner> banners) {
        this.banners = new ArrayList<>();
        this.banners.addAll(banners);
        notifyDataSetChanged();
        Log.e("bannerslistswap",this.banners.size()+"");
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}