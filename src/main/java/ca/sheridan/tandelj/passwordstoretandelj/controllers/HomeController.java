package ca.sheridan.tandelj.passwordstoretandelj.controllers;

import ca.sheridan.tandelj.passwordstoretandelj.beans.PasswordRecord;
import ca.sheridan.tandelj.passwordstoretandelj.databases.DatabaseAccess;
import ca.sheridan.tandelj.passwordstoretandelj.utilities.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class HomeController {
    private final PasswordService passwordService;

    public HomeController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }
    @Autowired
    private DatabaseAccess databaseAccess;
    @GetMapping("/")
    public String index(Model model) {
        PasswordRecord pr = new PasswordRecord();
        pr.setId(RandomNumberGenerator.generateNineDigitNumber());
        model.addAttribute("passwordRecord", pr);
        return "index";
    }
    @PostMapping("/addRecord")
    public String addRecord(@ModelAttribute PasswordRecord passwordRecord, Model model) {
        databaseAccess.save(passwordRecord);
        model.addAttribute("message", "Record added successfully!");
        PasswordRecord pr = new PasswordRecord();
        pr.setId(RandomNumberGenerator.generateNineDigitNumber());
        model.addAttribute("passwordRecord", pr);
        return "index";
    }
    @GetMapping("/viewRecords")
    public String viewRecords(Model model) {
        List<PasswordRecord> records = passwordService.getAllPasswords();
        model.addAttribute("records", records);
        return "viewPasswordRecord";  // Renders the viewPasswordRecord.html page
    }
    @GetMapping("/searchPasswordRecord")
    public String search(@RequestParam(value = "title", required = false) String title, Model model) {
        List<PasswordRecord> results = databaseAccess.findByTitleContainingIgnoreCase(title);
        model.addAttribute("results", results);
        model.addAttribute("title", title);
        return "searchPasswordRecord";
    }
}
