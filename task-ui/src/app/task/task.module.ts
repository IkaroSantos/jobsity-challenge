import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { TaskListComponent } from './task-list/task-list.component';
import { TaskRoutingModule } from './task.routes';

@NgModule({
    declarations: [
        TaskListComponent,
    ],
    imports: [
        TaskRoutingModule,
        CommonModule,
        HttpClientModule,
        ReactiveFormsModule,
    ],
    exports: [
        TaskListComponent,
    ],
})
export class TaskModule { }
