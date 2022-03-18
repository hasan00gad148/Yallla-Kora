/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.awt.*;
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
public class adminDeleteFrame extends Frame implements ActionListener {
    //Deletes paneles=------------------------
    // Delete Player Panel  components-----------------------------------
    JButton deleteButton1 = new JButton("Delete The Player");
    JTextField deletePlayer_i = new JTextField();
    JComboBox<String> deletePlayer_T_i = new JComboBox();
    JLabel deletePlyer_T_l = new JLabel("Team Index");
    JLabel deletePlayer_l = new JLabel("Player Index");
    JLabel deletePlayer_i_valid_info = new JLabel("");

    //Delete Team Panel components--------------------------------------
    JButton deleteButton2 = new JButton("Delete The Team");

    JComboBox<String> deleteTeam_i = new JComboBox();

    JLabel deleteTeam_l = new JLabel("Team");

    //Delete Match Panel  components-----------------------------
    JButton deleteButton3 = new JButton("Delete The Match");

    JComboBox<String> deleteMatch_i1 = new JComboBox();
    JComboBox<String> deleteMatch_i2 = new JComboBox();

    JLabel deleteMatch_l1 = new JLabel("Team1 in Match");
    JLabel deleteMatch_l2 = new JLabel("Team2 in Match");

    //Delete Referee Panel   components---------------------------------
    JButton deleteButton4 = new JButton("Delete The Referee");

    JComboBox<String> deleteReferee_i = new JComboBox();

    JLabel deleteReferee_l = new JLabel("Referee");

    //Delete Stadium Panel  components------------------------------------
    JButton deleteButton5 = new JButton("Delete The Stedium");

    JComboBox<String> deleteStadium_i = new JComboBox();

    JLabel deleteStadium_l = new JLabel("Stadium");

    // Constructor
    public adminDeleteFrame() {
        super();

        //Delete Player Panel-----------------------------------
        deletePlayerp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        deletePlayerp.setLayout(null);
        deletePlayerp.setBackground(new Color(108, 187, 240));
        deletePlayerp.setVisible(false);

        deletePlayerp.add(deletePlayer_T_i);
        deletePlayer_T_i.setBounds(525, 100, 400, 80);
        deletePlayer_T_i.setFont(new Font("atilic", Font.PLAIN, 25));

        deletePlayerp.add(deletePlyer_T_l);
        deletePlyer_T_l.setBounds(275, 100, 250, 80);
        deletePlyer_T_l.setFont(new Font("atilic", Font.PLAIN, 30));

        deletePlayerp.add(deletePlayer_i);
        deletePlayer_i.setBounds(525, 270, 400, 80);
        deletePlayer_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            deletePlayer_T_i.addItem(this.admin.league.teamList.get(i).getName());
        }

        deletePlayerp.add(deletePlayer_l);
        deletePlayer_l.setBounds(275, 270, 250, 80);
        deletePlayer_l.setFont(new Font("atilic", Font.PLAIN, 30));

        deletePlayerp.add(deleteButton1);
        deleteButton1.setBounds(400, 450, 400, 50);
        deleteButton1.setForeground(Color.RED);
        deleteButton1.setFont(new Font("SHRIF", 0, 32));
        deleteButton1.addActionListener(this);

        deletePlayerp.add(deletePlayer_i_valid_info);
        deletePlayer_i_valid_info.setBounds(350, 500, 500, 50);
        deletePlayer_i_valid_info.setForeground(Color.ORANGE);
        deletePlayer_i_valid_info.setFont(new Font("SHRIF", 0, 32));

        DisPlayer.addActionListener(this);

        //Delete Team Panel--------------------------------------
        deleteTeamp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        deleteTeamp.setLayout(null);
        deleteTeamp.setBackground(new Color(108, 187, 240));
        deleteTeamp.setVisible(false);

