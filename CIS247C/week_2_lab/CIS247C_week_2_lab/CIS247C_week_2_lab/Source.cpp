/*
Roman Kovtun
CIS247C
7/21/2018
*/


//Libraries
#include <iostream>
#include <conio.h>
#include <string>
using namespace std;

#include <fstream>
#include <ctime>
#include <iomanip>
#include "Card.h"
#include <vector> // STL

// prototypes
string showCards(vector<Card> cards);
short sumCardValues(vector<Card> cards);
void playHard(short &cash); // & is an address of veriable that sent by refrence

// Entry Point for the Application
int main()
{
	/* 
	set the starting cash
	display welcome message
	display amount user have on his/her account
	*/
	short cash = 100;
	cout << "Welcome to Blackjack Extreme!" << endl;
	cout << "\nYou are staring out with $" << cash << endl;

	// pause the console
	cout << "\nPress any key to continue...";
	_getch();

	// initiante short data type
	short choice = 0;

	// do loop for the short data type variable
	do
	{
		// show the menu to the user and get user choice
		system("cls"); // clear the console
		cout << "Menu\n" << endl;
		cout << "1) Play a hard" << endl;
		cout << "2) Show current cash balance" << endl;
		cout << "3) Exit" << endl;

		cout << "\nEnter based on the choice: ";
		cin >> choice;

		// switch based on the used choice
		switch (choice)
		{
		case 1:
			playHard(cash);
			break;
		case 2: 
			cout << "\nYour current cash balance: $" << cash << endl;
			break;
		case 3:
			cout << "\nThank you for playing Extreme BlackJack!" << endl;
			cout << "\nYour currnet cash balance is $" << cash << endl;
			break;
		default:
			cout << "\nError. Please select from the menu." << endl;
			break;
		}

		// pause the console
		cout << "\nPress any key to continue...";
		_getch();

	} while (choice !=3);

	// app compile successfully
	return 0;
}

// Show the Cards in the vector (resize array)
string showCards(vector<Card> cards)
{
	string output = "";

	// C++ 11 mentod changed "for each ( Card c in cards )"
	for (Card c : cards)
	{
		output += c.toString() + " ";
	}

	return output;
}

// Add up the total value of the cards
short sumCardValues(vector<Card> cards)
{
	short total = 0;

	// C++ 11 mentod changed "for each ( Card c in cards )"
	for (Card c : cards)
	{
		total += c.getValue();
	}

	return total;
}

// Play a single hand of BlackJack
void playHard(short &cash)
{
	// create two ArrayLinks that can hold Card objects
	vector<Card> dealerCards;
	vector<Card> playerCards;
	short dealerCardsTotal = 0;
	short playerCardsTotal = 0; 

	// get bet amount
	short bet = 0;
	cout << "\nEnter bet amount: ";
	cin >> bet;

	// crate two cards for a dealer and show first one
	Card card1;
	Card card2;
	dealerCards.push_back(card1);
	dealerCards.push_back(card2);
	dealerCardsTotal = sumCardValues(dealerCards);

	cout << "\nDealer is showing: " << dealerCards[0].toString() << endl;

	// create two cards for the player and show then both
	playerCards.push_back(Card()); // create the card and put it directly to array list
	playerCards.push_back(Card());
	playerCardsTotal = sumCardValues(playerCards);

	cout << "\nHere are your cards: " << showCards(playerCards) << endl;

	// give cards to the player until they stand ('S')
	char answer = '?';

	do
	{
		cout << "\n Do you want hit or stand (H/S)? ";
		cin.sync(); // flush keyboard bugger
		cin >> answer;
		cin.sync();

		if (toupper(answer) == 'H')
		{
			// give a card to the player
			Card c;
			cout << "\nYou were dealt this card: " << c.toString() << endl;
			playerCards.push_back(c); // add card player array

			// sum the card values
			playerCardsTotal = sumCardValues(playerCards);

			// did the player hit 21?
			if (playerCardsTotal > 21)
			{
				// do you have an Ace that can drop to a 1 value
				for (Card c : playerCards)
				{
					if (c.getValue() == 11)
					{
						cout << "\nYour total is: " << playerCardsTotal << endl;
						c.flipAceToOne();
						cout << "However, you have an Ace that was converted to '1' value" << endl;
						playerCardsTotal = sumCardValues(playerCards);
						cout << "\nYour new total is " << playerCardsTotal << endl;

						// if we are good on Ace's then keep looping if not break the loop
						if (playerCardsTotal <= 21)
							break;
					}
				}
			}

			// show the card and the total
			cout << "\nHere are your cards: " << showCards(playerCards) << endl;
			cout << "Your total is " << playerCardsTotal << endl;

			// if got > 21, then break the loop
			if (playerCardsTotal > 21)
			{
				answer = 'S';
			}
		}
	} while (toupper(answer) != 'S');

	// if Player Card Total is > 21, take money away
	if (playerCardsTotal > 21)
	{
		cout << "\nYou lost!" << endl;
		cash -= bet;
	}
	else
	{
		// player stands so the dealer hit until 17 or grather
		do
		{
			if (dealerCardsTotal < 17)
			{
				Card c;
				cout << "\nDealer was dealth: " << c.toString() << endl;
				dealerCards.push_back(c); // add the card to the dealer array
				cout << "\nDealer cards: " << showCards(dealerCards) << endl;
				dealerCardsTotal = sumCardValues(dealerCards);
				cout << "\nDealer total: " << dealerCardsTotal << endl;
			}
		} while (dealerCardsTotal < 17);

		// show the cards for the dealer and the player
		cout << "\nYour cards: " << showCards(playerCards) << " (" << playerCardsTotal << ") " << endl;
		cout << "\nDealer cards: " << showCards(dealerCards) << " (" << dealerCardsTotal << ") " << endl;

		// who wins?
		if (dealerCardsTotal > 21)
		{
			cout << "\nDealer busted!" << endl;
			cash += bet;
		}
		else if (dealerCardsTotal > playerCardsTotal)
		{
			cout << "\nDealer wins." << endl;
			cash -= bet;
		}
		else if (playerCardsTotal > dealerCardsTotal)
		{
			cout << "\nYou win!" << endl;
			cash += bet;
		}
		else
		{
			cout << "\nYou pushed the dealer (tie)." << endl;
		}
	}

	// show current cash balance
	cout << "\nYour current cash balance: $" << cash << endl;
}