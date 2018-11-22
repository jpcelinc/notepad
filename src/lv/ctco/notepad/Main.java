package lv.ctco.notepad;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        for (; ; ) {
            System.out.print("cmd: ");
            String cmd = scanner.next();
            switch (cmd) {
                case "create":
                    createPerson();
                    break;
                case "help":
                    showHelp();
                    break;
                case "delete":
                    deletePersonById();
                case "list":
                    showList();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command. Try 'help'");
            }
        }
    }

    private static void deletePersonById() {
        int id = askInt("ID to delete");
        if (persons.isEmpty()) {
            System.out.println("Person is empty");
        } else {
            for (int i = 0; i < persons.size(); i++) {
                Person p = persons.get(i);
                if (p.getId() == id) {
                    persons.remove(i);
                    break;
                }
            }
            showList();
        }
    }

    private static void showList() {
        persons.forEach(System.out::println);
    }

    private static void showHelp() {

    }

    private static void createPerson() {
        Person p = new Person();

        String firstName = askString("First Name");
        p.setFirstName(firstName);

        String lastName = askString("Last Name");
        p.setLastName(lastName);

        String email = askString("Email");
        p.setEmail(email);

        String phone = askPhone("Phone");
        p.setPhone(phone);

        persons.add(p);
    }

    public static String askString(String msg) {
        for (;;) {
            System.out.print(msg + ": ");
            String val = scanner.next();
            if (!val.startsWith("\"")) {
                return val;
            }
            List<String> words = new ArrayList<>();
            words.add(val);
            while (!val.endsWith("\"")) {
                val = scanner.next();
                words.add(val);
            }
            String result = String.join(" ", words);
            result = result.substring(1, result.length() - 1);
            if (result.length() < 1) {
                System.out.println("at least one character, please");
                continue;
            }
            return result;
        }
    }

    public static int askInt(String msg) {
        System.out.print(msg + ": ");
        int i = 0;
        while (true)
            try{
        i =  scanner.nextInt();
                return i;

    } catch (InputMismatchException e){
                System.out.println("invalid number");
                scanner.next();
    }
    }

    public static String askPhone(String msg) {
        for (; ; ) {
            String result = askString(msg);
            boolean hasWrongChars = result.codePoints()
                    .anyMatch(c -> !(Character.isDigit(c) || Character.isSpaceChar(c) || c == '-' || c == '+'));
            if (hasWrongChars) {
                System.out.println("Only numbers, spaces dashes and pluses are allowed");
                continue;
            }

            long digitCount = result.codePoints()
                    .filter(Character::isDigit)
                    .count();
            if (digitCount < 5) {
                System.out.println("Should be 5 or more digits");
                continue;
            }

            return result;
        }
    }
}

