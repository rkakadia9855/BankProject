import static org.junit.Assert.*;
import org.junit.Test;

public class DateTest {

  @Test
  public void testIsValid() {
    Date d1 = new Date(1, 31, 2000); //true
    Date d2 = new Date(2, 30, 2000); //false
    Date d3 = new Date(2, 29, 2020); //true
    Date d4 = new Date(2, 29, 2019); //false
    Date d5 = new Date(3, 31, 2000);//true
    Date d6 = new Date(4, 31, 2000); //false
    Date d7 = new Date(5, 31, 2020); //true
    Date d8 = new Date(6, 31, 2020); //false
    Date d9 = new Date(7, 31, 2020); //true
    Date d10 = new Date(8, 31, 2020);//true
    Date d11 = new Date(9, 31, 2020); //false
    Date d12 = new Date(10, 31, 2020);//true
    Date d13 = new Date(11, 31, 2020);//false
    Date d14 = new Date(12, 31, 2020); //true
    Date d15 = new Date(1, 32, 2020); //false
    Date d16 = new Date(3, 32, 2020); //false
    Date d17 = new Date(5, 32, 2020); //false
    Date d18 = new Date(7, 32, 2020); //false
    Date d19 = new Date(8, 32, 2020); //false
    Date d20 = new Date(10, 32, 2020); //false
    Date d21 = new Date(12, 32, 2020); //false

    assertTrue(d1.isValid());
    assertTrue(d3.isValid());
    assertTrue(d5.isValid());
    assertTrue(d7.isValid());
    assertTrue(d9.isValid());
    assertTrue(d10.isValid());
    assertTrue(d12.isValid());
    assertTrue(d14.isValid());
    
    assertFalse(d2.isValid());
    assertFalse(d4.isValid());
    assertFalse(d6.isValid());
    assertFalse(d8.isValid());
    assertFalse(d11.isValid());
    assertFalse(d13.isValid());
    assertFalse(d15.isValid());
    assertFalse(d16.isValid());
    assertFalse(d17.isValid());
    assertFalse(d18.isValid());
    assertFalse(d19.isValid());
    assertFalse(d20.isValid());
    assertFalse(d21.isValid());
  }

}
