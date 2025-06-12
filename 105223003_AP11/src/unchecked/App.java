package unchecked;

public class App {
    public static void main(String[] args) {
        int[] angka = { 1, 2, 3 };

        try {
            System.out.println(angka[2]); // indeks diluar batas array
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
        
        try {
            int hasil = 10 / 5; //pembagian dengan nol
            System.out.println("Hasil: " + hasil);
        } catch (ArithmeticException e) {
            System.out.println("Tidak bisa membagi dengan nol: " + e.getMessage());
        }
    }
}