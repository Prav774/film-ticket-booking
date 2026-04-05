package com.film.controller;

import com.film.model.Ticket;
import com.film.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ViewTicketController {

    private final TicketService ticketService;

    @Autowired
    public ViewTicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/view-tickets")
    public String viewAllTickets(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);
        model.addAttribute("totalTickets", tickets.size());
        return "view_tickets";
    }

    @GetMapping("/search-tickets")
    public String searchTickets(@RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
                                Model model) {
        List<Ticket> tickets = ticketService.searchTickets(keyword);
        model.addAttribute("tickets", tickets);
        model.addAttribute("keyword", keyword);
        model.addAttribute("totalTickets", tickets.size());
        return "view_tickets";
    }
}
