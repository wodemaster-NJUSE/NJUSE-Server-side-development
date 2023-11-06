package contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private List<Contact> cachedList  = null;
    @Override
    public void setCache(List<Contact>cache){
        cachedList = cache;
    }
    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public List<Contact> getAll() {
        if(cachedList!=null)return cachedList;
        else return (List<Contact>) contactRepository.findAll();
    }
    @Override
    public Contact add(Contact contact) {
        this.contactRepository.save(contact);
        return contact;
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }


    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }


}
