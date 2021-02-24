package lesson05;

public class AppRun05 {

    static long time;
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        System.out.println("Создаем и заполняем первый массив...");
        Array01 array01 = new Array01();
        array01.array01();
        System.out.println("_____________________________________________");

        System.out.println("Создаем и заполняем второй массив...");
        Array02 array02 = new Array02();
        array02.array02();



    }

//    private static void array02() {
//        // создаем второй массив
//        float[] arr2 = new float[size];
//        float[] a1 = new float[h];
//        float[] a2 = new float[h];
//        //зачекаем время до заполнения массива
//        long timeStart2 = System.currentTimeMillis();
//        //заполняем массив единицами
//        for (int i = 0; i < arr2.length; i++) {
//            arr2[i]=1;
//        }
//        System.arraycopy(arr2, 0, a1, 0, h);
//        System.arraycopy(arr2, h, a2, 0, h);
//        for (int j = 0; j < a1.length; j++) {
//            a1[j] = (float)(a1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
//        }
//        System.out.println(System.currentTimeMillis() - timeStart2);
//        for (int j = 0; j < a2.length; j++) {
//            a2[j] = (float)(a2[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
//        }
//        System.out.println(System.currentTimeMillis() - timeStart2);
//        System.arraycopy(a1, 0, arr2, 0, h);
//        System.arraycopy(a2, 0, arr2, h, h);
//
//        //засекаем время после заполнения массива
//        long timeFinish2 = System.currentTimeMillis();
//        System.out.println("Время заполнения второго массива: " + (timeFinish2 - timeStart2) + " миллисекунд.");
//    }

//    private static void array01() {
//        // создаем первый массив
//        float[] arr1 = new float[size];
//        //зачекаем время до заполнения массива
//        long timeStart1 = System.currentTimeMillis();
//        //заполняем массив единицами
//        for (int i = 0; i < arr1.length; i++) {
//            arr1[i]=1;
//        }
//        for (int j = 0; j < arr1.length; j++) {
//            arr1[j] = (float)(arr1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
//        }
//        //засекаем время после заполнения массива
//        long timeFinish1 = System.currentTimeMillis();
//        System.out.println("Время заполнения первого массива: " + (timeFinish1 - timeStart1) + " миллисекунд.");
//    }
}

