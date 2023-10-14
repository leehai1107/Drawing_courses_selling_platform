package com.main.drawingcourse.repository;

import com.main.drawingcourse.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
}
