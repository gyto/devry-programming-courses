#include "Salary.h"

Salary::Salary() : Employee()

{
	annualSalary = 0;
}

Salary::Salary(string fname, string lname, string ssn, double annualSalary) :Employee(fname, lname, ssn)

{

	this->annualSalary = annualSalary;

}

float Salary::calculatePay()

{

	return(annualSalary / 52.0f);

}

string Salary::toString()

{

	string salaryString = Employee::toString();

	salaryString = salaryString + " Annual Salary : $" + to_string(annualSalary);

	return salaryString;

}

void Salary::setAnnualSalary(double annualSalary)

{

	this->annualSalary = annualSalary;

}

double Salary::getAnnualSalary()

{

	return annualSalary;

}

