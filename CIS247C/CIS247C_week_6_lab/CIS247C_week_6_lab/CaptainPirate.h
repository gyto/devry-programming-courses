#pragma once
#include "Pirate.h"

class CaptainPirate : public Pirate
{
private:
	string pet;
public:
	// behavior
	CaptainPirate(string, string);

	// accessors and mutators
	void setPet(string);
	string getPet();
	string toString();
	string speak();
};

