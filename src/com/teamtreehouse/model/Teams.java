package com.teamtreehouse.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Teams {

    private List<Team> mTeams;

    public Teams ( ) {
        mTeams = new ArrayList<>();
    }

    //returns all teams created in League
    public List<Team> getTeams(){return mTeams;}

    //adds created Team to List of Teams
    public void addTeam(Team newTeam) {mTeams.add(newTeam);}

    // return the no of Teams created in League
    public int getSize() {
   return mTeams.size();
 }

}

   