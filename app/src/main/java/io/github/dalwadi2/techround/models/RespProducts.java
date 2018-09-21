package io.github.dalwadi2.techround.models;


import com.google.gson.annotations.SerializedName;

/**
 * Created by: Harsh Dalwadi - Software Engineer
 * Created Date: 22-09-2018
 */
public class RespProducts {

    /**
     * id : 0
     * description : Deliver documents to Andrio
     * imageUrl : https://s3-ap-southeast-1.amazonaws.com/lalamove-mock-api/images/pet-8.jpeg
     * locationData : {"lat":22.319181,"lng":114.170008,"address":"Mong Kok"}
     */

    @SerializedName("id")
    private int id;
    @SerializedName("description")
    private String description;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("location")
    private LocationData locationData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }
}
