package net.tabarcraft.opencraft;

import java.io.*;
import java.nio.file.*;
import javafx.collections.*;

public class QuestionStore {
    private final ObservableList<Question> questions = FXCollections.observableArrayList();
    private static final String SAVE_PATH = "questions.txt"; // nouveau fichier texte

    public QuestionStore() {
        loadQuestions();
    }

    public ObservableList<Question> getObservableQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
        saveQuestions();
    }

    public void deleteQuestion(Question question) {
        questions.remove(question);
        saveQuestions();
    }

    public void saveQuestions() {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAVE_PATH))) {
            for (Question q : questions) {
                writer.write(q.getQuery());
                writer.newLine();
                writer.write(q.getAnswer());
                writer.newLine();
                writer.newLine(); // ligne vide entre questions
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadQuestions() {
        Path path = Paths.get(SAVE_PATH);
        if (!Files.exists(path)) return;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            questions.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String question = line.trim();
                if (question.isEmpty()) {
                    // ignore lignes vides
                    continue;
                }
                String answer = reader.readLine(); // lecture réponse suivante
                if (answer == null) {
                    // fichier mal formé : question sans réponse
                    break;
                }
                questions.add(new Question(question, answer.trim()));

                // optionnel : sauter une ligne vide éventuelle entre questions
                reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateQuestion(Question question) {
        // On force la notification d'un changement dans la liste observable
        int index = questions.indexOf(question);
        if (index >= 0) {
            // Remplacer l'élément à son propre index déclenche la notification
            questions.set(index, question);
            saveQuestions();
        }
    }
}
