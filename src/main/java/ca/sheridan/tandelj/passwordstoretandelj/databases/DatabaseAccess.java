package ca.sheridan.tandelj.passwordstoretandelj.databases;

import ca.sheridan.tandelj.passwordstoretandelj.beans.PasswordRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatabaseAccess extends JpaRepository<PasswordRecord, Long> {
    List<PasswordRecord> findByTitleContainingIgnoreCase(String title);
}