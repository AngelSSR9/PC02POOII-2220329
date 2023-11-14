import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //1. Dada una lista de números enteros aleatorios, imprimir todos los números pares que
        //existen en la lista usando las funciones Stream. (1pto.)
        Random r = new Random();
        List<Integer> numeros = Stream.generate(r::nextInt)
                .limit(10)
                .toList();
        System.out.println("Numeros pares: ");
        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        //2. Dada una lista de números enteros aleatorios, imprimir todos los números que
        //comienzan con 5 usando las funciones Stream. (1pto.)
        System.out.println("Numeros que empiezan con 5: ");
        numeros.stream().filter(n -> n.toString().startsWith("5")).forEach(System.out::println);

        //3. Dada una lista de números enteros aleatorios, imprimir todos los números
        //duplicados usando las funciones Stream. (1pto.)
        System.out.println("Numeros duplicados: ");
        numeros.stream()
                .distinct()               // Filtra elementos únicos
                .filter(e -> numeros.indexOf(e) != numeros.lastIndexOf(e))  // Filtra duplicados
                .forEach(System.out::println);

        //4. Dada una lista de números enteros aleatorios, imprimir el número total de
        //elementos presentes en la lista usando funciones Stream. (1pto.)
        System.out.println("Cant. elementos con stream: " +  numeros.stream().count());
        System.out.println("Cant elementos: " + numeros.size());


        //5. Dada una lista de números enteros aleatorios, imprime todos los valores presentes
        //en ella en orden descendente utilizando las funciones Stream. (1pto.)
        System.out.println("Numeros ordenados de mayor a menor: ");
        numeros.stream().sorted((a,b) -> Integer.compare(b,a)).forEach(System.out::println);

        //6. Dado un array de números enteros, devuelve true si algún valor aparece al menos
        //tres veces en el array y devuelve falso si cada elemento es distinto. (1.5 ptos.)
        System.out.println(numeros.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .anyMatch(count -> count >= 3));

        //7. Dado dos arrays de cadenas, se desea concatenar. Por ejemplo: A[n] =
        //        {1,2,3,4,5,8,23} y B[m] = {4,6,8,0,2}, AB[n + m] = {1,2,3,4,5,8,23,4,6,8,0,2} (1.5 ptos.)
        List<String> array1 = Arrays.asList("1", "2", "3");
        List<String> array2 = Arrays.asList("4", "5", "6");
        System.out.println(Stream.concat(array1.stream(), array2.stream())
                .collect(Collectors.toList()));


        String[] arrayA = {"1", "2", "3", "4", "5", "8", "23"};
        String[] arrayB = {"4", "6", "8", "0", "2"};
        Stream.concat(Arrays.stream(arrayA), Arrays.stream(arrayB))
                .toArray(String[]::new);


        //8. Dado una lista de números enteros aleatorios, calcular el cubo de los números de
        //los elementos de lista y filtrar números mayores a 50. (1pto.)
        System.out.println("Numeros mayores a 50: ");
        numeros.stream().map(n -> n*n*n).filter(n -> n > 50).forEach(System.out::println);

        //9. ¿Cómo contabilizar el total de todos las palabras de un arreglo de cadena? (1pto.)
        List<String> aux = Arrays.asList("p1", "p2", "p3");
        System.out.println(aux.stream().count());


        //otra forma
        String[] arregloCadenas = {"Hola", "mundo", "esto", "es", "una", "prueba"};
        long totalPalabras = Arrays.stream(arregloCadenas)
                .mapToInt(s -> s.split("\\s+").length)
                .sum();


        //10. Dado un array de cadenas, ¿cómo encontramos solo elementos duplicados y el
        //número de veces? usando funciones Stream. (1.5 ptos.)
        Map<String, Long> duplicadosConFrecuencia = Arrays.stream(arregloCadenas)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    }
}
