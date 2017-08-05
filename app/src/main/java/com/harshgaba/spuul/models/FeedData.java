package com.harshgaba.spuul.models;

import com.harshgaba.spuul.models.picks.Pick;
import com.harshgaba.spuul.models.videos.Video;

import java.util.List;

/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedData {
   private Pick pick;
    private List<Video> videos;

    public FeedData(Pick pick, List<Video> videos) {
        this.pick = pick;
        this.videos = videos;
    }

    public Pick getPick() {
        return pick;
    }

    public void setPick(Pick pick) {
        this.pick = pick;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
