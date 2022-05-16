
package com.example.todolist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.example.todolist.network.Todos
import com.example.todolist.network.TodosApi

import kotlinx.coroutines.launch

enum class TodolistApiStatus {LOADING, ERROR, DONE}

class TodolistViewModel : ViewModel() {

    // TODO: Create properties to represent MutableLiveData and LiveData for the API status
    private val _status = MutableLiveData<TodolistApiStatus>()
     val status : LiveData<TodolistApiStatus> = _status
    // TODO: Create properties to represent MutableLiveData and LiveData for a list of todo objects
    // _todos                Todos
    private val _todos = MutableLiveData<List<Todos>>()
    val todos : LiveData<List<Todos>> = _todos
    // TODO: Create properties to represent MutableLiveData and LiveData for a single todo object.

    //  This will be used to display the details of an todo when a list item is clicked
    //_todo
    private val _todo = MutableLiveData<Todos>()
    val todo : LiveData<Todos> = _todo
    // TODO: Create a function that gets a list of todos from the api service and sets the
    //  status via a Coroutine
    // getTodosList
    fun getTodosList() {
        viewModelScope.launch {
            _status.value = TodolistApiStatus.LOADING
            try{
                _todos.value = TodosApi.retrofitService.getTodos()
                    _status.value = TodolistApiStatus.DONE

            }   catch (e: Exception){
                _status.value = TodolistApiStatus.ERROR
                _todos.value = listOf()
            }
        }
    }

    fun onTodolistClicked(todo: Todos) {
        // TODO: Set the todo object
        _todo.value = todo


    }
}
