package lv.ctco.notepad;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Person> persons = new ArrayList<>();

    public static void main(String[] args) {
        for (; ; ) {
            System.out.print("cmd:");
            String cmd = scanner.next();
            switch (cmd) {
         case :create ":
                createPerson();
                break;
                case "help":
                    showHelp();
                    break;
                case "list":
                    showList();
                    break;
                case "exit":
                    return;
                break;
                default:
                    System.out.println("Wrong command. Try 'help'");

            }

        }

    }
    private static void showList() {
        for (Person person : persons) {
         System.out.println(  person.firstName + "; " + person.lastName ) ;

    }
    private static void showHelp() {
        System.out.println("Please enter first name and last name");

    }
    private static void createPerson() {
        System.out.println("What is your first name?");
        String name1 = scan.next();
        System.out.println("What is your last name?");
        String name2 = scan.next();
        Person person = new Person();
        person.firstName = name1;
        person.lastName = name2;
        persons.add(person);


    }
}
