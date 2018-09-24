package presentation;

public class HealthProfile {

    // Build private variables
    private String name;
    private Integer age;
    private Double weight;
    // Should receive two options: feet, inches
    private Double height;
    private String category;

    // Default Constractor
    public HealthProfile() {}
    
    // Paramoterized Constractor
    public HealthProfile(String name, Integer age, Double weight, Double heightFeet, Double heightInc)
    {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = (heightFeet * 12) + heightInc;
    }

    // Get BMI is getting WEIGHT multiply by 703 and divided by HEIGHT multiplied on HEIGHT
    public Double getBMI() {
        return (weight * 703) / (height * height);
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
