package com.example.seriestest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.println("The path to your file:");
        String fileName=scan.next();
        try {
            File myFile = new File(fileName);
            Scanner scanFile = new Scanner(myFile);
            scanFile.useDelimiter("\\Z");
            FileData table = new FileData();
            while (scanFile.hasNextLine()) {
                table.addRow(scanFile.nextLine());
            }
            printMenu();
            scanFile.close();
            readCommands(table,fileName);
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
        }
    }
    static void printMenu()
    {
        System.out.println("Options:");
        System.out.println("Option A - Validate the file contents ");
        System.out.println("Option B - Switch entire line from the file with an entire other line");
        System.out.println("Option C - Switch number at specific index  ");
    }
    static void validate(FileData table)
    {
        if (table.valid().getFirst()==0 && table.valid().getSecond()==0 )
        {

            System.out.println("The input is valid!");
        }
        else System.out.println("The input is not correct on row " + table.valid().getFirst() + " in the number with index " + table.valid().getSecond());
    }
    static void readCommands(FileData table,String fileName)
    {
        Scanner scan= new Scanner(System.in);
        String command = scan.next();
        while (!command.equalsIgnoreCase("exit")) {
            switch (command) {
                case ("A"):
                    validate(table);
                    break;
                case ("B"):
                    switchLines(table,fileName);
                    break;
                case ("C"):
                    switchNumbers(table,fileName);
            }
            command = scan.next();
        }
    }
    static  void switchLines(FileData table,String fileName) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of line one:");
        int number1=scan.nextInt();
        System.out.println("Number of line two:");
        int number2=scan.nextInt();
        table.swap(number1,number2);
        write(table,fileName);

    }
    static  void switchNumbers(FileData table,String fileName) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of line1:");
        int line1=scan.nextInt();
        System.out.println("Number of index1:");
        int index1=scan.nextInt();
        System.out.println("Number of line2:");
        int line2=scan.nextInt();
        int index2=scan.nextInt();
        table.swapNumbers(line1,line2,index1,index2);
        write(table,fileName);

    }
    static void write (FileData table,String fileName)
    {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for(Row row : table.getTable()) {
                myWriter.write(row.getRowString());
                myWriter.write(System.lineSeparator());

            }
            myWriter.flush();
            myWriter.close();
        }
        catch (IOException e )
        {
            System.out.println("Problem occurred");
        }
    }
}
