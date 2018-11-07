#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int *generateVector(int n);
void printVector(int *Array, int numberOfElements);
int getBig(int *Array,int n);

int main(){
	int *myVector, mayor;
	myVector=generateVector(500000000);
    //printVector(myVector,10000000);
    mayor=getBig(myVector,500000000);
    printf("El mayor valor es %d:\n",mayor);
}

int *generateVector(int numberOfElements){
   int *myArray;
   srand(time(NULL));
   myArray=malloc(numberOfElements*sizeof(int));
   for (int i=0;i<numberOfElements;i++){
       myArray[i]=rand() % 100 + 1;
   }
   return myArray;
}

void printVector(int *Array, int numberOfElements){
     for (int i=0;i<numberOfElements;i++){
       printf("%d\n",Array[i]);
   }
}

int getBig(int *Array, int numberOfElements){
     int mayor=Array[0];
     for (int i=1;i<numberOfElements;i++){
     	if (Array[i]>mayor){
     		mayor=Array[i];
     	}
   }
   return mayor;
}