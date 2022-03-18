/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ELHSM
 */
public class adminAddFrame extends adminEditFrame implements ActionListener{
    //add panels     
    //add player-------------------------------------
    JButton add_player_button = new JButton("Save The Player");

    JComboBox<String> team_index = new JComboBox();
    JTextField player_name = new JTextField();
    JComboBox<Position> appostion = new JComboBox();
    JTextField player_height = new JTextField();
    JTextField player_weight = new JTextField();

    JLabel team_index_l = new JLabel("Team");
    JLabel player_name_l = new JLabel("Name");
    JLabel postion_l = new JLabel("Postion");
    JLabel player_height_l = new JLabel("Height (cm)");
    JLabel player_weight_l = new JLabel("Weight (kg)");
    JLabel player_valid_inf = new JLabel("");
    //add team------------------------------------------------
    JButton add_team_button = new JButton("Save The Team");
    JTextField team_name = new JTextField();
    JLabel team_name_l = new JLabel("Name");
    JLabel team_valid_inf = new JLabel("");

    //add match--------------------------------------------------------   
    JButton add_match_button = new JButton("Save The Match");

    JTextField date_match = new JTextField();
    JTextField time_match = new JTextField();
    JComboBox<String> referee_i = new JComboBox();
    JComboBox<String> stadium_i = new JComboBox();
    JComboBox<String> team1_i = new JComboBox();
    JComboBox<String> team2_i = new JComboBox();

    JLabel date_match_l = new JLabel("Date");
    JLabel time_match_l = new JLabel("Time");
    JLabel referee_i_l = new JLabel("Referee");
    JLabel stadium_i_l = new JLabel("Stadium");
    JLabel team1_i_l = new JLabel("Team 1");
    JLabel team2_i_l = new JLabel("Team 2");
    JLabel match_valid_inf = new JLabel("");

    //add referee--------------------------------------------------------
    JButton add_referee_button = new JButton("Save The Referee");

    JTextField referee_name = new JTextField();
    JTextField referee_height = new JTextField();
    JTextField referee_weight = new JTextField();

    JLabel referee_name_l = new JLabel("Name");
    JLabel referee_height_l = new JLabel("height(cm)");
    JLabel referee_weight_l = new JLabel("weight(kg)");
    JLabel referee_valid_inf = new JLabel("");

    //add stadium------------------------------------------------------------
    JButton add_staduim_button = new JButton("Save The Stadium");

    JTextField staduim_name = new JTextField();
    JTextField staduim_capsity = new JTextField();
    JTextField staduim_location = new JTextField();

    JLabel staduim_name_l = new JLabel("Name ");
    JLabel staduim_capsity_l = new JLabel("Seat Capsity");
    JLabel staduim_location_l = new JLabel("Location");
    JLabel staduim_valid_inf = new JLabel("");
    
    public adminAddFrame(){
        super();
        //add  Player panel---------------------------------------------------
        addPlayerp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        addPlayerp.setLayout(null);
        addPlayerp.setBackground(new Color(108, 187, 240));
        addPlayerp.setVisible(false);
        // team index combo box
        addPlayerp.add(team_index);
        team_index.setBounds(800, 130, 300, 80);
        team_index.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            this.team_index.addItem(this.admin.league.teamList.get(i).getName());
        }
        // team index label 
        addPlayerp.add(team_index_l);
        team_index_l.setBounds(675, 130, 100, 80);
        team_index_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addPlayerp.add(player_name);
        player_name.setBounds(250, 75, 300, 80);
        player_name.setFont(new Font("atilic", Font.PLAIN, 25));

        addPlayerp.add(player_name_l);
        player_name_l.setBounds(50, 75, 200, 80);
        player_name_l.setFont(new Font("atilic", Font.PLAIN, 30));
        //
        addPlayerp.add(appostion);
        appostion.setBounds(800, 240, 300, 80);
        appostion.setFont(new Font("atilic", Font.PLAIN, 25));
        appostion.addItem(Position.AMF);
        appostion.addItem(Position.CB);
        appostion.addItem(Position.CMF);
        appostion.addItem(Position.DMF);
        appostion.addItem(Position.FC);
        appostion.addItem(Position.GK);
        appostion.addItem(Position.LB);
        appostion.addItem(Position.LW);
        appostion.addItem(Position.RB);
        appostion.addItem(Position.RW);
        appostion.addItem(Position.SS);

        addPlayerp.add(postion_l);
        postion_l.setBounds(675, 240, 100, 80);
        postion_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addPlayerp.add(player_height);
        player_height.setBounds(250, 185, 300, 80);
        player_height.setFont(new Font("atilic", Font.PLAIN, 25));

