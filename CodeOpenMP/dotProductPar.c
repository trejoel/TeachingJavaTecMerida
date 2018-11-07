//The following program look for an element in an unsorted vector
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>

#define bool int
#define true 1
#define false 0

double *generateRandomArray(int numberOfElements);
double dotProductSeq(double *A, double *B, int numberOfElements);
double dotProduct(double *A,double *B, int numberOfElements);
void printArray(double *A, int n);

int main(int argc, char *argv[]){
   double *A, *B;
   double C,D;
   int n;
   printf("De cuantos elementos son los arreglos\n");
   scanf("%d",&n);
   A=generateRandomArray(n);
   //printArray(A,n);
   B=generateRandomArray(n);
   //printArray(B,n);
   C=dotProductSeq(A,B,n);
   D=dotProduct(A,B,n);
   free(A);
   free(B);
}

double *generateRandomArray(int numberOfElements){
   double *myArray;
   srand(time(NULL));
   myArray=malloc(numberOfElements*sizeof(double));
   for (int i=0;i<numberOfElements;i++){
       myArray[i]=rand() % 100 + 1;
   }
   return myArray;
}

void printArray(double *A, int n){
   
    printf("Arreglo=");
   for (int i=0;i<n;i++){
       printf("%f  ",A[i]);
   }
   printf("\n");
}

double dotProductSeq(double *A, double *B, int numberOfElements){
   double C=0;
   double wtime=0;
   wtime = omp_get_wtime ();
   for (int i=0;i<numberOfElements;i++){
        //printf("C=%d+A[%d]*B[%d]\n", C, i,i);
        C+=A[i]*B[i];
   }
   printf("El producto punto es %f\n", C);
   wtime = omp_get_wtime ()-wtime;
  printf("Tiempo de respuesta secuencial:%f\n",wtime);
   return C;
}

double dotProduct(double *A, double *B, int numberOfElements){
   double C=0;
   double wtime=0;
   wtime = omp_get_wtime ();
   #pragma omp parallel for reduction (+:C)
   //#pragma omp parallel for
   for (int i=0;i<numberOfElements;i++){
        //printf("C=%d+A[%d]*B[%d]\n", C, i,i);
        C+=A[i]*B[i];
   }
   printf("El producto punto es %f\n", C);
   wtime = omp_get_wtime ()-wtime;
   printf("Tiempo de respuesta paralelo:%f\n",wtime);
   return C;
}


