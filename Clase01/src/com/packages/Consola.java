package com.packages;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Consola {
    public Consola() {
    }

    public static char readChar() {
        char ch = ' ';

        try {
            ch = (char)System.in.read();
            System.in.read();
        } catch (IOException var2) {
        }

        return ch;
    }

    public static String readLine() {
        String r = "";
        boolean done = false;

        while(!done) {
            try {
                int ch = System.in.read();
                if (ch >= 0 && (char)ch != '\n') {
                    if ((char)ch != '\r') {
                        r = r + (char)ch;
                    }
                } else {
                    done = true;
                }
            } catch (IOException var4) {
                done = true;
            }
        }

        return r;
    }

    public static int readInt() {
        while(true) {
            try {
                return Integer.parseInt(readLine().trim());
            } catch (NumberFormatException var1) {
                System.out.println("No es un integer. Por favor, pruebe otra vez!");
            }
        }
    }

    public static double readDouble() {
        while(true) {
            try {
                return Double.parseDouble(readLine().trim());
            } catch (NumberFormatException var1) {
                System.out.println("No es un flotante. Por favor, pruebe otra vez!");
            }
        }
    }

    public static Date readDate() {
        while(true) {
            try {
                return new SimpleDateFormat("dd-MM-yyyy").parse(readLine().trim());
            }  catch (ParseException e) {
                System.out.println("No es una fecha. Por favor, pruebe otra vez!");
            }

        }
    }

    public static LocalDate readLocalDate() {
        while(true) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
                return LocalDate.parse(readLine().trim(), formatter);
            }  catch (DateTimeParseException e) {
                System.out.println("No es una fecha. Por favor, pruebe otra vez!");
            }

        }
    }
}
