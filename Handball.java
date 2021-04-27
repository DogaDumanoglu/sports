public class Handball extends Sports{
    public Handball(String clubName) {
        super(clubName);
    }

    public int calculatePoint(int score, int scoreAgainst){
        //This method calculate Point
        if (score> scoreAgainst) {
            return 2;
        }
        else if(score==scoreAgainst){
            return 1;
        }
        return 0;
    }
}
