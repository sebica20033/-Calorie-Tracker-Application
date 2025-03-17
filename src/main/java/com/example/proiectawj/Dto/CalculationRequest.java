package com.example.proiectawj.Dto;

import java.util.List;

public class CalculationRequest {
    private int age;
    private double height;
    private double weight;
    private double activityLevel;
    private List<FoodEntry> foods;

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(double activityLevel) {
        this.activityLevel = activityLevel;
    }

    public List<FoodEntry> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodEntry> foods) {
        this.foods = foods;
    }
}
