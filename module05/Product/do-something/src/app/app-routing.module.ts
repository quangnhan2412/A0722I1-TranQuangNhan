import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {ProductUpdateComponent} from './product/product-update/product-update.component';
import {BenhAnListComponent} from './benh-vien/benh-an-list/benh-an-list.component';
import {BenhAnUpdateComponent} from './benh-vien/benh-an-update/benh-an-update.component';


const routes: Routes = [
  {path: 'product/list', component: ProductListComponent},
  {path: 'benhAn/list', component: BenhAnListComponent},
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'product/edit/:id', component: ProductUpdateComponent},
  {path: 'benhAn/edit/:id', component: BenhAnUpdateComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
