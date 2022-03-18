/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.awt.event.*;
import java.awt.event.ActionListener;

/**
 *
 * @author ELHSM
 */
public class adminFrame extends adminAddFrame implements ActionListener {

    public adminFrame() {

        super();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        super.actionPerformed(e);

        // ADD $$$ Validatoin---------------------------------------------------
        //add player actions$$$ Validatoin--------------------------------------------------------------------------------------------------------------------
        if (e.getSource() == add_player_button) {
            int T_index = team_index.getSelectedIndex();
            int player_size = 0;
            int num_players = (Integer) TeamTableModel.getValueAt(T_index, 2);
            String Name = player_name.getText();
            Position position = appostion.getItemAt(appostion.getSelectedIndex());
            try {
                float Height = Float.parseFloat(player_height.getText());
                float Weight = Float.parseFloat(player_weight.getText());
                if ((Height > 210.0)
                        || (Height < 120.0)
                        || (Weight > 120.0)
                        || (Weight < 35.0)
                        || (Name.equals(""))) {
                    player_valid_inf.setText("<EROR>INVALID INPUT");

                } else {
                    //add player to arraylist
                    admin.ADD(T_index, Name, position, Height, Weight);

                    //add player to player table
                    for (int i = 0; i < admin.league.teamList.size(); i++) {
                        for (int j = 0; j < admin.league.teamList.get(i).playerList.size(); j++) {
                            if (i == T_index && (j == admin.league.teamList.get(i).playerList.size() - 1)) {
                                PlayerTableModel.insertRow((player_size), new Object[]{
                                    admin.league.teamList.get(T_index).playerList.size(),
                                    admin.league.teamList.get(T_index).playerList.get(admin.league.teamList.get(T_index).playerList.size() - 1).getName(),
                                    admin.league.teamList.get(T_index).getName(),
                                    admin.league.teamList.get(T_index).playerList.get(admin.league.teamList.get(T_index).playerList.size() - 1).getWeight(),
                                    admin.league.teamList.get(T_index).playerList.get(admin.league.teamList.get(T_index).playerList.size() - 1).getHeight(),
                                    admin.league.teamList.get(T_index).playerList.get(admin.league.teamList.get(T_index).playerList.size() - 1).position
                                });
                                num_players++;
                                TeamTableModel.setValueAt(num_players, T_index, 2);
                            }
                            player_size++;
                        }
                    }

                    player_name.setText("");
                    player_height.setText("");
                    player_weight.setText("");
                    player_valid_inf.setText("");
                } //else  
            } catch (NumberFormatException x) {
                player_valid_inf.setText(x.getMessage());
            }

        } //add teams actions$$$ Validatoin--------------------------------------------------------------------------------------------------------------------
        else if (e.getSource() == add_team_button) {
            boolean valid_input = true;
            String Name = team_name.getText();

            for (int i = 0; i < admin.league.teamList.size(); i++) {
                if ((admin.league.teamList.get(i).getName().toLowerCase()).equals((Name.toLowerCase()))) {
                    valid_input = false;
                }
            }
            if (Name.equals("")) {
                valid_input = false;
            }
            if (!valid_input) {
                team_valid_inf.setText("<EROR>INVALID INPUT");

            } else {
                //add team to arraylist
                admin.ADD(Name);
                //add team to team table-----------
                TeamTableModel.addRow(new Object[]{
                    admin.league.teamList.size(),
                    admin.league.teamList.get(admin.league.teamList.size() - 1).getName(),
                    0
                });
                //add team to combo boxs-------------
                team2_i.addItem(Name);
                team1_i.addItem(Name);
                team_index.addItem(Name);
                deletePlayer_T_i.addItem(Name);
                deleteMatch_i1.addItem(Name);
                deleteMatch_i2.addItem(Name);
                deleteTeam_i.addItem(Name);
                editTeam_i.addItem(Name);
                editMatch_t1_i.addItem(Name);
                editMatch_t2_i.addItem(Name);
                editPlayer_t_i.addItem(Name);

                team_valid_inf.setText("");
                team_name.setText("");
            }
        } //add match actions $$$ Validatoin--------------------------------------------------------------------------------------------------------------------         
        else if (e.getSource() == add_match_button) {
            String Date = date_match.getText();
            String Time = time_match.getText();
            int R_index = referee_i.getSelectedIndex();
            int S_index = stadium_i.getSelectedIndex();
            int T1_index = team1_i.getSelectedIndex();
            int T2_index = team2_i.getSelectedIndex();

            if ((T1_index == T2_index)
                    || (Date.equals(""))
                    || (Time.equals(""))
                    || (!(Date.indexOf('/') == 2))//!=22/10/2021
                    || (!(Date.indexOf('/', 3) == 5))
                    || (!(Time.indexOf(':') == 2))//!=06:30
                    || (Date.length() > 10)
                    || (Time.length() > 5)) {

                match_valid_inf.setText("<EROR>INVALID INPUT");

            } else {
                //add match to arraylist
                admin.ADD(Time, Date, R_index, S_index, T1_index, T2_index);

                //add match to match table
                MatchTableModel.addRow(new Object[]{
                    admin.league.matchList.size(),
                    admin.league.matchList.get(admin.league.matchList.size() - 1).team1.getName(),
                    admin.league.matchList.get(admin.league.matchList.size() - 1).team2.getName(),
                    admin.league.matchList.get(admin.league.matchList.size() - 1).getDate(),
                    admin.league.matchList.get(admin.league.matchList.size() - 1).getTime(),
                    admin.league.matchList.get(admin.league.matchList.size() - 1).referee.getName(),
                    admin.league.matchList.get(admin.league.matchList.size() - 1).stadium.getName(),});
                //add match to comboboxs
                editMatch_i.addItem(" match number (" + (admin.league.matchList.size()) + ") in the league");

                date_match.setText("");
                time_match.setText("");
                match_valid_inf.setText("");
            }
        } //add referee actions $$$ Validatoin-------------------------------------------------------------------------------------------------------------------   
        else if (e.getSource() == add_referee_button) {
            String Name = referee_name.getText();
            try {
                float Height = Float.parseFloat(referee_height.getText());
                float Weight = Float.parseFloat(referee_weight.getText());
                if (((Height > 210)
                        || (Height < 120))
                        || ((Weight > 120)
                        || (Weight < 50))
                        || (Name.equals(""))) {

                    referee_valid_inf.setText("<EROR>INVALID INPUT");

                } else {
                    //add referee to arraylist
                    admin.ADD(Name, Height, Weight);

                    //add referee to referee match
                    RefereeTableModel.addRow(new Object[]{
                        admin.league.refList.size(),
                        admin.league.refList.get(admin.league.refList.size() - 1).getName(),
                        admin.league.refList.get(admin.league.refList.size() - 1).getHeight(),
                        admin.league.refList.get(admin.league.refList.size() - 1).getWeight()
                    });

                    referee_name.setText("");
                    referee_height.setText("");
                    referee_weight.setText("");
                    referee_valid_inf.setText("");

                    //add referee to combo box
                    referee_i.addItem(Name);
                    deleteReferee_i.addItem(Name);
                    editRef_i.addItem(Name);
                    editMatch_r_i.addItem(Name);
                }

            } catch (NumberFormatException x) {
                referee_valid_inf.setText(x.getMessage());
            }

        } //add staduim actions $$$ Validatoin--------------------------------------------------------------------------------------------------------------------         
        else if (e.getSource() == add_staduim_button) {
            String Name = staduim_name.getText();
            String Location = staduim_location.getText();
            try {
                int Capicty = Integer.parseInt(staduim_capsity.getText());
                if ((Capicty > 800000)
                        || (Capicty < 10000)
                        || (Name.equals(""))
                        || (Location.equals(""))) {

                    staduim_valid_inf.setText("<EROR>INVALID INPUT");

                } else {
                    //add Stadium to arraylist
                    admin.ADD(Capicty, Location, Name);

                    //add stadium to stadium table
                    StadiumTableModel.addRow(new Object[]{
                        admin.league.stdList.size(),
                        admin.league.stdList.get(admin.league.stdList.size() - 1).getName(),
                        admin.league.stdList.get(admin.league.stdList.size() - 1).getLocation(),
                        admin.league.stdList.get(admin.league.stdList.size() - 1).getSeating()
                    });

                    staduim_name.setText("");
                    staduim_location.setText("");
                    staduim_capsity.setText("");
                    staduim_valid_inf.setText("");

                    //add stadium to combo boxs
                    stadium_i.addItem(Name);
                    deleteStadium_i.addItem(Name);
                    editStd_i.addItem(Name);
                    editMatch_s_i.addItem(Name);
                }
            } catch (NumberFormatException x) {
                staduim_valid_inf.setText(x.getMessage());
            }
        }

//edit panels----------------------------------------------------------------------------
        //edit player actions----------------------------------------------------------
        if (e.getSource() == editButton1) {
            int T_index = editPlayer_t_i.getSelectedIndex();
            int player_size = 0;
            String Name = editPlayer_n.getText();
            Position position = editPlayer_pos.getItemAt(editPlayer_pos.getSelectedIndex());
            try {
                float Height = Float.parseFloat(editPlayer_h.getText());
                float Weight = Float.parseFloat(editPlayer_w.getText());
                int P_index = (Integer.parseInt(editPlayer_i.getText())) - 1;
                if ((Height > 210.0)
                        || (Height < 120.0)
                        || (Weight > 120.0)
                        || (Weight < 35.0)
                        || (Name.equals(""))
                        || (P_index >= admin.league.teamList.get(T_index).playerList.size())
                        || (P_index < 0)) {
                    player_edit_valid_inf.setText("<EROR>INVALID INPUT");

                } else {

                    //edit player from arraylist
                    admin.EDIT(P_index, T_index, Name, position, Height, Weight);

                    //edit player from player table
                    for (int i = 0; i < admin.league.teamList.size(); i++) {
                        for (int j = 0; j < admin.league.teamList.get(i).playerList.size(); j++) {
                            if ((i == T_index) && (j == P_index)) {
                                PlayerTableModel.setValueAt(Name, player_size, 1);
                                PlayerTableModel.setValueAt(Height, player_size, 3);
                                PlayerTableModel.setValueAt(Weight, player_size, 4);
                                PlayerTableModel.setValueAt(position, player_size, 5);
                            }
                            player_size++;
                        }
                    }

                    editPlayer_n.setText("");
                    editPlayer_h.setText("");
                    editPlayer_w.setText("");
                    player_edit_valid_inf.setText("");
                    editPlayer_i.setText("");
                }
            } catch (NumberFormatException x) {
                player_edit_valid_inf.setText(x.getMessage());
            }
        } //edit team action------------------------------------------------------------------
        else if (e.getSource() == editButton2) {
            boolean valid_input = true;
            String Name = editTeam_n.getText();
            int T_index = editTeam_i.getSelectedIndex();
            int player_size = 0;

            for (int i = 0; i < admin.league.teamList.size(); i++) {
                if ((admin.league.teamList.get(i).getName().toLowerCase()).equals((Name.toLowerCase()))) {
                    valid_input = false;
                }
            }

            if (Name.equals("")) {
                valid_input = false;
            }
            if (!valid_input) {
                team_edit_valid_inf.setText("<EROR>INVALID INPUT");

            } else {
                //Edit team to arraylist
                admin.EDIT(T_index, Name);
                //Edit team to team table-----------
                TeamTableModel.setValueAt(Name, T_index, 1);
                //edit team in match table
                for (int i = 0; i < admin.league.matchList.size(); i++) {
                    if (Name.equals(admin.league.matchList.get(i).team1.getName())) {
                        MatchTableModel.setValueAt(Name, i, 1);
                    }
                    if (Name.equals(admin.league.matchList.get(i).team2.getName())) {
                        MatchTableModel.setValueAt(Name, i, 2);
                    }
                }

                //edit team to players table
                for (int i = 0; i < admin.league.teamList.size(); i++) {
                    for (int j = 0; j < admin.league.teamList.get(i).playerList.size(); j++) {

                        if (T_index == i) {
                            PlayerTableModel.setValueAt(Name, player_size, 2);
                        }
                        player_size++;
                    }
                }
                //Edit team to combo boxs-------------

                team_index.removeAllItems();
                team1_i.removeAllItems();
                team2_i.removeAllItems();
                deleteMatch_i1.removeAllItems();
                deleteMatch_i2.removeAllItems();
                deleteTeam_i.removeAllItems();
                deletePlayer_T_i.removeAllItems();
                editPlayer_t_i.removeAllItems();
                editTeam_i.removeAllItems();
                editMatch_t1_i.removeAllItems();
                editMatch_t2_i.removeAllItems();

                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    team_index.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    team1_i.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    team2_i.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    deletePlayer_T_i.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    deleteTeam_i.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    deleteMatch_i1.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    deleteMatch_i2.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    editPlayer_t_i.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    editTeam_i.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    this.editMatch_t1_i.addItem(this.admin.league.teamList.get(i).getName());
                }
                for (int i = 0; i < this.admin.league.teamList.size(); i++) {
                    this.editMatch_t2_i.addItem(this.admin.league.teamList.get(i).getName());
                }

                team_edit_valid_inf.setText("");
                editTeam_n.setText("");
            }

        } //edit match action--------------------------------------------------------------
        else if (e.getSource() == editButton3) {
            String Date = editMatch_d.getText();
            String Time = editMatch_t.getText();
            int M_index = editMatch_i.getSelectedIndex();
            int R_index = editMatch_r_i.getSelectedIndex();
            int S_index = editMatch_s_i.getSelectedIndex();
            int T1_index = editMatch_t1_i.getSelectedIndex();
            int T2_index = editMatch_t2_i.getSelectedIndex();

            if ((T1_index == T2_index)
                    || (Date.equals(""))
                    || (Time.equals(""))
                    || (!(Date.indexOf('/') == 2))//!=22/10/2021
                    || (!(Date.indexOf('/', 3) == 5))
                    || (!(Time.indexOf(':') == 2))//06:30
                    || (Date.length() > 10)
                    || (Time.length() > 5)) {

                match_edit_valid_inf.setText("<EROR>INVALID INPUT");

            } else {
                //add match to arraylist
                admin.EDIT(M_index, Time, Date, R_index, S_index, T1_index, T2_index);
                //add match to match table
                MatchTableModel.setValueAt(editMatch_t1_i.getItemAt(T1_index), M_index, 1);
                MatchTableModel.setValueAt(editMatch_t2_i.getItemAt(T2_index), M_index, 2);
                MatchTableModel.setValueAt(Date, M_index, 3);
                MatchTableModel.setValueAt(Time, M_index, 4);
                MatchTableModel.setValueAt(editMatch_r_i.getItemAt(R_index), M_index, 5);
                MatchTableModel.setValueAt(editMatch_s_i.getItemAt(S_index), M_index, 6);

                editMatch_d.setText("");
                editMatch_t.setText("");
                match_edit_valid_inf.setText("");
            }

        } //edit referee action------------------------------------------------------------
        else if (e.getSource() == editButton4) {
            String Name = editRef_n.getText();
            int R_index = editRef_i.getSelectedIndex();
            try {
                float Height = Float.parseFloat(editRef_h.getText());
                float Weight = Float.parseFloat(editRef_w.getText());
                if (((Height > 210)
                        || (Height < 120))
                        || ((Weight > 120)
                        || (Weight < 50))
                        || (Name.equals(""))) {

                    referee_edit_valid_inf.setText("<EROR>INVALID INPUT");

                } else {
                    //edit referee to arraylist
                    admin.EDIT(R_index, Weight, Name, Height);

                    //edit referee to referee table
                    RefereeTableModel.setValueAt(Name, R_index, 1);
                    RefereeTableModel.setValueAt(Height, R_index, 2);
                    RefereeTableModel.setValueAt(Weight, R_index, 3);
                    //edit rferee to math table
                    for (int i = 0; i < admin.league.matchList.size(); i++) {
                        if (Name.equals(admin.league.matchList.get(i).referee.getName())) {
                            MatchTableModel.setValueAt(Name, i, 5);
                        }
                    }
                    //edit referee to combo box
                    referee_i.removeAllItems();
                    deleteReferee_i.removeAllItems();
                    editRef_i.removeAllItems();
                    editMatch_r_i.removeAllItems();
                    for (int i = 0; i < this.admin.league.refList.size(); i++) {
                        this.referee_i.addItem(this.admin.league.refList.get(i).getName());
                    }
                    for (int i = 0; i < this.admin.league.refList.size(); i++) {
                        deleteReferee_i.addItem(this.admin.league.refList.get(i).getName());
                    }
                    for (int i = 0; i < this.admin.league.refList.size(); i++) {
                        editMatch_r_i.addItem(this.admin.league.refList.get(i).getName());
                    }
                    for (int i = 0; i < this.admin.league.refList.size(); i++) {
                        editRef_i.addItem(this.admin.league.refList.get(i).getName());
                    }

                    editRef_n.setText("");
                    editRef_h.setText("");
                    editRef_w.setText("");
                    referee_edit_valid_inf.setText("");

                }

            } catch (NumberFormatException x) {
                referee_edit_valid_inf.setText(x.getMessage());
            }

        } //edit stadium action------------------------------------------------------------
        else if (e.getSource() == editButton5) {
            String Name = editStd_n.getText();
            String Location = editStd_loc.getText();
            int S_index = editStd_i.getSelectedIndex();
            try {
                int Capicty = Integer.parseInt(editStd_cap.getText());
                if ((Capicty > 800000)
                        || (Capicty < 10000)
                        || (Name.equals(""))
                        || (Location.equals(""))) {

                    staduim_edit_valid_inf.setText("<EROR>INVALID INPUT");

                } else {
                    //edit Stadium to arraylist
                    admin.EDIT(S_index, Capicty, Location, Name);

                    //edit stadium to stadium table
                    StadiumTableModel.setValueAt(Name, S_index, 1);
                    StadiumTableModel.setValueAt(Location, S_index, 2);
                    StadiumTableModel.setValueAt(Capicty, S_index, 3);
                    //edit rferee to math table
                    for (int i = 0; i < admin.league.matchList.size(); i++) {
                        if (Name.equals(admin.league.matchList.get(i).stadium.getName())) {
                            MatchTableModel.setValueAt(Name, i, 6);
                        }
                    }
                    //edit stadium to combo boxs
                    stadium_i.removeAllItems();
                    deleteStadium_i.removeAllItems();
                    editStd_i.removeAllItems();
                    editMatch_s_i.removeAllItems();
                    for (int i = 0; i < this.admin.league.stdList.size(); i++) {
                        this.stadium_i.addItem(this.admin.league.stdList.get(i).getName());
                    }
                    for (int i = 0; i < this.admin.league.stdList.size(); i++) {
                        deleteStadium_i.addItem(this.admin.league.stdList.get(i).getName());
                    }
                    for (int i = 0; i < this.admin.league.stdList.size(); i++) {
                        editMatch_s_i.addItem(this.admin.league.stdList.get(i).getName());
                    }
                    for (int i = 0; i < this.admin.league.stdList.size(); i++) {
                        editStd_i.addItem(this.admin.league.stdList.get(i).getName());
                    }

                    editStd_n.setText("");
                    editStd_loc.setText("");
                    editStd_cap.setText("");
                    staduim_edit_valid_inf.setText("");

                }
            } catch (NumberFormatException x) {
                staduim_edit_valid_inf.setText(x.getMessage());
            }
        }

// Remove $$$ Validatoin----------------------------------------------------------------------------------------
        // remove player -----------------------------------------------------
        if (e.getSource() == deleteButton1) {
            int T_index = deletePlayer_T_i.getSelectedIndex();
            int player_size = 0;
            int num_players = (Integer) TeamTableModel.getValueAt(T_index, 2);
            try {
                int P_index = (Integer.parseInt(deletePlayer_i.getText())) - 1;
                if ((P_index >= admin.league.teamList.get(T_index).playerList.size())
                        || (P_index < 0)) {
                    deletePlayer_i_valid_info.setText("<EROR>INVALID PLAYER NUMBER");
                } else {
                    //remove player from arraylist
                    admin.removePlayer(T_index, P_index);

                    //remove player from player table
                    // for (int i = 3; i < 4; i++) 0---3
                    //for (int j = 10; j < 11; j ) 0--10
                    for (int i = 0; i < admin.league.teamList.size(); i++) {
                        for (int j = 0; j < admin.league.teamList.get(i).playerList.size(); j++) {
                            //if ((i == 3)&& (j == 10))

                            if ((i == T_index) && (j == P_index)) {
                                PlayerTableModel.removeRow(player_size);
                                num_players--;
                                TeamTableModel.setValueAt(num_players, T_index, 2);
                            }
                            player_size = player_size + 1; // = 44
                        }
                    }

                    deletePlayer_i.setText("");
                    deletePlayer_i_valid_info.setText("");
                }
            } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                deletePlayer_i_valid_info.setText(ex.getMessage());
            }
        } // remove team ----------------------------------------------------- 
        else if (e.getSource() == deleteButton2) {
            int T_index = deleteTeam_i.getSelectedIndex();
            int player_size = 0;
            int nx;
            //remove all players team in the player table
            for (int i = 0; i < admin.league.teamList.size(); i++) {
                nx = player_size;
                for (int j = 0; j < admin.league.teamList.get(i).playerList.size(); j++) {

                    if (T_index == i) {
                        PlayerTableModel.removeRow(nx);
                    }
                    player_size++;
                }
            }

            //remove team from team arraylist
            admin.removeTeam(T_index);

            //remove team from team table
            TeamTableModel.removeRow(T_index);

            //remove players team from arrylist
            admin.league.teamList.get(T_index).playerList.clear();

            //remove team from combo boxs
            team_index.removeItemAt(T_index);
            team1_i.removeItemAt(T_index);
            team2_i.removeItemAt(T_index);
            deleteMatch_i1.removeItemAt(T_index);
            deleteMatch_i2.removeItemAt(T_index);
            deleteTeam_i.removeItemAt(T_index);
            deletePlayer_T_i.removeItemAt(T_index);
            editPlayer_t_i.removeItemAt(T_index);
            editTeam_i.removeItemAt(T_index);
            editMatch_t1_i.removeItemAt(T_index);
            editMatch_t2_i.removeItemAt(T_index);
        } // remove match -----------------------------------------------------
        else if (e.getSource() == deleteButton3) {
            String T1_name = deleteMatch_i1.getItemAt(deleteMatch_i1.getSelectedIndex());
            String T2_name = deleteMatch_i2.getItemAt(deleteMatch_i2.getSelectedIndex());

            //chek if the match is existed
            for (int i = 0; i < admin.league.matchList.size(); i++) {
                if ((T1_name.equals(admin.league.matchList.get(i).team1.getName())
                        && T2_name.equals(admin.league.matchList.get(i).team2.getName()))
                        || (T1_name.equals(admin.league.matchList.get(i).team2.getName())
                        && T2_name.equals(admin.league.matchList.get(i).team1.getName()))) {
                    //remove match from arraylist
                    admin.removeMatch(i);
                    //remove match from match table
                    MatchTableModel.removeRow(i);
                }
            }
        } // remove Referee -----------------------------------------------------
        else if (e.getSource() == deleteButton4) {
            int R_index = deleteReferee_i.getSelectedIndex();
            //remove referee from arraylist
            admin.removeReferee(R_index);

            //remove referee from match table
            RefereeTableModel.removeRow(R_index);

            //remove referee from combo boxs
            referee_i.removeItemAt(R_index);
            deleteReferee_i.removeItemAt(R_index);
            editRef_i.removeItemAt(R_index);
            editMatch_r_i.removeItemAt(R_index);

        } // remove Stadium -----------------------------------------------------
        else if (e.getSource() == deleteButton5) {
            int S_index = deleteStadium_i.getSelectedIndex();

            //remove stadium from arraylist
            admin.removeStadium(S_index);

            //remove stadium from match table
            StadiumTableModel.removeRow(S_index);

            //remove referee from combo boxs
            stadium_i.removeItemAt(S_index);
            deleteStadium_i.removeItemAt(S_index);
            editStd_i.removeItemAt(S_index);
            editMatch_s_i.removeItemAt(S_index);
        }

    } // Method actionPerform
} // Class adminFrame
