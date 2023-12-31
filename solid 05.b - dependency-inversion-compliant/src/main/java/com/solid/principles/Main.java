package com.solid.principles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Message msg = new Message("This is new message!");
        MessagePrinter printer = new MessagePrinter();
        try(PrintWriter writer = new PrintWriter(new FileWriter("Test.txt"))){
            printer.writeMessage(msg, new JSONFormatter(), writer);
        }
    }
}