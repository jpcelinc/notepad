package lv.ctco.notepad;

import java.text.DateFormat;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static java.time.LocalDate.*;


public class Main {
    public static final String DATE_PATTERN = "dd-MM-uuuu";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    static Scanner scanner = new Scanner(System.in);
    static List<Record> records = new ArrayList<>();

    public static void main(String[] args) {
        for (; ; ) {
            System.out.print("cmd: ");
            String cmd = scanner.next();
            switch (cmd) {
                case "search":
                    search();
                    break;
                case "cp":
                case "createPerson":
                    createRecord(new Person());
                    break;
                case "cr":
                case "createReminder":
                    createRecord(new Reminder());
                    break;
                case "help":
                    showHelp();
                    break;
                case "delete":
                    deletePersonById();
                case "list":
                    showList();
                    break;
                case "cn":
                case "createNote":
                    createRecord(new StickNote());
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command. Try 'help'");
            }
        }
    }

    private static void search() {
        String ss = askString("What do you want to find?");
        records.stream()
                .filter(r -> r.contains(ss.toLowerCase()))
                .forEach(System.out::println);
    }


    private static void createRecord(Record record) {
        record.askData();
        records.add(record);
        System.out.println(record);
    }

    //   private static void createPerson() {
    //       Person p = new Person();
    //       p.askData();
    //       records.add(p);
    //  }
    //   private static void createNote() {
    //       StickNote p = new StickNote();
    //      p.askData();
    //      records.add(p);
    //  }

    private static void deletePersonById() {
        int id = askInt("ID to delete");
        if (records.isEmpty()) {
            System.out.println("Person is empty");
        } else {
            for (int i = 0; i < records.size(); i++) {
                Record p = records.get(i);
                if (p.getId() == id) {
                    records.remove(i);
                    break;
                }
            }
            showList();
        }
    }

    private static void showList() {
        records.forEach(System.out::println);
    }

    private static void showHelp() {

    }


    public static String askString(String msg) {
        for (; ; ) {
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
            try {
                i = scanner.nextInt();
                return i;

            } catch (InputMismatchException e) {
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

    public static LocalDate askDate(String msg) {

        LocalDate date = null;

        while (date == null) {
            try {
                String sdate = askString("Enter date .For example '" + LocalDate.now().format(Main.DATE_FORMATTER) + "'");
                date = LocalDate.parse(sdate, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("invalid date");
                       }

        }
        return date;
    }
}

