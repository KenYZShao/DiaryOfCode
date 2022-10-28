#include <iostream>
using namespace std;

int main() {
	int operand1 = 67;
	int operand2 = 70;

	cout << (operand1 == operand2) << endl;
	cout << operand1 < operand2 << endl;
	//Writing relational expressions without 
	//round brackets will generate an error.
	return 0;
}
