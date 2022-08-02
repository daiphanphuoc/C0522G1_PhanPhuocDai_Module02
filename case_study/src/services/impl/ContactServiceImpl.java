package services.impl;

import _exception.IDException;

import static libs.InputUtil.*;

import libs.io_file.IOBookingUtil;
import models.Booking;
import models.Contract;
import models.Path;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Queue;

public class ContactServiceImpl {
    private static ContactServiceImpl contactService;

    private ContactServiceImpl() {
    }

    public static ContactServiceImpl getInstance() {
        if (contactService == null) {
            contactService = new ContactServiceImpl();
        }
        return contactService;
    }

    public synchronized void add(@NotNull Queue<Booking> bookingQueue) {
        if (bookingQueue.isEmpty()) {
            System.out.println("Chưa có booking cần làm hợp đồng!");
        } else {
            List<Contract> contracts = IOBookingUtil.readContractFile(Path.CONTRACT.getPath());

            while (!bookingQueue.isEmpty()) {
                Booking booking = bookingQueue.peek();
                String idContract;
                while (true) {
                    try {
                        idContract = getString("Nhập vào mã số hợp đồng:");
                        assert contracts != null;
                        for (Contract temp : contracts) {
                            if (idContract.equals(temp.getContractNumber())) {
                                throw new IDException("Đã có số hợp đồng này, vui lòng nhập lại");
                            }
                        }
                        break;
                    } catch (IDException e) {
                        e.printStackTrace();
                    }
                }

                double first = getDouble("Nhập vào số tiền trả trước");
                double total = getDouble("Nhập vào tổng tiền cần thanh toán:");
                Contract temp = new Contract(idContract, booking.getIDBooking(), first, total, booking.getIDCustomer());
                contracts.add(temp);
                IOBookingUtil.writeContractFile(Path.CONTRACT.getPath(), contracts);
                bookingQueue.poll();
                BookingServiceImpl.setBookingQueue();
            }
            //IOBookingUtil.writeContractFile(Path.CONTRACT.getPath(), contracts);
        }


    }

    public void display() {
        List<Contract> contracts = IOBookingUtil.readContractFile(Path.CONTRACT.getPath());
        assert contracts != null;
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }

    public void update(String id) {
        List<Contract> contracts = IOBookingUtil.readContractFile(Path.CONTRACT.getPath());
        assert contracts != null;
        for (Contract contract : contracts) {
            if (contract.getContractNumber().equals(id)) {
                contract.setFirstMoney(getDouble("nhập vào số tiền trả trước :"));
                contract.setTotalMoney(getDouble("nhập vào tổng  số tiền cần trả  :"));
                contracts.set(contracts.indexOf(contract), contract);
                IOBookingUtil.writeContractFile(Path.CONTRACT.getPath(), contracts);
                break;
            }
        }
    }

    public Contract find(Booking booking) {
        List<Contract> contracts = IOBookingUtil.readContractFile(Path.CONTRACT.getPath());
        assert contracts != null;
        for (Contract contract : contracts) {
            if (contract.getBookingID().equals(booking.getIDBooking())) {
                return contract;
            }
        }
        return null;
    }

    public boolean remove(Booking booking) {
        Contract contract = find(booking);
        if (contract != null) {
            List<Contract> contracts = IOBookingUtil.readContractFile(Path.CONTRACT.getPath());
            if (getBoolean("Bạn chắc chắn muốn xóa, nhấn true:")) {
                contracts.remove(contract);
                IOBookingUtil.writeContractFile(Path.CONTRACT.getPath(), contracts);
                return true;
            }
            System.out.println("Bạn đã không xóa hợp đồng.");
            return false;
        }
        System.out.println("Không tìm thấy hợp đồng.");
        return false;
    }
}
