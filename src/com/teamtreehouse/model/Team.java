package com.teamtreehouse.model;

import java.util.*;


public class Team implements Comparator <Team> {
  
    private String mTeamName;
    private String mCoachName;
    private Set<Player> mTeamPlayers;
    private static final int maxPlayersinTeam = 11;

    public Team() {

    }
    /*
    Team Intializes teamName,CaochName and
    allocates to Memory to its Players
    */
    public Team( String team, String coach) {
        mTeamName     = team;
        mCoachName    = coach;
        mTeamPlayers  = new TreeSet<Player>(new Player());
    }


    public String getTeamName() {
    return mTeamName;
  }

    public String getCoachName() {
    return mCoachName;
  }
  
    public Set<Player> getTeamPlayers( ) {
    return mTeamPlayers;
  }

    // is used is testing to check whether team is full
    public boolean isFull() {
        if (mTeamPlayers.size() == maxPlayersinTeam) {
            return true;
        } else {
            return false;
        }
    }

  //Adds Player to Team
    public void addPlayer(Player player) {
        mTeamPlayers.add(player);
    }

    // is used to testing to check whether team is Empty
    public boolean isEmpty() {
        if(mTeamPlayers.size() == 0) {
            return false;
        } else {
            return false;
        }
    }
    //Remove Player from Team
    public void removePlayer(Player player) {
        mTeamPlayers.remove(player);
    }

    //Returns No of Players in Team
    public int getTeamSize() {return mTeamPlayers.size();}

    @Override
    public String toString() {
    return String.format("%n%s team created with Coach  %s%n", mTeamName, mCoachName);
  }

    //Compare method to sort teamName Implementing Comparator Interface
    @Override
    public int compare(Team o1, Team o2) {return o1.mTeamName.compareTo(o2.mTeamName);}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (!mTeamName.equals(team.mTeamName)) return false;
        if (!mCoachName.equals(team.mCoachName)) return false;
        return mTeamPlayers.equals(team.mTeamPlayers);

    }

    @Override
    public int hashCode() {
        int result = mTeamName.hashCode();
        result = 31 * result + mCoachName.hashCode();
        result = 31 * result + mTeamPlayers.hashCode();
        return result;
    }
}
    