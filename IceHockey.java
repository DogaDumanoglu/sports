public class IceHockey extends Sports {
    public IceHockey(String clubName) {
        super(clubName);
    }

    public int calculatePoint(int score, int scoreAgainst){
        //This method calculate Point
        if (score> scoreAgainst) {
            return 3;
        }
        else if(score==scoreAgainst){
            return 1;
        }
        return 0;
    }
}
