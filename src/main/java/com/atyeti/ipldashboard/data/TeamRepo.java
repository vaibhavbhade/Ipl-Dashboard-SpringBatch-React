package com.atyeti.ipldashboard.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team,Long> {

    Team findByTeamName(String teamName);

}
