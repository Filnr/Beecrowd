#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(void){
    char entrada[99999];
    fgets(entrada, sizeof(entrada), stdin);
    int i = 0;
    int qtAssuntos = 0;
    while(entrada[i] != '\0'){
        if(entrada[i] == '('){
            qtAssuntos++;
        }
        else if(entrada[i] == ')' && (qtAssuntos > 0)){
            qtAssuntos--;
        }
        i++;
    }
    if(qtAssuntos > 0){
        printf("Ainda temos %d assunto(s) pendente(s)!\n", qtAssuntos);
    }
    else{
        printf("Partiu RU!\n");
    }
}