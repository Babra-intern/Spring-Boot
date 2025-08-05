package com.example.quizapp.dao;


import com.example.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> getAllQuestionsByCategory(String category);

    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q where q.category =: category ORDER BY  RANDOM() LIMIT : num ")
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}