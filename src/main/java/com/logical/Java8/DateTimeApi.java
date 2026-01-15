package Java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


// till java 7...java.util package has most and remaining in java.sql package
// new 

// java 8 additions...java.time package
// classes,Enums  are...LocalDate,LocalTime,LocalDateTime,ZonedDateTime,MonthDayOfWeek,Duration,Period,Clock,
//



public class DateTimeApi {

	public static void main(String[] args)throws Exception {

//		System.out.println("time : "+System.currentTimeMillis());
//		
//		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		
//		System.out.println(ts);
//		
//		Date dt = ts;
//		
//		System.out.println(dt);
		
//		 DateTimeApi.date();
		// First.time();
		// First.zone();
		//First.dateBetween();
		 
		 
		formatStringDateToDate();
		
		 
		 
//			System.out.println("time : "+System.currentTimeMillis());			
//			Timestamp ts = new Timestamp(1693000000000L);			
//			System.out.println(ts);			
//			Date dt = new Date(1693000000000L);  // TimeStamp extends Date			
//			System.out.println(dt);
	}

	public static void dateBetween() {

		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		
		long oneDay = Duration.between(today.atStartOfDay(), yesterday.atStartOfDay()).toDays();
		System.out.println(oneDay);

		// ===
		LocalDate dateBefore = LocalDate.of(2017, Month.MAY, 24);
		// 29-July-2017, change this to your desired End Date
		LocalDate dateAfter = LocalDate.of(2017, Month.JULY, 29);
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		System.out.println(noOfDaysBetween);

		// ====
		LocalDate date1 = LocalDate.of(2017, Month.MAY, 24);
		// 29-July-2017, change this to your desired End Date
		LocalDate date2 = LocalDate.of(2017, Month.JULY, 29);
		long noOfDaysBetween2 = ChronoUnit.DAYS.between(date1, date2);
		System.out.println(noOfDaysBetween2);
	}

	public static void date() {
		
		Date date =new Date();
		System.out.println(" Date : "+date);
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now()); // combines  above two
		
		LocalDate ld2 = LocalDate.of(2015, 02, 20);
		LocalDate ld3 = LocalDate.parse("2015-02-20");
		
		
		String stringDate =ld3.toString();
//		
		// LocalDate ld 
		// .plusDays()/plusWeeks()/plusYears()/plusMonths() 
		// .plus(3, ChronoUnit.MONTHS) accepts an enum as the time unit:
		// .getDayOfWeek()
		// same for minus
		// same for LocalTime		
		System.out.println(LocalDateTime.now()
				);
		
		Objects.requireNonNull(ld3);  // Objects ext Object
		
		

	}

	public static void time() {

		LocalTime sixThirty = LocalTime.parse("06:30");
		LocalTime sixThirty2 = LocalTime.of(6, 30);

		// =========
		DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();

		int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();

		boolean leapYear = LocalDate.now().isLeapYear();

		// =========
		boolean leapYear2 = LocalDate.now().isLeapYear();
	}

	public static void datetime() {

		LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
		LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());

		// =========

		int six = LocalTime.parse("06:30").getHour();
		boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));

		LocalTime maxTime = LocalTime.MAX;

		// ==========

		LocalDateTime localDateTime = 
		LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);

		LocalDateTime.parse("2015-02-20T06:30:00");

		localDateTime.plusDays(1);
		localDateTime.minusHours(2);
		localDateTime.getMonth();

	}
	//

	public static void zone() {

		ZonedDateTime currentZone = ZonedDateTime.now();
		System.out.println("the current zone is " + currentZone.getZone());

		LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);

		ZoneId zoneId = ZoneId.of("Europe/Paris");

		System.out.println(zoneId);

		System.out.println(ZoneId.of("Asia/Kolkata"));

		// we can get a set of all zone ids:

		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
		System.out.println(allZoneIds);

		// LocalDateTime can be converted to a specific zone:

		ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
		System.out.println(zonedDateTime);

		// ZonedDateTime provides the parse method to get time-zone-specific date-time:

		ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris]");

	}

	public static void print() {
		// will give us the current time and date
		LocalDateTime current = LocalDateTime.now();
		System.out.println("current date and time : " + current);

		// to print in a particular format
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String formatedDateTime = current.format(format);

		System.out.println("in formatted manner " + formatedDateTime);

		// printing months days and seconds
		Month month = current.getMonth();
		int day = current.getDayOfMonth();
		int seconds = current.getSecond();
		System.out.println("Month : " + month + " day : " + day + " seconds : " + seconds);

		// printing some specified date
		LocalDate date2 = LocalDate.of(1950, 1, 26);
		System.out.println("the republic day :" + date2);

		// printing date with current time.
		LocalDateTime specificDate = current.withDayOfMonth(24).withYear(2016);

		System.out.println("specific date with " + "current time : " + specificDate);
	}
	
	public static void formatStringDateToDate() throws ParseException
	{
		String date="2023-15-10";
		
		SimpleDateFormat sdf= new SimpleDateFormat("YyYy-dD-mm");
		
		Date ddd =	sdf.parse(date);
		
		System.out.println(ddd.getDay());        
        
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");

        String dayOfWeek2 = dayFormat.format(ddd);

        System.out.println(dayOfWeek2);
    }
}
