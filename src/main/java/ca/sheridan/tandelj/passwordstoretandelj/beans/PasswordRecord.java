package ca.sheridan.tandelj.passwordstoretandelj.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PasswordRecord {
    @Id
    private Long id;
    private String title;
    private String username;
    private String password;
    private String url;
    private String email;
    private String notes;
}
