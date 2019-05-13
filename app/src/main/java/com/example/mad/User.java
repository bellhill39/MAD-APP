package com.example.mad;

import java.io.Serializable;

public class User implements Serializable {


    private String name;
    private String email;
    private double weight;
    private int heightFt;
    private int heightInch;
    private double bmi;
    private BMI_LEVEL bmiLevel;
    private char gender;

    public char getGender(){

        return gender;
    }

    public BMI_LEVEL getBmiLevel(){

        return bmiLevel;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){

        this.email = email;
    }

    public void setGender(char gender){
        this.gender = gender;

    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setHeightFt(int heightFt){
        this.heightFt = heightFt;
    }

    public void setHeightInch(int heightInch){
        this.heightInch = heightInch;
    }

    public void setBmiLevel(){

        if (this.bmi >= 0 && this.bmi <= 18.5){

            this.bmiLevel = BMI_LEVEL.UNDERWEIGHT;

        }else if(this.bmi > 18.5 && this.bmi <= 25){

            this.bmiLevel = BMI_LEVEL.NORMAL;

        }else if(this.bmi > 25 && this.bmi <= 40){

            this.bmiLevel = BMI_LEVEL.OVERWEIGHT;

        }else if(this.bmi > 40){

            this.bmiLevel = BMI_LEVEL.OBESITY;
        }

    }


    public void calculateBmi(){

        double totalHeightInch = (this.heightFt * 12) + this.heightInch;
        double heightMeters = totalHeightInch / 37.39;

        this.bmi = this.weight / (heightMeters * heightMeters);

    }



}
