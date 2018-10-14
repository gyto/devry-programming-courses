/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kovtun.data;

/**
 *
 * @author Roman K
 */
public class Student {
    private String name;
    private float test1, test2, test3;

    // Constractor
    public Student() {
        name = "unknown";
        test1 = 0.0f;
        test2 = 0.0f;
        test3 = 0.0f;
    }

    public Student(String name, float test1, float test2, float test3) {
        this.name = name;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
    }
    
    //  behaviors
    @Override
    public String toString() {
        return name;
    }
    
    public float calculateAverage()
    {
        return (test1 + test2 + test3) / 3.0f;
    }
    
    public String calculateLetterGrade()
    {
        float avg = calculateAverage();
        
        // return base on letter avarage
        if (avg >= 90.0f)
            return "A";
        else if (avg >= 80.0f)
            return "B";
        else if (avg >= 70.0f)
            return "C";
        else if (avg >= 60.0f)
            return "D";
        else
            return "F";
    }
    
    // gettors and settors

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTest1() {
        return test1;
    }

    public void setTest1(float test1) {
        this.test1 = test1;
    }

    public float getTest2() {
        return test2;
    }

    public void setTest2(float test2) {
        this.test2 = test2;
    }

    public float getTest3() {
        return test3;
    }

    public void setTest3(float test3) {
        this.test3 = test3;
    }
    
}
