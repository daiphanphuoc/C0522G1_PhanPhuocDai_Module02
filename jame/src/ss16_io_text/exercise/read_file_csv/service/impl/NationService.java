package ss16_io_text.exercise.read_file_csv.service.impl;

import ss16_io_text.exercise.read_file_csv.model.Nation;
import ss16_io_text.exercise.read_file_csv.util.FileNation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NationService {
    public List<Nation> getNations() {
        try {
            return FileNation.readNationFile("jame/src/ss16_io_text/exercise/read_file_csv/nation.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Nation>();

    }

    public void display(List<Nation> nations) {
        for (Nation n : nations) {
            System.out.println(n);
        }
    }
}
