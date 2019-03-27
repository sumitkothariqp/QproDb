package com.cli;

import qpro.cli.CliProcessor;
import qpro.cli.InitDatabase;

import java.util.Scanner;

public class CliEditor {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        InitDatabase.init();
        System.out.print("qprodb>");

        do {
            String command = scanner.nextLine();
            // System.out.println(command);

            if (command!= null && command.equals("exit")) {
                InitDatabase.dumpInFile();
                System.exit(0);
            }
            if (command != null) {
                CliProcessor processor = CliProcessor.getINSTANCE();
                processor.process(command);
                System.out.println();
            }

            System.out.print("qprodb>");

        } while (true);
    }
}
