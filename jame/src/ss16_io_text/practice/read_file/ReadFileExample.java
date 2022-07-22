package ss16_io_text.practice.read_file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFileExample {

    public void readFileText(String filePath) {
        int sum=0;
        try {
            // Đọc file theo đường dẫn
            File file = new File(filePath);

            // Kiểm tra nếu file không tồn tại thì ném ra ngoại lệ.
            /*if (!file.exists()) {
                throw new FileNotFoundException();
            }*/

            // Đọc từng dòng của file và tiến hành cộng tổng lại
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
             sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                int x=Integer.parseInt(line);
                sum += x;
            }
            br.close();

            // Hiển thị ra màn hình tổng các số nguyên trong file

        }catch (NumberFormatException e1){
            System.out.println(e1.getMessage());
        }
        catch (Exception e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        finally {
            System.out.println("Tổng = " + sum);
        }
    }

    public static void main(String[] args) {

        String path = "jame/src/ss16_io_text/number.txt";

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.readFileText(path);
    }
}
