/*
Roman Kovtun
CIS247C
8/18/2018
*/


//Libraries
#include <iostream>
#include <conio.h>
#include <string>
using namespace std;

#include <fstream>
#include <ctime>
#include <iomanip>

// include classes
#include "CaptainPirate.h"
#include "ZombiePirate.h"

void displayPirate(Pirate *ptrPirate);

// Entry Point for the Application
int main()
{
	Pirate* piratse[3];

	// Create three pirates
	piratse[0] = new CaptainPirate("Jack", "Parrot");
	piratse[1] = new ZombiePirate("Joe", 2);
	piratse[2] = new CaptainPirate("Jim", "Sparrow");

	for (int i = 0; i < 3; i++)
		cout << piratse[i]->speak() << endl;
	for (int i = 0; i < 3; i++)
		delete piratse[1];

	// pause the console
	return 0;
}

void displayPirate(Pirate* ptrPirate)
{
	CaptainPirate* cp = dynamic_cast<CaptainPirate*>(ptrPirate); // set to NULL if doesnt work
	if (cp != NULL)
	{
		cout << "Pet: " << cp->getPet() << endl;
	}

	ZombiePirate *zp = dynamic_cast<ZombiePirate*>(ptrPirate);
	if (zp != NULL)
	{
		cout << "Brain Hunger: " << zp->getBrainHunger() << endl;
	}
}
