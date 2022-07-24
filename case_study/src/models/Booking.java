package models;

import java.util.Date;

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
        return String.format("%s,%s,%s,%s,%s,%s", getIDBooking(), getBegin(), getEnd(),
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
}
