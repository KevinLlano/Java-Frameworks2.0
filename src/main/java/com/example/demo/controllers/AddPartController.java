package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AddPartController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private PartService partService;

    @GetMapping("/showPartFormForUpdate")
    public String showPartFormForUpdate(@RequestParam("partID") int theId, Model theModel) {
        PartService repo = context.getBean(PartServiceImpl.class);
        OutsourcedPartService outsourcedrepo = context.getBean(OutsourcedPartServiceImpl.class);
        InhousePartService inhouserepo = context.getBean(InhousePartServiceImpl.class);

        boolean inhouse = true;
        List<OutsourcedPart> outsourcedParts = outsourcedrepo.findAll();
        for (OutsourcedPart outsourcedPart : outsourcedParts) {
            if (outsourcedPart.getId() == theId) {
                inhouse = false;
            }
        }

        if (inhouse) {
            InhousePart inhousePart = inhouserepo.findById(theId);
            theModel.addAttribute("inhousepart", inhousePart);
            return "inhousepartform";  // Updated to all lowercase
        } else {
            OutsourcedPart outsourcedPart = outsourcedrepo.findById(theId);
            theModel.addAttribute("outsourcedpart", outsourcedPart);
            return "outsourcedpartform";  // Updated to all lowercase
        }
    }

    @GetMapping("/deletepart")
    public String deletePart(@Valid @RequestParam("partID") int theId, Model theModel) {
        Part part = partService.findById(theId);
        if (part.getProducts().isEmpty()) {
            partService.deleteById(theId);
            return "confirmationdeletepart";
        } else {
            return "negativeerror";
        }
    }

    // Handle saving of both Inhouse and Outsourced parts
    @PostMapping("/savePart")
    public String savePart(@ModelAttribute("inhousepart") InhousePart inhousePart, Model model) {
        String errorMessage = inhousePart.validateInventory();

        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            return "inhousepartform"; // If it's an inhouse part, return inhouse part form
        }

        if (inhousePart.getId() != 0) {  // Check if it's an update
            partService.update(inhousePart);  // calls the update method
        } else {
            partService.save(inhousePart);  // Create a new part

        }

        return "redirect:/mainscreen";
    }

    @PostMapping("/saveOutsourcedPart")
    public String saveOutsourcedPart(@ModelAttribute("outsourcedpart") OutsourcedPart outsourcedPart, Model model) {
        String errorMessage = outsourcedPart.validateInventory();

        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            return "outsourcedpartform";  // If it's an outsourced part, return outsourced part form
        }

        if (outsourcedPart.getId() != 0) {
            partService.update(outsourcedPart);
        } else {
            partService.save(outsourcedPart);
        }

        return "redirect:/mainscreen";
    }
}
