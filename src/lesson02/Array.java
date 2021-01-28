package lesson02;

public class Array {

    String[][] arr = {{"12", "3", "we", "34"}, {"23", "sdf", "23d", "df"}, {"g5", "7", "gh", "x"}, {"x2", "x3", "f4", "1"}};




    public void arrayInfo() {

        System.out.println("The Array was created");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("" +
                "");
    }

    //метод проверяет соответствие массива размеру 4 на 4
    public void MySizeArrayException() {
        if(arr.length != 4 || arr[0].length != 4){
            throw  new NullPointerException("MyArraySizeException");
        }
        System.out.println("Размер массива 4.4");
        System.out.println("" +
                "");
    }

    public void MyArrayDataException() {
        System.out.println("Let's try to summ all elements from array!");
        int summOfInt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
               try {
                   summOfInt = summOfInt + Integer.parseInt(arr[i][j]);
               } catch (NumberFormatException e){
                   //System.out.println(e.getMessage());
                   System.out.println("Element '" + arr[i][j] + "' from cell #" + i + "." + j + " unable to convert from String to int!");
               }
            }
        }
        System.out.println("_________________________");
        System.out.println("Summ of all converted elements is " +  summOfInt);
    }



}

