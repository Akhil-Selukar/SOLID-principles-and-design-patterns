package com.solid.principles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter {
    public void writeMessage(Message message, String fileName)throws IOException{
        Formatter formatter = new JSONFormatter();
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            writer.println(formatter.format(message));
            writer.flush();
        }
    }
}
