// ---------------------------------------------------
// Programming Assignment:  LAB3
// Developer:				Roman Kovtun
// Date Written:			03/16/2018
// Purpose:					Arrays
// ---------------------------------------------------

#include "stdafx.h"
#include <string>
#include <iostream>

using namespace std;

int getTotal(int[], int);

int largestNum(int[], int);

int smallestNum(int[], int);

int main()
{
	int sum = 0;
	const int numArray = 7;
	string salsa[numArray] = {"mild", "medium", "hot", "sweet", "fruit", "verde", "zesty" };
	int soldJars[numArray], totalSold, lowSalesProduct, hiSalesProduct;

	for (int productQTY = 0; productQTY < numArray; productQTY++)
	{
		cout << "Jars sold last month of " << salsa[productQTY] << ": ";
		cin >> soldJars[productQTY];

		while (soldJars[productQTY] <= 0)
		{
			cout << "Jars sold must be more that 0: Please re-enter again: ";
			cin >> soldJars[productQTY];
		}
	}

	totalSold = getTotal(soldJars, numArray);
	lowSalesProduct = smallestNum(soldJars, numArray);
	hiSalesProduct = largestNum(soldJars, numArray);

	cout << "\n\nSalsa Sales Report \n\n";
	cout << "Name ----- Jars Sold\n";
	cout << "--------------------\n";


	for (int productQTY = 0; productQTY < numArray; productQTY++)
	{
		cout << salsa[productQTY] << " --------- " << soldJars[productQTY] << "\n";
	}

	cout << "\nTotal Sales: " << totalSold << endl;
	cout << "High Seller: " << salsa[hiSalesProduct] << endl;
	cout << "Low Seller: " << salsa[lowSalesProduct] << endl;
	
	system("pause");
	return 0;
}

int getTotal(int array[], int numRepeat)
{
	int total = 0;
	
	for (int typeArray = 0; typeArray < numRepeat; typeArray++)
	{
		total += array[typeArray];
	}
	return total;
}

int largestNum(int array[], int numRepeat)
{
	int indexLargestNum = 0;

	for (int numPos = 1; numPos < numRepeat; numPos++)
	{
		if (array[numPos] > array[indexLargestNum])
		{
			indexLargestNum = numPos;
		}
	}
	return indexLargestNum;
}

int smallestNum(int array[], int numRepeat)
{
	int indexSmallestNum = 0;

	for (int numPos = 1; numPos < numRepeat; numPos++)
	{
		if (array[numPos] < array[indexSmallestNum])
		{
			indexSmallestNum = numPos;
		}
	}
	return indexSmallestNum;
}
