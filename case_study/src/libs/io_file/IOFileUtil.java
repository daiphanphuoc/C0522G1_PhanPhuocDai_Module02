package libs.io_file;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileUtil {

    public static @NotNull
    List<String> readFile(String path) throws IOException {
        List<String> strings = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.length() > 1) {
                strings.add(line);
            }
        }
        return strings;
    }

    public static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }


}
