/*
 Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что один человек может иметь несколько телефонов.
 */
package HomeWork_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) {
        Map<String, List<String>> phonBook = new HashMap<>();
        phonBook.put("Sasha", List.of("8 904 111 11 11", "8 904 222 22 22"));
        phonBook.put("Dima", List.of("8 904 333 33 33", "8 904 444 44 44"));
        phonBook.put("Olya", List.of("8 904 555 55 55", "8 904 666 66 66"));
        phonBook.put("Fedor", List.of("8 904 777 77 77", "8 904 888 88 88"));
        phonBook.put("Katya", List.of("8 904 999 99 99", "8 904 000 00 00"));

        menu(phonBook);

    }

    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        // scanner.close();
        return scan;
    }

    public static void find(Map<String, List<String>> phonBook) {
        System.out.println("Введите имя: ");
        String name = scanner();
        System.out.println(phonBook.get(name));
    }

    public static void allBook(Map<String, List<String>> phonBook) {
        System.out.println(phonBook);

    }

    public static Map<String, List<String>> add(Map<String, List<String>> phonBook) {
        System.out.println("Для остановки введите 'stop'");
        System.out.println("Введите имя: ");
        String name = scanner();
        List<String> number = new ArrayList<>();
        while (true) {
            System.out.println("Введите номер: ");
            String phon = scanner();
            if (phon.equals("stop")) {
                break;
            } else {
                number.add(phon);
            }
        }
        phonBook.put(name, number);

        return phonBook;
    }

    public static Map<String, List<String>> menu(Map<String, List<String>> phonBook) {
        System.out.println(
                "Введите команду из списка: find - найти контакт, add - добавить контакт, all - показать всю телефонную книгу, exit - выйти");
        while (true) {
            String comands = scanner();
            if (comands.equals("exit")) {
                break;
            } else {
                switch (comands) {
                    case "find":
                        find(phonBook);
                        break;
                    case "add":
                        add(phonBook);
                        break;
                    case "all":
                        allBook(phonBook);
                        break;
                    default:
                        break;
                }
            }
        }
        return phonBook;
    }
}