#pragma once
#include <iostream>
using namespace std;

class Pirate
{
private:
	string name;
public:
	// behavior
	Pirate(string);
	
	// accessors and mutators
	void setName(string);
	string getName();
	virtual string speak() = 0; // abstract method
	string toString();
};

