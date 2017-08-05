package com.harshgaba.spuul.models.banner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {

@SerializedName("id")
@Expose
private int id;
@SerializedName("image")
@Expose
private Image image;

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Image getImage() {
return image;
}

public void setImage(Image image) {
this.image = image;
}

}