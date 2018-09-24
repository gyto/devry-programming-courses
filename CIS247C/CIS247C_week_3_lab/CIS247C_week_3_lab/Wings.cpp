#include "Wings.h"

// class constractors
Wings::Wings(string flavor, short numberOfPieces)
{
	// Create validation of the flavor
	setFlavor(flavor);
	setNumberOfPieces(numberOfPieces);
}
Wings::~Wings(void) {/* no dynamic objects to destroy */}

// class behavior

Wings Wings::operator+(const Wings secondWings) const
{
	// create the Wings object to return
	Wings thirdWings;

	// combine wings attributes
	thirdWings.numPieces = this->numPieces + secondWings.numPieces;
	if (this->flavor != secondWings.flavor)
		thirdWings.flavor = this->flavor + " and " + secondWings.flavor;
	else
		thirdWings.flavor = this->flavor;

	// return the new, and combine wings
	return thirdWings;
}

Wings Wings::operator-(const Wings secondWings) const
{
	// create the Wings object to return
	Wings thirdWings;

	// combine wings attributes
	thirdWings.numPieces = this->numPieces - secondWings.numPieces;
	string full = this->flavor; // current flavor

	short position = full.find("and", 0);
	if (position > 0)
		thirdWings.flavor = full.substr(0, position - 1);
	else
		thirdWings.flavor = this->flavor;

	// return the new, and combine wings
	return thirdWings;
}

Wings Wings::operator-(void)
{
	// create negative wings
	numPieces = -1 * numPieces;

	//flavor cannot be set to negative value because they are strings

	return *this;
}

Wings& Wings::operator++(void)
{
	// pre-increment the object
	++numPieces;

	// return teh increment wings object
	return *this;
}

Wings Wings::operator++(int)
{
	// save the old state (old values)
	Wings temp = *this; // save the old state

	// post-increment the current state
	++(*this);

	// return the old state
	return temp;
}

Wings& Wings::operator=(const Wings& equalWings)
{
	// check if it not equal to wings
	if (this != &equalWings)
	{
		this->flavor = equalWings.flavor;
		this->numPieces = equalWings.numPieces;
	}
		
	// return the nw object
	return *this;
}

istream& operator>>(istream &is, Wings &obj)
{
	// append to the input stream
	cout << "Enter the wings flavor: ";
	getline(is, obj.flavor);
	cout << "Enter the number of wings: ";
	is >> obj.numPieces;

	// return the input stream so more stuff can be append
	return is;
}

ostream& operator<<(ostream &os, Wings &obj)
{

	// append the information to the current output stream
	os << "Wings Flavor: " << obj.flavor << ", Number of Wings: " << obj.numPieces;

	// return the output stram so more stuff can be append
	return os;
}

// class accesors and class mutators
string Wings::getFlavor(void) { return flavor; }
void Wings::setFlavor(string flavor)
{
	if (flavor.length() > 0)
		this->flavor = flavor;
	else
		this->flavor = "unknown";
}

short Wings::getNumberOfPieces(void) { return numPieces; }
void Wings::setNumberOfPieces(short numberOfPieces)
{
	if (numberOfPieces > 0)
		numPieces = numberOfPieces;
	else
		numPieces = 0;
}