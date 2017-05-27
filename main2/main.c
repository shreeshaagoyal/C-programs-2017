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

void addElement(List *list, int val)
{
    Node * temp1 = malloc(sizeof(Node));
    list->tail->next = temp1;
    list->tail->value = val;
    list->tail = temp1;
    list->tail->next = 0;
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
    addElement(list, 10);
    addElement(list, 20);
    addElement(list, -7);
    printList(list); // expect [10,20,-7,]
    printList(list); // expect [10,20,-7,]
    return 0;
}
