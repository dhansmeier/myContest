package main.java.com.dhansmeier.mycontest.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.OffsetDateTime;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @Column(name = "created_at", insertable = false, updatable = false)
    private OffsetDateTime createdAt;

    protected Tournament() {}

    public Tournament(String name, LocalDate eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public LocalDate getEventDate() { return eventDate; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
}
