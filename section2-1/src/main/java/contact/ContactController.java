package contact;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    // Inject ContactService via constructor
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    //    需要用’/‘指定根页面，输入’localhost:8080‘就可以访问页面了
    @GetMapping("/")
    public String showContacts() {
        return "contactForm";
    }
    @ModelAttribute("contact")
    public Contact contact() {
        return new Contact();
    }

    @PostMapping("/addContact")
    public String submitContactForm(
            @Valid @ModelAttribute("contact") Contact contact,
            BindingResult bindingResult,
            Model model) {
        log.info(String.valueOf(bindingResult.hasErrors()));
        if (!bindingResult.hasErrors()) {
            contactService.add(contact); // Save to the database
            model.addAttribute("contacts", contactService.getAll()); // Retrieve from the database
            model.addAttribute("contact", new Contact()); // Clear the form
        }
        return "contactForm";
    }

    @GetMapping("/showContacts") // Change the mapping to "/contacts/showContacts"
    public String show(Model model) {
        model.addAttribute("contacts", contactService.getAll());
        return "contactForm";
    }
}
