package com.example.mycitynovisad.objects;


public class Food {

    private final int mFoodImageId;
    private final String mFoodName;
    private final String mFoodDescription;
    private final String mFoodAddress;
    private final String mFoodTransportation;
    private String mFoodPhone;
    private String mFoodWeb;
    private final String mFoodHours;
    private final String mFoodFee;


    public Food(int foodImageId, String foodName, String foodDescription,
                String foodAddress, String foodTransportation, String foodPhone,
                String foodWeb, String foodHours, String foodFee) {
        this.mFoodImageId = foodImageId;
        this.mFoodName = foodName;
        this.mFoodDescription = foodDescription;
        this.mFoodAddress = foodAddress;
        this.mFoodTransportation = foodTransportation;
        this.mFoodPhone = foodPhone;
        this.mFoodWeb = foodWeb;
        this.mFoodHours = foodHours;
        this.mFoodFee = foodFee;
    }


    public Food(int foodImageId, String foodName, String foodDescription,
                String foodAddress, String foodTransportation, String foodPhone,
                String foodHours, String foodFee) {
        this.mFoodImageId = foodImageId;
        this.mFoodName = foodName;
        this.mFoodDescription = foodDescription;
        this.mFoodAddress = foodAddress;
        this.mFoodTransportation = foodTransportation;
        this.mFoodPhone = foodPhone;
        this.mFoodHours = foodHours;
        this.mFoodFee = foodFee;
    }


    public Food(String foodName, int foodImageId, String foodDescription,
                String foodAddress, String foodTransportation, String foodWeb,
                String foodHours, String foodFee) {
        this.mFoodImageId = foodImageId;
        this.mFoodName = foodName;
        this.mFoodDescription = foodDescription;
        this.mFoodAddress = foodAddress;
        this.mFoodTransportation = foodTransportation;
        this.mFoodWeb = foodWeb;
        this.mFoodHours = foodHours;
        this.mFoodFee = foodFee;
    }

    public int getFoodImageId() {
        return mFoodImageId;
    }

    public String getFoodName() {
        return mFoodName;
    }

    public String getFoodDescription() {
        return mFoodDescription;
    }

    public String getFoodAddress() {
        return mFoodAddress;
    }

    public String getFoodTransportation() {
        return mFoodTransportation;
    }

    public String getFoodPhone() {
        return mFoodPhone;
    }

    public String getFoodWeb() {
        return mFoodWeb;
    }

    public String getFoodHours() {
        return mFoodHours;
    }

    public String getFoodFee() {
        return mFoodFee;
    }

}
