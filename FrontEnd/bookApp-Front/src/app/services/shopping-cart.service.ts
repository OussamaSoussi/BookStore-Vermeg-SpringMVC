import { HttpClient } from '@angular/common/http';
import { stringify } from '@angular/compiler/src/util';
import { Injectable } from '@angular/core';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class ShoppingCartService {

  private URL: string = 'http://localhost:8080/BookStoreMVC/book';
  
  books: Book[] = [];
  quantities: number[] = [];
  constructor(private http: HttpClient) { }

  add(book: Book, quantity: number){
    this.books.push(book);
    this.quantities.push(quantity);
    localStorage.setItem('books', JSON.stringify(this.books));
    localStorage.setItem('quantities',JSON.stringify(this.quantities));
  }

  getAllBooks(): Book[]{
    return JSON.parse(localStorage.getItem('books'));
  }

  getAllQuantities(): number[]{
    return JSON.parse(localStorage.getItem('quantities'));
  }

  calculate(Id?: number){
    return this.http.get<number>(`${this.URL}/total-price/${Id}`);
  }

  purchase(){
    localStorage.removeItem('books');
    localStorage.removeItem('quantities');
  }

  remove (Id: number): void{
    localStorage.removeItem('books');
    localStorage.removeItem('quantities')
    
    let q = [];
    let i = 0;
    this.books = this.books.filter( 
      book => {
        if (book.id != Id){
          q.push(this.quantities[i]);
          i++;
          return book;
        }
      }
    );

    this.quantities = q;
    console.log(this.books);
    localStorage.setItem('books',JSON.stringify(this.books));

  }

}
