package com.teamtreehouse.controller;

import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Team;
import com.teamtreehouse.model.Teams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by Mallikarjuna on 9/20/2016.
 */
public class Prompter {
    private LeagueOrganizer mLeagueOrganizer;
    private BufferedReader mReader;
    private Map<Integer, String> mMenu;

    public Prompter(LeagueOrganizer league) {

        mLeagueOrganizer = league;
        mReader = new BufferedReader(new InputStreamReader(System.in));
        mMenu = new TreeMap< >();
        fillMenu();
    }
    /*
    MAIN MENU to League Manager Console Application
    @nMenu : Holds Menu List
     */

    private void fillMenu() {

        mMenu.put(1,"Add Team");
        mMenu.put(2,"Add Player");
        mMenu.put(3,"Remove Player");
        mMenu.put(4,"Height Report");
        mMenu.put(5,"League Report");
        mMenu.put(6,"Roster");
        mMenu.put(7,"Quit");
    }


    /*
    Output  : Display Main Menu
    @mMenu  : Holds Menu Items
    Input   : Receive User Choice from Menu
    @choice : Holds User Input
    Returns @choice to runnable method
    */

    private int promptForAction() throws IOException {

        for (Map.Entry<Integer, String> option : mMenu.entrySet()) {
            System.out.printf("%d) %s %n",
                    option.getKey(),
                    option.getValue());
        }
        System.out.print("\nPlease, choose your action item from Menu: ");
        int choice = Integer.parseInt(mReader.readLine().trim());
        return choice;
    }

    //Output : Display Headers of List of Players

    private void displayPlayerHeader() {

        String header1 = "No";
        String header2 = "First Name";
        String header3 = "Last Name";
        String header4 = "Height";
        String header5 = "Experience";
        String ruler = "--------------------------------------------------------";
        System.out.format("\n%-5s %-15s %-15s %-10s %-5s %n%s%n%n",
                header1, header2,
                header3, header4,
                header5, ruler);
    }

    //Output : Display Headers of List of Teams

    private void displayTeamHeader() {
        String heading1 = "No";
        String heading2 = "Team Name";
        String heading3 = "Coach Name";
        String ruler = "-------------------------------------------------------";
        System.out.format("\n%-5s %-30s %-30s %n%s%n%n",
                heading1, heading2,
                heading3, ruler);

    }

    private void addNewTeam() throws IOException {
        int teams = mLeagueOrganizer.getTeams().getSize();
        int maxTeams = mLeagueOrganizer.getMaxTeams();

        if(teams < maxTeams) {
            System.out.println("Enter the Team Name");
            String teamName = userInput();
            System.out.println("Enter the Coach Name");
            String coachName = userInput();
            mLeagueOrganizer.addTeam(teamName,coachName);
            System.out.printf("%nTeam : %s Created with Coach %s%n",
                    teamName,coachName);
        } else {
            System.out.printf("%nYou have created %d Team,Dont have " +
                    "Sufficent Players to Create " +
                    "Team %n", teams);
            displayTeam();
        }
    }

    private void addPlayerToTeam() throws IOException {

        Team team = promptForTeam();
        if(!team.isFull()) {
            Player player = promptForPlayer(mLeagueOrganizer.getLeaguePlayers().toArray
                    (new Player[mLeagueOrganizer.noOfLeaguePlayers()]));
            mLeagueOrganizer.addPlayer(team, player);
            System.out.printf("%nYou have Added Player: %s %s to Team : %s%n",
                    player.getFirstName(), player.getLastName(),
                    team.getTeamName());
        } else {
            System.out.printf("%n %s Team already consists of Maximum %d Players%n%n",
                    team.getTeamName(),team.getTeamSize());
        }
    }

