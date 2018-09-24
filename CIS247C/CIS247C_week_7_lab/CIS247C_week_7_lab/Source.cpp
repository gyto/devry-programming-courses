/*
Roman Kovtun
CIS247C
8/25/2018
*/


//Libraries
#include <iostream>
#include <conio.h>
#include <string>
using namespace std;

#include <fstream>
#include <ctime>
#include <iomanip>

//Header file
#include "ArrayList.h"

// Entry Point for the Application
int main()
{
	// chec for memory leaks
#if defined(DEBUG) | defined(_DEBUG)
	_CrtSetDbgFlag(_CRTDBG_ALLOC_MEM_DF | _CRTDBG_LEAK_CHECK_DF);
#endif

	// create an int ArrayList
	ArrayList<int> intList;
	intList.add(27);
	intList.add(13);
	intList.add(42);
	intList.add(31);
	intList.add(22);
	intList.add(19);

	// get ArrayList count
	for (int i = 0; i < intList.getCount(); i++)
	{
		cout << intList.get(1) << ", ";
	}

	cout << "\n" << endl;
	cout << "Count: " << intList.getCount() << endl;
	cout << "Capacity: " << intList.getCapacity() << endl;

	cout << "\n\n" << endl;

	// create a string ArrayList
	ArrayList<string> strList;
	strList.add("Brendan");
	strList.add("Maria");
	strList.add("Ivan");
	strList.add("Nathan");
	strList.add("Roman");

	// display list data
	for (int i = 0; i < strList.getCount(); i++)
	{
		cout << strList.get(i) << ", ";
	}

	cout << "\n" << endl;
	cout << "Count: " << strList.getCount() << endl;
	cout << "Capacity: " << strList.getCapacity() << endl;

	// pause the console
	cout << "\nPress any key to continue...";
	cin.sync();
	_getch();
	return 0;
}
