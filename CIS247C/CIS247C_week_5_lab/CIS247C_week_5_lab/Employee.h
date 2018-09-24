#pragma once
#include <iostream>
#include <string>

using namespace std;

class Employee {

private:
string fname;
string lname;
string ssn;

public:

Employee();

Employee(string, string, string);

float calculatePay();

string toString();

void setFirstname(string fname);

void setLastname(string lname);

void setSSN(string ssn);

string getFirstname();

string getLastname();

string getSSN();

virtual ~Employee() = default;

};