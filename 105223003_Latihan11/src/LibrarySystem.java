import java.util.ArrayList;
import java.util.Scanner;

class InvalidBookIDException extends Exception {
    public InvalidBookIDException(String message) {
        super(message);
    }
}

class ExceedMaxLoanDurationException extends Exception {
    public ExceedMaxLoanDurationException(String message) {
        super(message);
    }
}

public class LibrarySystem {

    public static boolean isValidBookID(String id, ArrayList<String> bookList) {
        for (String bookId : bookList) {
            if (bookId.equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        ArrayList<String> daftarBuku = new ArrayList<>();
        daftarBuku.add("B001");
        daftarBuku.add("B002");
        daftarBuku.add("B003");

        try {
            scanner = new Scanner(System.in);

            System.out.print("Masukkan nama pengguna: ");
            String nama = scanner.nextLine();

            System.out.print("Masukkan ID buku: ");
            String bookID = scanner.nextLine().trim();

            if (!isValidBookID(bookID, daftarBuku)) {
                throw new InvalidBookIDException("ID buku tidak ditemukan di sistem");
            }

            System.out.print("Masukkan lama peminjaman (hari): ");
            int lamaPinjam = scanner.nextInt();

            if (lamaPinjam <= 0) {
                throw new IllegalArgumentException("Lama peminjaman harus lebih dari 0 hari");
            }
            if (lamaPinjam > 14) {
                throw new ExceedMaxLoanDurationException("Lama peminjaman tidak boleh lebih dari 14 hari");
            }

            System.out.println("");
            System.out.println("Peminjaman berhasil");
            System.out.println("Nama Peminjam: " + nama);
            System.out.println("ID Buku: " + bookID);
            System.out.println("Lama Peminjaman: " + lamaPinjam + " hari");

        } catch (InvalidBookIDException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ExceedMaxLoanDurationException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan tak terduga: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("");
                System.out.println("Scanner ditutup");
            }
        }
    }
}