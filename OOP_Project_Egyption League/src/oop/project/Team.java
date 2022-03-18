/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.util.ArrayList;

/**
 *
 * @author LEGION R
 */
public class Team {
    private String name;
    public ArrayList<Player> playerList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
         ArrayList<Match> teamMatches = new ArrayList<>();
    public ArrayList<Match> getMatches(ArrayList<Match> list) {
   
        for (Match item: list) {
            if (item.team1.getName().toLowerCase().equals(this.getName().toLowerCase())) {
                teamMatches.add(item);
            }
            else if (item.team2.getName().toLowerCase().equals(this.getName().toLowerCase())) {
                teamMatches.add(item);
            }
        }
        return teamMatches;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
