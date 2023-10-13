package com.solution.appsolute.board.dao;

import com.solution.appsolute.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAll();

    Page<Board> findByTitleContaining(String title, Pageable pageable);

    void deleteById(Long id);
}
