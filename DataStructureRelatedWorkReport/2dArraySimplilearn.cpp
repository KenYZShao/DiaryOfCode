#include <iostream>
using namespace std;

int main() {
	int arr[3][3] = { {2,4,5},{1,8,6},{1,1,9} };
	/* arr[3][3]实则分行分列
	{2,4,5},
	{1,8,6},
	{1,1,9}
	*/
	
	for (int i = 0; i < 3; ++i) {
		for (int j = 0; j < 3; ++j) {
			cout << arr[i][j] << " ";
		}
		cout << endl;
	}

	return 0;
}
