public class Question {
    private String question;
    private String answer;
    private String classType;

    public Question(String question, String answer, String classType) {
        this.question = question;
        this.answer = answer;
        this.classType = classType;
    }

    public Question(String dataLine) {
        String[] dataComps = dataLine.split(",");
        this.classType = dataComps[0];
        this.question = dataComps[1];
        this.answer = dataComps[2];
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
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
        return String.format("%s,%s,%s", classType, question, answer);
    }





    public static void main(String[] args) {
        Question q = new Question("Calculus,What is the derivative of 2x?,2");
        System.out.println(q.toString());
    }

}
