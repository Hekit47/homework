package lesson05;

public class Array01 {
    static long time;
    static final int size = 10000000;
    static final int h = size / 2;

    public void array01() {
        // создаем первый массив
        float[] arr1 = new float[size];
        //заполняем массив единицами
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=1;
        }
        //зачекаем время до заполнения массива
        long timeStart1 = System.currentTimeMillis();
        for (int j = 0; j < arr1.length; j++) {
            arr1[j] = (float)(arr1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
        //засекаем время после заполнения массива
        long timeFinish1 = System.currentTimeMillis();
        System.out.println("Создали массив и заполнили за: " + (timeFinish1 - timeStart1) + "ms");
    }
}
