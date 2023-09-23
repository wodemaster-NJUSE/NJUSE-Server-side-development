package contact;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ContactConfig {
    @Bean
    public ContactRepository contactRepository() {
        return new ContactRepositoryImpl();
    }

    @Bean
    public ContactService contactService(ContactRepository contactRepository) {
        return new ContactServiceImpl(contactRepository);
    }
}



