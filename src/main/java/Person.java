@ActiveRecordEntity(tableName = "person",KeyColumnName="id")

public class Person extends ActivRecord{
//    id int AI PK
//    last_name varchar(255)
//    first_name varchar(255)
//    age
    int id;
    String last_name;
    String first_name;
    int age;

    public Person() {
    }

    public Person( String last_name, String first_name, int age) {

        this.last_name = last_name;
        this.first_name = first_name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", age=" + age +
                '}';
    }
}
