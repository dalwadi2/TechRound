package io.github.dalwadi2.techround.models;


import com.google.gson.annotations.SerializedName;

/**
 * Created by: Harsh Dalwadi - Software Engineer
 * Created Date: 22-09-2018
 */
public class LocationData {
    /**
     * lat : 22.319181
     * lng : 114.170008
     * address : Mong Kok
     */

    @SerializedName("lat")
    private double lat;
    @SerializedName("lng")
    private double lng;
    @SerializedName("address")
    private String address;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
