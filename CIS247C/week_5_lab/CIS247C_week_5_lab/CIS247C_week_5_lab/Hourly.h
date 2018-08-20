#pragma once
#include "Employee.h"

class Hourly : public Employee {

	float hours;

	float rate;

public:

	Hourly();

	Hourly(string, string, string, float, float);

	float calculatePay();

	string toString();

	void setHours(float hours);

	void setRate(float rate);

	float getHours();

	float getRate();

};