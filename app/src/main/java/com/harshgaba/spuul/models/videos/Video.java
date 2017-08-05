
package com.harshgaba.spuul.models.videos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("category_id")
    @Expose
    private int categoryId;
    @SerializedName("category_title")
    @Expose
    private String categoryTitle;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("length")
    @Expose
    private int length;
    @SerializedName("hd")
    @Expose
    private boolean hd;
    @SerializedName("production_year")
    @Expose
    private int productionYear;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("season")
    @Expose
    private Object season;
    @SerializedName("episode")
    @Expose
    private Object episode;
    @SerializedName("channel")
    @Expose
    private Object channel;
    @SerializedName("actors")
    @Expose
    private String actors;
    @SerializedName("director")
    @Expose
    private String director;
    @SerializedName("producer")
    @Expose
    private String producer;
    @SerializedName("ratio")
    @Expose
    private float ratio;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("cbfc_rating")
    @Expose
    private String cbfcRating;
    @SerializedName("imdb_id")
    @Expose
    private Object imdbId;
    @SerializedName("rt_id")
    @Expose
    private Object rtId;
    @SerializedName("critics_rating")
    @Expose
    private Object criticsRating;
    @SerializedName("critics_score")
    @Expose
    private Object criticsScore;
    @SerializedName("audience_rating")
    @Expose
    private Object audienceRating;
    @SerializedName("audience_score")
    @Expose
    private Object audienceScore;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("cover")
    @Expose
    private Cover cover;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHd() {
        return hd;
    }

    public void setHd(boolean hd) {
        this.hd = hd;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Object getSeason() {
        return season;
    }

    public void setSeason(Object season) {
        this.season = season;
    }

    public Object getEpisode() {
        return episode;
    }

    public void setEpisode(Object episode) {
        this.episode = episode;
    }

    public Object getChannel() {
        return channel;
    }

    public void setChannel(Object channel) {
        this.channel = channel;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCbfcRating() {
        return cbfcRating;
    }

    public void setCbfcRating(String cbfcRating) {
        this.cbfcRating = cbfcRating;
    }

    public Object getImdbId() {
        return imdbId;
    }

    public void setImdbId(Object imdbId) {
        this.imdbId = imdbId;
    }

    public Object getRtId() {
        return rtId;
    }

    public void setRtId(Object rtId) {
        this.rtId = rtId;
    }

    public Object getCriticsRating() {
        return criticsRating;
    }

    public void setCriticsRating(Object criticsRating) {
        this.criticsRating = criticsRating;
    }

    public Object getCriticsScore() {
        return criticsScore;
    }

    public void setCriticsScore(Object criticsScore) {
        this.criticsScore = criticsScore;
    }

    public Object getAudienceRating() {
        return audienceRating;
    }

    public void setAudienceRating(Object audienceRating) {
        this.audienceRating = audienceRating;
    }

    public Object getAudienceScore() {
        return audienceScore;
    }

    public void setAudienceScore(Object audienceScore) {
        this.audienceScore = audienceScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cover getCover() {
        return cover;
    }

    public void setCover(Cover cover) {
        this.cover = cover;
    }

}
