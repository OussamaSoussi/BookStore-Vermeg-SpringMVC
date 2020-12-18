import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Router } from '@angular/router';
import { BookDetailsComponent} from "../book-details/book-details.component";
import { Book } from '../../../models/book';
import { BookService } from './../../../services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Observable<Book[]>;

  constructor(
    private bookService: BookService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData(){
    this.books = this.bookService.getBooksList();
  }

  //delete
  deleteBook(b: Book){
    this.bookService.deleteBook(b)
      .subscribe(
        data=> {
          console.log(data)
          this.reloadData();
        },
        error => console.log(error)
      );
  }

  //details
  bookDetails(b: Book){
    this.router.navigate(['details', b])
  }

  //update

  updateBook(id: number){
    this.router.navigate(['update', id]);
  }

}
