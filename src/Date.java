
public class Date implements Comparable<Date> {
  
  private int year;
  private int month;
  private int day;
  
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  public int getDay() {
    return this.day;
  }
  
  public int getMonth() {
    return this.month;
  }
  
  public int getYear() {
    return this.year;
  }

  @Override
  public int compareTo(Date date) {
    int result = 0;
    
    // check if the passed date is valid
    
    // all same:- return 0
    if((this.year == date.getYear()) && (this.month == date.getMonth()) 
        && (this.day == date.getDay())) {
      result = 0;
    }
    // else if this year is greater than date year return 1
    else if(this.year > date.getYear()) {
      result = 1;
    }
    // else if this year is less than date year return -1 
    else if(this.year < date.getYear()) {
      result = -1;
    }
    // else if year is same
    // do the above steps for month
    else {
      if(this.month > date.getMonth()) {
        result = 1;
      }
      else if(this.month < date.getMonth()) {
        result = -1;
      }
      else {
        //then for the day
        if(this.day > date.getDay()) {
          result = 1;
        }
        else if(this.day < date.getDay()) {
          result = -1;
        }
      }
    }
    
    return result;
  }
  
  public String toString() {
    String date = "";
    String dayString = this.day + "";
    String monthString = this.month + "";
    String yearString = this.year + "";
    
    if(dayString.length() < 2) {
      dayString = "0" + dayString;
    }
    if(monthString.length() < 2) {
      monthString = "0" + monthString;
    }
    date = monthString + "/" + dayString + "/" + yearString;
    return date;
  }
  
  public boolean isValid() {
    boolean valid = false;
    
    if(this.day == 0 || this.month == 0 || this.year == 0) 
       valid = false;
    else
       valid = true;
    
    String temp = this.year + "";
    if(temp.length() < 4) 
      valid = false;
    return valid;
  }

}
