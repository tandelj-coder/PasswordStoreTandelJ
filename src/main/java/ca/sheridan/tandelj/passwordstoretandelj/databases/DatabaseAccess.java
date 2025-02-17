package ca.sheridan.tandelj.passwordstoretandelj.databases;

import ca.sheridan.tandelj.passwordstoretandelj.beans.PasswordRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DatabaseAccess extends JpaRepository<PasswordRecord, Long> {
    List<PasswordRecord> findByTitleContainingIgnoreCase(String title);
}