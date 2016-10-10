package com.application.repository;

import com.application.model.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Brayan on 9/30/2016.
 */
@Repository
public interface AnswersRepository extends JpaRepository<Answers,Long> {
}
