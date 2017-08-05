package com.harshgaba.spuul.models.banner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

@SerializedName("large")
@Expose
private String large;
@SerializedName("medium")
@Expose
private String medium;
@SerializedName("small")
@Expose
private String small;
@SerializedName("xsmall")
@Expose
private String xsmall;
@SerializedName("original")
@Expose
private String original;

public String getLarge() {
return large;
}

public void setLarge(String large) {
this.large = large;
}

public String getMedium() {
return medium;
}

public void setMedium(String medium) {
this.medium = medium;
}

public String getSmall() {
return small;
}

public void setSmall(String small) {
this.small = small;
}

public String getXsmall() {
return xsmall;
}

public void setXsmall(String xsmall) {
this.xsmall = xsmall;
}

public String getOriginal() {
return original;
}

public void setOriginal(String original) {
this.original = original;
}

}