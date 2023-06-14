import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {AddCustomerComponent} from './customer/add-customer/add-customer.component';
import {UpdateCustomerComponent} from './customer/update-customer/update-customer.component';
import {DeleteCustomerComponent} from './customer/delete-customer/delete-customer.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'customer/list', component: ListCustomerComponent},
  {path: 'customer/create', component: AddCustomerComponent},
  {path: 'customer/edit/:id', component: UpdateCustomerComponent},
  {path: 'customer/delete/:id', component: DeleteCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
