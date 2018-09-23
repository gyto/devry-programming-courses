package com.company;

public class HealthProfile {

    // Build private variables
    private String name;
    private Integer age;
    private Integer weight;
    // Should receive two options: feet, inches
    private Integer height;
    private String category;

    // Set the variables from private mode
    public void setName(String name) { this.name = name; }
    public void setAge(Integer age) { this.age = age; }
    public void setWeight (Integer weight) { this.weight = weight; }
    public void setHeight (Integer heightFeet, Integer heightInc) { height = (heightFeet * 12) + heightInc; }

    // Set simple getters
    public String getName() { return name; }
    public Integer getAge() { return age; }
    public Integer getWeight() { return weight; }
    public Integer getHeight() { return height; }

    // Get BMI is getting WEIGHT multiply by 703 and divided by HEIGHT multiplied on HEIGHT
    public Double getBMI() {
        return (double) (weight * 703) / (height*height);
    }

    // Get Category that user is assign to from getBMI
    public String getCategory() {
        Double range = getBMI();

        if (range < 18.5)
            category = "Underweight";
        else if (range > 18.5 && range <= 24.9)
            category = "Normal";
        else if (range >= 25 && range <= 29.9)
            category = "Overweight";
        else if (range > 30)
            category = "Obese";

        return category;
    }

    // Get Max Heart Rate from user age
    public Integer getMaxHR() {
        return 220 - age;
    }
}
