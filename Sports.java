public class Sports implements Comparable<Sports> {
    public String getClubName() {
        return clubName;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public int getTie() {
        return tie;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTotalScoreAgainst() {
        return totalScoreAgainst;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    private String clubName;
    private int win;
    private int lose;
    private int tie;
    private int totalScore;
    private int totalScoreAgainst;
    private int totalPoint;

    public Sports(String clubName) {
        this.clubName = clubName;
        this.win = 0;
        this.lose = 0;
        this.tie = 0;
        this.totalScore = 0;
        this.totalScoreAgainst = 0;
        this.totalPoint = 0;

    }

    public void addMatch(int score, int scoreAgainst) throws Exception{
        this.totalScore += score;
        this.totalScoreAgainst += scoreAgainst;
        this.totalPoint += calculatePoint(score, scoreAgainst);
        if (score > scoreAgainst) {
            this.win++;
        } else if (score < scoreAgainst) {
            this.lose++;
        } else {
            this.tie++;
        }
    }

    public int calculatePoint(int score, int scoreAgainst) throws Exception {
        throw new Exception("Not Implemented");
    }

    @Override
    public int compareTo(Sports o) {
        //It sorts by comparing matchResults
        if (o.getTotalPoint() < this.getTotalPoint()) {
            return -1;
        } else if (o.getTotalPoint() > this.getTotalPoint()) {
            return 1;
        }

        if (o.getTotalScore() - o.getTotalScoreAgainst() < this.getTotalScore() - this.getTotalScoreAgainst())
            //It finds The bigger the goal difference, the better.
            return  -1;

        return 1;
    }

    public String toString() {
        //It writes on output
        return "\t" +this.getClubName() + "\t" +(this.win+this.lose+this.tie)+ "\t" +this.win+"\t"+this.tie+"\t"+this.lose+"\t"
                +this.getTotalScore() + ":" + this.getTotalScoreAgainst()+"\t"+this.getTotalPoint();
    }
}
