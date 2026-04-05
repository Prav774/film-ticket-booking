package com.film.controller;

import com.film.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeleteTicketController {

    private final TicketService ticketService;

    @Autowired
    public DeleteTicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/delete-ticket/{id}")
    public String deleteTicket(@PathVariable("id") Long id,
                               RedirectAttributes redirectAttributes) {
        ticketService.getTicketById(id).ifPresentOrElse(
            ticket -> {
                ticketService.deleteTicketById(id);
                redirectAttributes.addFlashAttribute("successMessage",
                        "Ticket for '" + ticket.getMovieName() + "' deleted successfully!");
            },
            () -> redirectAttributes.addFlashAttribute("errorMessage",
                        "Ticket not found with ID: " + id)
        );
        return "redirect:/view-tickets";
    }
}
