#include "CaptainPirate.h"



CaptainPirate::CaptainPirate(string name, string pet) : Pirate(name)
{
	this->pet = pet;
}

void CaptainPirate::setPet(string pet)
{
	this->pet = pet;
}

string CaptainPirate::getPet()
{
	return pet;
}

string CaptainPirate::toString()
{
	return(Pirate::toString() + ", pet: " + pet);

}

string CaptainPirate::speak()
{
	return ("Yaaarrr! It be a " + pet + "! \nYaarrr Scallywags! Swab that poop deck!");
}
