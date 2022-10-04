#include<iostream>

using namespace std;


int main()
{
	//declaring a pointer to hold address of an int type value.
	int* num;
	//allocate dynamic memory for the pointer
	num = new int;//new keyword
	*num = 100;
	cout << "Num is storing to the address of:";
	cout << *num << "\n\n";
	//deallocate the memory
	delete num;//delete keyword
}
