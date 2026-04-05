package com.film.controller;

import com.film.model.Ticket;
import com.film.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddTicketController {

    private final TicketService ticketService;

    @Autowired
    public AddTicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/add-ticket")
    public String showAddTicketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "add_ticket";
    }

    @PostMapping("/add-ticket")
    public String addTicket(@Valid @ModelAttribute("ticket") Ticket ticket,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model) {
        if (bindingResult.hasErrors()) {
            return "add_ticket";
        }
        ticketService.saveTicket(ticket);
        redirectAttributes.addFlashAttribute("successMessage", "Ticket added successfully!");
        return "redirect:/view-tickets";
    }
}
