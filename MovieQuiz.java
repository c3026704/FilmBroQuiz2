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
