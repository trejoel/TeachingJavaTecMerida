#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <omp.h>



float **generateRandomSquareMatrix(int numberOfElements);
float **addArray(float **A,float **B, int numberOfElements);
float **addArrayPar(float **A,float **B, int numberOfElements);

void printArray(float **myArray, int N);

int main(int argc, char *argv[]){
   float **A, **B, **C, **D;
   int n;
   printf("De cuantos elementos son las matrices\n");
   scanf("%d",&n);
   A=generateRandomSquareMatrix(n);
   B=generateRandomSquareMatrix(n);
   //printArray(A,n);
   //printArray(B,n);
   C=addArray(A,B,n);
   D=addArrayPar(A,B,n);
   //printArray(C,n);
   //printArray(D,n); 
   free(A);
   free(B);
   free(C);
   free(D);

}

float **generateRandomSquareMatrix(int numberOfElements){
   float **myArray;
   myArray = (float **)malloc(numberOfElements*sizeof(float*));
   for (int i=0; i<numberOfElements; i++){
   	 myArray[i]=(float *)malloc(numberOfElements*sizeof(float));
   }
   srand(time(NULL));
   for (int i=0;i<numberOfElements;i++){
   	  for (int j=0; j<numberOfElements; j++){
   	     myArray[i][j]=rand()%10;	
   	  }   
   }
   return myArray;
}

float **addArray(float **A, float **B, int numberOfElements){
   float **C;
   double wtime=0;
   C = (float **)malloc(numberOfElements*sizeof(float*));
   for (int i=0; i<numberOfElements; i++){
       C[i]=(float *)malloc(numberOfElements*sizeof(float));
   }
    // printf("wtime:%f",omp_get_wtime());
   wtime = omp_get_wtime( );
   for (int i=0; i<numberOfElements; i++){
      for (int j=0;j<numberOfElements; j++){
            C[i][j]=A[i][j]+B[i][j];
         }
      }
     // printf("wtime:%f",omp_get_wtime());
    wtime = omp_get_wtime( )- wtime;
      printf("Tiempo de espera secuencial %f\n",wtime );
      return C;
}

float **addArrayPar(float **A, float **B, int numberOfElements){
   float **C;
   double wtime=0;
   int i, tid,nthreads,begin,end,load;
   C = (float **)malloc(numberOfElements*sizeof(float*));
   for (int i=0; i<numberOfElements; i++){
   	 C[i]=(float *)malloc(numberOfElements*sizeof(float));
   }
    wtime = omp_get_wtime ( );
   #pragma omp parallel private (i, tid, nthreads, begin, end, load) 
   {
     nthreads=omp_get_num_threads();
     tid=omp_get_thread_num();
     load=numberOfElements/nthreads;
     begin=tid*load;
     end=begin+load;
    for (i=begin; i<end; i++){
      for (int j=0;j<numberOfElements; j++){
      		C[i][j]=A[i][j]+B[i][j];
      	}
      }
     if (tid==0){
      for (i=load*(nthreads+1);i<numberOfElements; i++){
       for (int j=0;j<numberOfElements; j++){
          C[i][j]=A[i][j]+B[i][j];
        }
      }        
     }
   }  //end of the pragma
    wtime = omp_get_wtime ( )-wtime;
    printf("Tiempo de espera paralelo %f\n",wtime );
   return C;
}

void printArray(float **myArray, int N){	
	for (int i=0; i<N; i++){
		for (int j=0; j<N; j++){
			printf("Elemento C[%d][%d]=%f ",i,j,myArray[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}