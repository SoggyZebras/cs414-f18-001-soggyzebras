package edu.colostate.cs.cs414.soggyZebras.rollerball.Client.menu;

import edu.colostate.cs.cs414.soggyZebras.rollerball.Client.Client;
import edu.colostate.cs.cs414.soggyZebras.rollerball.Client.game.GameGUI;
import edu.colostate.cs.cs414.soggyZebras.rollerball.Game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * represents the main menu screen (current games, history, new game)
 */
public class MainMenuPanel extends MenuPanel {
    public MainMenuPanel(MenuGUI menuGUI) {
        super("main_menu", menuGUI);

        JLabel title = new JLabel("Active Games");
        add(title);

        DefaultListModel<String> activeGamesListModel = new DefaultListModel();

        // TODO: actually get active games from server
        activeGamesListModel.add(0, "game 1");
        activeGamesListModel.add(1, "game 2");
        activeGamesListModel.add(2, "game 3");

        JList<String> activeGamesList = new JList<>(activeGamesListModel);
        activeGamesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScroller = new JScrollPane(activeGamesList);
        listScroller.setPreferredSize(new Dimension(250, 100));
        add(listScroller);

        add(createLinkedActionButton("Start Selected Game", new StartGameListener(activeGamesList)));
        add(createLinkedButton("Invite Players", "create_invite"));
        add(createLinkedButton("Pending Invites", "pending_invites"));
        add(createLinkedButton("Game History", "game_history"));
        add(createLinkedButton("Logout", "register_login"));
        add(createLinkedButton("Unregister", "register_login"));
    }


    class StartGameListener implements ActionListener {
        private JList<String> gamesList;

        public StartGameListener(JList<String> gamesListModel) {
            this.gamesList = gamesListModel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String selectedGame = gamesList.getSelectedValue();
                // TODO: get game id
                System.err.println(selectedGame);
                Map m = new HashMap();
                new GameGUI(new Client("127.0.0.1",5003), new Game(m));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
