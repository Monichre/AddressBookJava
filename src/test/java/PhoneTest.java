import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PhoneTest {

  @Test
  public void Contact_InstanceOfPhone_True() {
    Phone testPhone = new Phone("cell", "6122398433");
    assertEquals(true, testPhone instanceof Phone);
  }

  @Test
  public void Contact_InstanceOfCell() {
    Phone testPhone = new Phone("cell", "6122398433");
    String cellTest = "cell : 6122398433";
    assertEquals(cellTest, testPhone.returnFullPhone());
  }
}
