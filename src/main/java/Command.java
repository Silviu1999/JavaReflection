
@ActiveRecordEntity(tableName = "command",KeyColumnName = "id")
public class Command extends ActivRecord{
//    id int AI PK
//    order_number int
//    person_id int
    int id;
    int order_number;
    int person_id;

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", order_number=" + order_number +
                ", person_id=" + person_id +
                '}';
    }
}
