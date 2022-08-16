

@ActiveRecordEntity(tableName = "customers",KeyColumnName = "id")
public class Custumers {
//    id int AI PK
//    username varchar(50)
//    last_name varchar(45)
//    first_name varchar(45)
//    phone varchar(45)
//    address varchar(45)
//    city varchar(45)
//    postal_code varchar(15)
//    country varchar(45)
    int id;
    String username;
    String last_name;
    String first_name;
    String phone;
    String addres;
    String city;
    String postal_code;
    String country;

    public Custumers( String username, String last_name, String first_name, String phone, String addres, String city, String postal_code, String country) {
        this.username = username;
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone = phone;
        this.addres = addres;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
