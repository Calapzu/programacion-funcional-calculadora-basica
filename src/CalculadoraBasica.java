import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;


public class CalculadoraBasica {
    static IntBinaryOperator suma = (a, b) -> a+b;
    static IntBinaryOperator resta = (a, b) -> a-b;
    static IntBinaryOperator multiplicacion = (a, b) -> {
        return IntStream.range(0, (b+1))//Math.abs(b)+1
                .reduce((acomulado, numero) -> suma.applyAsInt(acomulado, a)).hashCode();
                //.getAsInt();
    };

    static BiFunction<Integer, Integer, Integer> division = (a,b) -> {
        if (a.equals(0) || b.equals(0)){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        return IntStream.range(0,a).reduce((acomulador, numero) -> multiplicacion.applyAsInt(numero, b) <= a ? suma.applyAsInt(acomulador, 1) : acomulador).orElse(0);
    };


    public static void main(String[] args) {
        //System.out.println(suma.applyAsInt(-5,-3));
        //System.out.println(resta.apply(5,3));
        //System.out.println(multiplicacion.applyAsInt(5,0));
        System.out.println(division.apply(10,2));

    }
}
