#pragma once

#include <iostream>
#include <string>
using namespace std;

class Wings
{
private:
	// class atributes
	string flavor;
	short numPieces;

public:
	// class constractors
	Wings(string flavor = "unknown", short numberOfPieces = 0);
	~Wings();

	// class behaviors

	Wings operator+(const Wings secondWings) const;				// wings3 = wings1 + wings2;
	Wings operator-(const Wings secondWings) const;				// wings3 = wings1 - wings2;
	Wings operator-(void);										// wings2 = -wings1;
	Wings& operator++(void);									// ++wings;
	Wings operator++(int);										// wings++;
	Wings& operator=(const Wings& equalWings);					// wings2 = wings1;

	// overload the input stream operator
	friend istream& operator>>(istream &is, Wings &obj);		// cin >> wings;
	// overload the output stream operator
	friend ostream& operator<<(ostream &os, Wings &obj);		// cout << wings << endl;

	// class accesors and class mutators
	string getFlavor(void);
	void setFlavor(string flavor);

	short getNumberOfPieces(void);
	void setNumberOfPieces(short numberOfPieces);
};

