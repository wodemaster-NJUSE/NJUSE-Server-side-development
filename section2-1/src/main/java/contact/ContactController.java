package contact;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ContactController {


    private List<Contact> contacts = new ArrayList<>();


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
            contacts.add(contact);
            model.addAttribute("contacts", contacts);
            model.addAttribute("contact", new Contact()); // 清空表单
        }
        return "contactForm";
    }

    //    需要用’/‘指定根页面，输入’localhost:8080‘就可以访问页面了
    @GetMapping("/")
    public String showContacts() {
        return "contactForm";
    }

//      如果你指定“addContact”的话，输入’localhost:8080/addContact‘就可以访问页面了，所以其实这个方法没必要，可注释掉
//    @GetMapping("/addContact")
//    public String showContactForm(Model model) {
//        model.addAttribute("contacts", contacts);
//        return "contactForm";
//    }

}
