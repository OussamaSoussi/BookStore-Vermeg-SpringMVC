import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book = new Book();
  submitted = false;
  constructor(private bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    this.submitted = false;
    this.book = new Book();
  }

  save() {
    this.bookService
    .addBook(this.book).subscribe(data => {
      console.log(data)
      this.book = new Book();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/books']);
  }

}
