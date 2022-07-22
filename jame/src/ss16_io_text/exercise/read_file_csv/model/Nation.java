package ss16_io_text.exercise.read_file_csv.model;

public class Nation {
    private int id;
    private String key;
    private String name;

    public Nation() {
    }

    public Nation(int id, String key, String name) {
        this.id = id;
        this.key = key;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getInfo(){
        return String.format("%s,%s,%s",getId(),getKey(),getName());
    }

    @Override
    public String toString() {
        return "Nation{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
