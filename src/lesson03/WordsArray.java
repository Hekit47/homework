package lesson03;

import java.util.*;

public class WordsArray {
    // инициализируем слова для массива
    String dog = "dog";
    String cat = "cat";
    String ball = "ball";
    String water = "water";
    String apple = "apple";
    String ice = "ice";
    String busket = "busket";
    String air = "air";
    String kitten = "kitten";
    String pepsi = "pepsi";
    // создаем массив из слов
    String[] arrayOfWords = {dog, cat, ball, water, cat, ice, ball, busket, water, apple, air
            , kitten, pepsi, air, water, cat, apple, water, cat, ball};
    // создаем пустой лист
    List<String> unicWordList = new ArrayList<>();




//        // метод, в котором перебираем слова массива и, в случае их уникальности, заносим в лист
//        checkUnicWordsInArray(arrayOfWords, unicWordList);
//
//        // метод, выводящий массив в консоль
//        arrayInfo(arrayOfWords);
//
//        // сортируем слова по алфавиту
//        System.out.println("Слова, которые не повторяются!");
//        Collections.sort(unicWordList);
//
//        // выводим отсортированный лист уникальных слов
//        System.out.println(unicWordList);
//
//        // выводим количество уникальных слов
//        System.out.print("Всего уникальных слов: ");
//        System.out.println(unicWordList.size());
//
//        // считаем количество повторений каждого слова
//        countWordRepeat(arrayOfWords);



    public void countWordRepeat() {
        // создаем лист, в котором нет дубликатов слов из массива
        List<String> wordlist1 = Arrays.asList(arrayOfWords);
        System.out.println();
        System.out.println("Подсчет повторений слов из массива: ");
        HashSet h = new HashSet<>(wordlist1);

//        // вывод в консоль того, что получилось
//        System.out.println(h);
//        System.out.println(h.size());

        // создаем массив слов, чтобы сравнить
        Object[] wordsOnly = h.toArray();

        // перебираем через for кол-во повторений каждого слова
        for (int i = 0; i < wordsOnly.length; i++) {
            int wordCount = 0;
            for (int j = 0; j < arrayOfWords.length; j++) {
                String a = (String) wordsOnly[i];
                String b = arrayOfWords[j];
                if(a == b){
                    wordCount = wordCount + 1;
                }}
            System.out.println("Слово " + wordsOnly[i] + " встречается " + (wordCount) + " раз!");
        }
    }

    public void arrayInfo() {
        System.out.println("");
        System.out.print("Представлен массив из слов: [" );
        for (int i = 0; i < arrayOfWords.length; i++) {
            System.out.print(" " + arrayOfWords[i] + " ");
        }
        System.out.println("]");
    }

    public void checkUnicWordsInArray() {
        System.out.println("");
        for (int i = 0; i < arrayOfWords.length; i++) {
            int unicCount = 0;
            for (int j = 0; j < arrayOfWords.length; j++) {
                String a = arrayOfWords[i];
                String b = arrayOfWords[j];
                if(a == b){
                    unicCount = unicCount + 1;
                }}
            if(unicCount == 1){
                unicWordList.add(arrayOfWords[i]);
            }
        }
        System.out.print("Уникальные слова: ");
        Collections.sort(unicWordList);
        System.out.println(unicWordList);
        System.out.print("Всего уникальных слов: ");
        System.out.println(unicWordList.size());
        System.out.println("");
    }
}


