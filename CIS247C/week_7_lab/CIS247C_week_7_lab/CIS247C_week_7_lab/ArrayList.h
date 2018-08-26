#pragma once

template <class T>
class ArrayList
{
private:
	// attributes
	const static int DEFAULT_SIZE = 5; // set constant for Default Size;
	T* list; // pointer to the array
	int count; // number of the items in the array list
	int capacity; // current size in memory

public:
	// constructors
	ArrayList(void)
	{
		this->list = new T[DEFAULT_SIZE];
		this->capacity = DEFAULT_SIZE;
		this->count = 0;
	}

	ArrayList(int initialCapacity)
	{
		this->list = new T[initialCapacity];
		this->capacity = initialCapacity;
		this->count = 0;
	}
	
	// destructors
	~ArrayList(void)
	{
		// delete the arra pointer
		if (this->list != nullptr)
		{
			delete[] this->list;
			this->list = nullptr;
		}
	}

	// behaviors

	// check if the array list is empty
	bool isEmpty(void)
	{
		return count == 0;
	}

	// get the item at the given position
	T get(int position)
	{
		if (position < count)
			return list[position];
		else
			return NULL;
	}

	// add an item to the array
	void add(T data)
	{
		// if the array is full, double the size
		if (count == capacity)
		{
			// create bigger array
			capacity = 2 * capacity;
			T* temp = new T[capacity];

			//copy items from current array to bigger array
			for (int i = 0; i < count; i++)
			{
				temp[i] = list[i];
			}

			// delete the current array
			delete[] list;

			// rename the bigger array to the current array name
			list = temp;		
		}

		// add the data item to the array
		list[count] = data;

		// increment the count
		count++;
	}

	// Remove item at the given position
	void removeAt(int position)
	{
		// Move the item that next to it and push it one back
		for (int i = position; i < count - 1; i++)
		{
			list[i] = list[i + 1];
		}

		// decrease the item count
		count--;
	}

	// accessors

	// get the count from the array
	int getCount(void)
	{
		return count;
	}

	// get the array list from current capacity
	int getCapacity()
	{
		return capacity;
	}
};