        addPlayerp.add(player_height_l);
        player_height_l.setBounds(50, 185, 200, 80);
        player_height_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addPlayerp.add(player_weight);
        player_weight.setBounds(250, 295, 300, 80);
        player_weight.setFont(new Font("atilic", Font.PLAIN, 25));

        addPlayerp.add(player_weight_l);
        player_weight_l.setBounds(50, 295, 200, 80);
        player_weight_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addPlayerp.add(add_player_button);
        add_player_button.setBounds(450, 450, 300, 50);
        add_player_button.setForeground(Color.BLUE);
        add_player_button.setFont(new Font("SHRIF", 0, 32));
        add_player_button.addActionListener(this);

        addPlayerp.add(player_valid_inf);
        player_valid_inf.setBounds(400, 500, 400, 50);
        player_valid_inf.setForeground(Color.RED);
        player_valid_inf.setFont(new Font("SHRIF", 0, 32));

        AisPlayer.addActionListener(this);

        //add Team panal------------------------------------------
        addTeamp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        addTeamp.setBackground(new Color(108, 187, 240));
        addTeamp.setLayout(null);
        addTeamp.setVisible(false);

        addTeamp.add(team_name);
        team_name.setBounds(470, 185, 400, 80);
        team_name.setFont(new Font("atilic", Font.PLAIN, 25));

        addTeamp.add(team_name_l);
        team_name_l.setBounds(335, 185, 100, 80);
        team_name_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addTeamp.add(add_team_button);
        add_team_button.setBounds(450, 450, 300, 50);
        add_team_button.setForeground(Color.BLUE);
        add_team_button.setFont(new Font("SHRIF", 0, 32));
        add_team_button.addActionListener(this);

        addTeamp.add(team_valid_inf);
        team_valid_inf.setBounds(400, 500, 400, 50);
        team_valid_inf.setForeground(Color.RED);
        team_valid_inf.setFont(new Font("SHRIF", 0, 32));

        AisTeam.addActionListener(this);

        //addMatch panel-------------------------------------
        addMatchp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        addMatchp.setBackground(new Color(108, 187, 240));
        addMatchp.setLayout(null);
        addMatchp.setVisible(false);

        addMatchp.add(date_match);
        date_match.setBounds(250, 295, 300, 80);
        date_match.setFont(new Font("atilic", Font.PLAIN, 25));

        addMatchp.add(date_match_l);
        date_match_l.setBounds(50, 295, 200, 80);
        date_match_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addMatchp.add(time_match);
        time_match.setBounds(850, 295, 300, 80);
        time_match.setFont(new Font("atilic", Font.PLAIN, 25));

