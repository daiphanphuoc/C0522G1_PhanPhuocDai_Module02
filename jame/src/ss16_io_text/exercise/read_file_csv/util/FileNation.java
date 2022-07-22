package ss16_io_text.exercise.read_file_csv.util;

import org.jetbrains.annotations.NotNull;
import ss16_io_text.exercise.read_file_csv.model.Nation;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FileNation {
    private static @NotNull List<String> readFile(String path) throws IOException {
        List<String> strings = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        return strings;
    }

    public static @NotNull List<Nation> readNationFile(String path) throws IOException {
        List<Nation> nations = new ArrayList<>();
        List<String> strings = readFile(path);
        String[] arr;
        for (String s : strings) {
            arr = s.split(",");
            nations.add(new Nation(Integer.parseInt(arr[0]), arr[1], arr[2]));
        }
        return nations;
    }

}
