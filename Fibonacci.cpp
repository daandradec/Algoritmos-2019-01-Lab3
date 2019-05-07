#include <iostream>
#include <limits>
#include<string>

using namespace std;

/*

    char  - 8 bits
    short - 16 bits
    int - 32 bits
    long  - 32 bits o 64 bits
    long long - 64 bits
    
    Overflows:
    byte : 12 termino
    short : 24 termino
    int : 47 termino
    long : 93 termino    
    long long: 95 termino    
*/

unsigned long long fibonacci(unsigned long long n){
    if( n <= 1)
        return n;
    
    unsigned long long a = 0;
    unsigned long long b = 1;
    unsigned long long aux;
    for(unsigned long long i = 1; i < n;++i){
        aux = b;
        b = a+b;
        a = aux;
    }
    return b;
}

string overflows(int indice, unsigned long long n){
    switch(indice){
        case 0:
            return "El tipo de dato char tiene overflow en " + to_string(n);
        case 1:
            return "El tipo de dato short tiene overflow en " + to_string(n);
        case 2:
            return "El tipo de dato int tiene overflow en " + to_string(n);
        case 3:
            return "El tipo de dato long tiene overflow en " + to_string(n);
        case 4:
            return "El tipo de dato long long tiene overflow en " + to_string(n);
    }
}

void overflowFibonacci(){
    int indice = 0;
    unsigned long long n = 0;
    bool flag = false;
    
    char MAX_CHAR = (char) 127;
    short MAX_SHORT = numeric_limits<short>::max();
    int MAX_INT = numeric_limits<int>::max();
    long MAX_LONG = numeric_limits<long>::max();
    long long MAX_LONG_LONG = numeric_limits<long long>::max();

    while(true){
        unsigned long long fibo = fibonacci(n);
        switch(indice){
            case 0:
                if(fibo > (int) MAX_CHAR){
                    cout<<overflows(indice,n)<<endl;
                    indice = 1; 
                }
                break;
            case 1:
                if(fibo > MAX_SHORT){
                    cout<<overflows(indice,n)<<endl;
                    indice = 2; 
                }
                break;
            case 2:
                if(fibo > MAX_INT){
                    cout<<overflows(indice,n)<<endl;
                    indice = 3; 
                }
                break;
            case 3:
                if(fibo > MAX_LONG){
                    cout<<overflows(indice,n)<<endl;
                    indice = 4; 
                }
                break;
            case 4:
                if(fibo > MAX_LONG_LONG){
                    cout<<overflows(indice,n)<<endl;
                    flag = true;
                }
                break;                
        }
        ++n;
        if(flag)
            break;
    }
}

int main(){
    overflowFibonacci();
}