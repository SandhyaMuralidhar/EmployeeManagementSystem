package com.example.EmployeeManagementSystem.Controller;

import com.example.EmployeeManagementSystem.pojo.ConfirmationForm;
import com.example.EmployeeManagementSystem.pojo.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    // display the html page
    @GetMapping("/")
    public String getIndex(Model model) {
        List<Employee> employeeList = employeeRepo.findAll();
        model.addAttribute("employees", employeeList);
        model.addAttribute("employee", new Employee());
        model.addAttribute("confirmationForm", new ConfirmationForm());
        return "index";
    }

    // Insert employee data
    @PostMapping("/create")
    public String newEmployee(Employee employee, Model model) {
        model.addAttribute("employee", new Employee());

        // creating dynamic Employee ID
        Random random = new Random();
        long randomNumber = 1000 + random.nextInt(9000);
        String empId = "EMP";
        empId = empId + randomNumber;
        employee.setId(empId);

        // save the employee
        employeeRepo.save(employee);

        return "redirect:/";
    }

    // update the existing employee
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("employee", new Employee());
        Optional<Employee> existingEmployee = employeeRepo.findById(employee.getId());

        // checking employee exist or not
        if (existingEmployee.isPresent()) {
            employeeRepo.save(employee);
        } else {
            model.addAttribute("errorMessage", "Employee with ID " + employee.getId() + " not found.");
        }
        return "redirect:/";
    }

    // delete an employee by id
    @PostMapping("/remove")
    public String removeEmployee(Employee employee, Model model) {
        model.addAttribute("employee", new Employee());
        Optional<Employee> existingEmployee = employeeRepo.findById(employee.getId());
        if (existingEmployee.isPresent()) {
            employeeRepo.deleteById(employee.getId());
        }
        return "redirect:/";
    }

    // delete all employees data by confromation
    @PostMapping("/remove/all")
    public String removeAll(@ModelAttribute ConfirmationForm confirmationForm, Model model) {
        String confirmation = confirmationForm.getConfirmation();
        if ("Yes".equalsIgnoreCase(confirmation)) {
            employeeRepo.deleteAll();
        } else {
            return "redirect:/";
        }
        return "redirect:/";
    }


}
