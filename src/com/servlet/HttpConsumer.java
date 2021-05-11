package com.servlet;

import javax.servlet.ServletException;
import java.io.IOException;

@FunctionalInterface
public interface HttpConsumer<T, U> {
    void accept(T t, U u) throws ServletException, IOException;
}
