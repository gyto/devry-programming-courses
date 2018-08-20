#include "Pirate.h"


Pirate::Pirate(string name)
{
	this->name = name;
}

void Pirate::setName(string name)
{
	this->name = name;
}

string Pirate::getName()
{
	return name;
}

string Pirate::toString()
{
	return "Name : " + name;
}