        deleteTeamp.add(deleteTeam_i);
        deleteTeam_i.setBounds(525, 185, 400, 80);
        deleteTeam_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            deleteTeam_i.addItem(this.admin.league.teamList.get(i).getName());
        }

        deleteTeamp.add(deleteTeam_l);
        deleteTeam_l.setBounds(275, 185, 250, 80);
        deleteTeam_l.setFont(new Font("atilic", Font.PLAIN, 30));

        deleteTeamp.add(deleteButton2);
        deleteButton2.setBounds(400, 450, 400, 50);
        deleteButton2.setForeground(Color.RED);
        deleteButton2.setFont(new Font("SHRIF", 0, 32));
        deleteButton2.addActionListener(this);

        DisTeam.addActionListener(this);

        //Delete Match Panel-----------------------------
        deleteMatchp.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        deleteMatchp.setLayout(null);
        deleteMatchp.setBackground(new Color(108, 187, 240));
        deleteMatchp.setVisible(false);

        deleteMatchp.add(deleteMatch_i1);
        deleteMatch_i1.setBounds(525, 100, 400, 80);
        deleteMatch_i1.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            deleteMatch_i1.addItem(this.admin.league.teamList.get(i).getName());
        }

        deleteMatchp.add(deleteMatch_l1);
        deleteMatch_l1.setBounds(275, 100, 250, 80);
        deleteMatch_l1.setFont(new Font("atilic", Font.PLAIN, 30));

        deleteMatchp.add(deleteMatch_i2);
        deleteMatch_i2.setBounds(525, 270, 400, 80);
        deleteMatch_i2.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.teamList.size(); i++) {
            deleteMatch_i2.addItem(this.admin.league.teamList.get(i).getName());
        }

        deleteMatchp.add(deleteMatch_l2);
        deleteMatch_l2.setBounds(275, 270, 250, 80);
        deleteMatch_l2.setFont(new Font("atilic", Font.PLAIN, 30));

        deleteMatchp.add(deleteButton3);
        deleteButton3.setBounds(400, 450, 400, 50);
        deleteButton3.setForeground(Color.RED);
        deleteButton3.setFont(new Font("SHRIF", 0, 32));
        deleteButton3.addActionListener(this);

        DisMatch.addActionListener(this);

        //Delete Referee Panel---------------------------------
        deleteRefereep.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        deleteRefereep.setLayout(null);
        deleteRefereep.setBackground(new Color(108, 187, 240));
        deleteRefereep.setVisible(false);

        deleteRefereep.add(deleteReferee_i);
        deleteReferee_i.setBounds(525, 185, 400, 80);
        deleteReferee_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.refList.size(); i++) {
            deleteReferee_i.addItem(this.admin.league.refList.get(i).getName());
        }

        deleteRefereep.add(deleteReferee_l);
        deleteReferee_l.setBounds(275, 185, 250, 80);
        deleteReferee_l.setFont(new Font("atilic", Font.PLAIN, 30));

        deleteRefereep.add(deleteButton4);
        deleteButton4.setBounds(400, 450, 400, 50);
        deleteButton4.setForeground(Color.RED);
        deleteButton4.setFont(new Font("SHRIF", 0, 32));
        deleteButton4.addActionListener(this);

        DisReferee.addActionListener(this);

        //Delete Stadium Panel------------------------------------
        deleteStadiump.setBounds(0, 50, this.getWidth(), (this.getHeight()) - 50);
        deleteStadiump.setLayout(null);
        deleteStadiump.setBackground(new Color(108, 187, 240));
        deleteStadiump.setVisible(false);

        deleteStadiump.add(deleteStadium_i);
        deleteStadium_i.setBounds(525, 185, 400, 80);
        deleteStadium_i.setFont(new Font("atilic", Font.PLAIN, 25));
        for (int i = 0; i < this.admin.league.stdList.size(); i++) {
            deleteStadium_i.addItem(this.admin.league.stdList.get(i).getName());
        }

        deleteStadiump.add(deleteStadium_l);
        deleteStadium_l.setBounds(275, 185, 250, 80);
        deleteStadium_l.setFont(new Font("atilic", Font.PLAIN, 30));

        deleteStadiump.add(deleteButton5);
        deleteButton5.setBounds(400, 450, 400, 50);
        deleteButton5.setForeground(Color.RED);
        deleteButton5.setFont(new Font("SHRIF", 0, 32));
        deleteButton5.addActionListener(this);

        DisStadium.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        super.actionPerformed(e);
        if (DisPlayer.isSelected()) {
            deletePlayerp.setVisible(true);
            deleteTeamp.setVisible(false);
            deleteMatchp.setVisible(false);
            deleteStadiump.setVisible(false);
            deleteRefereep.setVisible(false);
        } else if (DisTeam.isSelected()) {
            deletePlayerp.setVisible(false);
            deleteTeamp.setVisible(true);
            deleteMatchp.setVisible(false);
            deleteStadiump.setVisible(false);
            deleteRefereep.setVisible(false);
        } else if (DisMatch.isSelected()) {
            deletePlayerp.setVisible(false);
            deleteTeamp.setVisible(false);
            deleteMatchp.setVisible(true);
            deleteStadiump.setVisible(false);
            deleteRefereep.setVisible(false);
        } else if (DisStadium.isSelected()) {
            deletePlayerp.setVisible(false);
            deleteTeamp.setVisible(false);
            deleteMatchp.setVisible(false);
            deleteStadiump.setVisible(true);
            deleteRefereep.setVisible(false);
        } else if (DisReferee.isSelected()) {
            deletePlayerp.setVisible(false);
            deleteTeamp.setVisible(false);
            deleteMatchp.setVisible(false);
            deleteStadiump.setVisible(false);
            deleteRefereep.setVisible(true);
        }

    }
}
