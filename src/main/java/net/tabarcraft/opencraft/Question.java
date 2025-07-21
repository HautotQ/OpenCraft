package net.tabarcraft.opencraft;

public class Question {
    private String query;
    private String answer;

    public Question(String query, String answer) {
        this.query = query;
        this.answer = answer;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

