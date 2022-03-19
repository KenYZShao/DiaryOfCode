#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int Max(int a, int b){
    if(a>b)
    return a;
    else
    return b;
}

int main() 
{

    int n;
    scanf("%d", &n);
  	// Complete the code to print the pattern.
      
    for(int i=1;i<=2*n-1;i++)
    {
        for(int j=1;j<=2*n-2;j++)
        {
            printf("%d ", Max(abs(n-i),abs(n-j))+1);//Leave a space after %d
        }
        printf("\n");
    }
    return 0;
}
