package java2.lesson3;

import java.util.*;

public class PhoneBookMain {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Pupkin", 89846012281L);
        phoneBook.add("Pupkin", 89866022282L);
        phoneBook.add("Pupkin", 89836032283L);
        phoneBook.add("Petrov", 89836063281L);
        phoneBook.add("Pupkin", 89856022284L);
        phoneBook.add("Petrov", 89826062282L);

        phoneBook.get("Pupkin");
        phoneBook.get("Petrov");

    }
}

    class PhoneBook {
        HashMap<String, HashSet<Long>> phoneBook1;

        PhoneBook() {
            this.phoneBook1 = new HashMap<>();
        }

        void add(String name, Long number) {
            HashSet<Long> phoneBook = phoneBook1.getOrDefault(name, new HashSet<>());
            phoneBook.add(number);

            phoneBook1.put(name, phoneBook);
        }

        void get(String name) {
            System.out.println("Контакт " + name + " " + phoneBook1.getOrDefault(name, new HashSet<>()));
        }


}


