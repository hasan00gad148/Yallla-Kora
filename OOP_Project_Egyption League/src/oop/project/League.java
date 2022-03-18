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
public class League {
    private String startDate;
    private String endDate;
    public ArrayList<Match> matchList = new ArrayList<>();
    public ArrayList<Team> teamList = new ArrayList<>();
    public ArrayList<Referee> refList = new ArrayList<>();
    public ArrayList<Stadium> stdList = new ArrayList<>();

    public League() {
        
    }
    
    public League(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
