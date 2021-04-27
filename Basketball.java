public class Basketball extends Sports {
    public Basketball(String clubName) {
        super(clubName);
    }

    public int calculatePoint(int score, int scoreAgainst){
        //This method calculates Point
        if (score > scoreAgainst) {
            return 2;
        }

        if (score < scoreAgainst) {
            return 1;
        }

        return 0;
    }
}
