package sample;

public class User {
    private String name;
    private int CorrectAnswer;
    private int WrongAnswer;
    private int Mark;
    public String Result;
    public int Error;

    public User() {
        this.CorrectAnswer = 0;
        this.WrongAnswer = 0;
    }

    public void setName(String name) {
        this.name = name;
    }


    void CorrAnswer() {
        int i = 0;
        this.CorrectAnswer++;
        i++;
    }

    public void WrAnswer() {
        int j = 0;
        this.WrongAnswer++;
        j++;
    }

    public void setMark() {
        int a = 51;
        int b = 71;
        int c = 81;
        int percent = 100 * this.CorrectAnswer / (this.CorrectAnswer + this.WrongAnswer);
        this.Error = 1;
        if (percent <= a) {
            this.Mark = 2;
        } else if (percent > a && percent <= b) {
            this.Mark = 3;
        } else if (percent > b && percent <= c) {
            this.Mark = 4;
        } else {
            this.Mark = 5;
        }
        if (a >= b || b >= c || a >= c) {
            this.Error = 0;
        }
    }

    public void OutputResults() {
        this.Result = ("Name: " + this.name
                + "\nCorrect answers: " + this.CorrectAnswer
                + "\nWrong answers: " + this.WrongAnswer
                + "\nMark: " + this.Mark);
    }
}