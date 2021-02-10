package lesson05;

public class Array02 extends Thread{
    static long time;
    static final int size = 10000000;
    static final int h = size / 2;

    public void array02() {
        // создаем второй массив
        float[] arr2 = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        //заполняем массив единицами
        for (int i = 0; i < arr2.length; i++) {
            arr2[i]=1;
        }
        //засекаем время до разбивки массива
        long time = System.currentTimeMillis();
        //разбиваем массив на 2 массива
        System.arraycopy(arr2, 0, a1, 0, h);
        System.arraycopy(arr2, h, a2, 0, h);
        //засекаем время после разбивки массива
        System.out.println("Создали массив и разбили на 2 части за: " + (System.currentTimeMillis() - time) + "ms");

        Thread t1 = new Thread(() -> {
            long timeStart1 = System.currentTimeMillis();
            for (int j = 0; j < a1.length; j++) {
                a1[j] = (float) (a1[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
            }
            long timeFin1 = System.currentTimeMillis();
            System.out.println("Первая часть посчиталась за: " + (timeFin1 - timeStart1) + "ms");
        });

        Thread t2 = new Thread(() -> {
            long timeStart2 = System.currentTimeMillis();
                for (int j = 0; j < a2.length; j++) {
                    a2[j] = (float) (a2[j] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                    //System.out.println(a2[j]);
                }
                long timeFin2 = System.currentTimeMillis();
            System.out.println("Вторая часть посчиталась за: " + (timeFin2 - timeStart2) + "ms");
        });

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(3000);
                final long timeStartMerge = System.currentTimeMillis();
                System.arraycopy(a1, 0, arr2, 0, h);
                System.arraycopy(a2, 0, arr2, h, h);
                System.out.println("Склеили массив из двух частей за: " + (System.currentTimeMillis() - timeStartMerge) + "ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        t1.start();
        t2.start();
        t3.start();





    }

}

