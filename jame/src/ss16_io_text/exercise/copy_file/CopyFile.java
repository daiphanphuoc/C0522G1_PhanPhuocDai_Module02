package ss16_io_text.exercise.copy_file;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class CopyFile {

    public static void main(String[] args) {
        final String PATHSOURCE="jame/src/ss16_io_text/exercise/copy_file/read.txt";
        final String PATHTARGET="jame/src/ss16_io_text/exercise/copy_file/write.txt";
        CopyFile c=new CopyFile();
        c.copyFile(PATHSOURCE,PATHTARGET);
    }
    public void copyFile(String pathSource,String pathTarget){
        try {
            writeFile(pathTarget,readerFile(pathSource));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public StringBuilder readerFile(String pathSource) throws IOException {
        StringBuilder stringBuilder=new StringBuilder();
        File file=new File(pathSource);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file) );
        String  line="";
        int kt=0;
        while ((line=bufferedReader.readLine())!=null){
           // if(stringBuilder.)
            stringBuilder.append(line);
            kt+=line.length();
            stringBuilder.append("\n");
        }
        System.out.println(kt);
        bufferedReader.close();
        return stringBuilder;
    }

    public  void writeFile(String pathTarget, StringBuilder stringBuilder) throws IOException {
        File file=new File(pathTarget);
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file));

        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        bufferedWriter.write(String.valueOf(stringBuilder));
        bufferedWriter.close();
    }
}
