package ss17_io_byte.exercise.copy_file_byte;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CopyFile {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        int count = 0;
        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
                count += length;
            }
            System.out.println("Số byte trong tệp: "+ count);
        } finally {
            inputStream.close();
            outputStream.close();
        }
    }

    public static void main(String[] args) {
        String sourcePath = "jame/src/ss17_io_byte/exercise/copy_file_byte/source.dat";
        String targetPath = "jame/src/ss17_io_byte/exercise/copy_file_byte/target1.dat";
        try {
            File sourceFile = new File(sourcePath);
            File targetFile = new File(targetPath);
            if (targetFile.exists()) {
                throw new FileExistsException("File đích đã tồn tại, vui lòng kiểm tra lại!");
            }
            copyFileUsingStream(sourceFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileExistsException e) {
            System.out.println(e.getMessage());
        }
    }
}
