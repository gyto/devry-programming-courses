#pragma once
#include "Employee.h"

class Salary : public Employee {
public:
	double annualSalary;

public:

	Salary();

	Salary(string, string, string, double);

	float calculatePay();

	string toString();

	void setAnnualSalary(double annualSalary);

	double getAnnualSalary();

};

