#include<iostream>
using namespace std;
void increment(int &x, int &y){
	x = x + 10;
	y = y + 10;
	cout << "Value of x inside the function: " << x << endl;
	cout << "Value of y inside the function: " << y << endl;
}

int main(){
	int x=10, y=100;
	increment(x, y);
	cout << "The actual value of x in main: " << x << endl;
	cout << "The actual value of y in main: " << y << endl;
}
