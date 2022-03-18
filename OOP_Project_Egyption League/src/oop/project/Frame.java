/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.table.*;

/**
 *
 * @author ELHSM
 */
public class Frame extends JFrame implements ActionListener {

    //Filds
    Admin admin = new Admin();
    int PlayerSize;
    int PlayerNumber;
    boolean validlogin;
    String RESOURCE;
    URL url;

    String[] MatchTablecolumns,
            TeamTablecolumns,
            PlayerTablecolumns,
            RefereeTablecolumns,
            StadiumTablecolumns;

    Object[][] MatchTabledata,
            TeamTabledata,
            PlayerTabledata,
            RefereeTabledata,
            StadiumTabledata;

    //Panels      
    JPanel HomePanel,
            AddPanel,
            DeletePanel,
            EditPanel,
            LoginPanel,
            AdminPanel,
            addPlayerp,
            addTeamp,
            addMatchp,
            addRefereep,
            addStadiump,
            editPlayerp,
            editTeamp,
            editMatchp,
            editRefereep,
            editStadiump,
            deletePlayerp,
            deleteTeamp,
            deleteMatchp,
            deleteRefereep,
            deleteStadiump;

    //Buttons 
    JButton homeButton,
            adminButton,
            matchButton,
            teamButton,
            playerButton,
            refereeButton,
            stadiumButton,
            addButton,
            deleteButton,
            editButton,
            loginButton,
            logoutButton;

    //JradiuoButtons
    JRadioButton AisPlayer,
            AisReferee,
            AisStadium,
            AisMatch,
            AisTeam,
            EisPlayer,
            EisReferee,
            EisStadium,
            EisMatch,
            EisTeam,
            DisPlayer,
            DisReferee,
            DisStadium,
            DisMatch,
            DisTeam;

    //ButtonGroub
    ButtonGroup addBG,
            editBG,
            deleteBG;

    //Images
    ImageIcon mainImage;

    //JLabels=---
    JLabel mainJLabelImage,
            invalidlog,
            userNameLabel,
            passwprdLabel;

    //JScrollPane
    JScrollPane showMatchPane,
            showTeamPane,
            showPlayerPane,
            showRefereePane,
            showStadiumPane;

    //DefaultTableModel 
    DefaultTableModel MatchTableModel,
            TeamTableModel,
            PlayerTableModel,
            RefereeTableModel,
            StadiumTableModel;

    //JTable    
    JTable MatchTable,
            TeamTable,
            PlayerTable,
            RefereeTable,
            StadiumTable;

    //JTextField
    JTextField userName;

    //JpasswordFiled
    JPasswordField password;

