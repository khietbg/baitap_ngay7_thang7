package bt.n7t7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    public EmployeeService service = new EmployeeService();


    @GetMapping("/api/employee")
    public ResponseEntity<?> findAll() {
        List<Employee> employeeList = service.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    @GetMapping("/api/employee/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Employee employee = service.findById(id);
        if (employee==null){
            return new ResponseEntity<>("id not found, please try again!",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/api/employee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
        boolean checkEmail = service.checkEmail(employee.getEmail());
        if (checkEmail) {
            return new ResponseEntity<>("email existed, please try again! ", HttpStatus.FAILED_DEPENDENCY);
        }
        service.save(employee);
        return new ResponseEntity<>("create success fully!",HttpStatus.OK);
    }

    @PutMapping("/api/employee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        boolean checkEmail = service.checkEmailUpdate(employee.getEmail(), employee.getId());
        if (checkEmail) {
            return new ResponseEntity<>("email existed, please try again! ", HttpStatus.FAILED_DEPENDENCY);
        }
        service.save(employee);
        return new ResponseEntity<>("update success fully!",HttpStatus.OK);
    }

    @DeleteMapping("/api/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
        boolean check = service.deleteById(id);
        if (check) {
            return new ResponseEntity<>("delete success fully!",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("id not found, please try again! ", HttpStatus.NOT_FOUND);
        }
    }

}
