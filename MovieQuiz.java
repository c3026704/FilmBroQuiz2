import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieQuiz {

    static class Question {
        String question;
        List<String> choices;
        String answer;
        int correctIndex; // Index of the correct answer in the shuffled list

        public Question(String question, List<String> choices, String answer) {
            this.question = question;
            this.choices = new ArrayList<>(choices);
            this.answer = answer;
            // Shuffle choices to randomize the position of the correct answer
            Collections.shuffle(this.choices);
            // Determine the index of the correct answer in the shuffled list
            this.correctIndex = this.choices.indexOf(answer);
        }
    }

    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private JFrame frame;
    private JPanel panel;
    private JLabel questionLabel;
    private JRadioButton[] choiceButtons;
    private JButton nextButton;
    private JButton endButton;
    private ButtonGroup choicesGroup;
    private void initializeQuestions() {
        questions.add(new Question(
                "Which film was directed by Jean-Luc Godard?",
                List.of("Breathless", "2001: A Space Odyssey", "Psycho", "The Godfather"),
                "Breathless"
        ));
        questions.add(new Question(
                "Who directed 'A Clockwork Orange'?",
                List.of("Stanley Kubrick", "Alfred Hitchcock", "Woody Allen", "Ingmar Bergman"),
                "Stanley Kubrick"
        ));
        questions.add(new Question(
                "Which movie is a classic Hitchcock thriller?",
                List.of("Vertigo", "The Shining", "Raging Bull", "Tokyo Story"),
                "Vertigo"
        ));
        questions.add(new Question(
                "Which film was directed by Andrei Tarkovsky?",
                List.of("Solaris", "The Seventh Seal", "The Godfather", "Inception"),
                "Solaris"
        ));
        questions.add(new Question(
                "Who directed '8½'?",
                List.of("Federico Fellini", "David Lynch", "Martin Scorsese", "Alfred Hitchcock"),
                "Federico Fellini"
        ));
        questions.add(new Question(
                "Which movie is known for its surreal imagery by David Lynch?",
                List.of("Mulholland Drive", "Casablanca", "Psycho", "The Godfather"),
                "Mulholland Drive"
        ));
        questions.add(new Question(
                "Which film is a classic by Ingmar Bergman?",
                List.of("The Seventh Seal", "The Shining", "Jurassic Park", "Inception"),
                "The Seventh Seal"
        ));
        questions.add(new Question(
                "Which film was directed by Akira Kurosawa?",
                List.of("Seven Samurai", "Pulp Fiction", "Forrest Gump", "The Matrix"),
                "Seven Samurai"
        ));
        questions.add(new Question(
                "Who directed 'The Last Emperor'?",
                List.of("Bernardo Bertolucci", "Jean-Luc Godard", "Woody Allen", "David Fincher"),
                "Bernardo Bertolucci"
        ));
        questions.add(new Question(
                "Which film is known for its innovative use of special effects by Stanley Kubrick?",
                List.of("2001: A Space Odyssey", "Titanic", "Avatar", "The Godfather"),
                "2001: A Space Odyssey"
        ));
        questions.add(new Question(
                "Which film features a famous scene with a shower?",
                List.of("Psycho", "Inception", "The Matrix", "The Godfather"),
                "Psycho"
        ));
        questions.add(new Question(
                "Who directed 'Goodfellas'?",
                List.of("Martin Scorsese", "Francis Ford Coppola", "Quentin Tarantino", "Woody Allen"),
                "Martin Scorsese"
        ));
        questions.add(new Question(
                "Which film was a major influence on the French New Wave?",
                List.of("Breathless", "Pulp Fiction", "Casablanca", "The Godfather"),
                "Breathless"
        ));
        questions.add(new Question(
                "Who directed 'Taxi Driver'?",
                List.of("Martin Scorsese", "David Lynch", "Stanley Kubrick", "Andrei Tarkovsky"),
                "Martin Scorsese"
        ));
        questions.add(new Question(
                "Which film is known for its use of nonlinear storytelling by Quentin Tarantino?",
                List.of("Pulp Fiction", "The Godfather", "Citizen Kane", "The Shining"),
                "Pulp Fiction"
        ));
    }
    private void initializeGUI() {
        frame = new JFrame("FilmBro Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        showWelcomeScreen();
    }

    private void showWelcomeScreen() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to the FilmBro Quiz!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start Quiz");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(welcomePanel);
                initializeQuizScreen();
            }
        });
        welcomePanel.add(startButton, BorderLayout.SOUTH);

        frame.add(welcomePanel);
        frame.setVisible(true);
    }
