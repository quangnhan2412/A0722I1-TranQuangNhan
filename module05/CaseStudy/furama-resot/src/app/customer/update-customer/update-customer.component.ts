import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {CustomerType} from '../../model/CustomerType';
import {CustomerTypeService} from '../../service/customer-type.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../model/Customer';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit {
  id: string;
  customerFormUpdate: FormGroup;
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
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = paramMap.get('id');
      this.customerService.findById(this.id).subscribe(next => {
        console.log(next);
        this.customer = next;
        this.customerFormUpdate = new FormGroup({
          id: new FormControl(this.customer.id, [Validators.required, Validators.pattern('^KH-[0-9]{4}$')]),
          customerType: new FormControl(this.customer.customerType.id),
          fullName: new FormControl(this.customer.fullName, [Validators.required]),
          dayOfBirth: new FormControl(this.customer.dayOfBirth, [Validators.required]),
          CMND: new FormControl(this.customer.CMND, [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]),
          numberPhone: new FormControl(this.customer.numberPhone,
            [Validators.required, Validators.pattern('^(091|090|\\+8490|\\+8491)\\d{7}$')]),
          email: new FormControl(this.customer.email, [Validators.required, Validators.email]),
          address: new FormControl(this.customer.address, [Validators.required])
        });
      });
    });
  }

  updateCustomer() {
    this.customer = this.customerFormUpdate.value;
    this.customerTypeService.findById(+this.customerFormUpdate.get('customerType').value).subscribe(customerType => {
      this.customer.customerType = customerType;
      this.customerService.updateCustomer(this.customer.id, this.customer).subscribe(next => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        });
        this.router.navigateByUrl('/customer/list');
      });
    });
    // });
  }
}
