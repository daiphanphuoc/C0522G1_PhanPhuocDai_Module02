package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Booking {
    private String iDBooking;
    private Date begin;
    private Date end;
    private String iDCustomer;
    private String nameFacility;
    private String facilityType;

    public Booking() {
    }

    public Booking(String iDBooking, Date begin, Date end, String iDCustomer,
                   String nameFacility, String facilityType) {
        this.iDBooking = iDBooking;
        this.begin = begin;
        this.end = end;
        this.iDCustomer = iDCustomer;
        this.nameFacility = nameFacility;
        this.facilityType = facilityType;
    }

    public String getInfo() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dateStringBegin  = df.format(getBegin());
        String dateStringEnd  = df.format(getEnd());
        return String.format("%s,%s,%s,%s,%s,%s", getIDBooking(), dateStringBegin, dateStringEnd,
                getIDCustomer(), getNameFacility(), getFacilityType());
    }

    public String getIDBooking() {
        return iDBooking;
    }

    public void setIDBooking(String iDBooking) {
        this.iDBooking = iDBooking;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getIDCustomer() {
        return iDCustomer;
    }

    public void setIDCustomer(String iDCustomer) {
        this.iDCustomer = iDCustomer;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "iDBooking='" + iDBooking + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", iDCustomer='" + iDCustomer + '\'' +
                ", nameFacility='" + nameFacility + '\'' +
                ", facilityType='" + facilityType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return iDBooking.equals(booking.iDBooking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iDBooking);
    }
}
