#include "ZombiePirate.h"

ZombiePirate::ZombiePirate(string name, int brainHunger) : Pirate(name)
{
	this->brainHunger = brainHunger;
}

void ZombiePirate::setBrainHunger(int brainHunger)
{
	this->brainHunger = brainHunger;
}

int ZombiePirate::getBrainHunger()
{
	return brainHunger;
}

string ZombiePirate::toString()
{
	return(Pirate::toString() + ", brain hunger : " + to_string(brainHunger));
}

string ZombiePirate::speak()
{
	// say something based on the hunger level

	switch (brainHunger) {
	case 0: return "Yum. I just ate a brain!";
		break;
	case 1: return "I'm getting a little hungry... Are there any brains out there?";
		break;
	case 2:
	case 3: return "I'm getting very hungry!! I need a brain to eat!!";
		break;
	case 4:
	case 5: return "BRAINS!!!! GIVE ME BRAINS NOW!!! I NEED TO EAT BRAINS NOW!!!";
		break;
	default: return "Error. Something went wrong.";
		break;
	}
}