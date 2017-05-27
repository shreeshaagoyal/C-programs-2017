#include <stdio.h>
#include <stdlib.h>

/*

typedef struct student
{
    char *name;
    int age;
} student;

typedef struct classroom
{
    struct student * s1;
    struct student * s2;
} classroom;

void printStudentName(struct student foo)
{
    printf("Name is %s and age is %d\n", foo.name, foo.age);
}

void printClassroom(struct classroom c1)
{
    printStudentName(*(c1.s1));
    printStudentName(*(c1.s2));
}

char * getFooArray()
{
    char * name = malloc(4);
    name[0] = 'f';
    name[1] = 'o';
    name[2] = 'o';
    name[3] = 0;
    return name;
}

int main()
{
    printf("Hello world!\n");
    student shivanshu;
    student *shreeshaa;
    shivanshu.name = getFooArray();
    shivanshu.age = 23;
    shreeshaa = malloc(sizeof(student));
    //(*shreeshaa).age = 18;
    shreeshaa->age = 18;
    shreeshaa->name = "Shreeshaa";
    classroom *c1 = malloc(sizeof(classroom));
    c1->s1 = &shivanshu;
    c1->s2 = shreeshaa;
    //shivanshu.name[0] = 'B';
    shivanshu.age = 100;
    printClassroom(*c1);
    free(shreeshaa);
    return 0;
}

*/

typedef struct Node
{
    int value;
    struct Node *next;
} Node;

Node * createList()
{
    Node * a = malloc(sizeof(Node));
    a->next = 0;
    return a;
}

void addElement(Node *head, int val)
{
    Node * temp = head;
    while((temp->next) != 0)
    {
        temp = temp->next;
    }
    Node * temp1 = malloc(sizeof(Node));
    temp->value = val;
    temp->next = temp1;
    temp1->next = 0;
}

void printList(Node *head)
{
    printf("[");
    Node * temp = head;
    while((temp->next) != 0)
    {
        printf("%d,", temp->value);
        temp = temp->next;
    }
    printf("]");
}

int main()
{
    Node *list = createList();
    addElement(list, 10);
    addElement(list, 20);
    addElement(list, -7);
    printList(list); // expect [10,20,-7,]
    return 0;
}
