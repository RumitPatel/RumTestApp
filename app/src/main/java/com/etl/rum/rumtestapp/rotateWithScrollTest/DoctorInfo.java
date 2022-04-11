package com.etl.rum.rumtestapp.rotateWithScrollTest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by FatehAli Asamadi on 9/14/2017.
 * Doctor information
 */

public class DoctorInfo {

    @SerializedName("doctor_id")
    @Expose
    private String doctorId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("subcategory_id")
    @Expose
    private String subcategoryId;
    @SerializedName("doctor_name")
    @Expose
    private String doctorName;
    @SerializedName("qualification")
    @Expose
    private String qualification;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("experience")
    @Expose
    private String experience;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("video_fees")
    @Expose
    private String videoFees;
    @SerializedName("chat_fees")
    @Expose
    private String chatFees;
    @SerializedName("home_visit_fees")
    @Expose
    private String homeVisitFees;
    @SerializedName("next_available_time")
    @Expose
    private String next_available_time;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getVideoFees() {
        return videoFees;
    }

    public void setVideoFees(String videoFees) {
        this.videoFees = videoFees;
    }

    public String getChatFees() {
        return chatFees;
    }

    public void setChatFees(String chatFees) {
        this.chatFees = chatFees;
    }

    public String getHomeVisitFees() {
        return homeVisitFees;
    }

    public void setHomeVisitFees(String homeVisitFees) {
        this.homeVisitFees = homeVisitFees;
    }

    public String getNext_available_time() {
        return next_available_time;
    }

    public void setNext_available_time(String next_available_time) {
        this.next_available_time = next_available_time;
    }
}
