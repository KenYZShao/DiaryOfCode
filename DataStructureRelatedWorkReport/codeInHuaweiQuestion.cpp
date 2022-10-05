#include<iostream>
#include <string>
using namespace std;
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
String& String::operator= (const String& other) {

}

void Test()
{
    String str3("Hello");
    str3 = Func(str3);
}

void main() {

}
