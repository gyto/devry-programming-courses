// Libraries
#include <ctime>
#include <stdlib.h>
#include <string>
using namespace std;

// initiate Card Class
class Card
{
private:
	// Card attributes
	char suit;
	char face;
	short value;

	static bool randomizeSeeded; // class-wide variable

public:
	// Card constractur and destructor
	Card();
	~Card();

	// Card behaviors
	string toString();
	bool flipAceToOne();

	// Card accessors and mutations
	inline char getSuit()
	{
		return suit;
	}
	inline char getFace()
	{
		return face;
	}
	inline short getValue()
	{
		return value;
	}
};

