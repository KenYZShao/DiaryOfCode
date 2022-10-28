#include <iostream>
using namespace std;
int number_sum(int num1, int num2) {
	return num1 + num2;//10+20=30	
}
int main() {
	float value1 = 10.1;
	float value2 = 20.9;
	int sum = number_sum(value1, value2);
	cout << sum;
	return 0;
}//What is the output of the above code?
//A.30.9 B.31 C.30 D.29
