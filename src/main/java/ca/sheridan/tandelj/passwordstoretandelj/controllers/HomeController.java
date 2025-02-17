package ca.sheridan.tandelj.passwordstoretandelj.controllers;

import ca.sheridan.tandelj.passwordstoretandelj.beans.PasswordRecord;
import ca.sheridan.tandelj.passwordstoretandelj.databases.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("passwordRecord", new PasswordRecord());
        return "index";
    }

    @PostMapping("/addRecord")
    public String addRecord(@ModelAttribute PasswordRecord passwordRecord, Model model) {
        databaseAccess.save(passwordRecord);
        model.addAttribute("message", "Record added successfully!");
        return "index";
    }

    @GetMapping("/viewPasswordRecord")
    public String viewRecords(Model model) {
        List<PasswordRecord> records = databaseAccess.findAll();
        model.addAttribute("records", records);
        return "viewPasswordRecord";
    }

    @GetMapping("/searchPasswordRecord")
    public String search(@RequestParam(value = "title", required = false) String title, Model model) {
        List<PasswordRecord> results = databaseAccess.findByTitleContainingIgnoreCase(title);
        model.addAttribute("results", results);
        model.addAttribute("title", title);
        return "searchPasswordRecord";
    }
}