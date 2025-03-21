/*
4️⃣  Task: Print Queue
There is a printer in an office and the employees want to print their documents in order.
The printer can only print one document at a time, so it should work according to the FIFO (First In, First Out) principle.

📝 What to do:
1️- Create a print queue using Queue<String>.
2️-Get the document names that the user wants to print and add them to the queue.
3️- When the user types "start", the printer starts working.
4️- The first document that enters should be printed first!
5️- When all the documents are printed, show the message "All documents are printed."
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Printer {
    public static void main(String[] args) throws Exception {
        printSomething();
    }

    public static void printSomething(){
        
        System.out.println("Type \"exit\" to quit");

        Queue<String> items = new LinkedList<String>();

        System.out.println("What would you print?");

        Scanner input2 = new Scanner(System.in);

        while(input2.hasNextLine()){
            
            String printingItem = input2.nextLine();
            
            if(printingItem.toLowerCase().equals("exit")){
                break;
            }

            items.add(printingItem);
        }
        
        input2.close();
        System.out.println(items);

    }
}
