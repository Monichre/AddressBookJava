import java.util.HashMap;

public class Phone {

  private HashMap<String, String> phoneBook = new HashMap<String, String>();

  public Phone(String type, String num){
    phoneBook.put(type, num);

  }

  public void addPhoneNumber(String type, String num){
    phoneBook.put(type, num);
  }

  public HashMap<String, String> returnFullPhone(){
    return phoneBook;
  }
}
