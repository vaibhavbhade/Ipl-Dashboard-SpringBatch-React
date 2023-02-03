package com.atyeti.ipldashboard.Controller;

import com.atyeti.ipldashboard.MatchRepo;
import com.atyeti.ipldashboard.data.Team;
import com.atyeti.ipldashboard.data.TeamRepo;
import com.atyeti.ipldashboard.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class IplController {

    @Autowired
    MatchRepo matchRepo;

    @Autowired
    TeamRepo teamRepo;

    @GetMapping("/team")
    public Iterable<Team> getAllTeam() {
        return teamRepo.findAll();
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = teamRepo.findByTeamName(teamName);
        team.setMatches(matchRepo.findLatestMatchesbyTeam(teamName,4));

        return team;
    }

    /*@GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return this.matchRepo.getMatchesByTeamBetweenDates(
                teamName,
                startDate,
                endDate
        );
    }*/

}
