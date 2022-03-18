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
public class adminEditFrame extends adminDeleteFrame implements ActionListener {

    //edit Paneles---------------------------------
    //Edit Player Panel  components------------
    JButton editButton1 = new JButton("Edit The Player");

    JComboBox<String> editPlayer_t_i = new JComboBox();
    JTextField editPlayer_i = new JTextField();
    JTextField editPlayer_n = new JTextField();
    JComboBox<Position> editPlayer_pos = new JComboBox();
    JTextField editPlayer_w = new JTextField();
    JTextField editPlayer_h = new JTextField();

    JLabel editPlayer_t_i_l = new JLabel("Team");
    JLabel editPlayer_i_l = new JLabel("Player Index");
    JLabel editPlayer_n_l = new JLabel("Name");
    JLabel editPlayer_pos_l = new JLabel("Position");
    JLabel editPlayer_w_l = new JLabel("Weight(cm)");
    JLabel editPlayer_h_l = new JLabel("Height(kg)");
    JLabel player_edit_valid_inf = new JLabel("");

    //Edit Team Panel  components------------
    JButton editButton2 = new JButton("Edit The Team");

    JComboBox<String> editTeam_i = new JComboBox();
    JTextField editTeam_n = new JTextField();

    JLabel editTeam_i_l = new JLabel("Team");
    JLabel editTeam_n_l = new JLabel("Name");
    JLabel team_edit_valid_inf = new JLabel("");

    //Edit Match Panel  components------------
    JButton editButton3 = new JButton("Edit The Match");

    JComboBox<String> editMatch_i = new JComboBox();
    JTextField editMatch_d = new JTextField();
    JTextField editMatch_t = new JTextField();
    JComboBox<String> editMatch_r_i = new JComboBox();
    JComboBox<String> editMatch_s_i = new JComboBox();
    JComboBox<String> editMatch_t1_i = new JComboBox();
    JComboBox<String> editMatch_t2_i = new JComboBox();

    JLabel editMatch_i_l = new JLabel("Match");
    JLabel editMatch_d_l = new JLabel("Date");
    JLabel editMatch_t_l = new JLabel("Time");
    JLabel editMatch_r_i_l = new JLabel("Refree");
    JLabel editMatch_s_i_l = new JLabel("Stadium");
    JLabel editMatch_t1_i_l = new JLabel("Team 1");
    JLabel editMatch_t2_i_l = new JLabel("Team 2");
    JLabel match_edit_valid_inf = new JLabel("");

    //Edit Referee Panel   components-----------
    JButton editButton4 = new JButton("Edit The Referee");

    JComboBox<String> editRef_i = new JComboBox();
    JTextField editRef_n = new JTextField();
    JTextField editRef_h = new JTextField();
    JTextField editRef_w = new JTextField();

    JLabel editRef_i_l = new JLabel("Referee");
    JLabel editRef_n_l = new JLabel("Name");
    JLabel editRef_h_l = new JLabel("Height(cm)");
    JLabel editRef_w_l = new JLabel("Weight(kg)");
    JLabel referee_edit_valid_inf = new JLabel("");

    //Edit Staduim Panel  components------------
    JButton editButton5 = new JButton("Edit The Stadium");

    JComboBox<String> editStd_i = new JComboBox();
    JTextField editStd_n = new JTextField();
    JTextField editStd_cap = new JTextField();
    JTextField editStd_loc = new JTextField();

    JLabel editStd_i_l = new JLabel("Stadium");
    JLabel editStd_n_l = new JLabel("Name");
    JLabel editStd_cap_l = new JLabel("Seat capsity");
    JLabel editStd_loc_l = new JLabel("Location");
    JLabel staduim_edit_valid_inf = new JLabel("");

    public adminEditFrame() {

        super();
        //edit panelesss-------------------------------------------
        //Edit Player Panel-----------------------------------
        editPlayerp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        editPlayerp.setLayout(null);
        editPlayerp.setBackground(new Color(108, 187, 240));
        editPlayerp.setVisible(false);

        editPlayerp.add(editPlayer_t_i);
        editPlayer_t_i.setBounds(850, 75, 300, 80);
        editPlayer_t_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            this.editPlayer_t_i.addItem(this.admin.league.teamList.get(i).getName());
        }

        editPlayerp.add(editPlayer_t_i_l);
        editPlayer_t_i_l.setBounds(650, 75, 200, 80);
        editPlayer_t_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editPlayerp.add(editPlayer_n);
        editPlayer_n.setBounds(250, 185, 300, 80);
        editPlayer_n.setFont(new Font("atilic", Font.PLAIN, 25));

