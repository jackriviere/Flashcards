import java.io.*;

public class FlashcardDatabase {
    String[] classes;
    Question[] allQuestions;
    Question[][] questionsByClass;
    String fileName;

    public FlashcardDatabase(String fileName) {
        classes = null;
        questionsByClass = null;
        allQuestions = null;
        this.fileName = fileName;
    }

    public void readClasses() {
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {
            classes = bfr.readLine().split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAllQuestions() {
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {
            bfr.readLine();  // skips past line with classes
            String line = bfr.readLine();
            int counter = 0;
            while (line != null) {
                counter++;
                line = bfr.readLine();
            } allQuestions = new Question[counter];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader bfr = new BufferedReader(new FileReader(fileName))) {
            bfr.readLine(); // skips past line with classes
            String data = bfr.readLine();
            int counter = 0;
            while (data != null) {
                allQuestions[counter] = new Question(data);
                counter++;
                data = bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createQuestionsByClass() {
        questionsByClass = new Question[classes.length][];
        for (int i = 0; i < questionsByClass.length; i++) {
            for (int j = 0; j < allQuestions.length; j++) {
                if (classes[i].equals(allQuestions[j].getClassType())) {
                    if (questionsByClass[i] == null) {
                        questionsByClass[i] = new Question[]{allQuestions[j]};
                    } else {
                        Question[] tempQuestions = new Question[questionsByClass[i].length + 1];
                        for (int k = 0; k < questionsByClass[i].length; k++) {
                            tempQuestions[k] = questionsByClass[i][k];
                        } tempQuestions[tempQuestions.length - 1] = allQuestions[j];
                    }
                }
            }
        }
    }

    public Question[] getAllQuestions() {
        return allQuestions;
    }

    public static void main(String[] args) {
        FlashcardDatabase f = new FlashcardDatabase("data.txt");
        f.readClasses();
        f.readAllQuestions();
        for (int i = 0; i < f.allQuestions.length; i++) {
            System.out.println(f.allQuestions[i].toString());
        }
    }

}
