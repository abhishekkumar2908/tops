package Repo;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
