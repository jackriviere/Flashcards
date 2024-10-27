import java.io.*;

public class FlashcardDatabase {
    String[] classes;
    Question[] allQuestions;
    Question[][] questionsByClass;
    String fileName;

    public FlashcardDatabase(String fileName) {
        this.fileName = fileName;
        readClasses();
        readAllQuestions();
        createQuestionsByClass();
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
                        questionsByClass[i] = tempQuestions;
                    }
                }
            }
        }
    }

    public void addClass(String classType) {
        String[] tempClasses = new String[classes.length + 1];
        for (int i = 0; i < classes.length; i++) {
            tempClasses[i] = classes[i];
        } tempClasses[tempClasses.length - 1] = classType;
        classes = tempClasses;
        createQuestionsByClass();
    }

    public void removeClass(String classType) {
        String[] tempClasses = new String[classes.length - 1];
        for (int i = 0, j = 0; i < classes.length; i++) {
            if (classes[i].equals(classType)) {
                continue;
            } else {
                tempClasses[j] = classes[i];
                j++;
            }
        } classes = tempClasses;
        createQuestionsByClass();
    }

    public void addQuestion(Question newQuestion) {
        Question[] tempQuestions = new Question[allQuestions.length + 1];
        for (int i = 0; i < allQuestions.length; i++) {
            tempQuestions[i] = allQuestions[i];
        } tempQuestions[tempQuestions.length - 1] = newQuestion;
        allQuestions = tempQuestions;
        createQuestionsByClass();
    }

    public void removeQuestion(Question badQuestion) {
        Question[] tempQuestions = new Question[allQuestions.length - 1];
        for (int i = 0, j = 0; i < allQuestions.length; i++) {
            if (allQuestions[i].equals(badQuestion)) {
                continue;
            } else {
                tempQuestions[j] = allQuestions[i];
                j++;
            }
        }
        allQuestions = tempQuestions;
        createQuestionsByClass();
    }

    public void writeFile() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName))) {
            for (int i = 0; i < classes.length; i++) {
                pw.print(classes[i]);
                if (i != classes.length - 1) {
                    pw.print(",");
                }
            }
            pw.print("\n");
            for (Question q : allQuestions) {
                pw.println(q.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getClasses() {
        return classes;
    }

    public void setClasses(String[] classes) {
        this.classes = classes;
    }

    public Question[] getAllQuestions() {
        return allQuestions;
    }

    public void setAllQuestions(Question[] allQuestions) {
        this.allQuestions = allQuestions;
    }

    public Question[][] getQuestionsByClass() {
        return questionsByClass;
    }

    public void setQuestionsByClass(Question[][] questionsByClass) {
        this.questionsByClass = questionsByClass;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        FlashcardDatabase f = new FlashcardDatabase("data.txt");
        f.addClass("Stats");
        f.addQuestion(new Question("Stats,What is the median?,Middle Value"));
        f.writeFile();
    }
}


