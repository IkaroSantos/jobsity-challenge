import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Task } from './task.model';
import { DataService } from '../util/data.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
    private tasksSubject = new BehaviorSubject<Task[]>([]);
    tasks$ = this.tasksSubject.asObservable();
    private apiUrl = 'tasks';

    constructor(private _dataService: DataService) { }

    getTasks(): void {
        this._dataService.get<Task[]>(this.apiUrl).subscribe(tasks => this.tasksSubject.next(tasks));
    }

    addTask(task: Task): void {
        this._dataService.post<Task>(this.apiUrl, task).subscribe(() => this.getTasks());
    }

    updateTask(task: Task): void {
        this._dataService.put<Task>(`${this.apiUrl}/${task.id}`, task).subscribe(() => this.getTasks());
    }

    deleteTask(id: string | number): void {
        this._dataService.delete(`${this.apiUrl}/${id}`).subscribe(() => this.getTasks());
    }
}
