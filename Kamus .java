import java.util.Arrays;
import java.util.Scanner;

class Kamus {
    private String[] kataInggris;
    private String[] kataIndonesia;

    public Kamus(String[] kataInggris, String[] kataIndonesia) {
        this.kataInggris = kataInggris;
        this.kataIndonesia = kataIndonesia;
    }

    public String terjemahkan(String kata) {
        int indeks = binarySearch(kataInggris, kata);
        if (indeks != -1) {
            return kataIndonesia[indeks];
        }

        indeks = binarySearch(kataIndonesia, kata);
        if (indeks != -1) {
            return kataInggris[indeks];
        }

        return "Kata tidak ditemukan dalam kamus.";
    }

    private int binarySearch(String[] arr, String kata) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int hasilPerbandingan = kata.compareToIgnoreCase(arr[mid]);

            if (hasilPerbandingan == 0) {
                return mid;
            } else if (hasilPerbandingan < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

public class ProgramKamus {
    public static void main(String[] args) {
        String[] kataInggris = {
            "apple", "banana", "car", "dog", "elephant", "flower"
        };

        String[] kataIndonesia = {
            "apel", "pisang", "mobil", "anjing", "gajah", "bunga"
        };

        Kamus kamus = new Kamus(kataInggris, kataIndonesia);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kata: ");
        String kata = scanner.nextLine();

        String hasilTerjemahan = kamus.terjemahkan(kata);
        System.out.println("Hasil terjemahan: " + hasilTerjemahan);
    }
}
