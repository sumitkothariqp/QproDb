package com.cli;

import qpro.cli.CliProcessor;

import java.util.Scanner;

public class CliEditor {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("qprodb>");

        do {
            String command = scanner.nextLine();
            // System.out.println(command);

            if (command.equals("exit")) {
                System.exit(0);
            }
            CliProcessor processor = CliProcessor.getINSTANCE();
            processor.process(command);

        } while (true);
    }
}
