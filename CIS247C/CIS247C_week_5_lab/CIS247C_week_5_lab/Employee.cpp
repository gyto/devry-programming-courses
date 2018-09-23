#pragma once
#include "Employee.h"

Employee::Employee()

{}

Employee::Employee(string fname, string lname, string ssn)

{

	this->fname = fname;

	this->lname = lname;

	this->ssn = ssn;

}

float Employee::calculatePay()

{

	return 0.0f;

}

string Employee::toString()

{

	return("SSN : " + ssn + "Firstname : " + fname + " Lastname : " + lname);

}

void Employee::setFirstname(string fname)

{

	this->fname = fname;

}

void Employee::setLastname(string lname)

{

	this->lname = lname;

}

void Employee::setSSN(string ssn)

{

	this->ssn = ssn;

}


string Employee::getFirstname()

{

	return fname;

}

string Employee::getLastname()

{

	return lname;

}


string Employee::getSSN()

{

	return ssn;

}