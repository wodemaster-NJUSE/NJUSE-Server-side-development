package contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();

    void setCache(List<Contact>cache);
    Contact add(Contact contact);


    Contact findById(Long id);



    void delete(Long id);
}
