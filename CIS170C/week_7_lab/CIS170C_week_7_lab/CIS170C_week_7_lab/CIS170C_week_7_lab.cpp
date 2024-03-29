// ---------------------------------------------------
// Programming Assignment:  Lab 7
// Developer:				Roman Kovtun
// Date Written:			04/14/2018
// Purpose:					Week Lab 7 Sequential Files
// ---------------------------------------------------


#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>
using namespace std;
void menu(void);
void writeData(void);
void readData(void);

const char FileName[] = "TestAddress.txt";
int main() {
	menu();
	return 0;
}
void menu(void) {
	
	char userEnter;
	do
	{
		// do you want to append, show records or E for exit
		cout << "Welcome!\n" << endl;
		cout << "To add a record press (A)" << endl;
		cout << "To show a record press (S)" << endl;
		cout << "To exit press (E)" << endl;
		cout << "Command  <- ";
		cin >> userEnter;

		cin.ignore();
		cout << endl;

		userEnter = toupper(userEnter);

		switch (userEnter)
		{
		case 'A':
			writeData();
			break;
		case 'S':
			readData();
			break;
		case 'E':
			break;
		}

	} while (userEnter != 'E');
}
void writeData(void) {

	string name = " ", street = " ", city = " ", state = " ", zip = " ";

	cout << "Enter your Name: ";
	getline(cin, name);

	cout << "Enter your Street: ";
	getline(cin, street);

	cout << "Enter your City: ";
	getline(cin, city);

	cout << "Enter your State: ";
	getline(cin, state);

	cout << "Enter your Zip: ";
	getline(cin, zip);

	ofstream outMyStream(FileName, ios::app);

	if (outMyStream.is_open())
	{
		outMyStream << name << "," << street << "," << city << "," << state << "," << zip << ",";
	}

	outMyStream.close();
}
void readData(void) {

	ifstream inMyStream(FileName);

	if (inMyStream.is_open()) {

		cout << "\nRecords\n" << endl;

		string recBreaks = "";
		recBreaks.assign(20, '-');

		int fieldCount = 1; // her one 1
		int recordCount = 1;

		fieldCount = 1;
		string fieldBuffer;
		getline(inMyStream, fieldBuffer, ',');

		while (!inMyStream.eof()) {

			switch (fieldCount) {
			case 1:
				cout << recBreaks << endl;
				cout << "record #" << recordCount << endl;
				cout << "Name....." << fieldBuffer << endl;
				break;
			case 2:
				cout << "Street..." << fieldBuffer << endl;
				break;
			case 3:
				cout << "City....." << fieldBuffer << endl;
				break;
			case 4:
				cout << "State...." << fieldBuffer << endl;
				break;
			case 5:
				cout << "Zip......" << fieldBuffer << endl;
				fieldCount = 0;
				recordCount++;
				break;
			}

			//read the next field
			getline(inMyStream, fieldBuffer, ',');
			fieldCount++;
		}
		cout << recBreaks << endl;

		inMyStream.close();

	}
}
