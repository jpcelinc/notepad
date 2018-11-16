package lv.ctco.notepad;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   static Scanner scanner = new Scanner(System.in);
   static List<Person> records = new ArrayList<Person>() ;

    public static void main(String[] args) {
        for(; ;){
         System.out.print("cmd:");
         String cmd  = scanner.next();
         switch (cmd) {
             case "help";
             showHelp();
             break;
             case "create";
                 create();
                 break;

         }

        }
	// write your code here
    }
}
