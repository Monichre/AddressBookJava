import java.util.ArrayList;
import java.util.HashMap;


public class Contact {
  private String mFirstName;
  private String mLastName;
  private String mBirthMonth;
  private int mId;
  private Phone mPhone;
  private  HashMap<String, String> mAddresses = new HashMap<String, String>();

// PUBLIC / CLASS LEVE LEVEL VAIABLES //
  private static HashMap<String, String> mEmail = new HashMap<String, String>();
  private static ArrayList<Contact> addressBook = new ArrayList<Contact>();


  public Contact(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
    addressBook.add(this);
    mId = addressBook.size();
  }

  public Contact(String firstName, String lastName, Phone phone) {
    mFirstName = firstName;
    mLastName = lastName;
    addressBook.add(this);
    mId = addressBook.size();
    mPhone = phone;
  }

  public Integer getId(){
    return mId;
  }

  public String getName() {
    return mFirstName + " " + mLastName;
  }

  public String getFirstName() {
    return mFirstName;
  }

  public String getLastName() {
    return mLastName;
  }

// METHOD FOR !ST CONSTRUCTOR //
  public void addPhone(Phone phone) {
    mPhone = phone;
  }

  public Phone getPhone(){
    return mPhone;
  }

  public void addBirthMonth(String month){
    mBirthMonth = month;
  }

  public String getBirthMonth(){
    return mBirthMonth;
  }

  public void addEmail(String type, String email){
    mEmail.put(type, email);
  }

  public HashMap<String, String> getEmail(){
    return mEmail;
  }

  public void addAddress(String type, String address){
    mAddresses.put(type, address);
  }

  public String getAddress(){
    String theAddress = "";
    for(String address : this.mAddresses.keySet()){
      theAddress += address + " : " + this.mAddresses.get(address);
    }

    return theAddress;
  }

  public static ArrayList<Contact> getAll(){
    return addressBook;
  }

  public String getContactPhone(){
    // return mPhone.returnFullPhone();
    String theNum = "";
    for(String num : mPhone.returnFullPhone().keySet()){
      theNum += num + " : " + mPhone.returnFullPhone().get(num);

    }
    return theNum;
  }

  public static Contact find(int id){
    try {
      return addressBook.get(id - 1);
    } catch (IndexOutOfBoundsException e){
      return null;
    }
  }


}
