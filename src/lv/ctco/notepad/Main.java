package lv.ctco.notepad;

//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//import java.time.LocalDateTime;


public class Main {
    public static final String DATE_PATTERN = "dd-MM-uuuu";
    public static final String TIME_PATTERN = "HH:mm";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
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
                case "ca":
                case "createAlarm":
                    createRecord(new Alarm());
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
                case "fd":
                case "calcDuration":
                    calcDuration();
                    break;
                case "fa":
                case "calcArrive":
                    calcArrive();
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
                String sdate = askString(msg + "For example '" + LocalDate.now().format(Main.DATE_FORMATTER) + "'");
                date = LocalDate.parse(sdate, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("invalid date");
            }

        }
        return date;
    }

    public static LocalTime askTime(String s) {
        LocalTime time = null;

        while (time == null) {
            try {
                String stime = askString(s + "For example '" + LocalTime.now().format(Main.TIME_FORMATTER) + "'");
                time = LocalTime.parse(stime, TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("invalid time");
            }

        }
        return time;
    }

    public static void calcDuration() {
        String tz1 = askString("Depart timeZone. (Europe/Copenhagen, America/Montreal, Asia/Kuala_Lumpur )");
        LocalDate dat1 = askDate("Depart date:");
        LocalTime t1 = askTime("Depart time:");
        String tz2 = askString("Arrive timeZone. (Europe/Copenhagen, America/Montreal, Asia/Kuala_Lumpur )");
        LocalDate dat2 = askDate("Arrive date:");
        LocalTime t2 = askTime("Arrive time:");
        LocalDateTime dt1 = LocalDateTime.of(dat1, t1);
        LocalDateTime dt2 = LocalDateTime.of(dat2, t2);
        ZonedDateTime zdt1 = dt1.atZone(ZoneId.of(tz1));
        ZonedDateTime zdt2 = dt2.atZone(ZoneId.of(tz2));
       // ZoneOffset zoffset1 = zdat1.getOffset();
       // ZoneOffset zoffset2 = zdat2.getOffset();
        Duration d = Duration.between(zdt1, zdt2);
        System.out.println("\n---systemDefault TimeZone = " + ZoneId.systemDefault().toString()
        + " / " + zdt1.withZoneSameInstant(ZoneId.systemDefault()).format(Main.DATE_FORMATTER) + " " + zdt1.withZoneSameInstant(ZoneId.systemDefault()).format(Main.TIME_FORMATTER)
        + " -  " + zdt2.withZoneSameInstant(ZoneId.systemDefault()).format(Main.DATE_FORMATTER) + " " + zdt2.withZoneSameInstant(ZoneId.systemDefault()).format(Main.TIME_FORMATTER)
                + "/---");
        System.out.println("Depart:" + zdt1.toString());
        System.out.println("Arrive:" + zdt2.toString());
        System.out.println("Duration : " + d.toString());
    }
    public static void calcArrive() {
        String tz1 = askString("Depart timeZone. (Europe/Copenhagen, America/Montreal, Asia/Kuala_Lumpur )");
        LocalDate dat1 = askDate("Depart date:");
        LocalTime t1 = askTime("Depart time:");
        String tz2 = askString("Arrive timeZone. (Europe/Copenhagen, America/Montreal, Asia/Kuala_Lumpur )");
        LocalTime dt = askTime("Duration");
         //LocalDate dat2 = askDate("Arrive date");
        //LocalTime t2 = askTime("Arrive time");
        LocalDateTime dt1 = LocalDateTime.of(dat1, t1);
        LocalDateTime dt2 = dt1.plusHours(dt.getHour()).plusMinutes(dt.getMinute());
       // LocalDateTime dt2 = LocalDateTime.of(dat1, t1.plusHours(dt.getHour()).plusMinutes(dt.getMinute()));
        ZonedDateTime zdt1 = dt1.atZone(ZoneId.of(tz1));
     //   ZonedDateTime zdt2 = dt2.atZone(ZoneId.of(tz2));
        ZonedDateTime zdt2 = zdt1.plusHours(dt.getHour()).plusMinutes(dt.getMinute()).withZoneSameInstant(ZoneId.of(tz2));
        // ZoneOffset zoffset1 = zdat1.getOffset();
        // ZoneOffset zoffset2 = zdat2.getOffset();
        Duration d = Duration.between(zdt1, zdt2);
        System.out.println("\n---systemDefault TimeZone = " + ZoneId.systemDefault().toString()
                + " / " + zdt1.withZoneSameInstant(ZoneId.systemDefault()).format(Main.DATE_FORMATTER) + " " + zdt1.withZoneSameInstant(ZoneId.systemDefault()).format(Main.TIME_FORMATTER)
                + " -  " + zdt2.withZoneSameInstant(ZoneId.systemDefault()).format(Main.DATE_FORMATTER) + " " + zdt2.withZoneSameInstant(ZoneId.systemDefault()).format(Main.TIME_FORMATTER)
                + "/---");
        System.out.println("Depart:" + zdt1.toString());
        System.out.println("Arrive:" + zdt2.toString());
        System.out.println("Duration : " + d.toString());
    }
}

