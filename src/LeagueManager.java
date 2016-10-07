import com.teamtreehouse.controller.Prompter;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Teams;
import com.teamtreehouse.controller.LeagueOrganizer;

public class LeagueManager {

  public static void main(String[] args) {
      // load methods intializes the finalized registered players list
      Player[] players = Players.load();
      //@ leaague is application controller is respond user actions
      LeagueOrganizer league = new LeagueOrganizer(players);
      Prompter prompter = new Prompter(league);
      prompter.run();

  }

}
