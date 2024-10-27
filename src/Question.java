public class Question {
    private String clue;
    private String answer;
    private String classType;

    public Question(String clue, String answer, String classType) {
        this.clue = clue;
        this.answer = answer;
        this.classType = classType;
    }

    public Question(String dataLine) {
        String[] dataComps = dataLine.split(",");
        this.classType = dataComps[0];
        this.clue = dataComps[1];
        this.answer = dataComps[2];
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public String getClue() {
        return clue;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getClassType() {
        return classType;
    }

    public String toString() {
        return String.format("%s,%s,%s", classType, clue, answer);
    }

    public boolean equals(Question q) {
        return(clue.equals(q.clue) && answer.equals(q.answer) && classType.equals(q.classType));
    }



    public static void main(String[] args) {
        Question q = new Question("Calculus,What is the derivative of 2x?,2");
        System.out.println(q.toString());
    }

}
