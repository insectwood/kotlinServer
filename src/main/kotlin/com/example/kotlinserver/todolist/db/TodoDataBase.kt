package com.example.kotlinserver.todolist.db

data class TodoDataBase (
    var index: Int = 0,
    var todoList: MutableList<Todo> = mutableListOf()
){
    fun init(){
        this.todoList = mutableListOf()
        println("[DEBUG] init todo database")
    }
}