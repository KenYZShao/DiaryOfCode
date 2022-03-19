#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num, *arr, i;
    scanf("%d", &num);
    arr = (int*) malloc(num * sizeof(int));
    for(i = 0; i < num; i++) {
        scanf("%d", arr + i);
    }

    int *bbb;
    /* Write the logic to reverse the array. */

    for(i = num-1; i < -1; i--){
        //printf("%d ", *(arr + i));
        bbb = (int*) malloc(num * sizeof(int));
        printf("%d", *(bbb+i));
        }
    return 0;
}
