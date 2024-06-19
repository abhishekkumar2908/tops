package Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data

@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;

	
    
    
}
