package com.dhansmeier.mycontest.repo;

import com.dhansmeier.mycontest.domain.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TournamentRepository extends JpaRepository<Tournament, UUID> {
}
