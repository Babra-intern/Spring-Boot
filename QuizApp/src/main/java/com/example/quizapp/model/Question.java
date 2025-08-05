package com.example.quizapp.model;


import jakarta.persistence.*;


@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String rightAnswers;
    private String category;
    private String difficulty;
    private String question;




    public Question(){
        this.questionTitle = "Question Title";
        this.option1 = "Option 1";
        this.option2 = "Option 2";
        this.option3 = "Option 3";
        this.rightAnswers = "rightAnswers";
        this.category = "Category";
        this.difficulty = "Difficulty";
        this.question = "Question";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getQuestionTitle() {
        return questionTitle;
    }
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public String getOption2() {
        return option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public String getOption3() {
        return option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public String getRightAnswers() {
        return rightAnswers;
    }
    public void setRightAnswers(String rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
