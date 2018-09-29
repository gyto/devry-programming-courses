/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

public class Person {
    
    private static final String DEFAULT_NAME = "Not Given";
    
    String firstName;
    String lastName;
    
    public Person()
    {
        this.firstName = DEFAULT_NAME;
        this.lastName = DEFAULT_NAME;
    }
    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
     public String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
         this.firstName = firstName; 
    }
    public String getLastName() {
        return lastName;
    }
    public final void setLastName(String lastName) {
       this.lastName = lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    @Override
    public String toString() {
        return getFullName();
    }
}
