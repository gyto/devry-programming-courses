#include "Hourly.h"

Hourly::Hourly() : Employee()

{

	hours = 0;

	rate = 0;

}

Hourly::Hourly(string fname, string lname, string ssn, float hours, float rate) :Employee(fname, lname, ssn)

{

	this->hours = hours;

	this->rate = rate;

}

float Hourly::calculatePay()

{

	if (hours>40)

	{

		return((40 * rate) + ((hours - 40)*rate*1.5));

	}
	else

		return(hours * 40);

}

string Hourly::toString()

{

	string hourlyString = Employee::toString();

	hourlyString = hourlyString + "Hours : " + to_string(hours) + " Rate : " + to_string(rate);

	return hourlyString;

}

void Hourly::setHours(float hours)

{

	this->hours = hours;

}

void Hourly::setRate(float rate)

{

	this->rate = rate;

}

float Hourly::getHours()

{

	return hours;

}

float Hourly::getRate()

{

	return rate;

}

