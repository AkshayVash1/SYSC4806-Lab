package org.example;

import jakarta.transaction.Transactional;
import org.example.AddressBook;
import org.example.AddressBookRepository;
import org.example.BuddyInfo;
import org.example.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddressBookController {

    @Autowired
    AddressBookRepository addressBookRepository;

    @GetMapping("/createBook1")
    public String createBook(Model model) {
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        model.addAttribute("id", addressBook.getId());
        return "createBook";
    }

    @Transactional
    @GetMapping("/addBuddy1")
    public String addBuddy(@RequestParam(name="name") String name, @RequestParam(value="phoneNumber") String phoneNumber,
                           @RequestParam(value="address") String address,
                           @RequestParam(value="addressBookID") long addressBookID , Model model) {
        BuddyInfo buddy = new BuddyInfo(name, phoneNumber, address);
        AddressBook addressBook = addressBookRepository.findById(addressBookID);
        addressBook.addBuddy(buddy);
        model.addAttribute("buddies", addressBook.getBuddyList());
        model.addAttribute("id", addressBook.getId());
        return "addBuddy";
    }

    @Transactional
    @GetMapping("/removeBuddy1")
    public String removeBuddy(@RequestParam(value="buddyID") long buddyInfoID,
                              @RequestParam(value="addressBookID") long addressBookID , Model model) {
        AddressBook addressBook = addressBookRepository.findById(addressBookID);
        addressBook.removeBuddyByID(buddyInfoID);
        model.addAttribute("buddies", addressBook.getBuddyList());
        model.addAttribute("id", addressBook.getId());
        return "removeBuddy";
    }

    @GetMapping("/getBuddies1")
    public String getBuddies(@RequestParam(value="addressBookID") long addressBookID , Model model) {
        AddressBook addressBook = addressBookRepository.findById(addressBookID);
        model.addAttribute("buddies", addressBook.getBuddyList());
        model.addAttribute("id", addressBookID);
        return "getBuddies";
    }
}
