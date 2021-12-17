package com.example.kotlinserver.todolist.repository

import com.example.kotlinserver.todolist.domain.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository: JpaRepository<Todo, Long>