package com.example.kotlinserver.todolist.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "todo")
data class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long?=null,

    @Column(name = "title")
    var title: String?=null,
    @Column(name = "description")
    var description: String?=null,
    @Column(name = "schedule")
    var schedule: LocalDateTime?=null,
    @Column(name = "create_at")
    var create_at: LocalDateTime?=null,
    @Column(name = "update_at")
    var update_at: LocalDateTime?=null
)

