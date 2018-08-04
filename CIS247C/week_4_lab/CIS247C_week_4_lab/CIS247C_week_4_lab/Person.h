#pragma once

// Libararies
#include "Glasses.h"
#include <fstream>
#include <string>
using namespace std;

class Person
{
private:
	// Class Attributes
	string name;
	string ssn;
	Glasses myGlasses; // create default Glasses object

public:
	// Class construction and destructor
	Person(void);
	Person(string name, string ssn, Glasses theGlasses);
	~Person(void);

	// Class behaviors
	string toString(void);
	string writeToFile(void);
	string readFromFile(void);

	// Class Accessors and mutators
	string getName(void);
	void setName(string name);

	string getSSN(void);
	void setSSN(string ssn);

	Glasses getMyGlasses(void);
	void setMyGlasses(Glasses theGlasses);
};

