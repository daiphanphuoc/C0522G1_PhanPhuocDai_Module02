package libs.io_file;

import models.Booking;
import models.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class IOBookingUtil {
    public static @Nullable Set<Booking> readBookingFile(String path) throws ParseException {
        Set<Booking> bookingSet = new TreeSet<>();
        List<String> strings = new ArrayList<>();
        try {
            strings = IOFileUtil.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String str : strings) {
            String[] temp = str.split(",");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date begin = df.parse(temp[1]);
            Date end = df.parse(temp[2]);
            bookingSet.add(new Booking(temp[0], begin, end, temp[3], temp[4], temp[5]));
        }
        return bookingSet;
    }

    public static void writeBookingFile(String path, Set<Booking> bookings) {
        StringBuilder data = new StringBuilder();
        for (Booking booking : bookings) {
            data.append(booking.getInfo()).append("\n");
        }
        data.deleteCharAt(data.length() - 1);
        try {
            IOFileUtil.writeFile(path, data.toString());
            System.out.println("Cập nhật lên file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static @Nullable List<Contract> readContractFile(String path) {
        List<Contract> contractList = new LinkedList<>();
        List<String> strings = new ArrayList<>();
        try {
            strings = IOFileUtil.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String str : strings) {
            String[] temp = str.split(",");
            contractList.add(new Contract(temp[0], temp[1], Double.parseDouble(temp[2]),
                    Double.parseDouble(temp[3]), temp[4]));
        }
        return contractList;
    }

    public static void writeContractFile(String path, List<Contract> contracts) {
        StringBuilder data = new StringBuilder();
        for (Contract contract : contracts) {
            data.append(contract.getInfo()).append("\n");
        }
        data.deleteCharAt(data.length() - 1);
        try {
            IOFileUtil.writeFile(path, data.toString());
            System.out.println("Cập nhật lên file thành công.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
