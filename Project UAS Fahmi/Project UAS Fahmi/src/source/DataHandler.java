package source;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataHandler {
    private static final String FILE_PATH = "catatan.dat";

    public static List<Catatan> bacaCatatan() {
        List<Catatan> catatanList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            catatanList = (List<Catatan>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Tangani exception jika file tidak ditemukan atau kesalahan lainnya
            e.printStackTrace();
        }
        return catatanList;
    }

    public static void tulisCatatan(List<Catatan> catatanList) {
         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(catatanList); // Write the List directly
        } catch (IOException e) {
            // ...
        }
    }
}
