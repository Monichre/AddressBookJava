import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;



public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      ArrayList<Contact> contacts = Contact.getAll();
      model.put("contacts", contacts);
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts", (request, response) -> {
      HashMap model = new HashMap();
      ArrayList<Contact> contacts = Contact.getAll();
      String firstName = request.queryParams("firstName");
      String lastName = request.queryParams("lastName");
      String type = request.queryParams("type");
      String phoneNumber = request.queryParams("phoneNumber");
      String addressType = request.queryParams("addressType");
      String address = request.queryParams("address");

      //************************ IF STATEMENTS FOR CONTACTS**********************//



      int counter = 0;
      int indexContact = 0;
      for(Contact contact : contacts){
        if(contact.getFirstName().contains(firstName) && contact.getLastName().contains(lastName)){
          counter++;
          indexContact = contacts.indexOf(contact);
        }
      }
      if(counter > 0){
        Phone newPhone = new Phone(type, phoneNumber);
        if(!(contacts.get(indexContact).getPhone().returnFullPhone().get(type) == phoneNumber)){
          contacts.get(indexContact).getPhone().addPhoneNumber(type, phoneNumber);
        }else{
          contacts.get(indexContact).addPhone(newPhone);
        }
      }else{
        Contact contact = new Contact(firstName, lastName);
        contact.addAddress(addressType, address);
        if(!(type == null || phoneNumber == null)){
          Phone phone = new Phone(type, phoneNumber);
          contact.addPhone(phone);
        }
      }
      model.put("contacts", contacts);
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

//************************ PATH ROUTE FOR CONTACT INFO**********************



    get("/contactInfo/:id", (request, response) -> {
      HashMap model = new HashMap();
      Contact contact = Contact.find(Integer.parseInt(request.params(":id")));
      // String email = contact.getEmail();
      // model.put("email", email);
      model.put("contact", contact);
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
