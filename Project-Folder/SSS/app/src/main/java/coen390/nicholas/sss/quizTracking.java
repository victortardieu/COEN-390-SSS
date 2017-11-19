package coen390.nicholas.sss;

public class quizTracking
{
    //-------------------------------------Variables to set the lvl list---------------------------------------------
    private String lvl;
    private String lvlDescription;
    private int totalQ;

    //-------------------------------------tracking variables for quizzes---------------------------------------------
    private int nmbCorrect;
    int questionCompletion[] = new int[26];

    //---------------------------------------------Quiz Questions-------------------------------------------------
    private static String questions[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    //----------------------------------------------------Constructor--------------------------------------------------------
    public quizTracking(int level, String description)
    {
        lvl = "Level " + level; lvlDescription = description;

       if (level == 1){totalQ = 26;}
        else {totalQ = 5;}
    }

    //--------------------------------------------------------Getters--------------------------------------------------------
    //get the level
    public String getLevel(){return lvl;}

    //get the description
    public String getDescription() { return lvlDescription;}

    public String getScore() { return "Score: " + nmbCorrect + "/" + totalQ;}

    public int getNmbCorrect() { return nmbCorrect;}

    public static String getQuestion(int q){ return questions[q];}

    public int getTotal(){ return totalQ;}

    //-------------------------------------------------------Setters--------------------------------------------------------
    public void setCorrect() { if (nmbCorrect < totalQ) {nmbCorrect += 1;}}

    public void setNewGame() { nmbCorrect = 0;}

}
