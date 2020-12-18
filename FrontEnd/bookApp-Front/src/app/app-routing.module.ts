import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddBookComponent } from './components/book/add-book/add-book.component';
import { BookDetailsComponent } from './components/book/book-details/book-details.component';
import { BookListComponent } from './components/book/book-list/book-list.component';
import { UpdateBookComponent } from './components/book/update-book/update-book.component';
import { HomeComponent } from './components/home/home.component';
import { ShoppingCardComponent } from './components/item-card/shopping-card/shopping-card.component';


const routes: Routes = [
  
  { path: '', component: HomeComponent},
  { path: 'shopping-cart', component: ShoppingCardComponent},
  { path: 'books', component: BookListComponent },
  { path: 'add', component: AddBookComponent },
  { path: 'update/:id', component: UpdateBookComponent },
  { path: 'details/:id', component: BookDetailsComponent },
  { path: 'home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
