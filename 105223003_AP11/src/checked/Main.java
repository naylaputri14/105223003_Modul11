package checked;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("src/checked/data.txt"); // File tidak ada
            BufferedReader reader = new BufferedReader(file);
            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e){
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }
}