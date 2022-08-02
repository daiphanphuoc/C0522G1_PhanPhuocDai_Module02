package models;

public enum Path {
    BOOKING("case_study/src/data/booking.csv"),
    FACILITY("case_study/src/data/facility.csv"),
    CUSTOMER("case_study/src/data/customer.csv"),
    EMPLOYEE("case_study/src/data/employee.csv"),
    CONTRACT("case_study/src/data/contract.csv");
    private String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
