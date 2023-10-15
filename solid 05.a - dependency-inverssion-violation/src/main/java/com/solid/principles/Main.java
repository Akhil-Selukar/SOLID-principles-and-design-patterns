package com.solid.principles;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Message msg = new Message("This is new message!");
        MessagePrinter printer = new MessagePrinter();
        printer.writeMessage(msg, "Test.txt");
    }
}