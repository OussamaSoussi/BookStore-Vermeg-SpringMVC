import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  books: Book[] = [];
  cart: string[] = [];
  constructor(private bookService : BookService, private cartService : ShoppingCartService, private router : Router) { }

  ngOnInit(): void {
    this.bookService.getBooksList().subscribe(book =>
      {
        this.books = book;
      });
  }

    //details
    bookDetails(b: Book){
      this.router.navigate(['details', b])
    }
    
  delete(book: Book): void{
    this.bookService.deleteBook(book).subscribe(() => { 
      console.log('book deleted')
    });
  }

  addToCart(id: number, quantity: number):void {
    this.bookService.getBook(id).subscribe(book => {
      this.cartService.add(book,quantity)
      this.gotoList();
    });
  }
  gotoList() {
    this.router.navigate(['/shopping-cart']);
  }
  
}
