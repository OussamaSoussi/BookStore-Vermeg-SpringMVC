import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Book } from '../models/book';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BookService {

  private URL: string = 'http://localhost:8080/BookStoreMVC/book';

  constructor(private http: HttpClient) { }

  getBooksList(): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.URL}/all`);
  }  
  
  getBook(id: number): Observable<any> {
    return this.http.get(`${this.URL}/get/${id}`);
  }

  addBook(book: Book) {
    return this.http.post(`${this.URL}/add`, book);
  }

  updateBook(book: Book) {
    return this.http.put(`${this.URL}/update`, book);
  }

  deleteBook(book: Book) {
    return this.http.post(`${this.URL}/delete`, book);
  }

 
}
