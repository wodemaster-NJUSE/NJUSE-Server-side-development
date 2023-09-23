package contact;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component

public class ContactServiceAspect {
    List<Contact> contactList = new ArrayList<>();
    private final ContactService contactService;

    @Autowired
    public ContactServiceAspect(ContactService contactService) {
        this.contactService = contactService;
        Contact contact1 = new Contact();
        contact1.setId(1L);
        contact1.setFirstName("san");
        contact1.setLastName("zhang");
        contact1.setPhoneNumber("12345678901");
        contact1.setEmailAddress("zhangsan@163.com");
        contactList.add(contact1);

        Contact contact2 = new Contact();
        contact2.setId(2L);
        contact2.setFirstName("si");
        contact2.setLastName("li");
        contact2.setPhoneNumber("12345678902");
        contact2.setEmailAddress("lisi@163.com");
        contactList.add(contact2);
    }

    @Before("execution(* contact.ContactService.getAll())")
    public void beforeGetAll() {
        contactService.setCache(contactList);
    }
    @After("execution(* contact.ContactService.getAll())")
    public void afterGetAll(){
        contactService.setCache(null);
    }

}
