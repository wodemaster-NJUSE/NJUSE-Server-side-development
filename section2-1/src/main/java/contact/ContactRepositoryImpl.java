package contact;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ContactRepositoryImpl implements ContactRepository{
    ArrayList<Contact>repository;

    public ContactRepositoryImpl() {
        repository = new ArrayList<>(); // 在构造函数中初始化 repository
    }
    @Override
    public List<Contact> findAll() {
        return repository;
    }

    @Override
    public void save(Contact contact) {
        repository.add(contact);
    }

    @Override
    public void clear() {
        repository.clear();
    }
}