
/*
    Tipos de Datos en Java
    
    byte - 8 bits
    short - 16 bits
    int - 32 bits
    long 64 bits
    
    Overflows:
    byte : 12 termino
    short : 24 termino
    int : 47 termino
    long : 93 termino
    
*/

import java.math.BigInteger; 
import java.util.Arrays;

class Fibonacci{
    
    public static BigInteger fibonnaci(BigInteger n){
        if( n.compareTo(BigInteger.valueOf(2)) < 0 )
            return n;
        
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(1);
        BigInteger aux;
        for(BigInteger i = BigInteger.valueOf(1); i.compareTo(n) < 0; i = i.add(BigInteger.valueOf(1))){
            aux = b;
            b = b.add(a);
            a = aux;
        }
        return b;
    }
    
    public static void main(String[] arguments){
        String[] data = fibonnaciOverflows();
        //System.out.println(Arrays.toString(data));
    }
    
    
    private static String[] fibonnaciOverflows(){
        String[] t_datos = new String[4];
        int indice = 0;
        BigInteger n = BigInteger.valueOf(0);
        boolean flag = false;
        while (true){
            BigInteger fibo = fibonnaci(n);
            switch(indice){
                case 0:
                    if( fibo.compareTo(BigInteger.valueOf(Byte.MAX_VALUE)) > 0 ){
                        String respuesta = overflows(indice, n);
                        System.out.println(respuesta);
                        t_datos[indice] = respuesta;
                        indice = 1;
                    }
                    break;
                case 1:
                    if( fibo.compareTo(BigInteger.valueOf(Short.MAX_VALUE)) > 0 ){
                        String respuesta = overflows(indice, n);
                        System.out.println(respuesta);
                        t_datos[indice] = respuesta;
                        indice = 2;
                    }
                    break;
                case 2:
                    if( fibo.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ){
                        String respuesta = overflows(indice, n);
                        System.out.println(respuesta);
                        t_datos[indice] = respuesta;
                        indice = 3;
                    }
                    break;
                case 3:
                    if( fibo.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 ){
                        String respuesta = overflows(indice, n);
                        System.out.println(respuesta);
                        t_datos[indice] = respuesta;
                        flag = true;
                    }
                    break;
            }
            n = n.add(BigInteger.valueOf(1));
            if(flag)
                break;
        }
        return t_datos;
    }
    
    private static String overflows(int indice, BigInteger n){
        switch(indice){
            case 0:
                return "El tipo de dato byte tiene overflow en : "+String.valueOf(n);
            case 1:
                return "El tipo de dato short tiene overflow en : "+String.valueOf(n);
            case 2:
                return "El tipo de dato int tiene overflow en : "+String.valueOf(n);
            case 3:
                return "El tipo de dato long tiene overflow en : "+String.valueOf(n);
        }
        return "";
    }
    
}