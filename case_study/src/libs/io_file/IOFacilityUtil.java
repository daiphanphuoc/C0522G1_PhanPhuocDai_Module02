package libs.io_file;

import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class IOFacilityUtil extends IOFileUtil {
    public static @NotNull LinkedHashMap<Facility, Integer> readFacilityFile(String path) {
        LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();
        List<String> strings = null;
        try {
            strings = readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("");
        }
        String[] arr;
        assert strings != null;
        try {
            for (String s : strings) {
                arr = s.split(",");
                if (arr.length == 10) {
                    Facility facility = new Villa(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Integer.parseInt(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7]), Double.parseDouble(arr[8]));

                    facilities.put(facility, Integer.parseInt(arr[9]));
                } else if (arr.length == 9) {
                    Facility facility = new House(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Integer.parseInt(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7]));

                    facilities.put(facility, Integer.parseInt(arr[8]));
                } else if (arr.length == 8) {
                    Facility facility = new Room(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Integer.parseInt(arr[4]), arr[5], arr[6]);

                    facilities.put(facility, Integer.parseInt(arr[7]));
                }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();

        }
        return facilities;
    }

    public static void writeFacilityFile(String path, @NotNull LinkedHashMap<Facility, Integer> facilities) {
        StringBuilder data = new StringBuilder();
        for (Facility facility : facilities.keySet()) {
            data.append(facility.getInfo()).append(",").append(facilities.get(facility)).append("\n");
        }
        data.deleteCharAt(data.length() - 1);
        try {
            writeFile(path, data.toString());
            System.out.println("Cập nhật lên file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("");
        }

    }
}
