package com.solid.principles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter {
    public void writeMessage(Message message, Formatter formatter, PrintWriter writer)throws IOException{
            writer.println(formatter.format(message));
            writer.flush();
    }
}
