import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/CustomerType';
import {CustomerTypeService} from '../../service/customer-type.service';
import {Customer} from '../../model/Customer';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-delete-customer',
  templateUrl: './delete-customer.component.html',
  styleUrls: ['./delete-customer.component.css']
})
export class DeleteCustomerComponent implements OnInit {
  customerForm: FormGroup;
  id: string;
  customer: Customer;
  customerType: CustomerType[];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.customerTypeService.getAll().subscribe(next => {
      this.customerType = next;
    });
    this.activatedRoute.paramMap.subscribe((pramMap: ParamMap) => {
      this.id = pramMap.get('id');
      this.customerService.findById(this.id).subscribe(next => {
        this.customer = next;
        console.log(this.customer);
        this.customerForm = new FormGroup({
          id: new FormControl(this.customer.id),
          customerType: new FormControl(this.customer.customerType.id),
          fullName: new FormControl(this.customer.fullName),
          dayOfBirth: new FormControl(this.customer.dayOfBirth),
          CMND: new FormControl(this.customer.CMND),
          numberPhone: new FormControl(this.customer.numberPhone),
          email: new FormControl(this.customer.email),
          address: new FormControl(this.customer.address)
        });
      });
    });
  }


  deleteProduct(id) {
    const customer = this.customerForm.value;
    customer.customerType = this.customerTypeService.findById(+customer.customerType).subscribe(customerType => {
      this.customer.customerType = customerType;
      this.customerService.deleteCustomer(id).subscribe(next => {
        this.router.navigate(['/customer/list']);
      });
    });
  }
}
