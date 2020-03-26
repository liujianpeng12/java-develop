
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println(date.getTime());
		System.out.println(date);
		
		//Calendar
		Calendar c1=Calendar.getInstance();		
		Calendar c2=new GregorianCalendar();
		
		int year=c1.get(Calendar.YEAR);
		System.out.println(year);
		
		
		//DateFormat
		DateFormat df=DateFormat.getInstance();
		String nowDate=df.format(new Date());
		System.out.println(nowDate);
		
		DateFormat df2=DateFormat.getDateInstance(DateFormat.LONG,Locale.CHINA);
		String nowDate2=df2.format(new Date());
		System.out.println(nowDate2);
		
		DateFormat df3=DateFormat.getTimeInstance(DateFormat.SHORT);
		String nowDate3=df3.format(new Date());
		System.out.println(nowDate3);
		
		
		//SimpleDateFormat
		SimpleDateFormat sdf=new SimpleDateFormat();
		String nowDate4=sdf.format(new Date());
		System.out.println(nowDate4);
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String nowDate5=sdf2.format(new Date());
		System.out.println(nowDate5);
	}

}
