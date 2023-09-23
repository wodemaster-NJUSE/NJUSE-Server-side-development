package example;

import contact.Contact;
import contact.ContactConfigAOP;
import contact.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContactConfigAOP.class)
public class ContactServiceAOPTest {
    @Autowired
    private ContactService contactService;

    @Test
    public void testGetAllReturnTwo() throws Exception {
        List<Contact> contacts = contactService.getAll();
        assertThat(contacts, is(expectedContacts()));
    }

    private List<Contact> expectedContacts() {
        List<Contact> contacts = new ArrayList<Contact>();

        Contact contact1 = new Contact();
        contact1.setId(1L);
        contact1.setFirstName("san");
        contact1.setLastName("zhang");
        contact1.setPhoneNumber("12345678901");
        contact1.setEmailAddress("zhangsan@163.com");
        contacts.add(contact1);

        Contact contact2 = new Contact();
        contact2.setId(2L);
        contact2.setFirstName("si");
        contact2.setLastName("li");
        contact2.setPhoneNumber("12345678902");
        contact2.setEmailAddress("lisi@163.com");
        contacts.add(contact2);

        return contacts;
    }
}