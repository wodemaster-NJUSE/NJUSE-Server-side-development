package contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();

    void setCache(List<Contact>cache);
    void add(Contact contact);
}
