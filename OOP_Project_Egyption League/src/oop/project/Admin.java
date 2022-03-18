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
public class Admin {

    private String username;
    private String password;

    League league = new League();

    public Admin(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public Admin() {
        password = "0";
        username = "0";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

// ADD--------------------------------------------
    //ADD Team_________________________________________________________________________________________
    public void ADD(String team_name) {
        Team tt = new Team(team_name);

        league.teamList.add(tt);
    }

    //Add Player___________________________________________________________________________________
    public void ADD(int team_index, String player_name, Position postion, float player_height, float player_weight) {
        Player player_ = new Player(player_name, player_height, player_weight, postion);

        league.teamList.get(team_index).playerList.add(player_);
    }

    //Add Match__________________________________________________________________________________
    public void ADD(String time_match, String date_match, int referee_i, int stadium_i, int team_1_i, int team_2_i) {
        Referee ref = league.refList.get(referee_i);

        Stadium std = league.stdList.get(stadium_i);

        Team team1 = league.teamList.get(team_1_i);

        Team team2 = league.teamList.get(team_2_i);

        Match m = new Match(time_match, date_match, std, team1, team2, ref);

        league.matchList.add(m);
    }

    //Add Stadium_____________________________________________________________
    public void ADD(int seat_capacity, String location, String stadium_name) {
        Stadium s = new Stadium(stadium_name, location, seat_capacity);

        league.stdList.add(s);
    }

    //Add Referee________________________________________________________________________
    public void ADD(String referee_name, float referee_height, float referee_weight) {
        Referee referee = new Referee(referee_name, referee_height, referee_weight);

        league.refList.add(referee);
    }

//edit methods-----------------------------------------
    //edit team________________________________________________________________________
    public void EDIT(int index_team, String team_name) {
        league.teamList.get(index_team).setName(team_name);
    
    }

    //edit player_________________________________________________________________________
    public void EDIT(int index_player, int index_team, String player_name, Position postion, float player_height, float player_weight) {
        league.teamList.get(index_team).playerList.get(index_player).setHeight(player_height);
        league.teamList.get(index_team).playerList.get(index_player).setName(player_name);
        league.teamList.get(index_team).playerList.get(index_player).position = postion;
        league.teamList.get(index_team).playerList.get(index_player).setWeight(player_weight);
    }

    //edit match________________________________________________________________________________--
    public void EDIT(int match_index, String time_match, String date_match, int referee_i, int stadium_i, int team_1_i, int team_2_i) {
        league.matchList.get(match_index).setDate(date_match);

        league.matchList.get(match_index).setTime(time_match);

        league.matchList.get(match_index).setRef(league.refList.get(referee_i));

        league.matchList.get(match_index).setStadium(league.stdList.get(stadium_i));

        league.matchList.get(match_index).setTeam1(league.teamList.get(team_1_i));

        league.matchList.get(match_index).setTeam2(league.teamList.get(team_2_i));
    }

    //edit stadium___________________________________________________________________________
    public void EDIT(int stadium_index, int seat_capacity, String location, String stadium_name) {
        league.stdList.get(stadium_index).setSeating(seat_capacity);
        league.stdList.get(stadium_index).setLocation(location);
        league.stdList.get(stadium_index).setName(stadium_name);
    }

    //edit referee__________________________________________________________________
    public void EDIT(int referee_index, float referee_weight, String referee_name, float referee_height) {
        league.refList.get(referee_index).setHeight(referee_height);
        league.refList.get(referee_index).setName(referee_name);
        league.refList.get(referee_index).setWeight(referee_weight);
    }

//remove methods--------------------------------------------------
    //remove team______________________________________________________
    public void removeTeam(int index_team) {
        league.teamList.remove(index_team);
    }

    // remove player__________________________________________________________________  
    public void removePlayer(int team_index, int index_player) {
        league.teamList.get(team_index).playerList.remove(index_player);
    }

    // remove match __________________________________________________________________ 
    public void removeMatch(int index_match) {
        league.matchList.remove(index_match);
    }

    // remove stadium__________________________________________________________________ 
    public void removeStadium(int stadium_index) {
        league.stdList.remove(stadium_index);
    }

    // remve Referee __________________________________________________________________ 
    public void removeReferee(int referee_index) {
        league.refList.remove(referee_index);
    }
    
//saved data----------------------------------------------------------------
    public void intial0_data0() {

        //    teams=------
        ADD("Al Ahly");
        ADD("Al Zamalek");
        ADD("Al Esmaily");
        ADD("Al Moqaoliuon El Arab");

        //    players=-----
        ADD(0, "mohamed hami", Position.GK, 175, 75);
        ADD(0, "deradi nero", Position.AMF, 176, 74);
        ADD(0, "vdera nawer", Position.CMF, 155, 81);
        ADD(0, "nndasw mrhg", Position.DMF, 160, 71);
        ADD(0, "khalid mohamed", Position.LW, 164, 68);
        ADD(0, "jhht cdff", Position.LB, 173, 69);
        ADD(0, "fbdf tty", Position.CB, 178, 84);
        ADD(0, "kil gff", Position.RW, 180, 81);
        ADD(0, "otuj gsd", Position.SS, 156, 85);
        ADD(0, "hrgf dgfgf", Position.RB, 190, 74);
        ADD(0, "hassan balbola", Position.FC, 175, 72);
        ADD(1, "fgfh fgg", Position.GK, 173, 72);
        ADD(1, "kkkjlg fgfbg", Position.AMF, 185, 78);
        ADD(1, "fbg gjy", Position.CMF, 173, 76);
        ADD(1, "hjtk dfd", Position.DMF, 174, 74);
        ADD(1, "ykujmutj fbfb", Position.LW, 184, 75);
        ADD(1, "uiujuj ffvfv", Position.LB, 164, 81);
        ADD(1, "oikuik fvfv", Position.CB, 185, 73);
        ADD(1, "ioili fvfvf", Position.RW, 170, 71);
        ADD(1, "iuku sdv", Position.SS, 174, 85);
        ADD(1, "0p0 ;jkl", Position.RB, 184, 82);
        ADD(1, "ibrahim", Position.FC, 172, 75);
        ADD(2, "bfgfdg hkjhnhgh", Position.GK, 172, 73);
        ADD(2, "uili eht", Position.AMF, 176, 75);
        ADD(2, "hg dcd", Position.CMF, 173, 71);
        ADD(2, "kip fbfrname", Position.DMF, 184, 86);
        ADD(2, "ukjm ffb", Position.LW, 190, 74);
        ADD(2, "bgg fgfbfb", Position.LB, 165, 85);
        ADD(2, "kli ggfb", Position.CB, 174, 76);
        ADD(2, "il sdvsd", Position.RW, 172, 75);
        ADD(2, "ill bfb", Position.SS, 178, 74);
        ADD(2, "ddvdf gmh", Position.RB, 179, 73);
        ADD(2, "hlkasa sfafzc", Position.FC, 185, 82);
        ADD(3, "iopk sfbfb", Position.GK, 169, 82);
        ADD(3, "ukk fgfb", Position.AMF, 185, 71);
        ADD(3, "ol,jk dvfsbv", Position.CMF, 157, 76);
        ADD(3, "fhfd jhj", Position.DMF, 184, 71);
        ADD(3, "ilkjmj sfbb", Position.LW, 169, 85);
        ADD(3, "ilikjk gbfdbg", Position.LB, 175, 75);
        ADD(3, "olklk gbgbn", Position.CB, 184, 93);
        ADD(3, "jkjm bgngfn", Position.RW, 185, 95);
        ADD(3, "ghmhm dfgbgn", Position.SS, 175, 85);
        ADD(3, "kjjghgh fbfbbb", Position.RB, 195, 78);
        ADD(3, "vasse fgdd", Position.FC, 176, 80);

        // Referees=-----------
        ADD("Elhassan ELmatarwy", 176, 74);
        ADD("Mohamwd Mostafa", 172, 79);
        ADD("Ahmed Samer", 169, 72);
        ADD("Eslam shabban", 185, 76);
        ADD("Eslam Salem", 190, 85);
        ADD("Elhassan Gad", 174, 75);

        //  Stadiums=-------------
        ADD(50000, "Cairo", "Borg El Arab Stadium");
        ADD(70000, "Suez", "Suez Stadium");
        ADD(40000, "Port Said", "Port Said Stadium");
        ADD(100000, "Giza", "Tersana Stadium");

        // matches=---------------
        //  add("17:20","20/2/2021",index refree,index staduim, t1 ,t2);
        ADD("09:20", "09/02/2021", 0, 0, 0, 3);
        ADD("06:40", "11/02/2021", 1, 1, 0, 1);
        ADD("10:25", "15/02/2021", 2, 2, 1, 3);
        ADD("05:50", "18/02/2021", 3, 3, 1, 2);
        ADD("08:15", "23/02/2021", 4, 2, 2, 0);
        ADD("10:00", "28/02/2021", 5, 1, 3, 2);

    }

}