        addMatchp.add(time_match_l);
        time_match_l.setBounds(650, 295, 200, 80);
        time_match_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addMatchp.add(referee_i);
        referee_i.setBounds(250, 75, 300, 80);
        referee_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.refList.size(); i++) {
            this.referee_i.addItem(this.admin.league.refList.get(i).getName());
        }

        addMatchp.add(referee_i_l);
        referee_i_l.setBounds(50, 75, 200, 80);
        referee_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addMatchp.add(stadium_i);
        stadium_i.setBounds(250, 185, 300, 80);
        stadium_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.stdList.size(); i++) {
            this.stadium_i.addItem(this.admin.league.stdList.get(i).getName());
        }

        addMatchp.add(stadium_i_l);
        stadium_i_l.setBounds(50, 185, 200, 80);
        stadium_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addMatchp.add(team1_i);
        team1_i.setBounds(850, 75, 300, 80);
        team1_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            this.team1_i.addItem(this.admin.league.teamList.get(i).getName());
        }

        addMatchp.add(team1_i_l);
        team1_i_l.setBounds(650, 75, 200, 80);
        team1_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addMatchp.add(team2_i);
        team2_i.setBounds(850, 185, 300, 80);
        team2_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            this.team2_i.addItem(this.admin.league.teamList.get(i).getName());
        }

        addMatchp.add(team2_i_l);
        team2_i_l.setBounds(650, 185, 200, 80);
        team2_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addMatchp.add(add_match_button);
        add_match_button.setBounds(450, 450, 300, 50);
        add_match_button.setForeground(Color.BLUE);
        add_match_button.setFont(new Font("SHRIF", 0, 32));
        add_match_button.addActionListener(this);

        addMatchp.add(match_valid_inf);
        match_valid_inf.setBounds(400, 500, 400, 50);
        match_valid_inf.setForeground(Color.RED);
        match_valid_inf.setFont(new Font("SHRIF", 0, 32));

        AisMatch.addActionListener(this);

        //addReferee  panel---------------------------------
        addRefereep.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        addRefereep.setBackground(new Color(108, 187, 240));
        addRefereep.setLayout(null);
        addRefereep.setVisible(false);

        addRefereep.add(referee_name);
        referee_name.setBounds(525, 75, 400, 80);
        referee_name.setFont(new Font("atilic", Font.PLAIN, 25));

        addRefereep.add(referee_name_l);
        referee_name_l.setBounds(275, 75, 250, 80);
        referee_name_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addRefereep.add(referee_height);
        referee_height.setBounds(525, 185, 400, 80);
        referee_height.setFont(new Font("atilic", Font.PLAIN, 25));

        addRefereep.add(referee_height_l);
        referee_height_l.setBounds(275, 185, 250, 80);
        referee_height_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addRefereep.add(referee_weight);
        referee_weight.setBounds(525, 295, 400, 80);
        referee_weight.setFont(new Font("atilic", Font.PLAIN, 25));

        addRefereep.add(referee_weight_l);
        referee_weight_l.setBounds(275, 295, 250, 80);
        referee_weight_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addRefereep.add(add_referee_button);
        add_referee_button.setBounds(450, 450, 300, 50);
        add_referee_button.setForeground(Color.BLUE);
        add_referee_button.setFont(new Font("SHRIF", 0, 32));
        add_referee_button.addActionListener(this);

        addRefereep.add(referee_valid_inf);
        referee_valid_inf.setBounds(400, 500, 400, 50);
        referee_valid_inf.setForeground(Color.RED);
        referee_valid_inf.setFont(new Font("SHRIF", 0, 32));

        AisReferee.addActionListener(this);

        //addStadiuom  panel     
        addStadiump.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        addStadiump.setBackground(new Color(108, 187, 240));
        addStadiump.setLayout(null);
        addStadiump.setVisible(false);

        addStadiump.add(staduim_name);
        staduim_name.setBounds(525, 75, 400, 80);
        staduim_name.setFont(new Font("atilic", Font.PLAIN, 25));

        addStadiump.add(staduim_name_l);
        staduim_name_l.setBounds(275, 75, 250, 80);
        staduim_name_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addStadiump.add(staduim_capsity);
        staduim_capsity.setBounds(525, 185, 400, 80);
        staduim_capsity.setFont(new Font("atilic", Font.PLAIN, 25));

        addStadiump.add(staduim_capsity_l);
        staduim_capsity_l.setBounds(275, 185, 250, 80);
        staduim_capsity_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addStadiump.add(staduim_location);
        staduim_location.setBounds(525, 295, 400, 80);
        staduim_location.setFont(new Font("atilic", Font.PLAIN, 25));

        addStadiump.add(staduim_location_l);
        staduim_location_l.setBounds(275, 295, 250, 80);
        staduim_location_l.setFont(new Font("atilic", Font.PLAIN, 30));

        addStadiump.add(add_staduim_button);
        add_staduim_button.setBounds(450, 450, 300, 50);
        add_staduim_button.setForeground(Color.BLUE);
        add_staduim_button.setFont(new Font("SHRIF", 0, 32));
        add_staduim_button.addActionListener(this);

        addStadiump.add(staduim_valid_inf);
        staduim_valid_inf.setBounds(400, 500, 400, 50);
        staduim_valid_inf.setForeground(Color.RED);
        staduim_valid_inf.setFont(new Font("SHRIF", 0, 32));

        AisStadium.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        //add panels actions-------------------------------------------------------- 
        if (AisPlayer.isSelected()) {
            addPlayerp.setVisible(true);
            addTeamp.setVisible(false);
            addMatchp.setVisible(false);
            addStadiump.setVisible(false);
            addRefereep.setVisible(false);

        } else if (AisTeam.isSelected()) {
            addPlayerp.setVisible(false);
            addTeamp.setVisible(true);
            addMatchp.setVisible(false);
            addStadiump.setVisible(false);
            addRefereep.setVisible(false);

        } else if (AisMatch.isSelected()) {

            addPlayerp.setVisible(false);
            addTeamp.setVisible(false);
            addMatchp.setVisible(true);
            addStadiump.setVisible(false);
            addRefereep.setVisible(false);

        } else if (AisReferee.isSelected()) {

            addPlayerp.setVisible(false);
            addTeamp.setVisible(false);
            addMatchp.setVisible(false);
            addStadiump.setVisible(false);
            addRefereep.setVisible(true);

        } else if (AisStadium.isSelected()) {

            addPlayerp.setVisible(false);
            addTeamp.setVisible(false);
            addMatchp.setVisible(false);
            addStadiump.setVisible(true);
            addRefereep.setVisible(false);

        }
    }

    
}
    
