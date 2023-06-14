import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ICategory} from '../../model/i-category';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  productForm: FormGroup;
  category: ICategory[];

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.findAllCategory();
    this.productForm = new FormGroup({
      id: new FormControl('', [Validators.required]),
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      manufactureDate: new FormControl('', [Validators.required]),
      expirationDate: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      category: new FormControl('', [Validators.required]),
    });
  }

  findAllCategory() {
    this.categoryService.getAll().subscribe(item => {
      this.category = item;
    });
  }

  submitAddProduct() {
    this.productService.saveProduct(this.productForm.value).subscribe(next => {
      console.log(next);
      this.productForm.reset();
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Your work has been saved',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('product/list');
    }, e => {
      console.log(e);
    });  }
}
