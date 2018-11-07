#include <stdio.h>

int main(){
    int A[10];
    int i;
    int mayor;
    printf("Captura los enteros\n");
    for (i=0; i<10; i++){
    	scanf("%d",&A[i]);
    }
    mayor=A[0];
    for (i=1;i<10;i++){
       if (mayor<A[i]){
         mayor=A[i];
       }
    }
    printf("El elemento mayor es %d \n",mayor);
	return 0;
}