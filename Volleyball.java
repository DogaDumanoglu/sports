public class Volleyball extends Sports {
    public Volleyball(String clubName) {
        super(clubName);
    }

    public int calculatePoint(int score, int scoreAgainst){
        //This method calculates Point
        if (score == 3) {
            if (scoreAgainst == 1 || scoreAgainst == 0) {
                return 3;
            } else {
                return 2;
            }
        }

        if (score == 2) {
            return 1;
        }
        return 0;
    }
}
