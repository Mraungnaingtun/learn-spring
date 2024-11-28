package com.trainSpringBoot.logant.QueryByExample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}