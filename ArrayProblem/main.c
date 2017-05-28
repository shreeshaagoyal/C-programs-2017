#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int ArraySize(int arr[])
{
    int size = 0;
    while(arr[size]>0)
    {
        size++;
    }
    return size;
}

int * printArr(int n, int arr[], int newArr[])
{
    int i;
    for(i = 0; i < n; i++)
    {
        newArr[i] = arr[i];
        ///printf("%d\n", newArr[i]);
    }
    return newArr;
}

int * nextArr(int n, int arr[], int newArr[])
{
    int i = 1, a, temp = n;
    while(1)
    {
       for(a=0; a < (n-i); a++)
       {
           int b;
           for(b = 0; b < (n-i); b++)
            {
                newArr[temp] = arr[i*n];
                temp++;
                ///printf("%d\n", newArr[i]);
            }
            for(b; b < (n-i); b++)
            {
                newArr[temp] = arr[i-1];
                temp++;
            }
            for(b; b < (n-i-1); b++)
            {
                ///
            }
            for(b; b < (n-i-1); b++)
            {
                ///
            }
       }
       if(i>=((2*n)-2))
       {
           break;
       }
    }
    return newArr;
    i=i+2;
}

/*
int main()
{
    int size, n;
    int * a, b;
    int arr[] = {1,20,3,4,5,6,7,8,9,10,11,12,13,14,15,16,0};
    size = ArraySize(arr);
    int newArr[size];
    printf("size of array is : %d\n", size);
    n = (long) sqrt(size);
    printf("square root of %d : %d\n", size, n);
    a = printArr(n, arr, newArr);
    int i;
    ///b = nextArr(n, arr, newArr);
    for(i = 0; i < size; i++)
    {
        printf("%d\n", *(a+i));
    }
    return 0;
}
*/
