package lesson03;

import java.util.HashMap;

public class PhoneBook {

    public void PhoneBook() {

// создаем телефонный справочник по фамилиям
        HashMap<String, String> phoneBook = new HashMap<String, String>();

        //заполняем справочник методом add()


//        add(phoneBook, "Antonov","+79001234566");
//        add(phoneBook, "Egorov", "+79003500000");
//        add(phoneBook, "Petrov","+79003511111");
//        add(phoneBook, "Antipov","+79003519411");
//        add(phoneBook, "Navalnyi","+79053575511");
//        add(phoneBook,"Navalnyi","+70000000000");
//        add(phoneBook, "Navalnyi","+79053575511");
//        add(phoneBook,"Navalnyi","+70000000000");
//        add(phoneBook, "Putin", "+79103102311");
//        add(phoneBook, "Medvedev", "+79003516511");
//        add(phoneBook, "Antipov","+79003519411");
//        add(phoneBook, "Navalnyi","+79053575511");
//        add(phoneBook,"Navalnyi","+70000000000");
//        add(phoneBook, "Navalnyi","+79053575511");
//        add(phoneBook,"Navalnyi","+70000000000");
//        add(phoneBook, "Putin", "+79103102311");
//        add(phoneBook, "Medvedev", "+79003516511");
//
//        // ищем в справочние контакты по фамилии
//        get(phoneBook, "Sidorov");
//        get(phoneBook, "Navalny");

    }

    public static void get(HashMap<String, String> phoneBook, String secondName) {
        secondName = secondName;
        if(phoneBook.get(secondName) == null){
            System.out.println("Contact " + secondName + " wasn't found!" );
        } else {
            System.out.println("Contact " + secondName + " has " + phoneBook.get(secondName) + " phone number(s)");}
    }

    static void add(HashMap<String, String> phoneBook, String secondName, String phoneNumber) {
        if(phoneBook.containsKey(secondName)) {
            phoneBook.put(secondName, phoneBook.get(secondName) + "; " + phoneNumber);
        }else
        {
            phoneBook.put(secondName, phoneNumber);
        }

    }


}


