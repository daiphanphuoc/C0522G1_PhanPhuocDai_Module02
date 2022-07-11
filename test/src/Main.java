public class Main {
    public static void main(String[] args) {
        Hinh h1 = new Tron();

        Hinh h2 = new TamGiac(3,4,5);

        Hinh h3 = new ChuNhat(4,5);
        h2 = h3;
        System.out.println(((ChuNhat)h2).b);
        Tron h6 = (Tron) h1;
        Hinh h5 = h1;
        //DaGiac h4=h2;
    }
}
