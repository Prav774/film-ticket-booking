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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UpdateTicketController {

    private final TicketService ticketService;

    @Autowired
    public UpdateTicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/edit-ticket/{id}")
    public String showEditTicketForm(@PathVariable("id") Long id,
                                     Model model,
                                     RedirectAttributes redirectAttributes) {
        Optional<Ticket> ticketOptional = ticketService.getTicketById(id);
        if (ticketOptional.isEmpty()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Ticket not found with ID: " + id);
            return "redirect:/view-tickets";
        }
        model.addAttribute("ticket", ticketOptional.get());
        return "update_ticket";
    }

    @PostMapping("/update-ticket")
    public String updateTicket(@Valid @ModelAttribute("ticket") Ticket ticket,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update_ticket";
        }
        ticketService.updateTicket(ticket);
        redirectAttributes.addFlashAttribute("successMessage", "Ticket updated successfully!");
        return "redirect:/view-tickets";
    }
}
