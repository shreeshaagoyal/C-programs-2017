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
    a->head = 0;
    a->tail = 0;
    return a;
}

void appendElement(List *list, int val)
{
    Node * temp = malloc(sizeof(Node));
    if(list->head == 0)
    {
        list->head = temp;
        list->tail = temp;
        list->tail->next = 0;
        list->tail->value = val;
    }
    else
    {
        list->tail->next = temp;
        list->tail = temp;
        list->tail->value = val;
        list->tail->next = 0;
    }

}

void prependElement(List *list, int val)
{
    Node * temp = malloc(sizeof(Node));
    temp->value = val;
    if(list->head == 0)
    {
        list->head = temp;
        list->tail = temp;
        list->tail->next = 0;
    }
    else
    {
        temp->next = list->head;
        list->head = temp;
    }
}

void printList(List *list)
{
    Node * temp = list->head;
    printf("[");
    while((temp) != 0)
    {
        printf("%d,", temp->value);
        temp = temp->next;
    }
    printf("]");
}

int main()
{
    List *list = createList();
    prependElement(list, 100);
    appendElement(list, 10000);
    printList(list); // expect [10,20,-7,]
    return 0;
}
