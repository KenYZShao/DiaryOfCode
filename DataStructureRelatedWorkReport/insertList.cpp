#include <iostream>
#include <unordered_map>
using namespace std;

class Node {//creating a Node for the List
public:
	int data;
	Node* pNext;
	Node* pLast;
};

class List {//Creating a Doubly Linked List
private:
	Node* pHead;
	Node* pTail;
	int length;
public:
	List(int length)//Creating Doubly Linked List
	{
		this->length = length;
		pHead = new Node();
		pHead->pLast = NULL;
		pTail = pHead;
		for (int i = 0; i < length; i++) {
			Node* temp = new Node();
			cout << "please enter the no " << i + 1 << " Node's data:";
			cin >> temp->data;
			temp->pNext = NULL;
			temp->pLast = pTail;
			pTail->pNext = temp;
			pTail = temp;
		}
	}

	void traverseList() {
		Node* p = pHead->pNext;
		while (p != NULL) {
			cout << p->data << endl;
			p = p->pNext;
		}
	}
	void insertList(int num, int position) {
		Node* p = pHead->pNext;
		if (position > length || position <= 0) {
			cout << "over stack!" << endl;
			return;
		}
		for (int i = 0; i < position - 1; i++) {
			p = p->pNext;
		}
		Node* temp = new Node();
		temp-> data = num;
		temp->pNext = p;
		temp->pLast = p->pLast;
		p->pLast->pNext = temp;
		p->pLast = temp;
		length++;
	}
	~List()//Cleanning the memory
	{
		Node* q;
		Node* p = pHead->pNext;
		while (p != NULL) {
			q = p;
			p = p->pNext;
			delete q;
		}
		p = NULL;
		q = NULL;
	}
};

int main() {
	List l(3);
	l.traverseList();
	cout << "CURRENT LIST----------------------------------------------------" << endl;
	l.traverseList();
	cout << "\n";
	cout << "AFTER INSERT------------------------------------------------------" << endl;
	cout << "\n";
	l.insertList(108, 3);//Inserting a new item

	l.traverseList();
	return 0;

}
