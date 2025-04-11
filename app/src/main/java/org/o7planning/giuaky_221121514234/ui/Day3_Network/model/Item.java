package org.o7planning.giuaky_221121514234.ui.Day3_Network.model;

import com.google.gson.annotations.SerializedName;

public class Item {
    @SerializedName("id")
    private String id;
    @SerializedName("releaseDate")
    private String date;
    @SerializedName("primaryTitle")
    private String title;
    @SerializedName("primaryImage")
    private String image;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDate(){return date;}
    public void setDate(String date) {this.date = date;}
    public String getTitle(){return title;}
    public void setTitle(String title) {this.title = title;}
    public String getImage(){return image;}
    public void setImage(String image) {this.image = image;}
    @SerializedName("description")
    private String description;
    @SerializedName("url")
    private String url;
    public String getDescription(){
        return description;
    }
    public String getUrl(){
        return url;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setUrl(String url){
        this.url = url;
    }
}
