#pragma once
#include "Salary.h"

class Manager : public Salary

{

	double bonus;

public:

	Manager();

	Manager(string, string, string, double, double);

	float calculatePay();

	string toString();

	void setBonus(double bonus);

	double getBonus();

};