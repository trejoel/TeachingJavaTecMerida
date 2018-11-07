#include <stdlib.h>
#include <stdio.h>
#include <omp.h>

int main ( int argc, char *argv[] );
int cuentaPrimos(int N);
int cuentaPrimosPar(int N);
int esPrimo(int K);

int main ( int argc, char *argv[] )
{
    int N,totales;
    printf("Este programa regresa todos los numeros primos del 2 al N. Ingrese un valor para N\n");
    scanf("%d",&N);
    totales=cuentaPrimos(N);
    totales=cuentaPrimosPar(N);
    printf("Existen %d primos entre 2 y %d\n",totales, N);
	return 0;
}

int cuentaPrimos(int N){
  double wtime=0;
  wtime = omp_get_wtime ( );
	int i,Total=0;
    for (i=2;i<N;i++){
    	if (esPrimo(i)==0){
    		Total++;
    	}
    }
    wtime = omp_get_wtime ( )-wtime;
    printf("Secuencial tardo %f \n",wtime);
    return Total;
}

int cuentaPrimosPar(int N){
  double wtime=0;
  wtime = omp_get_wtime ( );
	int i,Total=0;
	#pragma omp parallel for reduction (+:Total)
      for (i=2;i<N;i++){
     	 if (esPrimo(i)==0){
     		Total++;
     	 } 
      }		
    wtime = omp_get_wtime ( )-wtime;
    printf("Paralelo tardo %f \n",wtime);
    return Total;
}

int esPrimo(int K){
   if (K==2){
   	  // printf("El %d es primo\n",K);
   	  return 0;
   }
   for (int i=2;i<K-1;i++){
      if (K % i ==0){
           return 1;
      }
   }
   //printf("El %d es primo\n",K);
   return 0;
}

