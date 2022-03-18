/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;


/**
 *
 * @author LEGION R
 */
public class Match {
    private String time;
    private String date;
    public Stadium stadium;
    public Team team1;
    public Team team2;
    public Referee referee;
    
    public Match(String time, String date, Stadium stadium, Team team1,
            Team team2, Referee referee) {
        this.time = time;
        this.date = date;
        this.stadium = stadium;
        this.team1 = team1;
        this.team2 = team2;
        this.referee = referee;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public void setRef(Referee r)
    {
        this.referee = r;
        
    }
    
    public void setStadium(Stadium s)
    {
        this.stadium = s;
        
    }
    
    public void setTeam1(Team t)
    {
        this.team1 = t;
    }   
    
    public void setTeam2(Team t)
    {
        this.team2 = t;
    }   

    @Override
    public String toString() {
        return  "  time&date---> "+ time +" "+date+" teaam1---> "+team1.getName()+"  team2----->   "+team2.getName()+"  stadium------>   "+stadium.getName()+"  refree------>     "+referee.getName();
    }
 
    
}
