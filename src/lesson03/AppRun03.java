package lesson03;

import java.util.*;

public class AppRun03 {

    public static void main(String[ ] args) {
// задача 1
        System.out.println("Task 1");
        WordsArray wordsArray = new WordsArray();
        wordsArray.arrayInfo();
        wordsArray.countWordRepeat();
        wordsArray.checkUnicWordsInArray();


// задача 2

        System.out.println("Task 2");
        HashMap<String, String> phoneBook = new HashMap<>();

        add(phoneBook, "Sidorov", "+79001113334");
        add(phoneBook, "Antonov", "+79001234566");
        add(phoneBook, "Egorov", "+79003503200");
        add(phoneBook, "Petrov", "+79003511111");
        add(phoneBook, "Antipov", "+79003519411");
        add(phoneBook, "Navalnyi", "+79053575511");
        add(phoneBook, "Navalnyi", "+71234569878");
        add(phoneBook, "Navalnyi", "+79053575511");
        add(phoneBook, "Navalnyi", "+78152647167");
        add(phoneBook, "Putin", "+79103102311");
        add(phoneBook, "Medvedev", "+79003516511");
        add(phoneBook, "Antipov", "+790035132100");

        get(phoneBook, "Antipov");
        get(phoneBook, "Navalny");
        get(phoneBook,"Navalnyi");
        get(phoneBook,"Egorov");


    }

    private static void get(HashMap<String, String> phoneBook, String secondName) {
        PhoneBook.get(phoneBook, secondName);
    }

    private static void add(HashMap<String, String> phoneBook, String secondName, String phoneNumber) {
        PhoneBook.add(phoneBook, secondName, phoneNumber);
    }
}


