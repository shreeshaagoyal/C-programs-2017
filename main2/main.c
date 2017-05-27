#include <stdio.h>
#include <stdlib.h>

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
