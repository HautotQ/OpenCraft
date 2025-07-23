package net.tabarcraft.opencraft;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Question)) return false;
        Question other = (Question) obj;
        return Objects.equals(query, other.query) && Objects.equals(answer, other.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(query, answer);
    }

    @Override
    public String toString() {
        return query + " → " + answer;
    }
}


