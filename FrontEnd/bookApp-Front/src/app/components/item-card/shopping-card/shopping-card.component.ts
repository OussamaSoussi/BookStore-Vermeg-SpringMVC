import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/models/book';
import { BookService } from 'src/app/services/book.service';
import { ShoppingCartService } from 'src/app/services/shopping-cart.service';


@Component({
  selector: 'app-shopping-card',
  templateUrl: './shopping-card.component.html',
  styleUrls: ['./shopping-card.component.css']
})
export class ShoppingCardComponent implements OnInit {

  availableBooks: Book[];

  books: Book[];
  quantities: number[];
  total = 0;
  constructor(private cartService : ShoppingCartService,
    private bookService : BookService, private router : Router) { }

  ngOnInit(): void {
  this.books = this.cartService.getAllBooks();
  this.quantities = this.cartService.getAllQuantities();

  if(this.books != null){
    this.bookService.getBooksList().subscribe(books => {
        this.availableBooks = books;
        this.books.forEach(book => {
            if(this.availableBooks.map((b) => b.id).indexOf(book.id) < 0 ) {
                this.delete(book.id);
                this.books = this.cartService.getAllBooks();
            }
        })

        for(let i=0; i<this.books.length; i++) {
            this.cartService.calculate(this.books[i].id).subscribe(res => {
                this.total += res;
            });
        }
    });

  }
}

  purchase() {
      this.cartService.purchase();
      this.books = this.cartService.getAllBooks();
      this.total = 0;
  }

  delete(id: number): void {

    this.cartService.remove(id);
    this.books = this.cartService.getAllBooks();
    this.quantities = this.cartService.getAllQuantities();
    let newTotal = 0;
    for(let i=0; i<this.books.length; i++) {
        this.cartService.calculate(this.books[i].id).subscribe(res => {
            if(this.books.length <= 0)
                newTotal = 0;
            newTotal += res;
            this.total = newTotal;
        });
    }
    this.total = newTotal;
    this.gotoList();

}

updateQte(id,qte) {
  let index = this.books.map((b) => b.id).indexOf(id);
  let newQte = parseInt(qte);
  this.quantities[index] = newQte;
  localStorage.setItem('quantities',JSON.stringify(this.quantities));
  this.quantities = this.cartService.getAllQuantities();
  
  let newTotal = 0;
  for(let i=0; i<this.books.length; i++) {
      this.cartService.calculate(this.books[i].id).subscribe(res => {
          if(this.books.length <= 0)
              newTotal = 0;
          newTotal += res;
          this.total = newTotal;
      });
  }
  this.total = newTotal;
}
gotoList() {
  this.router.navigate(['/home']);
}

list(){
  this.router.navigate(['home']);
}
}
