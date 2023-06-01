import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customers: any[] = [
    {
      id: 1,
      name: 'John Doe',
      dateOfBirth: '1990-01-01',
      gender: 1,
      idCard: '123456789',
      phone: '123456789',
      email: 'john@example.com',
      address: '123 Main Street',
      customerTypeId: 1,
      status: 1
    }, {
      id: 1,
      name: 'John Doe',
      dateOfBirth: '1990-01-01',
      gender: 1,
      idCard: '123456789',
      phone: '123456789',
      email: 'john@example.com',
      address: '123 Main Street',
      customerTypeId: 1,
      status: 1
    },
    {
      id: 1,
      name: 'John Doe',
      dateOfBirth: '1990-01-01',
      gender: 1,
      idCard: '123456789',
      phone: '123456789',
      email: 'john@example.com',
      address: '123 Main Street',
      customerTypeId: 1,
      status: 1
    }
    // Add more customer objects here
  ];

  constructor() {
  }

  ngOnInit() {
  }

}
