#include<iostream>

using namespace std;

int autoExample(int n1, int n2)
{
	return n1 * n2;
}
int main()
{
	//autoExample() return an int value,
	//so the type of the variable "product" will be
	//deduced to int.

	auto product{ autoExample(10,20) };
	cout << product << "\n\n";
	return 0;
}
