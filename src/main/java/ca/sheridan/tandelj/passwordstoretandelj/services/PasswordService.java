package ca.sheridan.tandelj.passwordstoretandelj.services;

import ca.sheridan.tandelj.passwordstoretandelj.beans.PasswordRecord;
import ca.sheridan.tandelj.passwordstoretandelj.databases.DatabaseAccess;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {
    private final DatabaseAccess databaseAccess;

    public PasswordService(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public List<PasswordRecord> getAllPasswords() {
        return databaseAccess.findAll();  // Fetch all records from DB
    }
}
