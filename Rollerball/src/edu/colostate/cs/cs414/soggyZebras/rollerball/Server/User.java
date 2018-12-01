package edu.colostate.cs.cs414.soggyZebras.rollerball.Server;

import edu.colostate.cs.cs414.soggyZebras.rollerball.Transport.TCPConnection;

import java.util.ArrayList;

public class User {

    //Local variables
    private int userID;
    private String username;
    private String password;
    private String email;
    private TCPConnection userConnection;
    private ArrayList<Invite> sentInvites;
    private ArrayList<Invite> gotInvites;

    //Constructors
    public User(int uID, String username, String password, TCPConnection con){
        this.userID = uID;
        this.username = username;
        this.password = password;
        this.userConnection = con;
    }

    //Get and Set

    public void setUserID(int uID){
        this.userID = uID;
    }

    public int getUserID(){
        return userID;
    }

    public void setUserConnection(TCPConnection con){
        this.userConnection = con;
    }

    public TCPConnection getUserConnection(){
        return userConnection;
    }

    //Wrapper wrapper for TCPConnection send method
    public void sendData(String data){
        this.userConnection.sendData(data);
    }

    public boolean containsInviteID(int id){
        for(Invite i : gotInvites){
            if(i.getInviteID() == id){
                return true;
            }
        }

        for(Invite i : sentInvites){
            if(i.getInviteID() == id){
                return true;
            }
        }

        return false;
    }

    public void addInviteSent(Invite inv){
        this.sentInvites.add(inv);
    }

    public void addInviteGot(Invite inv){
        this.gotInvites.add(inv);
    }

    public void removeInviteSent(int id){
        for(Invite i : sentInvites){
            if(i.getInviteID() == id){
                sentInvites.remove(i);
            }
        }
    }

    public void removeInviteGot(int id){
        for (Invite i : gotInvites){
            if(i.getInviteID() == id){
                gotInvites.remove(i);
            }
        }
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}
