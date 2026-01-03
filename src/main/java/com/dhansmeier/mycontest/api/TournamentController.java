package com.dhansmeier.mycontest.api;

import com.dhansmeier.mycontest.domain.Tournament;
import com.dhansmeier.mycontest.repo.TournamentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentRepository repo;

    public TournamentController(TournamentRepository repo) {
        this.repo = repo;
    }

    public record CreateTournamentRequest(
            @NotBlank String name,
            LocalDate eventDate
    ) {}

    public record TournamentResponse(
            UUID id,
            String name,
            LocalDate eventDate,
            OffsetDateTime createdAt
    ) {}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TournamentResponse create(@Valid @RequestBody CreateTournamentRequest req) {
        Tournament saved = repo.save(new Tournament(req.name(), req.eventDate()));
        return new TournamentResponse(saved.getId(), saved.getName(), saved.getEventDate(), saved.getCreatedAt());
    }

    @GetMapping("/{id}")
    public TournamentResponse get(@PathVariable UUID id) {
        Tournament t = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found")
        );
        return new TournamentResponse(t.getId(), t.getName(), t.getEventDate(), t.getCreatedAt());
    }
}
