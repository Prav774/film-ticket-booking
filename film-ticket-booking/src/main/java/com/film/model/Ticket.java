package com.film.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
    @Column(name = "ticketid")
    private Long ticketId;

    @NotBlank(message = "Movie name is required")
    @Column(name = "moviename", nullable = false, length = 100)
    private String movieName;

    @NotBlank(message = "Show time is required")
    @Column(name = "showtime", nullable = false, length = 50)
    private String showTime;

    @NotBlank(message = "Seat number is required")
    @Column(name = "seatnumber", nullable = false, length = 10)
    private String seatNumber;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    @Column(name = "price", nullable = false)
    private Double price;

    public Ticket() {
    }

    public Ticket(String movieName, String showTime, String seatNumber, Double price) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", movieName='" + movieName + '\'' +
                ", showTime='" + showTime + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", price=" + price +
                '}';
    }
}
