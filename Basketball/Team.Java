// This class utilizes an array of class Player

import java.util.Arrays;

public class Team {
    Player[] team;

    // takes in a team array to make a team
    public Team (Player[] players){
        setTeam(players);
    }

    // Get team
    public Player[] getTeam(){
        return team;
    }

    // Allows for the team to be set, making a deep copy of it
    public void setTeam (Player[] players){
        Player[] copy = new Player[players.length];
        for (int i = 0; i<copy.length; i++){
            copy[i] = new Player(players[i].getName(), players[i].getPosition(), players[i].getPointsPerGame(), players[i].getFgPercent(), players[i].getFtPercent(), players[i].getTpPercent());
        }
        this.team = copy;
    }

    // Get the field goal percent average of the team
    public double FGAverage(){
        double totalFG = 0;
        double FGAverage = 0;
        for (int player = 0; player < team.length; player++){
            totalFG += getTeam()[player].getFgPercent();
        }
        FGAverage = totalFG/ team.length;
        return FGAverage;
    }

    // Count how many people on the team are a part of a position, ignore case needed for position
    public int positionCount(String pos){
        int count = 0;
        for (int player = 0; player < team.length; player++) {
            if (getTeam()[player].getPosition().equalsIgnoreCase(pos)){
                count += 1;
            }
        }
        return count;
    }

    // Returns an array that has all the players in order of descending free throw percents
    public Player[] sort(){
        Player[] copy = new Player[team.length];
        for (int i = 0; i<copy.length; i++){
            copy[i] = new Player(team[i].getName(), team[i].getPosition(), team[i].getPointsPerGame(), team[i].getFgPercent(), team[i].getFtPercent(), team[i].getTpPercent());
        }
        for (int i = 0; i<team.length; i++){
            for (int j = i + 1; j<team.length;j++){
                Player temp;
                if (copy[i].getFtPercent() < copy[j].getFtPercent()){
                    temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }

            }
        }
        return copy;
    }

    // Checks to see if a player is a part of the team array
    public boolean onTeam(String name){
        boolean present = false;
        for (int player = 0; player < team.length; player++) {
            if (getTeam()[player].getName().equals(name)){
                present = true;
            }
        }
        return present;
    }

    // Returns the player who has the best three pointer percentage
    public Player best3pt(){
        Player best = getTeam()[0];
        for (int player = 0; player < team.length; player++) {
            if (getTeam()[player].getTpPercent() > best.getTpPercent()){
                best = getTeam()[player];
            }
        }
        return best;
    }

    // Create the print statement for Team
    @Override
    public String toString() {
        return "Team{" +
                "team=" + Arrays.toString(team) +
                '}';
    }

    // New equals method to see if an array contains all the same values as another array
    @Override
    public boolean equals(Object otherObject){
        if (otherObject == null) {return false;}
        if (otherObject == this) {return true;}
        if (otherObject instanceof Team) {
            Team otherTeam = (Team) otherObject;
            if (Arrays.equals(this.getTeam(), otherTeam.getTeam())){
                return true;
            }
        }
        return false;
    }
}