    //constructor
    public Frame() {

        // JFrame=--------------
        this.admin.intial0_data0();

        this.RESOURCE = "Images\\mainPanelimage.jpg";
        this.url = getClass().getResource(RESOURCE);
        this.mainImage = new ImageIcon(url);

        this.userName = new JTextField();
        this.password = new JPasswordField();
        this.invalidlog = new JLabel("");
        this.userNameLabel = new JLabel(" USERNAME : ");
        this.passwprdLabel = new JLabel(" PASSWORD : ");

        this.AisPlayer = new JRadioButton("Add Player");
        this.AisReferee = new JRadioButton("Add Referee");
        this.AisStadium = new JRadioButton("Add Stadium");
        this.AisMatch = new JRadioButton("Add Match");
        this.AisTeam = new JRadioButton("Add Team");
        this.EisPlayer = new JRadioButton("Edit Player");
        this.EisReferee = new JRadioButton("Edit Referee");
        this.EisStadium = new JRadioButton("Edit Stadium");
        this.EisMatch = new JRadioButton("Edit Match");
        this.EisTeam = new JRadioButton("Edit Team");
        this.DisPlayer = new JRadioButton("Delete Player");
        this.DisReferee = new JRadioButton("Delete Referee");
        this.DisStadium = new JRadioButton("Delete Stadium");
        this.DisMatch = new JRadioButton("Delete Match");
        this.DisTeam = new JRadioButton("Delete Team");

        this.addBG = new ButtonGroup();
        this.editBG = new ButtonGroup();
        this.deleteBG = new ButtonGroup();

        this.validlogin = false;

        this.MatchTablecolumns = new String[]{"#", "Team 1", "Team 2", "Date", "Time", "Referee", "Stadium"};
        this.TeamTablecolumns = new String[]{"#", "Name", "Numper Of Players"};
        this.PlayerTablecolumns = new String[]{"#", "Name", "Team Name", "Height(cm)", "Weight(kg)", "Position"};
        this.RefereeTablecolumns = new String[]{"#", "Name", "Height(cm)", "Weight(kg)"};
        this.StadiumTablecolumns = new String[]{"#", "Name", "Location", "Seat Cspicty"};

        this.PlayerSize = 0; //(Total num of players in league)
        for (int i = 0; i < admin.league.teamList.size(); i++) {
            PlayerSize += admin.league.teamList.get(i).playerList.size();
        }
        this.MatchTabledata = new Object[admin.league.matchList.size()][7];
        this.TeamTabledata = new Object[admin.league.teamList.size()][3];
        this.PlayerTabledata = new Object[PlayerSize][6];
        this.RefereeTabledata = new Object[admin.league.refList.size()][4];
        this.StadiumTabledata = new Object[admin.league.stdList.size()][4];

        //object[][]
        //MatchTabledata
        for (int i = 0; i < admin.league.matchList.size(); i++) {
            MatchTabledata[i][0] = i + 1;
            MatchTabledata[i][1] = admin.league.matchList.get(i).team1.getName();
            MatchTabledata[i][2] = admin.league.matchList.get(i).team2.getName();
            MatchTabledata[i][3] = admin.league.matchList.get(i).getDate();
            MatchTabledata[i][4] = admin.league.matchList.get(i).getTime();
            MatchTabledata[i][5] = admin.league.matchList.get(i).referee.getName();
            MatchTabledata[i][6] = admin.league.matchList.get(i).stadium.getName();
        }

        //TeamTabledata
        for (int i = 0; i < admin.league.teamList.size(); i++) {
            TeamTabledata[i][0] = i + 1;
            TeamTabledata[i][1] = admin.league.teamList.get(i).getName();
            TeamTabledata[i][2] = admin.league.teamList.get(i).playerList.size();
        }

        //PlayerTabledata
        PlayerNumber = 0;
        for (int i = 0; i < admin.league.teamList.size(); i++) {
            for (int j = 0; j < admin.league.teamList.get(i).playerList.size(); j++) {

                PlayerTabledata[PlayerNumber][0] = j + 1;
                PlayerTabledata[PlayerNumber][1] = admin.league.teamList.get(i).playerList.get(j).getName();
                PlayerTabledata[PlayerNumber][2] = admin.league.teamList.get(i).getName();
                PlayerTabledata[PlayerNumber][3] = admin.league.teamList.get(i).playerList.get(j).getHeight();
                PlayerTabledata[PlayerNumber][4] = admin.league.teamList.get(i).playerList.get(j).getWeight();
                PlayerTabledata[PlayerNumber][5] = admin.league.teamList.get(i).playerList.get(j).position;
                PlayerNumber += 1;

            }
        }

        //RefereeTabledata
        for (int i = 0; i < admin.league.refList.size(); i++) {
            RefereeTabledata[i][0] = i + 1;
            RefereeTabledata[i][1] = admin.league.refList.get(i).getName();
            RefereeTabledata[i][2] = admin.league.refList.get(i).getHeight();
            RefereeTabledata[i][3] = admin.league.refList.get(i).getWeight();
        }

        //StadiumTabledata
        for (int i = 0; i < admin.league.stdList.size(); i++) {
            StadiumTabledata[i][0] = i + 1;
            StadiumTabledata[i][1] = admin.league.stdList.get(i).getName();
            StadiumTabledata[i][2] = admin.league.stdList.get(i).getLocation();
            StadiumTabledata[i][3] = admin.league.stdList.get(i).getSeating();
        }

        this.MatchTableModel = new DefaultTableModel(MatchTabledata, MatchTablecolumns);
        this.TeamTableModel = new DefaultTableModel(TeamTabledata, TeamTablecolumns);
        this.PlayerTableModel = new DefaultTableModel(PlayerTabledata, PlayerTablecolumns);
        this.RefereeTableModel = new DefaultTableModel(RefereeTabledata, RefereeTablecolumns);
        this.StadiumTableModel = new DefaultTableModel(StadiumTabledata, StadiumTablecolumns);

        this.MatchTable = new JTable(MatchTableModel) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        this.TeamTable = new JTable(TeamTableModel) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        this.PlayerTable = new JTable(PlayerTableModel) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        this.RefereeTable = new JTable(RefereeTableModel) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        this.StadiumTable = new JTable(StadiumTableModel) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };

