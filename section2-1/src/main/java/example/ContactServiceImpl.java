package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public List<Contact> getAll() {
        return this.contactRepository.findAll();
    }

    @Override
    public void add(Contact contact) {
        this.contactRepository.save(contact);
    }
}
