import java.awt.event.*;

public class Handling implements ActionListener {
    private HomeScreen homeScreen;
    private FlashcardClueScreen flashcardClueScreen;
    FlashcardDatabase database;


    public Handling(HomeScreen homeScreen, String fileName) {
        this.homeScreen = homeScreen;
        this.database = new FlashcardDatabase(fileName);
    }

    public Handling(FlashcardClueScreen flashcardScreen, String fileName) {
        this.flashcardClueScreen = flashcardScreen;
        this.database = new FlashcardDatabase(fileName);
    }

    public Handling(FlashcardClueScreen flashcardClueScreen, HomeScreen homeScreen, String fileName) {
        this.flashcardClueScreen = flashcardClueScreen;
        this.homeScreen = homeScreen;
        this.database = new FlashcardDatabase(fileName);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (homeScreen != null && e.getSource() == this.homeScreen.goButton) {
            FlashcardClueScreen flashcardScreen = new FlashcardClueScreen(database.getAllQuestions()[0].getClue());
        } else if (flashcardClueScreen != null && e.getSource() == this.flashcardClueScreen) {
            FlashcardClueScreen flashcardClueScreen1 = new FlashcardClueScreen(database.getAllQuestions()[0].getAnswer());
        }
    }



    public HomeScreen getHomeScreen() {
        return homeScreen;
    }

    public void setHomeScreen(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    public FlashcardClueScreen getFlashcardScreen() {
        return flashcardClueScreen;
    }

    public void setFlashcardScreen(FlashcardClueScreen flashcardScreen) {
        this.flashcardClueScreen = flashcardScreen;
    }

    public FlashcardDatabase getDatabase() {
        return database;
    }

    public void setDatabase(FlashcardDatabase database) {
        this.database = database;
    }

    public static void main(String[] args) {
        Handling h = new Handling(new HomeScreen(), "data.txt");
        h.homeScreen.addClasses(h.database.getClasses());
        h.homeScreen.setVisible(true);
    }

}
