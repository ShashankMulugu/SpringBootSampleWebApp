package com.frankmoley.lil.sbet.landon.roomwebapp.controllers;

import com.frankmoley.lil.sbet.landon.roomwebapp.models.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private static final List<Staff> staff = new ArrayList<>();
    private static final String[] firstNames= {"raju", "shoma", "prasad", "rahul", "shashank"};
    private static final String[] lastNames= {"rao", "reddy", "agarwal", "chaudary", "mulugu"};
    private static final String[] positions = {"Housekeeping", "Front-desk", "Security", "Laundry", "Restaurant"};

    static {
        for (int i = 0; i < 10; i++) {
            UUID uuid = UUID.randomUUID();
            int firstIndex = new Random().nextInt(firstNames.length);
            int lastIndex = new Random().nextInt(lastNames.length);
            int positionsIndex = new Random().nextInt(positions.length);
            staff.add(new Staff(uuid.toString(), firstNames[firstIndex], lastNames[lastIndex], positions[positionsIndex]));
        }
    }

    @GetMapping
    public String getAllStaff(Model model) {
        model.addAttribute("staff", staff);
        return "staff";
    }

}
