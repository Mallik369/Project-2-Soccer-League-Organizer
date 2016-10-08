package com.teamtreehouse.controller;

import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Team;
import com.teamtreehouse.model.Teams;
import java.io.IOException;
import java.util.*;

public class LeagueOrganizer {

    private Player[] mPlayers;
    private Teams mTeams ;
    private Prompter mPrompter;
    private Set<Player> mleaguePlayers;
    private static final int maxPlayersinTeam = 11;

    public LeagueOrganizer(Player[] players) {
        mPlayers  = players;
        mTeams    = new Teams();
        mleaguePlayers = new TreeSet< >(new Player());
        fillLeaguePlayersSet();
    }

    protected int getMaxPlayersinTeam() {
        return maxPlayersinTeam;
    }

    private void fillLeaguePlayersSet() { Collections.addAll(mleaguePlayers, mPlayers);
    }

    protected Set<Player> getLeaguePlayers() {
        return mleaguePlayers;
    }

    protected int noOfLeaguePlayers( ) {
        return mleaguePlayers.size();
    }

    protected Teams getTeams() {
        return mTeams;
    }

    /*
    protected Map<String,String> currentTeamsInLeague( ) {
        Map<String,String> leagueTeams = new HashMap<>();
        for(Team team: mTeams.getTeams()) {
            leagueTeams.put(team.getTeamName(),team.getCoachName())
        }
        return leagueTeams;
    }
    */

    protected int getMaxTeams( ) {
        int maxTeams = mPlayers.length/ maxPlayersinTeam;
        return maxTeams;
    }

    protected void addTeam(String teamName, String coachName) throws IOException {
        Team newTeam = new Team(teamName, coachName);
        mTeams.addTeam(newTeam);
        Collections.sort(mTeams.getTeams(), new Team());
    }

    protected void addPlayer(Team team , Player player) throws IOException {
        team.addPlayer(player);
        mleaguePlayers.remove(player);
    }

    protected void removePlayer(Team team , Player player) throws IOException {
        team.removePlayer(player);
        mleaguePlayers.add(player);
    }

    /*
     Computes Height Report of Players of Team Selected by User
    @ heightReport : Holds height Report of Team
    Returns Team Players Height Report to Runnable
    */
    protected Map<Integer,Integer> generateTeamHeightReport(Team team) {

        Map<Integer,Integer> heightReport = new TreeMap<>();
        for(Player player : team.getTeamPlayers() ) {
            Integer count = heightReport.get(player.getHeightInInches());
            if (count == null ) {
                count = 0;
            }
            count++;
            heightReport.put(player.getHeightInInches(), count);
        }
        return heightReport;
    }
    /*
    Computes League Balance Report of Team
    @ leagueReportFinal : Holds LeagueReport of All Teams
    @ leagueReport : Holds LeagueReport of Eeach Team
    Returns League Balance Report to Runnable
    */

    public Map<String, Map<String, Integer>> generateLeagueReport() {

        Map<String, Map<String,Integer>> leagueReportFinal = new TreeMap<>();
        for (Team team : mTeams.getTeams()) {
            Map<String,Integer> leagueReport = new TreeMap<>();
            for (Player player : team.getTeamPlayers()) {
                Integer count = leagueReport.get(player.PreviousExperience());
                if (count == null) {
                    count = 0;
                }
                count++;
                leagueReport.put(player.PreviousExperience(),count);
            }
            leagueReportFinal.put(team.getTeamName(),leagueReport);
        }
        return leagueReportFinal;
    }
}






