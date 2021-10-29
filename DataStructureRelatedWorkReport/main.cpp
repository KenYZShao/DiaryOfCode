#include<iostream>

using namespace std;

class Node          //Creating a Node for the List
{
public:
    int data;
    Node* pNext;
    Node* pLast;
};

class List      //Creating a Doubly Linked List
{
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
        for (int i = 0; i < length; i++)
        {
            Node* temp = new Node();
            cout << "please enter the no" << i + 1 << " Node's data:";
            cin >> temp->data;
            temp->pNext = NULL;
            temp->pLast = pTail;
            pTail->pNext = temp;
            pTail = temp;
        }
    }

    void traverseList()//Forward Traverse 
    {
        Node* p = pHead->pNext;
        while (p != NULL)
        {
            cout << p->data << endl;
            p = p->pNext;
        }
    }

    
    void insertList(int num, int position)//Inserting Data
    {
        Node* p = pHead->pNext;
        if (position > length || position <= 0)
        {
            cout << "over stack !" << endl;
            return;
        }
        for (int i = 0; i < position - 1; i++)
        {
            p = p->pNext;
        }
        Node* temp = new Node();
        temp->data = num;
        temp->pNext = p;
        temp->pLast = p->pLast;
        p->pLast->pNext = temp;
        p->pLast = temp;
        length++;

    }


    ~List() //Cleanning the memory
    {
        Node* q;
        Node* p = pHead->pNext;
        while (p != NULL)
        {
            q = p;
            p = p->pNext;
            delete q;
        }
        p = NULL;
        q = NULL;
    }

};

//Also added an alternative way
void insertAfter(Node* prev_node, Node* new_node)
{
    //1. Check if the given prev_node is NULL
    if (prev_node == NULL)
    {
        cout << "the given previous node cannot be NULL";
        return;
    }

    //2. Make next of new node as next of prev_node
    new_node->pNext = prev_node->pNext;

    //3. Make the next of prev_node as new_node
    prev_node->pNext = new_node;

    //4.Make prev_node as previous of new_node*/
    new_node->pLast = prev_node;

    //5.Change previous of new_node's next node
    if (new_node->pNext != NULL)
    {
        new_node->pNext->pLast = new_node;
    }
}

int main()
{
    List l(3);
    l.traverseList();
    cout << "CURRENT LIST-----------------------------------------------------" << endl;
    l.traverseList();
    cout << "\n";
    cout << "AFTER INSERT-----------------------------------------------------" << endl;
    cout << "\n";
    l.insertList(108, 3);//Inserting a new item
   
    l.traverseList();
    return 0;
}

////////////
class String
{
public:
    String() { m_str = new char[1]; *m_str = 0; }
    ~String();
    String(const char* str);
    String(const String& other);
    String& operator = (const String& other);

private:
    char* m_str;
};


String Func(String str1)
{
    String str2;
    str2 = str1;
    return str2;
}

void Test()
{
    String str3("Hello");
    str3 = Func(str3);
}
///////////
/////
String str = "-640"
{
    int n = str.length();
    bool unsigned = false;
    int f = 1;//factor
    int num = 0;
}
for(int i = n - 1; i >= 0; i--)
//travel in str from right to left
{
    if (str[i] == '-')
        signed = true;
    num += (str[i] - '0') * f;
    f * 10;//advacing to 10th, 100th place...
}
if (signed)
{
    num *= -1;
    return num;
}



