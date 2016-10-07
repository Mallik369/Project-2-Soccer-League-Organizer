package com.teamtreehouse.model;

import java.io.Serializable;
import java.util.Comparator;

public class Player implements Comparator <Player>, Serializable {


    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private int heightInInches;
    private boolean previousExperience;


    public Player(String firstName, String lastName, int heightInInches, boolean previousExperience) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.heightInInches = heightInInches;
    this.previousExperience = previousExperience;
  }

    public Player() {

    }

    public String getFirstName() {
    return firstName;
  }

    public String getLastName() {
    return lastName;
  }

    public int getHeightInInches() {
    return heightInInches;
  }
  
    public boolean isPreviousExperience() {
    return previousExperience;
  }

    public String PreviousExperience( ) {
        if(previousExperience) {
            return "Experienced";
        } else {
        return "InExperienced";
        }
    }

    @Override
    public int compare(Player o1, Player o2) {

        int lastCmp = o1.lastName.compareTo(o2.lastName);
        return (lastCmp != 0 ? lastCmp : o1.firstName.compareTo(o2.firstName));
    }


    @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (heightInInches != player.heightInInches) return false;
        if (previousExperience != player.previousExperience) return false;
        if (!firstName.equals(player.firstName)) return false;
        return lastName.equals(player.lastName);

     }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + heightInInches;
        result = 31 * result + (previousExperience ? 1 : 0);
        return result;
      }
}
