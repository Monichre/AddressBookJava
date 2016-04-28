import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactTest {

  @Test
  public void Contact_InstanceOfContact_True() {
    Contact testContact = new Contact("Patrick", "Wells");
    assertEquals(true, testContact instanceof Contact);
  }

  @Test
  public void Contact_ContactName_True() {
    Contact testContact = new Contact("Patrick", "Wells");
    String testName = "Patrick Wells";
    assertEquals(testName, testContact.getName());
  }

  @Test
  public void Contact_AddContactBirthMonth_True() {
    Contact testContact = new Contact("Patrick", "Wells");
    testContact.addBirthMonth("March");
    String birthMonth = "March";
    assertEquals(birthMonth, testContact.getBirthMonth());
  }

  @Test
  public void Contact_AddEmails() {
    Contact testContact = new Contact("Patrick", "Wells");
    HashMap<String, String> email = new HashMap<String, String>();
    email.put("work", "hello@this.com");
    assertEquals(email, testContact.addEmail("work", "hello@this.com"));
  }

  @Test
  public void Contact_AddAddress() {
    Contact testContact = new Contact("Patrick", "Wells");
    testContact.addAddress("home", "thisStreet");
    HashMap<String, String> address = new HashMap<String, String>();
    address.put("home", "thisStreet");
    assertEquals(address, testContact.getAddress());
  }

  @Test
  public void Does_ReturnTheAddress_Correctly() {
    Contact testContact = new Contact("Patrick", "Wells");
    Contact testContact2 = new Contact("Liam", "Ellis");
    HashMap<String, String> address = new HashMap<String, String>();
    HashMap<String, String> address2 = new HashMap<String, String>();
    address.put("work", "this work street");
    address2.put("home", "this home street");
    testContact.addAddress("work", "this work street");
    testContact2.addAddress("home", "this home street");
    assertEquals(address, testContact.getAddress());
    assertEquals(address2, testContact2.getAddress());
  }

  @Test
  public void Contact_GetPhoneNumber() {
    Phone testPhone = new Phone("cell", "1234567890");
    Contact testContact = new Contact("Patrick", "Wells", testPhone);
    Contact testContact2 = new Contact("Liam", "Ellis");
    testContact2.addPhone(testPhone);
    String testNum = "cell : 1234567890";
    assertEquals(testNum, testContact2.getContactPhone());
    assertEquals(testNum, testContact.getContactPhone());
  }

  @Test
  public void Contact_GetBirthMonth() {
    Contact testContact = new Contact("Patrick", "Wells");
    testContact.addBirthMonth("March");
    String testMonth = "March";
    assertEquals(testMonth, testContact.getBirthMonth());
  }
}
