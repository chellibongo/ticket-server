package com.ticketserver.ticketserver;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue
    private int ticketID;

    @Column(name = "user_id")
    private int userID;

    @Column(name = "content", nullable = false)
    private String content;

    public int getTicketID() {
        return this.ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
