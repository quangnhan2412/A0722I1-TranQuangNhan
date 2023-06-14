import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerType} from '../../model/CustomerType';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customerForm: FormGroup;
  customerType: CustomerType[];


  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router) {
    this.customerTypeService.getAll().subscribe(next => {
      this.customerType = next;
    });
  }

  ngOnInit() {
    this.customerForm = new FormGroup({
      id: new FormControl('', [Validators.required, Validators.pattern('^KH-[0-9]{4}$')]),
      customerType: new FormControl('', [Validators.required]),
      fullName: new FormControl('', [Validators.required]),
      dayOfBirth: new FormControl('', [Validators.required]),
      CMND: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]),
      numberPhone: new FormControl('', [Validators.required, Validators.pattern('^(091|090|\\+8490|\\+8491)\\d{7}$')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('', [Validators.required])
    });
  }

  submitAddCustomer() {
    this.customerService.saveCustomer(this.customerForm.value).subscribe(next => {
      console.log(next);
      this.customerForm.reset();
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Your work has been saved',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('customer/list');
    }, e => {
      console.log(e);
    });
  }


}