    private void removePlayerFromTeam() throws IOException {

        Team team = promptForTeam();
        if(!team.isEmpty()) {
            System.out.printf("%nYou can Remove Players from %s%n%n",
                    team.getTeamName());
            Player player = promptForPlayer(team.getTeamPlayers().toArray
                    (new Player[team.getTeamSize()]));
            mLeagueOrganizer.removePlayer(team,player);
            System.out.printf("%nYou have Removed Player: %s %s From Team : %s%n",
                    player.getFirstName(), player.getLastName(),
                    team.getTeamName());

        } else {
            System.out.printf("%nYou have not added Players to %s Team %n%n",
                    team.getTeamName());
        }
    }

    private void generateHeightReport() throws IOException {
        Team team = promptForTeam();
        System.out.printf("%nGenerating %s Team Report%n", team.getTeamName());
        Map<Integer, Integer> heightReport = mLeagueOrganizer.generateTeamHeightReport(team);
        displayheightReport(heightReport);
    }

    private void generateLeagueReport() {
        Map<String, Map<String, Integer>> leagueReport = mLeagueOrganizer.generateLeagueReport();
        System.out.println("\nGenerating League Balance Report\n");
        displayLeagueReport(leagueReport);
    }

    private void printRoster() throws IOException {
        Team team = promptForTeam();
        if (team.getTeamSize() < mLeagueOrganizer.getMaxPlayersinTeam()) {
            System.out.printf("%n %s Team consists of %d Players," +
                            "%nCoach can take Team Roster after Complete " +
                            "Team Creation by League Manager%n%n",
                    team.getTeamName(), team.getTeamSize());
        } else {
            System.out.printf("%n %s Team Roster%n", team.getTeamName());
            displayPlayer(team.getTeamPlayers().toArray
                    (new Player[team.getTeamSize()]));
        }

    }

    /*
       Soccer League Organizer Runnable method
        Holds the Core Implementation of
        Soccer League Organizer Application
 */
    public void run() {

        int choice = 0;
        //int teams = mLeagueOrganizer.getTeams().getSize();
        System.out.println("\nWelcome to Soccer league Organizer Software\n");
        do {
            try {
                if (mLeagueOrganizer.getTeams().getSize() > 0 ) {
                    switch (choice = promptForAction()) {
                        case 1:
                            addNewTeam();
                            break;
                        case 2:
                            addPlayerToTeam();
                            break;
                        case 3:
                            removePlayerFromTeam();
                            break;
                        case 4:
                            generateHeightReport();
                            break;
                        case 5:
                            generateLeagueReport();
                            break;
                        case 6:
                            printRoster();
                            break;
                        case 7:
                            System.out.println("Exiting Application");
                            break;
                    }
                } else {
                    System.out.println("Intially Create Team to Proceed to Other Menu Items");
                    switch (choice = promptForAction()) {
                        case 1:
                            addNewTeam();
                            break;
                        case 7:
                            System.out.println("Exiting Application");
                            break;
                    }
                }
            }catch (IOException ioe) {
                System.out.println("Problem reading Input");
                ioe.printStackTrace();
            }
        } while(!(choice == 7));

    }

    // Prompt user to select Team
    // @ teamchoice : Holds the user Choice of Team
    // Return Selected Team to Runnable Method

    private Team promptForTeam() throws IOException {
        int teamChoice;
        displayTeam();
        do {
            System.out.println("\nSelect Team from above list of Team in League\n");
            teamChoice = userChoice( );
        }while (teamChoice < 1 || teamChoice > mLeagueOrganizer.getTeams().getSize());
        return mLeagueOrganizer.getTeams().getTeams().get(teamChoice -1);
    }

    // Prompt user to select player
    // @ player choice : Holds the user Choice of Player
    // Return Selected Player to Runnable Method

    private Player promptForPlayer(Player[] players) throws IOException {

        int playerChoice;
        System.out.println("\nPLAYERS LIST\n\n");
        displayPlayer(players);
        do {
            System.out.println("\nSelect Players from above list of Players\n");
            playerChoice = userChoice();
        }while (playerChoice < 1 || playerChoice > players.length);
        return players[playerChoice-1];
    }


