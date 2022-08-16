import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //insert
        Person p1=new Person("Silviu-Dan","Mitreanu",18);
        //p1.insert();
        try {
            p1.insert();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


        //delete
         //p1.delete();


        //update
        //p1.setAge(31);
        //p1.setFirst_name("Gigel");


        //get by id
       // Person p2=p1.getById(5);


        //select
//        try {
//            List<Person> personList=p1.getAll();
//            System.out.println(personList);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }
//     Command c=new Command();
//        try {
//            List<Command>commandsList=c.getAll();
//            System.out.println(commandsList);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        }

    }
}
