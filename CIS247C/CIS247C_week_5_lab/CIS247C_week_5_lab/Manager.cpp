#include "Manager.h"

Manager::Manager() : Salary()

{

	bonus = 0;

}

Manager::Manager(string fname, string lname, string ssn, double annualSalary, double bonus) : Salary(fname, lname, ssn, annualSalary)

{

	this->bonus = bonus;

}

float Manager::calculatePay()

{

	return((Salary::calculatePay() + (bonus / 52.0f)));

}

string Manager::toString()

{

	string managerString = Salary::toString();

	managerString = managerString + " Bonus : " + to_string(bonus);

	return managerString;

}

void Manager::setBonus(double bonus)

{

	this->bonus = bonus;

}

double Manager::getBonus()

{

	return bonus;

}