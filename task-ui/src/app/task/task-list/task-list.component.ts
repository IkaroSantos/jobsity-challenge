import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { TaskService } from '../task.service';
import { Task } from '../task.model';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
    tasks$: Observable<Task[]>;
    taskForm: FormGroup;
    editTaskForm: FormGroup;
    editingTask: Task | null = null;

    constructor(private taskService: TaskService, private fb: FormBuilder) {
        this.tasks$ = this.taskService.tasks$;
        this.taskForm = this.fb.group({
            title: ['', Validators.required]
        });
        this.editTaskForm = this.fb.group({
            title: ['', Validators.required]
        });
    }

    ngOnInit(): void {
        this.taskService.getTasks();
    }

    addTask() {
        if (this.taskForm.valid) {
            const newTask: Task = { title: this.taskForm.value.title, completed: false };
            this.taskService.addTask(newTask);
            this.taskForm.reset();
        }
    }

    toggleTaskStatus(task: Task) {
        task.completed = !task.completed;
        this.taskService.updateTask(task);
    }

    editTask(task: Task) {
        this.editingTask = { ...task };
        this.editTaskForm.setValue({ title: this.editingTask.title });
    }

    saveTask() {
        if (this.editTaskForm.valid && this.editingTask) {
            this.editingTask.title = this.editTaskForm.value.title;
            this.taskService.updateTask(this.editingTask);
            this.editingTask = null;
            this.editTaskForm.reset();
        }
    }

    deleteTask(task: Task) {
        if (!!task.id) {
            this.taskService.deleteTask(task.id);
        }
    }
}
