package com.harshgaba.spuul.models;

import com.harshgaba.spuul.models.picks.Pick;
import com.harshgaba.spuul.models.videos.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedData {
   private Pick pick;
    private ArrayList<Video> videos;

    public FeedData(Pick pick, ArrayList<Video> videos) {
        this.pick = pick;
        this.videos = videos;
    }

    public Pick getPick() {
        return pick;
    }

    public void setPick(Pick pick) {
        this.pick = pick;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }
}
