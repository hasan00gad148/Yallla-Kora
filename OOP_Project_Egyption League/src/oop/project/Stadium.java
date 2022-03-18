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
public class Stadium {
    private String name;
    private String location;
    private int seating;
    
    public Stadium(String name, String location, int seating) {
        this.name = name;
        this.location = location;
        this.seating = seating;
    }
    
    public ArrayList<Match> getMatches(ArrayList<Match> list) {
        ArrayList<Match> stdMatches = new ArrayList<>();
        for (Match item: list) {
            if (item.stadium.getName().toLowerCase().equals(this.getName().toLowerCase())) {
                stdMatches.add(item);
            }
        }
        return stdMatches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    @Override
    public String toString() {
        return name +" "+location+" "+seating;
    }
    
    
}
