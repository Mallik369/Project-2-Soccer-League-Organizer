# Project-2-Soccer-League-Organizer

Soccer League Organizer Application helps League Organizer to Setup League, create Team, Assign Players to Team, print out Roster for each Team.Soocer League Organizer is Java Console Application and it is developed to Apply,Test and Verify Skills Acuiqred during Team Tree House Java Web Development Tech Degree Program.This Application is review by Mentors and Fellow Students

Soccer League Organizer Application is developed considering following User Stories

**1.  As an organizer, I should be presented with a menu item that allows me to create a new team, so that I can build the season.**
                
        Required fields are team name and coach.
        
Soccer League Organizer Needs to Obtain Input From User and Create a New Team

        Team model is created
            Team has both name and coach name fields.
            Players field is using proper collection interface that prevents duplication
            
Methods Implement the User Story Functionality

        private void addNewTeam()
        protected Team addTeam(String teamName, String coachName)
        
**2.  As an organizer, I should be presented with a menu item that allows me to add players to a team, so that I can build fair teams.**

Soccer League Organizer Needs to Add Player to Team from List of Registered Players 

Methods Implement the User Story Functionality

        private void addPlayerToTeam()
        protected void addPlayer(Team team , Player player)
        
**3.  As an organizer, I should be presented with a menu item that allows me to remove players from a team, so that I can attempt to produce more fair teams.**

Soccer League Organizer Needs to Remove Players From Teams

        private void removePlayerFromTeam()
        protected void removePlayer(Team team , Player player)
        
**4.  As an organizer adding or removing a player to a yet to be chosen team, I should be prompted with an alphabetically ordered list of teams to choose from, so that I can quickly locate the team and avoid typos.**

        •	Teams are presented in an alphabetical list.
        •	Choosing the team, actually chooses the correct team.


Soccer League Organizer Needs to Alphabetically ordered list of Teams

        Collections.sort(mTeams.getTeams(), new Team());
        
**5.  As an organizer adding or removing a player to a chosen team, I should be prompted with an alphabetically ordered list of players along with their stats, so that I can quickly locate the player and take action.

Soccer League Organizer Needs to Alphabetically ordered List of Players 

**6.  As an organizer planning teams, I should be able to view a report of a chosen team grouped by height, so that I can determine if teams are fair.**

        •	Shows a count of how many players are that height on each team.

Soocer League Organizer Needs to Compute and display Team Players Height Distribution

        private void generateHeightReport()
        protected Map<Integer,Integer> generateTeamHeightReport(Team team)

**7.  As an organizer who is planning teams, I should be able to see a League Balance Report for all teams in the league showing a total count of experienced players vs. inexperienced players, so I can determine from a high level if the teams are fairly balanced regarding previous experience.**

        •	Report uses a map like solution to properly report experienced vs. inexperienced for each team
        
Soccer League Organizer needs to Compute League Balance Report

        private void generateLeagueReport()
        public Map<String, Map<String, Integer>> generateLeagueReport()
        
**8.  As a coach of a team, I should be able to print out a roster of all the players on my team, so that I can plan appropriately.**

        •	Menu exists and roster creates an alphabetically sorted players list of the team.
      
Soccer League Organizer Needs to Display Team Roster once Team Contains  MaxPlayersInTeam

         private void printRoster()
        
