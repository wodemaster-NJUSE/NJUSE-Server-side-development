package contact;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long> {
//    List<Contact> findAll();
//
//    void save(Contact contact);
//
//    void clear();
}
