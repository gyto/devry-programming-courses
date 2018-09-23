#include "Person.h"

Person::Person()
{
	name = "unknown";
	ssn = "unknown";
	// Glasses objec is already created
}

Person::Person(string name, string ssn, Glasses theGlasses)
{
	setName(name);
	setSSN(ssn);
	setMyGlasses(theGlasses);
}
Person::~Person(void)
{
}

// Class behaviors
string Person::toString(void)
{
	return "Name: " + name + ", SSN: " + ssn + ", Glasses: [" + myGlasses.toString() + "]";
}

string Person::writeToFile(void)
{
	// write the state of the Person to the file using the person's name
	string fileName = name + ".txt";
	ofstream oFile(fileName, ios::app);

	oFile << name << endl;
	oFile << ssn << endl;
	oFile << myGlasses.getColor() << endl;
	oFile << myGlasses.getPrescription() << endl;

	oFile.close();

	// tell user that the data was written to the file
	return name + "'s data was written to the file.";
}

string Person::readFromFile(void)
{
	// read from the file
	string fileName = name + ".txt";
	ifstream iFile(fileName);

	// checking if the file is NOT open
	if (!iFile.is_open())
	{
		return "Error. File cannot be opened. Does it exist?";
	}
	else
	{
		// read into the object file of name and ssn attributes
		getline(iFile, name);
		getline(iFile, ssn);

		// read the Glasses prescription and color
		string color = "";
		getline(iFile, color);
		float pers = 0.0f;
		iFile >> pers;

		this->setMyGlasses(Glasses(color, pers));

		// ignore and use up the new line
		iFile.ignore(1);

		// tell the user that the data has been loaded
		return name + "'s data has been loaded from the file.";
	}

}

// Class Accessors and mutators
string Person::getName(void)
{
	return name;
}

void Person::setName(string name)
{
	if (name.length() > 0)
		this->name = name;
	else
		this->name = "unknown";
}

string Person::getSSN(void)
{
	return ssn;
}

void Person::setSSN(string ssn)
{
	if (ssn.length() == 9 || ssn.length() == 11)
		this->ssn = ssn;
	else
		this->ssn = "unknown";
}

Glasses Person::getMyGlasses(void)
{
	return myGlasses;
}
void Person::setMyGlasses(Glasses theGlasses)
{
	this->myGlasses = theGlasses;
}