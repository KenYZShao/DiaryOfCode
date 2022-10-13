#include <iostream>
using namespace std;

void pass(int arr[]) {
	for (int i = 0; i < 5; i++) {
		cout << "The element is " << arr[i] << endl;
	}
}

int main() {
	int arr[5] = { 1,3,9,4,5 };

	pass(arr);//function pass
	return 0;
}

/*
The element is 1
The element is 3
The element is 9
The element is 4
The element is 5
*/