    /*
    Output  : Display List of Teams
    Team No,Team Name, Team Coach Name
    */
    private void displayTeam( ) {

        int counter = 1;
        //Map<String,String> currentTeams = new HashMap<>();
        //currentTeams = mLeagueOrganizer.currentTeamsInLeague();
        //for (Map.Entry<String,String> team : currentTeams.entrySet()) {
        for(Team team : mLeagueOrganizer.getTeams().getTeams()) {
            displayTeamHeader();
            System.out.format("%n%-5d %-30s %-30s",
                    counter,team.getTeamName(),team.getCoachName());
                    /* counter,team.getkey(),team.getValue()); */
            System.out.printf("%n%s Team Players %n",team.getTeamName());
            displayPlayer(team.getTeamPlayers().toArray(new Player[team.getTeamSize()]));
            counter++;
        }


    }

    /*
    Output : Display List of Players
    Player FirstName,LastName,Height,Experience
    */

    private void displayPlayer(Player[] playersList) {

        int counter = 1;
        displayPlayerHeader();
        for(Player player : playersList) {
            System.out.printf("%n%-5d %-15s %-15s %-10d %-5s %n",
                    counter,
                    player.getFirstName(),
                    player.getLastName(),
                    player.getHeightInInches(),
                    player.PreviousExperience());
            counter++;
        }

    }

    //Output : Display Team Height Report

    private void displayheightReport(Map<Integer, Integer> heightReport) {
        String header1 = "Height";
        String header2 = "Count";
        System.out.format("%n%-10s %-10s%n",
                header1,
                header2);

        for (Map.Entry<Integer, Integer> hieght : heightReport.entrySet()) {
            System.out.format("%-10d %-10d %n",
                    hieght.getKey(),
                    hieght.getValue());
        }

    }

    /*
    Ouput : Display League Balance Report
    @ leagueReport : Holds League report
    @ teamReport : Holds each Team report
    */
    private void displayLeagueReport(Map<String, Map<String, Integer>> leagueReport) {
        String header1 = "Experience Status";
        String header2 = "No of Players";
        for (Map.Entry<String, Map<String, Integer>> leagueReports : leagueReport.entrySet()) {
            System.out.printf("%n%s Report %n%n", leagueReports.getKey());
            System.out.format("%-20s %-20s%n%n", header1, header2);
            Map<String, Integer> teamReports = leagueReports.getValue();
            for (Map.Entry<String, Integer> teamReport : teamReports.entrySet()) {
                System.out.printf("%-20s %-20d%n",
                        teamReport.getKey(),
                        teamReport.getValue());

            }
        }
    }
    /*
    Input : Receive User Choice
    Validate User Input with restricted pattern
    @choice : Holds User Input Choice
    Prompt for Team and Player
    Returns choice to Prompt for Team and Player
    */

    private int userChoice() throws IOException {
        int choice;
        boolean isValid = false;
        String optionAsString = " ";
        while (!isValid) {
            optionAsString = mReader.readLine();
            if (optionAsString.matches("[0-9]+")) {
                isValid = true;
            } else {
                System.out.printf("%s is not Valid%n", optionAsString);
            }
        }
        choice = Integer.parseInt(optionAsString.trim());
        return choice;


    }

    /*
    Input : Receive TeamName and CoachName
    Validate User Input with restricted pattern
    @name : Holds the User Input
    Returns name to Runnable Method
    */

    private String userInput() throws IOException {
        boolean isValid = false;
        String name = " ";
        while (!isValid) {
            name = mReader.readLine();
            if (name.matches("^[a-zA-Z]+\\s?[a-zA-Z]*\\s?[a-zA-Z]*")) {
                isValid = true;
            } else {
                System.out.printf("%s is not a valid Input " +
                        "%nValid Input Template \"fistword\" " +
                        "\"secondword\" \"thirdword\" " +
                        "%nsecondword and thirdword are optional%n" +
                        "Single Space between each word%n" +
                        "Example %nCoach Name : John Craig Dennis%n" +
                        "Team Name : Grand Theft Rondo%n",name);
            }
        }
        return name;
    }

}
