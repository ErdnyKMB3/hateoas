package com.backbase.example.repository;

import com.backbase.example.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("SELECT ms FROM Message as ms WHERE ms.id = :id")
    Message getById(@Param("id") Integer id);

    @Query("SELECT ms FROM Message as ms WHERE ms.")
}