        editPlayerp.add(editPlayer_n_l);
        editPlayer_n_l.setBounds(50, 185, 200, 80);
        editPlayer_n_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editPlayerp.add(editPlayer_pos);
        editPlayer_pos.setBounds(850, 185, 300, 80);
        editPlayer_pos.setFont(new Font("atilic", Font.PLAIN, 25));
        editPlayer_pos.addItem(Position.AMF);
        editPlayer_pos.addItem(Position.CB);
        editPlayer_pos.addItem(Position.CMF);
        editPlayer_pos.addItem(Position.DMF);
        editPlayer_pos.addItem(Position.FC);
        editPlayer_pos.addItem(Position.GK);
        editPlayer_pos.addItem(Position.LB);
        editPlayer_pos.addItem(Position.LW);
        editPlayer_pos.addItem(Position.RB);
        editPlayer_pos.addItem(Position.RW);
        editPlayer_pos.addItem(Position.SS);

        editPlayerp.add(editPlayer_pos_l);
        editPlayer_pos_l.setBounds(650, 185, 200, 80);
        editPlayer_pos_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editPlayerp.add(editPlayer_h);
        editPlayer_h.setBounds(850, 295, 300, 80);
        editPlayer_h.setFont(new Font("atilic", Font.PLAIN, 25));

        editPlayerp.add(editPlayer_h_l);
        editPlayer_h_l.setBounds(650, 295, 200, 80);
        editPlayer_h_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editPlayerp.add(editPlayer_i);
        editPlayer_i.setBounds(250, 75, 300, 80);
        editPlayer_i.setFont(new Font("atilic", Font.PLAIN, 25));

        editPlayerp.add(editPlayer_i_l);
        editPlayer_i_l.setBounds(50, 75, 200, 80);
        editPlayer_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editPlayerp.add(editPlayer_w);
        editPlayer_w.setBounds(250, 295, 300, 80);
        editPlayer_w.setFont(new Font("atilic", Font.PLAIN, 25));

        editPlayerp.add(editPlayer_w_l);
        editPlayer_w_l.setBounds(50, 295, 200, 80);
        editPlayer_w_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editPlayerp.add(editButton1);
        editButton1.setBounds(450, 450, 300, 50);
        editButton1.setForeground(Color.GREEN);
        editButton1.setFont(new Font("SHRIF", 0, 32));
        editButton1.addActionListener(this);

        editPlayerp.add(player_edit_valid_inf);
        player_edit_valid_inf.setBounds(400, 500, 400, 50);
        player_edit_valid_inf.setForeground(Color.RED);
        player_edit_valid_inf.setFont(new Font("SHRIF", 0, 32));

        EisPlayer.addActionListener(this);

        //Edit Team panal------------------------------------------
        editTeamp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        editTeamp.setBackground(new Color(108, 187, 240));
        editTeamp.setLayout(null);
        editTeamp.setVisible(false);

