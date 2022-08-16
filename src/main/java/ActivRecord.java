import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ActivRecord {
    //CRUD

    public void insert() throws SQLException, IllegalAccessException {
        Class<ActivRecord> c= (Class<ActivRecord>) this.getClass();
        ActiveRecordEntity arAnnotation=c.getAnnotation(ActiveRecordEntity.class);
        String tableName=arAnnotation.tableName();
        String keycolumnName= arAnnotation.KeyColumnName();
         Field[] fields=c.getDeclaredFields();
        String command="INSERT INTO "+tableName+"(";
         for(int i=0;i<fields.length;i++){
             if(fields[i].getName().equals(keycolumnName))
             {
                 continue;
             }
              if(i!=fields.length-1) {
                  command += fields[i].getName() + ", ";
              }
              else {
                  command += fields[i].getName();
              }
         }

         command+=") Values ( ?";

         for(int i=0;i<fields.length-1;i++){
             if(fields[i].getName().equals(keycolumnName))
             {
                 continue;
             }
             command+=" ,?";
         }
         command+=")";

        System.out.println(command);

     PreparedStatement preparedStatement=DBUtils.getConnection().prepareStatement(command);
     int counter=0;
        for(int i=0;i<fields.length;i++){
            if(fields[i].getName().equals(keycolumnName))
            {
                continue;
            }
            counter++;
            if(fields[i].getType()==int.class){
                preparedStatement.setInt(counter,fields[i].getInt(this));
            } else if (fields[i].getType()==String.class) {
                preparedStatement.setString(counter,(String) fields[i].get(this));

            }

        }
        System.out.println(preparedStatement.executeUpdate());

    }
    private void delete(){

    }
    public  void update(){

    }

    public <T> T getByid(int id){
        return null;

    }

    public <T> List<T> getAll() throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        //Plan:
        //Selct *from tableName
        //ResultSet -getInt/getString--->tipul si Numele
        //cine e T,ce campuri are ,ce tipuri au cumpurile respective;

        List<T> resultList=new ArrayList<>();//rezultatul la query
        //1.accesam table name
        Class<ActivRecord> c= (Class<ActivRecord>) this.getClass();
        ActiveRecordEntity arAnnotation=c.getAnnotation(ActiveRecordEntity.class);
        String tableName=arAnnotation.tableName();
        String keycolumnName= arAnnotation.KeyColumnName();
        //2.Rulam Select
        Connection connection=DBUtils.getConnection();
        if(connection==null){//ceva nu a mers bine cu DB
            return null;
        }
        Statement s= connection.createStatement();
        ResultSet queryresult=s.executeQuery("Select * from "+tableName);
        ResultSetMetaData meta= queryresult.getMetaData();
        int numbercolumns= meta.getColumnCount();

        //3.interpretam queryResult si cream obiect de tip
        while (queryresult.next()){
            //apelam constructul
            T obj=(T)c.getDeclaredConstructor().newInstance();
            //Potrivesc fiecare camp din T cu Rezultatul din querryresult
            for (int i=1;i<=numbercolumns;i++){
                //numele coloanelor din tabel sunt la fel cu numele atributeleor din Java
                String columnname=meta.getColumnName(i);
                Field f=c.getDeclaredField(columnname);

                //verificam tipul campului
                if(f.getType()==int.class){
                    f.setInt(obj,queryresult.getInt(columnname));

                } else if (f.getType()==String.class) {
                    f.set(obj,queryresult.getString(columnname));

                } else if (f.getType()==Date.class) {
                        f.set(obj,queryresult.getDate(columnname));
                } else if (f.getType()==Timestamp.class) {
                    f.set(obj,queryresult.getTimestamp(columnname));

                }

                //String,float ,double ,date etc,


            }
            resultList.add(obj);

        }



        return resultList;
    }


}
