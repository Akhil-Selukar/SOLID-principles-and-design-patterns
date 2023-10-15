package com.solid.principles;

public interface Formatter {
    public String format(Message message) throws FormatException;
}
