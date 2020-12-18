import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {AddBookComponent} from './components/book/add-book/add-book.component'
import { BookDetailsComponent } from './components/book/book-details/book-details.component';
import { BookListComponent } from './components/book/book-list/book-list.component';
import { UpdateBookComponent } from './components/book/update-book/update-book.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './components/home/home.component';
import { ShoppingCardComponent } from './components/item-card/shopping-card/shopping-card.component';



@NgModule({
  declarations: [
    AppComponent,
    AddBookComponent,
    BookDetailsComponent,
    BookListComponent,
    UpdateBookComponent,
    HomeComponent,
    ShoppingCardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
