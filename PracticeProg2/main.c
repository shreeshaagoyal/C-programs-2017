#include <stdio.h>
#include <stdlib.h>

int factorial(int num)
{
    int i, product=1;
    for(i = 1; i <= num; i++)
    {
        product = product*i;
    }
    return product;
}

int main()
{
   int fact = factorial(3);
   printf("fact = %d\n", fact);
   return 0;
}