        this.showMatchPane = new JScrollPane();
        this.showMatchPane.getViewport().add(MatchTable);
        this.showPlayerPane = new JScrollPane();
        this.showPlayerPane.getViewport().add(PlayerTable);
        this.showRefereePane = new JScrollPane();
        this.showRefereePane.getViewport().add(RefereeTable);
        this.showStadiumPane = new JScrollPane();
        this.showStadiumPane.getViewport().add(StadiumTable);
        this.showTeamPane = new JScrollPane();
        this.showTeamPane.getViewport().add(TeamTable);

        this.mainJLabelImage = new JLabel();
        this.HomePanel = new JPanel();
        this.AdminPanel = new JPanel();
        this.AddPanel = new JPanel();
        this.DeletePanel = new JPanel();
        this.EditPanel = new JPanel();
        this.LoginPanel = new JPanel();
        this.addPlayerp = new JPanel();
        this.addMatchp = new JPanel();
        this.addRefereep = new JPanel();
        this.addStadiump = new JPanel();
        this.addTeamp = new JPanel();
        this.editMatchp = new JPanel();
        this.editPlayerp = new JPanel();
        this.editRefereep = new JPanel();
        this.editStadiump = new JPanel();
        this.editTeamp = new JPanel();
        this.deleteMatchp = new JPanel();
        this.deletePlayerp = new JPanel();
        this.deleteRefereep = new JPanel();
        this.deleteStadiump = new JPanel();
        this.deleteTeamp = new JPanel();

