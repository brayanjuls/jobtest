package com.application.repository;

import com.application.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Brayan on 9/30/2016.
 */
@Repository
public interface QuestionsRepository extends JpaRepository<Questions,Long> {
}
