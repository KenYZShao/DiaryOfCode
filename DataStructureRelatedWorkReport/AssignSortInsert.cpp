#include<iostream>
#include<vector>

using namespace std;
int main()
{
	vector<int> n;

	n.assign(9, 1);

	cout << "The contents are: ";
	for (int a = 0; a < n.size(); a++)
		cout << n[a] << " ";

	n.push_back(2);// add 2 at the end
	int no = n.size();
	cout << "\nLast element is: " << n[no - 1];

	n.pop_back();// delete the added 2

	cout << "\nThe contents are: ";
	for (int a = 0; a < n.size(); a++)
		cout << n[a] << " ";

	n.insert(n.begin(), 7);

	cout << "\nFirst element is: " << n[0];

	n.clear();
	cout << "\nNow the size is: " << n.size();
}
