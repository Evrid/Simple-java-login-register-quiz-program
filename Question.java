package Quiz;
import java.awt.*; 
import javax.swing.*;


public abstract class Question 
//Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
{
	
static int nQuestions;
static int nCorrect;
QuestionDialog question;
String correctAnswer;

public Question(String query) {
	this.question = new QuestionDialog();  //The this keyword refers to the current object in a method or constructor.
	this.question.setLayout(new GridLayout(0,1));
	//this.question.add(new JLabel(" "+question+"	",JLabel.CENTER));
	this.question.add(new JLabel(" "+query+"	",JLabel.CENTER));
}
void initQuestionDialog() {
	
	this.question.setModal(true);
	this.question.pack();
	this.question.setLocationRelativeTo(null);
}
public static void showResults()
{
        JOptionPane.showMessageDialog(null, "Number of Questions: " +nQuestions + "\n Correct Answers:" + nCorrect, "Message",
                JOptionPane.INFORMATION_MESSAGE);
    } 

public static String GiveResults()   //newly added
{
return String.valueOf(nCorrect);
//	return nCorrect;
}

public void check()
{
nQuestions++;
String answer=ask();
if (answer.equals(correctAnswer)) {
JOptionPane.showMessageDialog(null, "Correct!");
nCorrect++;
} 
else 
{
JOptionPane.showMessageDialog(null, "Sorry, Your Answer is incorrect");
}
    }
String ask() {
        question.setVisible(true);
        return question.answer;
    }

}
