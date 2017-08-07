package com.harshgaba.spuul.Screens.list.categorized_list;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.banner.Banner;
import com.harshgaba.spuul.utils.UiUtils;

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
        Drawable mDefaultBackground = ContextCompat.getDrawable(context, R.drawable.loading_error_vector);
        Glide.with(context).load(banners.get(position).getImage().getMedium().trim().replace("https", "http")).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                UiUtils.handleThrowable(e);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                return false;
            }
        }).fitCenter().error(mDefaultBackground).into(iv_main_image);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
