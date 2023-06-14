import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {Customer} from '../../model/Customer';
import {Router} from '@angular/router';
import {CustomerTypeService} from '../../service/customer-type.service';
import {CustomerType} from '../../model/CustomerType';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [];
  customerType: CustomerType[];
  customer: Customer;
  p = 1;
  keyword = '';


  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService
  ) {
  }

  ngOnInit() {
    this.customerTypeService.getAll().subscribe(next => {
      this.customerType = next;
    });
    this.getAll();
  }

  private getAll() {
    // this.customers = this.customerService.getAll();
    this.customerService.getAll().subscribe(next => {
      this.customers = next;
    });
  }


  search(input: HTMLInputElement) {
    this.customerService.search(input.value).subscribe(next => {
      this.customers = next;
    });
  }


  getCustomer(id: any) {
    this.customerService.findById(id).subscribe(data => {
      this.customer = data;
    });
  }

  deleteCustomer() {
    this.customerService.deleteCustomer(this.customer.id).subscribe(item => {
      this.getAll();
    });
  }

  searchDate(input1: HTMLInputElement, input2: HTMLInputElement) {
    if (input1.value === '' || input2.value === '') {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Vui lòng nhập đầy đủ Date star - Date End!',
      });
      this.getAll();
    } else {
      this.customerService.searchDate(input1.value, input2.value).subscribe(next => {
        this.customers = next;
      });
    }
  }
}
