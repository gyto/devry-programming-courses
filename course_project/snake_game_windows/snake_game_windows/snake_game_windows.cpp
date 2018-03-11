
#include "stdafx.h"
#include <iostream>
#include <map>
#include <cstdlib>
#include <conio.h>
#include <cmath>
#include <vector>
#include <ctime>

using namespace std;

const int boardX = 40, boardY = 20;
int center = ceil((boardX / 2 * boardY) - (boardX / 2));

map<int, char> gameMap;
map<int, char>::const_iterator it;

int snakeXY = center;
enum snakeDir { UP, DOWN, LEFT, RIGHT };
snakeDir direction;
vector<int> tailPieces;

bool fruitSpawned = false;
bool stopped;
bool gameOver;

// Creates and places all the elements into the map (gameMap)
void createMap() {
	for (int i = 1; boardX*boardY >= i; i++) {
		if ((i <= boardX) || (i>(boardX*boardY - boardX))) {
			gameMap[i] = '#';
		}
		else if ((i % boardX == 0) || ((i - 1) % boardX == 0)) {
			gameMap[i] = '#';
		}
		else {
			gameMap[i] = ' ';
		}
	}
}

// Handles input from the user
void keyUpdate() {
	char key;

	if (_kbhit() == true) {
		key = _getch();

		switch (key) {
		case 'w':
		case 'W':
			direction = UP;
			break;
		case 'a':
		case 'A':
			direction = LEFT;
			break;
		case 's':
		case 'S':
			direction = DOWN;
			break;
		case 'd':
		case 'D':
			direction = RIGHT;
			break;
		case 'P':
		case 'p':
				if (!stopped) {
					stopped = true;
				}
				else {
					stopped = false;
				}
				default:
					break;
		}
	}
}

// Handles hit detection, snake's head and tail movement
void updateSnake() {
	int prevXY = snakeXY;

	if (!stopped) {
		switch (direction) {
		case UP:
			snakeXY = snakeXY - boardX;
			break;
		case DOWN:
			snakeXY = snakeXY + boardX;
			break;
		case LEFT:
			--snakeXY;
			break;
		case RIGHT:
			++snakeXY;
			break;
		}

		if (!stopped) {
			if (tailPieces.empty()) {
				gameMap[prevXY] = ' ';
			}
			else {

				int tailPieceXY;

				for (int i = 0; i <= tailPieces.size(); i++) {
					if (i == tailPieces.size()) {
						gameMap[prevXY] = ' ';
					}
					else {
						tailPieceXY = tailPieces[i];
						tailPieces[i] = prevXY;
						gameMap[prevXY] = 'o';
						prevXY = tailPieceXY;
					}
				}
			}
			if (gameMap[snakeXY] == '#' || gameMap[snakeXY] == 'o') {
				gameOver = true;
			}
			else if (gameMap[snakeXY] == 'F') {
				tailPieces.push_back(prevXY);
				gameMap[snakeXY] = 'O';
				fruitSpawned = false;
			}
			else {
				gameMap[snakeXY] = 'O';
			}
		}
	}
}

// Draws the map into the cmd console.
void updateMap() {
	system("cls");
	for (it = gameMap.begin(); it != gameMap.end(); it++) {
		cout << it->second;
		if (it->first % boardX == 0) {
			cout << endl;
		}
	}
}

// Determines locations for the fruit, and spawns them accordingly.
void spawnFruit() {

	vector<int> safeSpace;

	for (it = gameMap.begin(); it != gameMap.end(); it++) {
		if (it->second == ' ') {
			safeSpace.push_back(it->first);
		}
	}

	srand(time(NULL)); // Seeding for randomness
	int random = rand() % safeSpace.size();
	gameMap[safeSpace[random]] = 'F';
	fruitSpawned = true;

}


int main() {
	createMap();

	gameOver = false;
	stopped = false;

	while (!gameOver) {
		updateMap();
		updateSnake();
		if (!fruitSpawned) {
			spawnFruit();
		}
		keyUpdate();
		_sleep(125);
	}


	return 0;
}