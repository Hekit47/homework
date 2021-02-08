package lesson04;

import lesson04.Interface.Index;
import lesson04.Interface.Maximum;
import lesson04.Interface.Reverse;

import java.util.ArrayList;

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

        }



        


    private static void search(ArrayList<Integer> integerList) {

        System.out.println(integerList.indexOf(2));
    }

}