import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/book';
import { ActivatedRoute, Router } from '@angular/router';
import { BookService } from 'src/app/services/book.service';
@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {
  id: number;
  book: Book;
  constructor(private route: ActivatedRoute,private router: Router,
    private bookService: BookService) { }

  ngOnInit(): void {
    this.book = new Book();

    this.id = this.route.snapshot.params['id'];
    
    this.bookService.getBook(this.id)
      .subscribe(data => {
        console.log(data)
        this.book = data;
      }, error => console.log(error));
  }
  updateBook() {
    this.bookService.updateBook(this.book)
      .subscribe(data => {
        console.log(data);
        this.book = new Book();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateBook();    
  }

  gotoList() {
    this.router.navigate(['/books']);
  }
  }


