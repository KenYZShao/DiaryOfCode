#include <iostream>
#include <cstdio>
using namespace std;

/*
Add `int max_of_four(int a, int b, int c, int d)` here.
*/
int max_of_four(int a,int b,int c,int d)
{
    int k;
    if(a>=b)
    {
        k=a;
        if(a>=c)
        {
            k=a;
            if(k>=d)
            {
                k=a;
            }
            else {
                k=d;
            }
        }
        else
        {
            k=c;
            if(k>=d)
            {
                k=c;
            }
            else {
                k=d;
            }
        }
    }
    else 
    {
        k=b;
        if(k>=c)
        {
            k=b;
            if(k>=d)
            {
                k=b;
            }
            else {
                k=d;
            }
        }
        else
        {
            k=c;
            if(k>=d)
            {
                k=c;
            }
            else
            {
                k=d;    
            }    
        }
    }
    
    return k;
}

int main() {
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four(a, b, c, d);
    printf("%d", ans);
    
    return 0;
}
