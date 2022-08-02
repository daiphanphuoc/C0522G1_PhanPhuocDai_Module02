package models;

public enum Path {
    TAI_KHOAN("ngan_hang/src/du-lieu/tai_khoan.csv");
    private String path;



    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
