package example;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContactConfig.class)
public class ContactServiceTest {
    @Autowired
    private ContactService contactService;

    @Autowired
    private ContactRepository contactRepository;

    private static long id = 0;

    @Before
    public void setUp() throws Exception {
        contactRepository.clear();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetAllReturnEmpty() throws Exception {
        List<Contact> contacts = contactService.getAll();
        assertThat(contacts.size(), is(0));
    }

    @Test
    public void testGetAllReturnOne() throws Exception {
        Contact contact = generateContact();

        contactRepository.save(contact);

        List<Contact> contacts = contactService.getAll();

        assertThat(contacts, hasItem(contact));
    }

    @Test
    public void testGetAllReturnTwo() throws Exception {
        Contact contact1 = generateContact();
        contactRepository.save(contact1);

        Contact contact2 = generateContact();
        contactRepository.save(contact2);

        List<Contact> contacts = contactService.getAll();

        assertThat(contacts, hasItems(contact1, contact2));
    }

    private Contact generateContact() {
        id++;

        Faker faker = new Faker(Locale.ENGLISH);

        Contact contact = new Contact();
        contact.setId(id);
        contact.setFirstName(faker.name().firstName());
        contact.setLastName(faker.name().lastName());
        contact.setPhoneNumber(faker.phoneNumber().cellPhone());
        contact.setEmailAddress(faker.internet().emailAddress());

        return contact;
    }
}