        editTeamp.add(editTeam_i);
        editTeam_i.setBounds(525, 96, 400, 80);
        editTeam_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            editTeam_i.addItem(this.admin.league.teamList.get(i).getName());
        }

        editTeamp.add(editTeam_i_l);
        editTeam_i_l.setBounds(275, 96, 250, 80);
        editTeam_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editTeamp.add(editTeam_n);
        editTeam_n.setBounds(525, 273, 400, 80);
        editTeam_n.setFont(new Font("atilic", Font.PLAIN, 25));

        editTeamp.add(editTeam_n_l);
        editTeam_n_l.setBounds(275, 273, 100, 80);
        editTeam_n_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editTeamp.add(editButton2);
        editButton2.setBounds(450, 450, 300, 50);
        editButton2.setForeground(Color.GREEN);
        editButton2.setFont(new Font("SHRIF", 0, 32));
        editButton2.addActionListener(this);

        editTeamp.add(team_edit_valid_inf);
        team_edit_valid_inf.setBounds(400, 500, 400, 50);
        team_edit_valid_inf.setForeground(Color.RED);
        team_edit_valid_inf.setFont(new Font("SHRIF", 0, 32));

        EisTeam.addActionListener(this);

        //Edit Match panel-------------------------------------
        editMatchp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        editMatchp.setBackground(new Color(108, 187, 240));
        editMatchp.setLayout(null);
        editMatchp.setVisible(false);
        //top center
        editMatchp.add(editMatch_i);
        editMatch_i.setBounds(450, 42, 475, 60);
        editMatch_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.matchList.size(); i++) {
            editMatch_i.addItem(" match number (" + (i + 1) + ") in the league");
        }

        editMatchp.add(editMatch_i_l);
        editMatch_i_l.setBounds(250, 42, 200, 60);
        editMatch_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        // text feild //
        editMatchp.add(editMatch_d);
        editMatch_d.setBounds(250, 348, 300, 60);
        editMatch_d.setFont(new Font("atilic", Font.PLAIN, 25));

        editMatchp.add(editMatch_d_l);
        editMatch_d_l.setBounds(50, 348, 200, 60);
        editMatch_d_l.setFont(new Font("atilic", Font.PLAIN, 30));
        // text feild
        editMatchp.add(editMatch_t);
        editMatch_t.setBounds(850, 348, 300, 60);
        editMatch_t.setFont(new Font("atilic", Font.PLAIN, 25));

        editMatchp.add(editMatch_t_l);
        editMatch_t_l.setBounds(650, 348, 200, 60);
        editMatch_t_l.setFont(new Font("atilic", Font.PLAIN, 30));
        // text feild
        editMatchp.add(editMatch_r_i);
        editMatch_r_i.setBounds(250, 144, 300, 60);
        editMatch_r_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.refList.size(); i++) {
            editMatch_r_i.addItem(this.admin.league.refList.get(i).getName());
        }

        editMatchp.add(editMatch_r_i_l);
        editMatch_r_i_l.setBounds(50, 144, 200, 60);
        editMatch_r_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editMatchp.add(editMatch_s_i);
        editMatch_s_i.setBounds(250, 246, 300, 60);
        editMatch_s_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.stdList.size(); i++) {
            this.editMatch_s_i.addItem(this.admin.league.stdList.get(i).getName());
        }

        editMatchp.add(editMatch_s_i_l);
        editMatch_s_i_l.setBounds(50, 246, 200, 60);
        editMatch_s_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editMatchp.add(editMatch_t1_i);
        editMatch_t1_i.setBounds(850, 144, 300, 60);
        editMatch_t1_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            this.editMatch_t1_i.addItem(this.admin.league.teamList.get(i).getName());
        }

        editMatchp.add(editMatch_t1_i_l);
        editMatch_t1_i_l.setBounds(650, 144, 200, 60);
        editMatch_t1_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editMatchp.add(editMatch_t2_i);
        editMatch_t2_i.setBounds(850, 246, 300, 60);
        editMatch_t2_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            this.editMatch_t2_i.addItem(this.admin.league.teamList.get(i).getName());
        }

        editMatchp.add(editMatch_t2_i_l);
        editMatch_t2_i_l.setBounds(650, 246, 200, 60);
        editMatch_t2_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editMatchp.add(editButton3);
        editButton3.setBounds(450, 450, 300, 50);
        editButton3.setForeground(Color.GREEN);
        editButton3.setFont(new Font("SHRIF", 0, 32));
        editButton3.addActionListener(this);

        editMatchp.add(match_edit_valid_inf);
        match_edit_valid_inf.setBounds(400, 500, 400, 50);
        match_edit_valid_inf.setForeground(Color.RED);
        match_edit_valid_inf.setFont(new Font("SHRIF", 0, 32));

        EisMatch.addActionListener(this);

        //Edit Referee  panel---------------------------------
        editRefereep.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        editRefereep.setBackground(new Color(108, 187, 240));
        editRefereep.setLayout(null);
        editRefereep.setVisible(false);

        editRefereep.add(editRef_i);
        editRef_i.setBounds(850, 96, 300, 80);
        editRef_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.refList.size(); i++) {
            editRef_i.addItem(this.admin.league.refList.get(i).getName());
        }

        editRefereep.add(editRef_i_l);
        editRef_i_l.setBounds(650, 96, 200, 80);
        editRef_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editRefereep.add(editRef_n);
        editRef_n.setBounds(250, 96, 300, 80);
        editRef_n.setFont(new Font("atilic", Font.PLAIN, 25));

        editRefereep.add(editRef_n_l);
        editRef_n_l.setBounds(50, 96, 200, 80);
        editRef_n_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editRefereep.add(editRef_h);
        editRef_h.setBounds(250, 273, 300, 80);
        editRef_h.setFont(new Font("atilic", Font.PLAIN, 25));

        editRefereep.add(editRef_h_l);
        editRef_h_l.setBounds(50, 273, 200, 80);
        editRef_h_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editRefereep.add(editRef_w);
        editRef_w.setBounds(850, 273, 300, 80);
        editRef_w.setFont(new Font("atilic", Font.PLAIN, 25));

        editRefereep.add(editRef_w_l);
        editRef_w_l.setBounds(650, 273, 200, 80);
        editRef_w_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editRefereep.add(editButton4);
        editButton4.setBounds(450, 450, 300, 50);
        editButton4.setForeground(Color.GREEN);
        editButton4.setFont(new Font("SHRIF", 0, 32));
        editButton4.addActionListener(this);

        editRefereep.add(referee_edit_valid_inf);
        referee_edit_valid_inf.setBounds(400, 500, 400, 50);
        referee_edit_valid_inf.setForeground(Color.RED);
        referee_edit_valid_inf.setFont(new Font("SHRIF", 0, 32));

        EisReferee.addActionListener(this);

        //Edit Stadiuom  panel    
        editStadiump.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        editStadiump.setBackground(new Color(108, 187, 240));
        editStadiump.setLayout(null);
        editStadiump.setVisible(false);

        editStadiump.add(editStd_i);
        editStd_i.setBounds(850, 96, 300, 80);
        editStd_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.stdList.size(); i++) {
            editStd_i.addItem(this.admin.league.stdList.get(i).getName());
        }

        editStadiump.add(editStd_i_l);
        editStd_i_l.setBounds(650, 96, 200, 80);
        editStd_i_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editStadiump.add(editStd_n);
        editStd_n.setBounds(250, 96, 300, 80);
        editStd_n.setFont(new Font("atilic", Font.PLAIN, 25));

        editStadiump.add(editStd_n_l);
        editStd_n_l.setBounds(50, 96, 200, 80);
        editStd_n_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editStadiump.add(editStd_cap);
        editStd_cap.setBounds(250, 273, 300, 80);
        editStd_cap.setFont(new Font("atilic", Font.PLAIN, 25));

        editStadiump.add(editStd_cap_l);
        editStd_cap_l.setBounds(50, 273, 200, 80);
        editStd_cap_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editStadiump.add(editStd_loc);
        editStd_loc.setBounds(850, 273, 300, 80);
        editStd_loc.setFont(new Font("atilic", Font.PLAIN, 25));

        editStadiump.add(editStd_loc_l);
        editStd_loc_l.setBounds(650, 273, 200, 80);
        editStd_loc_l.setFont(new Font("atilic", Font.PLAIN, 30));

        editStadiump.add(editButton5);
        editButton5.setBounds(450, 450, 300, 50);
        editButton5.setForeground(Color.GREEN);
        editButton5.setFont(new Font("SHRIF", 0, 32));
        editButton5.addActionListener(this);

        editStadiump.add(staduim_edit_valid_inf);
        staduim_edit_valid_inf.setBounds(400, 500, 400, 50);
        staduim_edit_valid_inf.setForeground(Color.RED);
        staduim_edit_valid_inf.setFont(new Font("SHRIF", 0, 32));

        EisStadium.addActionListener(this);

    } // constructor 

    @Override
    public void actionPerformed(ActionEvent e) {

        super.actionPerformed(e);
        //edit radio button
        if (EisPlayer.isSelected()) {
            editPlayerp.setVisible(true);
            editTeamp.setVisible(false);
            editMatchp.setVisible(false);
            editStadiump.setVisible(false);
            editRefereep.setVisible(false);

        } else if (EisTeam.isSelected()) {
            editPlayerp.setVisible(false);
            editTeamp.setVisible(true);
            editMatchp.setVisible(false);
            editStadiump.setVisible(false);
            editRefereep.setVisible(false);

        } else if (EisMatch.isSelected()) {

            editPlayerp.setVisible(false);
            editTeamp.setVisible(false);
            editMatchp.setVisible(true);
            editStadiump.setVisible(false);
            editRefereep.setVisible(false);

        } else if (EisReferee.isSelected()) {

            editPlayerp.setVisible(false);
            editTeamp.setVisible(false);
            editMatchp.setVisible(false);
            editStadiump.setVisible(false);
            editRefereep.setVisible(true);

        } else if (EisStadium.isSelected()) {

            editPlayerp.setVisible(false);
            editTeamp.setVisible(false);
            editMatchp.setVisible(false);
            editStadiump.setVisible(true);
            editRefereep.setVisible(false);

        }

    } // method Action Perform

}//class adminEditFrame
