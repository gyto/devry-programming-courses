/*
Roman Kovtun
CIS247C
8/12/2018
*/


//Libraries
#include <iostream>
#include <conio.h>
#include <string>


#include <fstream>
#include <ctime>
#include <iomanip>

#include "Employee.h"
#include "Salary.h"
#include "Hourly.h"
#include "Manager.h"
using namespace std;

void displayEmployee(Employee *emp);

int main()

{

	Hourly hourly("Roman", "Kovtun", "12345", 42.0, 45.5);

	Salary salary("Yana", "Kovtun", "12356", 120000);

	Manager manager("Roman", "TheTest", "12333", 250000, 1200);

	cout << " Size of Hourly object : " << sizeof(hourly) << endl;

	cout << " Address of first object : " << &hourly << endl;

	displayEmployee(&hourly);

	displayEmployee(&salary);

	displayEmployee(&manager);

	cout << "\nPress any key to continue...";
	_getch();
	return 0;

}

void displayEmployee(Employee *emp)

{

	Hourly *hourly = dynamic_cast<Hourly*>(emp);

	if (hourly != NULL)

	{

		cout << " Hours : " << hourly->getHours() << " Rate : " << hourly->getRate() << endl;

	}

	Salary *salary = dynamic_cast<Salary*>(emp);

	if (salary != NULL)

	{

		cout << " Annual Salary : " << salary->getAnnualSalary() << endl;

	}

	Manager *manager = dynamic_cast<Manager*>(emp);

	if (manager != NULL)

	{

		cout << " Bonus : " << manager->getBonus() << endl;

	}

}
