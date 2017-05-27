#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE * fPointer;

    /*
    fPointer = fopen("file.txt", "w");
    fprintf(fPointer, "Hello world! My name is Shreeshaa\n");
    */

    fPointer = fopen("file.txt", "r");
    char singleLine[100];
    while(!feof(fPointer))
    {
        ///fscanf(fPointer, "%s", singleLine);
        fgets(singleLine, 100, fPointer);
        puts(singleLine);
    }


    fclose(fPointer);
    return 0;
}
