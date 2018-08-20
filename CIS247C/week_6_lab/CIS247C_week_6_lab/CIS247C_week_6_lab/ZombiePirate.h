#pragma once
#include "Pirate.h"
#include <string>

class ZombiePirate : public Pirate
{
private:
	int brainHunger;
public:
	// behavior
	ZombiePirate(string, int);

	// accessors and mutators
	void setBrainHunger(int);
	int getBrainHunger();
	string toString();
	string speak();
};

