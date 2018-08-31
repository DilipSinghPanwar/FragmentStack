package com.androiddevs.models;

/**
 * Created by Syacraft on 22-Sep-16.
 */
public class ViewSellerModel {

    public String propertyName;
    public String propertyDetails;
    public String phone;
    public String email;


    public ViewSellerModel(String propertyName, String propertyDetails, String phone, String email) {
        this.propertyName = propertyName;
        this.propertyDetails = propertyDetails;
        this.phone = phone;
        this.email = email;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(String propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ViewBuyerModel{" +
                "propertyName='" + propertyName + '\'' +
                ", propertyDetails='" + propertyDetails + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
