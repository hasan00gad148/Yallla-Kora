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
public class Referee extends Person {

    public Referee(String name, float height, float weight) {
        super(name, height, weight);
    }
    ArrayList<Match> refMatches = new ArrayList<>();

    public ArrayList<Match> getMacthes(ArrayList<Match> list) {

        for (Match item : list) {
            if (item.referee.getName().toLowerCase().equals(this.getName().toLowerCase())) {
                refMatches.add(item);
            }
        }
        return refMatches;
    }

    @Override
    public String toString() {
        return getName() + " " + getHeight() + " " + getWeight();
        
    }
}