        this.homeButton = new JButton("Home");
        this.adminButton = new JButton("Admin");
        this.matchButton = new JButton("Matches");
        this.teamButton = new JButton("Teams");
        this.playerButton = new JButton("Players");
        this.refereeButton = new JButton("Referees");
        this.stadiumButton = new JButton("Stadiums");
        this.addButton = new JButton("ADD");
        this.deleteButton = new JButton("DELETE");
        this.editButton = new JButton("EDIT");
        this.loginButton = new JButton("Login");
        this.logoutButton = new JButton("Logout");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 720);
        this.setVisible(true);
        this.setLocation(70, 5);
        this.setResizable(false);
        this.setTitle("The Egyption League 2021");
        this.setLayout(null);
        this.add(homeButton);
        this.add(adminButton);
        this.add(HomePanel);
        this.add(AdminPanel);
        this.add(mainJLabelImage);

        //ButtonGroub
        addBG.add(AisPlayer);
        addBG.add(AisTeam);
        addBG.add(AisMatch);
        addBG.add(AisReferee);
        addBG.add(AisStadium);
        editBG.add(EisPlayer);
        editBG.add(EisTeam);
        editBG.add(EisMatch);
        editBG.add(EisReferee);
        editBG.add(EisStadium);
        deleteBG.add(DisPlayer);
        deleteBG.add(DisTeam);
        deleteBG.add(DisMatch);
        deleteBG.add(DisReferee);
        deleteBG.add(DisStadium);

        //Panels=----------------- 
        //homePanel
        HomePanel.setLayout(null);
        HomePanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        HomePanel.setBackground(new Color(0, 0, 0, 0));
        HomePanel.setVisible(true);

        HomePanel.add(matchButton);
        HomePanel.add(teamButton);
        HomePanel.add(playerButton);
        HomePanel.add(refereeButton);
        HomePanel.add(stadiumButton);
        HomePanel.add(showMatchPane);
        HomePanel.add(showTeamPane);
        HomePanel.add(showPlayerPane);
        HomePanel.add(showRefereePane);
        HomePanel.add(showStadiumPane);

        //admin Panel
        AdminPanel.setLayout(null);
        AdminPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
        AdminPanel.setBackground(new Color(0, 0, 0, 0));
        AdminPanel.setVisible(false);

        AdminPanel.add(LoginPanel);
        AdminPanel.add(AddPanel);
        AdminPanel.add(DeletePanel);
        AdminPanel.add(EditPanel);
        AdminPanel.add(addButton);
        AdminPanel.add(editButton);
        AdminPanel.add(deleteButton);
        AdminPanel.add(logoutButton);

        //LoginPanel
        LoginPanel.setLayout(null);
        LoginPanel.setBounds(0, 90, this.getWidth(), this.getHeight() - 90);
        LoginPanel.setBackground(new Color(218, 239, 253));
        LoginPanel.setVisible(false);

        LoginPanel.add(loginButton);
        LoginPanel.add(userName);
        LoginPanel.add(password);
        LoginPanel.add(userNameLabel);
        LoginPanel.add(passwprdLabel);
        LoginPanel.add(invalidlog);

        //AddPanel
        AddPanel.setLayout(null);
        AddPanel.setBounds(0, 90, this.getWidth(), this.getHeight() - 90);
        AddPanel.setBackground(new Color(218, 239, 253));
        AddPanel.setVisible(false);

        AddPanel.add(AisPlayer);
        AddPanel.add(AisMatch);
        AddPanel.add(AisReferee);
        AddPanel.add(AisStadium);
        AddPanel.add(AisTeam);
        AddPanel.add(addPlayerp);
        AddPanel.add(addMatchp);
        AddPanel.add(addTeamp);
        AddPanel.add(addRefereep);
        AddPanel.add(addStadiump);

        //DeletePanel
        DeletePanel.setLayout(null);
        DeletePanel.setBounds(0, 90, this.getWidth(), this.getHeight() - 90);
        DeletePanel.setBackground(new Color(218, 239, 253));
        DeletePanel.setVisible(false);

        DeletePanel.add(DisPlayer);
        DeletePanel.add(DisMatch);
        DeletePanel.add(DisReferee);
        DeletePanel.add(DisStadium);
        DeletePanel.add(DisTeam);
        DeletePanel.add(deleteMatchp);
        DeletePanel.add(deletePlayerp);
        DeletePanel.add(deleteRefereep);
        DeletePanel.add(deleteStadiump);
        DeletePanel.add(deleteTeamp);

        //EditPanel
        EditPanel.setLayout(null);
        EditPanel.setBounds(0, 90, this.getWidth(), this.getHeight() - 90);
        EditPanel.setBackground(new Color(218, 239, 253));
        EditPanel.setVisible(false);

        EditPanel.add(EisPlayer);
        EditPanel.add(EisMatch);
        EditPanel.add(EisReferee);
        EditPanel.add(EisStadium);
        EditPanel.add(EisTeam);
        EditPanel.add(editMatchp);
        EditPanel.add(editPlayerp);
        EditPanel.add(editRefereep);
        EditPanel.add(editStadiump);
        EditPanel.add(editTeamp);

        //Imageas=-------------
        mainJLabelImage.setIcon(mainImage);

        //mainJLabelImage
        mainJLabelImage.setBounds(0, 0, this.getWidth(), this.getHeight());

        //invalidlog
        invalidlog.setBounds(350, 400, 500, 100);
        invalidlog.setFont(new Font("Gill Sans Ultra Bold", 0, 30));
        invalidlog.setForeground(Color.red);

        //userNameLabel
        userNameLabel.setBounds(325, 100, 175, 60);
        userNameLabel.setFont(new Font("SERIF", Font.BOLD, 25));
        userNameLabel.setOpaque(true);
        userNameLabel.setBackground(new Color(206, 89, 255, 230));

        //passwardLabel
        passwprdLabel.setBounds(325, 210, 175, 60);
        passwprdLabel.setFont(new Font("SERIF", Font.BOLD, 25));
        passwprdLabel.setOpaque(true);
        passwprdLabel.setBackground(new Color(206, 89, 255, 230));

        //JTextField
        //userName
        userName.setBounds(500, 100, 400, 60);
        userName.setFont(new Font("SERIF", 0, 20));

        //JPasswordField
        //password
        password.setBounds(500, 210, 400, 60);
        password.setFont(new Font("SERIF", 0, 20));

        //JScrollPane
        //showMatchPane
        showMatchPane.setBounds(0, 90, this.getWidth() - 8, (this.getHeight()) - 120);
        showMatchPane.setBackground(new Color(150, 150, 200));
        showMatchPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        showMatchPane.setVisible(false);

        //showTeamPane
        showTeamPane.setBounds(0, 90, this.getWidth() - 8, (this.getHeight()) - 120);
        showTeamPane.setBackground(new Color(150, 150, 200));
        showTeamPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        showTeamPane.setVisible(false);

        //showPlayerPane
        showPlayerPane.setBounds(0, 90, this.getWidth() - 8, (this.getHeight()) - 120);
        showPlayerPane.setBackground(new Color(150, 150, 200));
        showPlayerPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        showPlayerPane.setVisible(false);

        //showRefereePane
        showRefereePane.setBounds(0, 90, this.getWidth() - 8, (this.getHeight()) - 120);
        showRefereePane.setBackground(new Color(150, 150, 200));
        showRefereePane.getViewport().setBackground(new Color(0, 0, 0, 0));
        showRefereePane.setVisible(false);

        //showStadiumPane
        showStadiumPane.setBounds(0, 90, this.getWidth() - 8, (this.getHeight()) - 120);
        showStadiumPane.setBackground(new Color(150, 150, 200));
        showStadiumPane.getViewport().setBackground(new Color(0, 0, 0, 0));
        showStadiumPane.setVisible(false);

        //JTable
        //MatchTable
        MatchTable.setRowHeight(50);
        MatchTable.setBackground(new Color(218, 239, 253));
        MatchTable.setFont(new Font("Serif", 0, 17));
        MatchTable.setRowSelectionAllowed(true);
        MatchTable.setEditingRow(0);
        MatchTable.setEditingColumn(0);
        MatchTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 25));
        MatchTable.getTableHeader().setForeground(new Color(12, 180, 186));
        MatchTable.getTableHeader().setBackground(new Color(11, 59, 61));
        MatchTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        MatchTable.getColumnModel().getColumn(1).setPreferredWidth(196);
        MatchTable.getColumnModel().getColumn(2).setPreferredWidth(196);
        MatchTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        MatchTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        MatchTable.getColumnModel().getColumn(5).setPreferredWidth(196);
        MatchTable.getColumnModel().getColumn(6).setPreferredWidth(196);

        //TeamTable
        TeamTable.setRowHeight(50);
        TeamTable.setBackground(new Color(218, 239, 253));
        TeamTable.setFont(new Font("Serif", 0, 17));
        TeamTable.setRowSelectionAllowed(true);
        TeamTable.setEditingRow(0);
        TeamTable.setEditingColumn(0);
        TeamTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 25));
        TeamTable.getTableHeader().setForeground(new Color(12, 180, 186));
        TeamTable.getTableHeader().setBackground(new Color(11, 59, 61));
        TeamTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        TeamTable.getColumnModel().getColumn(1).setPreferredWidth(542);
        TeamTable.getColumnModel().getColumn(2).setPreferredWidth(542);

        //PlayerTable
        PlayerTable.setRowHeight(50);
        PlayerTable.setBackground(new Color(218, 239, 253));
        PlayerTable.setFont(new Font("Serif", 0, 17));
        PlayerTable.setRowSelectionAllowed(true);
        PlayerTable.setEditingRow(0);
        PlayerTable.setEditingColumn(0);
        PlayerTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 25));
        PlayerTable.getTableHeader().setForeground(new Color(12, 180, 186));
        PlayerTable.getTableHeader().setBackground(new Color(11, 59, 61));
        PlayerTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        PlayerTable.getColumnModel().getColumn(1).setPreferredWidth(217);
        PlayerTable.getColumnModel().getColumn(2).setPreferredWidth(217);
        PlayerTable.getColumnModel().getColumn(3).setPreferredWidth(217);
        PlayerTable.getColumnModel().getColumn(4).setPreferredWidth(217);
        PlayerTable.getColumnModel().getColumn(5).setPreferredWidth(217);

        //RefereeTable
        RefereeTable.setRowHeight(50);
        RefereeTable.setBackground(new Color(218, 239, 253));
        RefereeTable.setFont(new Font("Serif", 0, 17));
        RefereeTable.setRowSelectionAllowed(true);
        RefereeTable.setEditingRow(0);
        RefereeTable.setEditingColumn(0);
        RefereeTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 25));
        RefereeTable.getTableHeader().setForeground(new Color(12, 180, 186));
        RefereeTable.getTableHeader().setBackground(new Color(11, 59, 61));
        RefereeTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        RefereeTable.getColumnModel().getColumn(1).setPreferredWidth(351);
        RefereeTable.getColumnModel().getColumn(2).setPreferredWidth(351);
        RefereeTable.getColumnModel().getColumn(3).setPreferredWidth(351);

        //StadiumTable
        StadiumTable.setRowHeight(50);
        StadiumTable.setBackground(new Color(218, 239, 253));
        StadiumTable.setFont(new Font("Serif", 0, 17));
        StadiumTable.setRowSelectionAllowed(true);
        StadiumTable.setEditingRow(0);
        StadiumTable.setEditingColumn(0);
        StadiumTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 25));
        StadiumTable.getTableHeader().setForeground(new Color(12, 180, 186));
        StadiumTable.getTableHeader().setBackground(new Color(11, 59, 61));
        StadiumTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        StadiumTable.getColumnModel().getColumn(1).setPreferredWidth(351);
        StadiumTable.getColumnModel().getColumn(2).setPreferredWidth(351);
        StadiumTable.getColumnModel().getColumn(3).setPreferredWidth(351);

        //Radio Buttons
        //AisPlayer
        AisPlayer.setBounds(0, 0, 240, 70);
        AisPlayer.setFont(new Font("SERIF", Font.BOLD, 30));
        AisPlayer.setBackground(new Color(218, 239, 253));

        //AisTeam
        AisTeam.setBounds((((this.getWidth()) / 5) * 1), 0, 240, 70);
        AisTeam.setFont(new Font("SERIF", Font.BOLD, 30));
        AisTeam.setBackground(new Color(218, 239, 253));

        //AisMatch
        AisMatch.setBounds((((this.getWidth()) / 5) * 2), 0, 240, 70);
        AisMatch.setFont(new Font("SERIF", Font.BOLD, 30));
        AisMatch.setBackground(new Color(218, 239, 253));

        //AisReferee
        AisReferee.setBounds((((this.getWidth()) / 5) * 3), 0, 240, 70);
        AisReferee.setFont(new Font("SERIF", Font.BOLD, 30));
        AisReferee.setBackground(new Color(218, 239, 253));

        //AisStadium
        AisStadium.setBounds((((this.getWidth()) / 5) * 4), 0, 240, 70);
        AisStadium.setFont(new Font("SERIF", Font.BOLD, 30));
        AisStadium.setBackground(new Color(218, 239, 253));

        //EisPlayer
        EisPlayer.setBounds(0, 0, 240, 70);
        EisPlayer.setFont(new Font("SERIF", Font.BOLD, 30));
        EisPlayer.setBackground(new Color(218, 239, 253));

        //EisTeam
        EisTeam.setBounds((((this.getWidth()) / 5) * 1), 0, 240, 70);
        EisTeam.setFont(new Font("SERIF", Font.BOLD, 30));
        EisTeam.setBackground(new Color(218, 239, 253));

        //EisMatch
        EisMatch.setBounds((((this.getWidth()) / 5) * 2), 0, 240, 70);
        EisMatch.setFont(new Font("SERIF", Font.BOLD, 30));
        EisMatch.setBackground(new Color(218, 239, 253));

        //EisReferee
        EisReferee.setBounds((((this.getWidth()) / 5) * 3), 0, 240, 70);
        EisReferee.setFont(new Font("SERIF", Font.BOLD, 30));
        EisReferee.setBackground(new Color(218, 239, 253));

        //EisStadium
        EisStadium.setBounds((((this.getWidth()) / 5) * 4), 0, 240, 70);
        EisStadium.setFont(new Font("SERIF", Font.BOLD, 30));
        EisStadium.setBackground(new Color(218, 239, 253));

        //DisPlayer
        DisPlayer.setBounds(0, 0, 240, 70);
        DisPlayer.setFont(new Font("SERIF", Font.BOLD, 30));
        DisPlayer.setBackground(new Color(218, 239, 253));

        //DisTeam
        DisTeam.setBounds((((this.getWidth()) / 5) * 1), 0, 240, 70);
        DisTeam.setFont(new Font("SERIF", Font.BOLD, 30));
        DisTeam.setBackground(new Color(218, 239, 253));

        //DisMatch
        DisMatch.setBounds((((this.getWidth()) / 5) * 2), 0, 240, 70);
        DisMatch.setFont(new Font("SERIF", Font.BOLD, 30));
        DisMatch.setBackground(new Color(218, 239, 253));

        //DisReferee
        DisReferee.setBounds((((this.getWidth()) / 5) * 3), 0, 240, 70);
        DisReferee.setFont(new Font("SERIF", Font.BOLD, 30));
        DisReferee.setBackground(new Color(218, 239, 253));

        //DisStadium
        DisStadium.setBounds((((this.getWidth()) / 5) * 4), 0, 240, 70);
        DisStadium.setFont(new Font("SERIF", Font.BOLD, 30));
        DisStadium.setBackground(new Color(218, 239, 253));

        //JButtons=------------
        //homeButton
        homeButton.setBounds(this.getWidth() / 4, 0, this.getWidth() / 4, 40);
        homeButton.setFont(new Font("Gill Sans Ultra Bold", 0, 20));
        homeButton.setForeground(new Color(64, 29, 50));
        homeButton.addActionListener(this);

        //adminButton
        adminButton.setBounds(this.getWidth() / 2, 0, this.getWidth() / 4, 40);
        adminButton.setFont(new Font("Gill Sans Ultra Bold", 0, 20));
        adminButton.setForeground(new Color(64, 29, 50));
        adminButton.addActionListener(this);

        //matchButton
        matchButton.setBounds((this.getWidth() / 5) * 0, 40, this.getWidth() / 5, 50);
        matchButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        matchButton.setForeground(new Color(64, 29, 50));
        matchButton.addActionListener(this);

        //teamButton
        teamButton.setBounds((this.getWidth() / 5) * 1, 40, this.getWidth() / 5, 50);
        teamButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        teamButton.setForeground(new Color(64, 29, 50));
        teamButton.addActionListener(this);

        //playerButton
        playerButton.setBounds((this.getWidth() / 5) * 2, 40, this.getWidth() / 5, 50);
        playerButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        playerButton.setForeground(new Color(64, 29, 50));
        playerButton.addActionListener(this);

        //refereeButton
        refereeButton.setBounds((this.getWidth() / 5) * 3, 40, this.getWidth() / 5, 50);
        refereeButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        refereeButton.setForeground(new Color(64, 29, 50));
        refereeButton.addActionListener(this);

        //stadiumButton
        stadiumButton.setBounds((this.getWidth() / 5) * 4, 40, this.getWidth() / 5, 50);
        stadiumButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        stadiumButton.setForeground(new Color(64, 29, 50));
        stadiumButton.addActionListener(this);

        //addButton
        addButton.setBounds((this.getWidth() / 4) * 0, 40, this.getWidth() / 4, 50);
        addButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        addButton.setForeground(new Color(64, 29, 50));
        addButton.addActionListener(this);

        //editButton
        editButton.setBounds((this.getWidth() / 4) * 1, 40, this.getWidth() / 4, 50);
        editButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        editButton.setForeground(new Color(64, 29, 50));
        editButton.addActionListener(this);

        //deleteButton
        deleteButton.setBounds((this.getWidth() / 4) * 2, 40, this.getWidth() / 4, 50);
        deleteButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        deleteButton.setForeground(new Color(64, 29, 50));
        deleteButton.addActionListener(this);

        //logoutButton
        logoutButton.setBounds((this.getWidth() / 4) * 3, 40, this.getWidth() / 4, 50);
        logoutButton.setFont(new Font("Gill Sans Ultra Bold", 0, 15));
        logoutButton.setForeground(new Color(64, 29, 50));
        logoutButton.addActionListener(this);

        //loginButton
        loginButton.setBounds(522, 300, 175, 75);
        loginButton.setFont(new Font("Gill Sans Ultra Bold", 0, 25));
        loginButton.setForeground(new Color(64, 29, 50));
        loginButton.addActionListener(this);

    }
    //end of the constructer

    // ACTIONS  &&&& EVENTS_________________________________________________________________
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == homeButton) {
            HomePanel.setVisible(true);
            AdminPanel.setVisible(false);
        } else if (e.getSource() == adminButton) {
            HomePanel.setVisible(false);
            AdminPanel.setVisible(true);
            if (validlogin) {
                LoginPanel.setVisible(false);
                logoutButton.setText("EXIT");
                addButton.setText("ADD");
                editButton.setText("EDIT");
                deleteButton.setText("DELETE");
            } else {
                LoginPanel.setVisible(true);
                logoutButton.setText("");
                addButton.setText("");
                editButton.setText("");
                deleteButton.setText("");
            }
        } else if (e.getSource() == matchButton) {
            showMatchPane.setVisible(true);
            showTeamPane.setVisible(false);
            showPlayerPane.setVisible(false);
            showRefereePane.setVisible(false);
            showStadiumPane.setVisible(false);
        } else if (e.getSource() == teamButton) {
            showMatchPane.setVisible(false);
            showTeamPane.setVisible(true);
            showPlayerPane.setVisible(false);
            showRefereePane.setVisible(false);
            showStadiumPane.setVisible(false);
        } else if (e.getSource() == playerButton) {
            showMatchPane.setVisible(false);
            showTeamPane.setVisible(false);
            showPlayerPane.setVisible(true);
            showRefereePane.setVisible(false);
            showStadiumPane.setVisible(false);
        } else if (e.getSource() == refereeButton) {
            showMatchPane.setVisible(false);
            showTeamPane.setVisible(false);
            showPlayerPane.setVisible(false);
            showRefereePane.setVisible(true);
            showStadiumPane.setVisible(false);
        } else if (e.getSource() == stadiumButton) {
            showMatchPane.setVisible(false);
            showTeamPane.setVisible(false);
            showPlayerPane.setVisible(false);
            showRefereePane.setVisible(false);
            showStadiumPane.setVisible(true);
        } else if (e.getSource() == loginButton) {
            if ((userName.getText().equals(admin.getUsername()))
                    && ((new String(password.getPassword())).equals(admin.getPassword()))) {
                invalidlog.setText("");
                validlogin = true;
                AddPanel.setVisible(true);
                LoginPanel.setVisible(false);
                logoutButton.setText("EXIT");
                addButton.setText("ADD");
                editButton.setText("EDIT");
                deleteButton.setText("DELETE");
                password.setText("");
                userName.setText("");
            } else {
                invalidlog.setText("<ERROR>INVALID INPUT");
                validlogin = false;
                logoutButton.setText("");
                addButton.setText("");
                editButton.setText("");
                deleteButton.setText("");
                password.setText("");
                userName.setText("");
            }
        } //----------------------------------------------------------------------------------------------------------------------------------------       
        else if ((e.getSource() == addButton) && (validlogin == true)) {
            AddPanel.setVisible(true);
            EditPanel.setVisible(false);
            DeletePanel.setVisible(false);
        } else if ((e.getSource() == editButton) && (validlogin == true)) {
            AddPanel.setVisible(false);
            EditPanel.setVisible(true);
            DeletePanel.setVisible(false);
        } else if ((e.getSource() == deleteButton) && (validlogin == true)) {
            AddPanel.setVisible(false);
            EditPanel.setVisible(false);
            DeletePanel.setVisible(true);
        } else if (e.getSource() == logoutButton) {
            validlogin = false;
            AddPanel.setVisible(false);
            EditPanel.setVisible(false);
            DeletePanel.setVisible(false);
            LoginPanel.setVisible(true);
            logoutButton.setText("");
            addButton.setText("");
            editButton.setText("");
            deleteButton.setText("");
        }

    }
}

// end of ACTIONS && EVENTS_________________________________________________________________________________

