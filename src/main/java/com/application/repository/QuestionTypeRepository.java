package com.application.repository;

import com.application.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Brayan on 9/30/2016.
 */
@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType,Long> {
}
