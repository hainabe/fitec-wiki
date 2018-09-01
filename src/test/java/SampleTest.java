import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class SampleTest {

    public static void main(String[] args) {

        Date date = formatDate("01-01-2011");
        String year = String.valueOf(date.getYear());
        System.out.println("YEAR = " + year);

        String strYear = String.valueOf(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date)).getYear());
        System.out.println("STR YEAR = " + strYear);
    }

    public static Date formatDate(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            System.out.println("### Exception: date error!");
            e.printStackTrace();
        }
        return date;
    }
}
