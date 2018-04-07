#ifndef __RETAILITEM_HPP__
#define __RETAILITEM_HPP__

#include <string>

class RetailItem
{
private:
	std::string description;
	double price;
	int unitOnHand;

public:
	RetailItem()
	{
		description = "<Empty Describtion>";
		price = 0;
		unitOnHand = 0;
	}
	RetailItem(std::string desc, double cost, int qty)
	{
		description = desc;
		price = cost;
		unitOnHand = qty;
	}

	std::string getDescription()			{ return description; }
	double getPrice()						{ return price; }
	int getUnits()							{ return unitOnHand; }
	void SetDescribtion(std::string desc)	{ description = desc; }
	void SetPrice(double cost)				{ price = cost; }
	void SetUnits(int qty)					{ unitOnHand = qty; }
};

#endif