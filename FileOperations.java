import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileOperations {
    /*ReadFromFile function reads the lines from the file. Returns the list.
     *if a problem is encountered throws IOException.*/
    public static List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    private static Sports getClub(HashMap<String,Sports> clubs, String clubName, String sportType) {
        /*If object does not exist it creates a new object else it returns Sport Type(Basketball,Voleyball..) Object*/
        if(!clubs.containsKey(clubName)) {
            switch(sportType){
                case "B": clubs.put(clubName, new Basketball(clubName)); break;
                case "I": clubs.put(clubName, new IceHockey(clubName)); break;
                case "H": clubs.put(clubName, new Handball(clubName)); break;
                case "V": clubs.put(clubName, new Volleyball(clubName)); break;
                default: break;
            }
        }

        return clubs.get(clubName);
    }

    public static void readFixtures(String path) throws Exception {
        /*Reads and assigns variables to the required Sport Type*/
        List<String> lines = readFile(path);
        HashMap<String, HashMap<String, Sports>> clubs = new HashMap<>();
        clubs.put("B", new HashMap<String, Sports>());
        clubs.put("I", new HashMap<String, Sports>());
        clubs.put("H", new HashMap<String, Sports>());
        clubs.put("V", new HashMap<String, Sports>());
        for (String line : Objects.requireNonNull(lines)) {
            String[] fixturesInfosArray = line.split("\t");
            String sportType = fixturesInfosArray[0];
            String clubName1 = fixturesInfosArray[1];
            String clubName2 = fixturesInfosArray[2];
            String matchResult = fixturesInfosArray[3];
            String[] scores = matchResult.split(":");
            int score1 = Integer.parseInt(scores[0]);
            int score2 = Integer.parseInt(scores[1]);
            Sports s1 = getClub(clubs.get(sportType), clubName1, sportType);
            Sports s2 = getClub(clubs.get(sportType), clubName2, sportType);
            s1.addMatch(score1, score2);
            s2.addMatch(score2, score1);
        }

        for (Map.Entry<String, HashMap<String, Sports>> sportTypes : clubs.entrySet()) {
            List<Sports> sportList = new ArrayList<>();
            for (Map.Entry<String, Sports> kv : sportTypes.getValue().entrySet()) {
                //It adds HashMap values in a List for sort
                sportList.add(kv.getValue());
            }

            Collections.sort(sportList);

            String output = "";
            for (Sports s : sportList) {
                //Writes the output
                output += (sportList.indexOf(s)+1+".")+s.toString() + "\n";
            }
            String fileName = "";
            switch(sportTypes.getKey()) {
                //It creates a file by using Object Class names
                case "B" : fileName = "basketball.txt";break;
                case "I" : fileName = "iceHockey.txt";break;
                case "V" : fileName = "volleyball.txt";break;
                case "H" : fileName = "handball.txt";break;
            }
            Files.write(Paths.get(fileName), output.getBytes());
        }
    }

}
