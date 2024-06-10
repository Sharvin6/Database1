package com.example.pet_adoption_platform.controller;

import com.example.pet_adoption_platform.model.Staff;
import com.example.pet_adoption_platform.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    // Displays the staff login page.
    @GetMapping("/staff-login")
    public String showLoginPage() {
        return "staff-login";
    }

    // Processes the staff login form submission.
    @PostMapping("/staff-login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {
        // Authenticate staff credentials.
        Staff staff = staffService.authenticate(username, password);
        if (staff != null) {
            // If authentication is successful, redirect to the management page.
            model.addAttribute("staffList", staffService.getAllStaff());
            return "redirect:/staff/management";
        } else {
            // If authentication fails, display an error message and stay on the login page.
            model.addAttribute("error", "Invalid username or password");
            return "staff-login";
        }
    }

    // Displays the staff management page.
    @GetMapping("/staff/management")
    public String showManagementPage() {
        return "staff-management";
    }

    // Displays the list of staff members.
    @GetMapping("/staff/list")
    public String listStaff(Model model) {
        model.addAttribute("staffList", staffService.getAllStaff());
        return "staff-list";
    }

    // Displays the form to create a new staff member.
    @GetMapping("/staff/create")
    public String showCreateStaffForm(Model model) {
        model.addAttribute("staff", new Staff());
        return "create-staff";
    }

    // Processes the submission to create a new staff member.
    @PostMapping("/staff/create")
    public String createStaff(@ModelAttribute("staff") Staff staff, Model model) {
        staffService.saveStaff(staff);
        return "redirect:/staff/list";
    }

    // Displays the list of staff members for editing.
    @GetMapping("/staff/edit")
    public String showEditList(Model model) {
        model.addAttribute("staffList", staffService.getAllStaff());
        return "staff-edit-list";
    }

    // Displays the form to edit a specific staff member.
    @GetMapping("/staff/edit/{id}")
    public String showEditPage(@PathVariable("id") Long id, Model model) {
        Staff staff = staffService.getStaffById(id);
        if (staff != null) {
            model.addAttribute("staff", staff);
            return "staff-edit";
        } else {
            return "redirect:/staff/edit";
        }
    }

    // Processes the submission to edit a specific staff member.
    @PostMapping("/staff/edit/{id}")
    public String editStaff(@PathVariable("id") Long id,
                            @RequestParam("name") String name,
                            @RequestParam("username") String username,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone) {
        Staff staff = staffService.getStaffById(id);
        if (staff != null) {
            // Update staff member details.
            staff.setName(name);
            staff.setUsername(username);
            staff.setEmail(email);
            staff.setPhone(phone);
            staffService.saveStaff(staff);
        }
        return "redirect:/staff/edit";
    }

    // Displays the page to delete a staff member.
    @GetMapping("/staff/delete")
    public String showDeletePage(Model model) {
        model.addAttribute("staffList", staffService.getAllStaff());
        return "staff-delete";
    }

    // Processes the deletion of a specific staff member.
    @PostMapping("/staff/delete/{id}")
    public String deleteStaff(@PathVariable("id") Long id) {
        // Delete the specified staff member.
        staffService.deleteStaffById(id);
        return "redirect:/staff/delete";
    }
}
