package lesson04;

import lesson02.Array;
import lesson04.Interface.*;

import java.util.*;
import java.util.stream.Stream;

public class AppRunb04 {

    public static void main(String[] args) {

        // задача №1
        // new MyWindow();

        // задача №2
        ArrayList<Integer> integerList = new ArrayList<Integer>();
        Integer[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        Index index;
        index = (ArrayList<Integer> x, int y) -> x.indexOf(y);

        for (int i = 0; i < list.length; i++) {
            integerList.add(list[i]);
        }
        int indexOf = index.ind(integerList,1);
        System.out.println("Index is " + indexOf);
    //    search(integerList);

        // задача №3
        Reverse reverse;
        System.out.println();
        System.out.println("java interview");
        reverse = (String sb) -> {StringBuffer buffer = new StringBuffer(sb);
                                    System.out.println(buffer.reverse());
                                     return sb; };
        String wordToReverse = reverse.reverse("java interview");
       // System.out.println(wordToReverse);

        // задача №4
        Maximum maximum;
        System.out.println();
        Integer[] listOfInt = {2,4,6,74,2,3,8,55,12};
        maximum = (Integer[] arr) ->{
            int max = 0;
            for (int i = 0; i < listOfInt.length; i++) {
                if(max <= listOfInt[i]){
                    max = listOfInt[i];
                }
            }
            System.out.println("Самое большое число: " + max);
            return max;};
        maximum.maximum(listOfInt);

        // задача №5
        Average average;
        System.out.println();
        List<Integer> list1 = Arrays.asList(12,23,22,1,36);
         System.out.println("Список: " + list1);
        average = (List<Integer> ll) -> {
            Integer[] arr = (Integer[]) list1.toArray();
            double averag = 0;
            double summ = 0;
            for (int i = 0; i < arr.length; i++) {
                summ = summ + arr[i];
            } averag = summ/ arr.length;
                          return averag;
        };
        System.out.println("Среднее значение списка:" + average.average(list1));

        // Задача №6
        System.out.println();
        List<String> listOfString = Arrays.asList("apple", "dog", "angle", "redux", "ale", "render", "application", "age");
        System.out.println("Список слов: " + listOfString);
        List<String> threeChars = new ArrayList<>();
        HashSet h = new HashSet<>(listOfString);
        Object[] wordsOnly = h.toArray();
        String str;
        for (int i = 0; i < wordsOnly.length; i++) {
            str = (String) wordsOnly[i];
            int count = 0;
            for(int j = 0; j<str.length(); j++) {
                count++;
            }
            if(count == 3){
                threeChars.add(str);
            }
        }
        System.out.println("Слова длинной в 3 буквы: " + threeChars);
        System.out.println("Слова на а:");

        String start = "a";
        threeChars.stream()
                .filter(x -> x.startsWith(start))
                .forEach(System.out::println);

        }



        


    private static void search(ArrayList<Integer> integerList) {

        System.out.println(integerList.indexOf(2));
    }

}