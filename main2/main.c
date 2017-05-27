#include <stdio.h>
#include <stdlib.h>

typedef struct List
{
    Node *head;
    Node *tail;
} List;

typedef struct Node
{
    int value;
    struct Node *next;
} Node;

List * createList()
{
}

void addElement(List *list, int val)
{
}

void printList(List *list)
{
}

int main()
{
    List *list = createList();
    addElement(list, 10);
    addElement(list, 20);
    addElement(list, -7);
    printList(list); // expect [10,20,-7,]
    return 0;
}
