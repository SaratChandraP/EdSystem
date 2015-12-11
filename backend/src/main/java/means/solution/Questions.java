package means.solution;

import java.util.ArrayList;
import java.util.List;

public class Questions {

	public int id;
	public String question;
//	public List<String> answer = new ArrayList<>();
	public ArrayList<String> answer = new ArrayList<>();
//	public ArrayList<String> answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getAnswer() {
		return answer;
	}
	public void setAnswer(ArrayList<String> answer) {
		this.answer = answer;
	}
	public void addAnswer(String answer) {
		this.answer.add(answer);
	}
}