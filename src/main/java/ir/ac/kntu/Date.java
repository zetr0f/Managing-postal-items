package ir.ac.kntu;

/**
 * @author Ali Afshar
 * @version 2.0
 * @since 3/14/2020
 */
public class Date implements Cloneable{
    /**
     * declaring the Date fields
     */
    private int year;
    private int month;
    private int day;

    /**
     * the constructor with Date fields(year,month,day) input
     *
     * @param year the year of date
     * @param month the month of date
     * @param day the day of date
     */
    public Date(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    /**
     * the constructor with Date input
     *
     * @param date we do not check it because it will be checked before (at declaration)
     */
    public Date(Date date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }

    /**
     * check and set the date fields
     *
     * @param year  the positive integer
     * @param month the integer between [1-12]
     * @param day   the integer show the day of month we are in , between [1-31]
     */
    private void checkAndSetDate(int year, int month, int day) {
        if (checkInputs(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            this.year = 0;
            this.month = 1;
            this.day = 1;
        }
    }

    /**
     * check the date fields
     *
     * @param year it must be positive
     * @param month the integer between [1-12]
     * @param day the integer show the day of month we are in , between [1-31]
     * @return if the inputs is okay return true else return false
     */
    private boolean checkInputs(int year, int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31 || month > 6
                && day == 31) {
            return false;
        }
        return month != 12 || day != 30 || isLeapYear(year);
    }

    /**
     * check and set the date fields
     *
     * @param year it must be positive
     * @param month the integer between [1-12]
     * @param day the integer show the day of month we are in , between [1-31]
     */
    public void setDate(int year, int month, int day) {
        checkAndSetDate(year, month, day);
    }

    /**
     * get the year of date
     *
     * @return year of date
     */
    public int getYear() {
        return year;
    }

    /**
     * set the year of date
     *
     * @param year give the year (int) you want to set
     */
    public void setYear(int year) {
        checkAndSetDate(year, this.month, this.day);
    }

    /**
     * get the month of date
     *
     * @return month of date
     */
    public int getMonth() {
        return month;
    }

    /**
     * set the month of date
     *
     * @param month give the year (int) you want to set
     */
    public void setMonth(int month) {
        checkAndSetDate(this.year, month, this.day);
    }

    /**
     * get the day of date
     *
     * @return day of date
     */
    public int getDay() {
        return day;
    }

    /**
     * set the day of date
     *
     * @param day give the year (int) you want to set
     */
    public void setDay(int day) {
        checkAndSetDate(this.year, this.month, day);
    }

    /**
     * convert current date to next date
     *
     * @return the next Date
     */
    public Date nextDay() {
        Date curDate = new Date(this);
        Date nextDate = new Date(this);
        if (curDate.month == 12) {
            handleTheLastMonth(curDate, nextDate);
        } else if (curDate.day < 30) {
            curDate.day++;
        } else if (curDate.day == 30 && curDate.month < 7) {
            nextDate.day++;
        } else {
            nextDate.day = 1;
            nextDate.month++;
        }
        return nextDate;
    }

    /**
     * handle the 12th month because it's special
     *
     * @param curDate  the Date we in
     * @param nextDate the next Date
     */
    private void handleTheLastMonth(Date curDate, Date nextDate) {
        int endOfMonthDay = 29;
        if (isLeapYear(curDate.year)) {
            endOfMonthDay = 30;
        }
        if (curDate.day == endOfMonthDay) {
            nextDate.year++;
            nextDate.month = 1;
            nextDate.day = 1;
        } else {
            nextDate.day++;
        }
    }

    /**
     * check if year is leap(kabise) or not
     *
     * @param year the year we want to check
     * @return if year is leap return true else return false
     */
    private boolean isLeapYear(int year) {
        int firstFraction, secondFraction;
        final double a = 0.025d;
        final double b = 266d;
        double c, d;
        if (year > 0) {
            c = ((year + 38) % 2820) * 0.24219 + a;
            d = ((year + 39) % 2820) * 0.24219 + a;
        } else if (year < 0) {
            c = ((year + 39) % 2820) * 0.24219 + a;
            d = ((year + 40) % 2820) * 0.24219 + a;
        } else {
            return false;
        }
        firstFraction = (int) ((c - Math.floor(c)) * 1000);
        secondFraction = (int) ((d - Math.floor(d)) * 1000);
        return firstFraction <= b && secondFraction > b;
    }

    public int compareTo(Date date){
        if (date.getYear()!=this.getYear()) {
            return this.getYear() - date.getYear();
        } if (date.getMonth()!=this.getMonth()) {
            return this.getMonth() - date.getMonth();
        }
        return this.getDay() - date.getDay();
    }

    @Override
    protected Date clone() throws CloneNotSupportedException {
        return (Date)super.clone();
    }

    /**
     * convert date to string
     *
     * @return the string of date
     */
    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}