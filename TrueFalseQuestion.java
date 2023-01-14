package Quiz;
import java.awt.event.*;
import javax.swing.*;
public class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String question, String answer) {
        super(question);
        //The super keyword in Java is a reference variable which is used to refer immediate parent class object
        JPanel buttons = new JPanel();
        addButton(buttons, "TRUE");
        addButton(buttons,"FALSE");
        this.question.add(buttons);
        initQuestionDialog();
        correctAnswer = answer;
        answer = answer.toUpperCase();
        if (answer.equals("T") || answer.equals("TRUE") || answer.equals("Y") || 
answer.equals("YES")) correctAnswer = "TRUE";
        if (answer.equals("F") || answer.equals("FALSE") || answer.equals("N") || 
answer.equals("NO")) correctAnswer = "FALSE";
    }
    void addButton(JPanel buttons, String label) {
        JButton button = new JButton(label);
        button.addActionListener(question);
        buttons.add(button);
    }
}


