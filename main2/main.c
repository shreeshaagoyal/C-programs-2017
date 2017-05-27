#include <stdio.h>
#include <stdlib.h>

typedef struct Node
{
    int value;
    struct Node *next;
} Node;


typedef struct List
{
    Node *head;
    Node *tail;
} List;

List * createList()
{
    List * a = malloc(sizeof(List));
    Node * init = malloc(sizeof(Node));
    a->head = init;
    a->tail = init;
    return a;
}

void appendElement(List *list, int val)
{
    Node * temp1 = malloc(sizeof(Node));
    list->tail->next = temp1;
    list->tail->value = val;
    list->tail = temp1;
    list->tail->next = 0;
}

void prependElement(List *list, int val)
{
    Node * temp = malloc(sizeof(Node));
    temp->value = val;
    temp->next = list->head;
    list->head = temp;
    list->tail = temp;
}

void printList(List *list)
{
    Node * temp = list->head;
    printf("[");
    while((temp->next) != 0)
    {
        printf("%d,", temp->value);
        temp = temp->next;
    }
    printf("]");
}

int main()
{
    List *list = createList();
    appendElement(list, 10);
    appendElement(list, 20);
    appendElement(list, -7);
    prependElement(list, 100);
    printList(list); // expect [10,20,-7,]
    return 0;
}
