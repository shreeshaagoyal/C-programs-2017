/*
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int age;
    printf("Please enter the age: ");
    scanf("%d",&age);
    if(age>18)
    {
        printf("Age is greater than 18");
    }
    else
    {
        printf("Age is not greater than 18");f
    }
}



PROGRAM 2
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a=19,b=20;
    int c;
    ///() ? () : ()
    c = (a > b) ? a : b;
    printf("%d",c);
}



PROGRAM 3
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int mark=90;

    switch (mark)
    {
    case 95:
    case 90:
        printf("Excellent");
        break;

    case 75:
        printf("V good");
        break;

    case 60:
        printf("good");
        break;

    case 40:
        printf("meh");
        break;

    default:
        printf("grade unavailable");

    }
}



PROGRAM 4
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i=0;

    while(i<=10)
    {
        printf("i = %d\n",i);
        i++;
    }

    do
    {
        printf("i = %d\n",i);
        i++;
    } while(i<=10);

}


#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i=0;

    while(i<=10)
    {
        printf("i = %d\n",i);
        i++;
    }

    do
    {
        printf("i = %d\n",i);
        i++;
    } while(i<=10);

}


PROGRAM 5
#include <stdio.h>
#include <stdlib.h>

int main()
{
    for(int i=0; i<=10; i++)
    {
        printf("i = %d\n",i);
    }
}


//PROGRAM 6: FUNCTIONS
#include <stdio.h>
#include <stdlib.h>

void Sum(int a, int b)
{
    int sum=a+b;
    printf("sum = %d\n",sum);
}

int main()
{
    int a,b;
    printf("Enter a: ");
    scanf("%d",&a);
    printf("Enter b: ");
    scanf("%d",&b);
    Sum(a,b);

}



//PROGRAM 7: RETURN VALUES IN FUNCTIONS
#include <stdio.h>
#include <stdlib.h>


int foo()
{
    int arr[1000];

    int * a = arr;

    int i;
    for (i = 0; i < 10; i++)
    {
        a[i] = i * i;
    }

    arr[0] = 1000;

    for (i = 0; i < 10; i++)
    {
        printf("Index %d: %d\n", i, a[i]);
    }
    return 2+3;
}

int bar()
{
    int a = 15;
    printf("Value of a is %d\n", a);
    int * b = &a;
    *b = 90;
    printf("Value of a is %d\n", a);
}

int baz()
{
    unsigned int a = 1831079376;
    unsigned int * b = &a;
    unsigned char * c = b;
    c = c + 3;
    printf("Hello : %d\n", *c);
}

int main()
{
    baz();
    int prod = 10;
    printf("Product = %d\n",prod);
    return 0;
}



ASSIGNMENT
#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a, sum=0;
    printf("Enter an integer: ");
    scanf("%d",&a);
    for(int i=0; i<=a; i++)
    {
        sum = sum+i;
    }
    printf("Total sum = %d",sum);
    return 0;
}



int * foo()
{
    int * a = (int *) malloc(101 * sizeof(int));
    int i;
    for (i = 0; i < 100; i ++)
    {
        a[i] = 100 + i;
    }
    a[100] = -1;
    return a;
}

int main()
{
    printf("Hello, world!\n");
    int * a = foo();
    int i;
    for (i = 0; i < 100; i ++)
    {
        printf("Value is : %d\n", a[i]);
    }
    return 0;
}


int

int * foo(int size)
{
    int * a = (int *) malloc((size + 1) * sizeof(int));
    int i;
    for (i = 0; i < size; i ++)
    {
        a[i] = size + i;
    }
    a[size] = -1;
    return a;
}

int main()
{
    int size;
    printf("Hello, world!\n");
    printf("Please enter number of bites : ");
    scanf("%d",&size);
    int * a = foo(size);
    int i = 0;
    while(a[i]>0)
    {
        i++;
    }
    printf("Size of array a is : %d", i);
    return 0;
}


///ASSIGNMENT: ADDING TWO ARRAYS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int ArraySize(int a[])
{
    int size = 0;
    while(a[size]>0)
    {
        size++;
    }
    return size;
}

int * ArrayAdder(int sizeA, int sizeB, int * a, int * b)
{
    int * sum = malloc((sizeA + sizeB + 1)*(sizeof(int)));
    int i;
    for(i = 0; i < sizeA ; i++)
    {
        sum[i] = a[i];
    }
    for(i = 0; i < sizeB ; i++)
    {
        sum[sizeA+i] = b[i];
        printf("b[i] = %d\n", b[i]);
    }
    sum[sizeA+sizeB] = -1;
    return sum;
}

int main()
{
    int sizeA, sizeB;
    int a[] = {1,2,3,4,5,-1};
    int b[] = {7,8,9,-1};
    sizeA = ArraySize(a);
    sizeB = ArraySize(b);
    printf("sizeA = %d\n", sizeA);
    printf("sizeB = %d\n", sizeB);
    int * sum = ArrayAdder(sizeA, sizeB, a, b);
    int i;
    for(i = 0; i < sizeA + sizeB + 1; i++)
    {
        printf("%d\n",sum[i]);
    }
    free(sum);
    return 0;
}


int main()
{
    char hello[] = "Shivanshu Goyal";
    hello[15] = 1;
    printf("My name is %s\n", hello);
    int i;
    for (i = 0; i < 16; i++)
    {
        printf("Char: %d\n", hello[i]);
    }
    int length = strlen(hello);
    printf("The length is : %d\n", length);
}



struct student {
    int age;
    char * name;
};

void printStudent(struct student stu)
{
    printf("Student: Age is %d, and name is %s\n", stu.age, stu.name);
}

int main()
{
    struct student a, b;

    a.age = 10;
    a.name = "Shreeshaa";

    b.age = 20;
    b.name = "Shivanshu";

    printStudent(a);
    printStudent(b);
}



struct user
{
    char * name;
    int age;
};

int maxUsers = 4;

void PrintList()
{
    printf("List Print...\n");
}

int AddUser(struct user * stu)
{
    char * userName;
    printf("Enter name : ");
    scanf("%s);
    printf("Enter age : ");

}

int main()
{
    struct user allUsers[maxUsers];
    int numUsers = 0;
    return 0;
}



struct Node
{
    int data;
    struct Node * address;
};


int main()
{
    struct Node * A = 0;
    struct Node * temp = malloc(sizeof(struct Node));
    (*temp).data = 2;
    (*temp).address = 0;
    A = temp;
    printf("data in Node 1 : %d",*A);
    printf("address of Node 1 : %d",A.address);
    return 0;
}
*/
