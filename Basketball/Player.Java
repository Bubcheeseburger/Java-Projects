// This class defines qualities for an indvidual player and methods to change them

public class Player {
    String name;
    String position;
    double pointsPerGame;
    double fgPercent;
    double tpPercent;
    double ftPercent;

    // Default Player Values
    public Player(){
        setName("");
        setPosition("");
        setPointsPerGame(0);
        setFgPercent(0);
        setTpPercent(0);
        setFtPercent(0);
    }

    // Allows for the ability to fill in parameter values
    public Player(String name, String position, double pointsPerGame, double fgPercent, double ftPercent, double tpPercent){
        setName(name);
        setPosition(position);
        setPointsPerGame(pointsPerGame);
        setFgPercent(fgPercent);
        setFtPercent(ftPercent);
        setTpPercent(tpPercent);
    }

    // Returns name
    public String getName() {
        return name;
    }

    // Sets the name
    public void setName(String name) {
        this.name = name;
    }

    // Returns position
    public String getPosition() {
        return position;
    }


    // Set the position, ignore case needed
    public void setPosition(String position) {
        if (position.equalsIgnoreCase("center") || position.equalsIgnoreCase("guard") ||position.equalsIgnoreCase("forward")){
            this.position = position;
        }else {
            this.position = " ";
        }
    }


    // Get points per game
    public double getPointsPerGame() {
        return pointsPerGame;
    }

    // Set points per game
    public void setPointsPerGame(double pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }

    // Get field goal percent
    public double getFgPercent() {
        return fgPercent;
    }

    // Set field goal percent
    public void setFgPercent(double fgPercent) {
        this.fgPercent = fgPercent;
    }

    // Get three pointer percent
    public double getTpPercent() {
        return tpPercent;
    }

    // Set three pointer percent
    public void setTpPercent(double tpPercent) {
        this.tpPercent = tpPercent;
    }

    // Get free throw percent
    public double getFtPercent() {
        return ftPercent;
    }

    // Set free throw percent
    public void setFtPercent(double ftPercent) {
        this.ftPercent = ftPercent;
    }

    // Creates the print statement for Player
    public String toString() {
        return "Player{" +
                "name='" + name +
                ", position=" + position +
                ", pointsPerGame='" + pointsPerGame +
                ", fieldGoalPercentage=" + fgPercent +
                ", freeThrowPercentage=" + ftPercent +
                ", threePointerPercentage=" + tpPercent +
                '}';
    }

    // New equals method inorder to compare names and position, ignore case needed for position
    @Override
    public boolean equals(Object otherObject){
        if (otherObject == null) {return false;}
        if (otherObject == this) {return true;}
        if (otherObject instanceof Player) {
            Player otherPlayer = (Player) otherObject;
            if (this.getName().equals(otherPlayer.getName()) && this.getPosition().equalsIgnoreCase(otherPlayer.getPosition())){
                return true;
            }
        }
        return false;
    }

}
