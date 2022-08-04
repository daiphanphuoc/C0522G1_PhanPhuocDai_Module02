package quan_ly_phuong_tien_giao_thong.libs;

import com.sun.istack.internal.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static @NotNull
    @org.jetbrains.annotations.NotNull
    List<String> docFile(String path) throws IOException {
        List<String> strings = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String dong;
        while ((dong = bufferedReader.readLine()) != null) {
            if (dong.length() > 1) {
                strings.add(dong);
            }
        }
        return strings;
    }

    public static void ghiFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(data);
        bufferedWriter.close();
    }
}
