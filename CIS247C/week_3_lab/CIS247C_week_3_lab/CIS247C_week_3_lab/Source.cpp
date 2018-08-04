/*
Roman Kovtun
CIS247C
7/26/2018
Week 3 Lab
*/


//Libraries
#include <iostream>
#include <conio.h>
#include <string>
#include "Wings.h"
using namespace std;

#include <fstream>
#include <ctime>
#include <iomanip>

// Entry Point for the Application
int main()
{
	// create two wings objects
	Wings w1("Honey Hot", 6);
	Wings w2("BBQ", 6);

	// Combine wings together with overload operators
	Wings w3 = w1 + w2;
	cout << "Combined wings: " << w3.getFlavor() << ", " << w3.getNumberOfPieces() << endl;

	// Smaller wings from with overload operators
	Wings w4 = w3 - w2;
	cout << "Smaller wings: " << w4.getFlavor() << ", " << w4.getNumberOfPieces() << endl;

	// Set negative wings with overload operator
	Wings w5 = -w4;
	cout << "Negative wings: " << w5.getFlavor() << ", " << w5.getNumberOfPieces() << endl;

	// Reset the negative number
	w5 = -w5;

	// Pre Increment with overload operator
	++w5;
	cout << "Incremented wings: " << w5.getFlavor() << ", " << w5.getNumberOfPieces() << endl;

	// Post Incremetn with overload operator
	w5++;
	cout << "Incremented wings: " << w5.getFlavor() << ", " << w5.getNumberOfPieces() << endl;

	// Check if wings are teh same
	Wings w6 = w5;
	cout << "Equal wings: " << w6.getFlavor() << ", " << w6.getNumberOfPieces() << endl;

	// Input stream with overload operator
	Wings w7;
	cin >> w7;

	cout << "Input stream wings: " << w7.getFlavor() << ", " << w7.getNumberOfPieces() << endl;

	// Output stream with overload operator
	cout << "Output stream wings: " << w7 << endl;

	// pause the console
	cout << "\nPress any key to continue...";
	_getch();
	return 0;
}
