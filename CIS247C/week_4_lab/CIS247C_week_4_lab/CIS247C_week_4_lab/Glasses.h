#pragma once

// Libararies
#include <string>
using namespace std;

class Glasses
{
private:
	 // Class Attributes
	string color;
	float prescription;

public:
	// Class construction and destructor
	Glasses(void);
	Glasses(string color, float prescription);
	~Glasses(void);

	// Class behaviors
	string toString(void);

	// Class Accessors and mutators
	string getColor(void);
	void setColor(string color);

	float getPrescription(void);
	void setPrescription(float prescription);
};

