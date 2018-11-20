package lv.ctco.notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Person> persons = new ArrayList<>();
    public static void main(String[] args) {
        for (; ; ) {
       //     String askString("cmd:");
            System.out.print("cmd:");
            String cmd = scanner.next();
            switch (cmd) {
                case "create":
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
                default:
                    System.out.println("Wrong command. Try 'help'");

            }

        }

    }

    private static void showList() {

        persons.forEach(person -> System.out.println(person));
        //   for (Person person : persons) {
        //       System.out.println(person.firstName + "; " + person.lastName);
        //   }
    }

    private static void showHelp() {
        System.out.println("Please enter first name and last name");

    }

    private static void createPerson() {

        Person person = new Person();
       // System.out.println("What is your first name?");
        person.setFirstName(scanner.next());
       // System.out.println("What is your last name?");
        person.setLastName(scanner.next());
      //  System.out.println("What is your email?");
        person.setEmail(scanner.next());
        persons.add(person);


    }

    private String askString (String msg) {
        List<String>  inputList = new ArrayList<>();
        String rString = "";

        do while (true) {
            System.out.println(msg);
            rString = scanner.next();
             if (rString.startsWith("\"")) {
                inputList.add(rString);
               return true ;
            }

              return  false;
            }

        }
        return
    }
    private static boolean checkInput(String input) {
        String[] inputOptions = {"create", "help","list","exit"};
        for (String i : inputOptions) {
            if (input.equals(i)) {
                return true;
            }
        }
        return false;
    }
}
