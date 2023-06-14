import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {IProduct} from '../../model/i-product';
import {ICategory} from '../../model/i-category';
import {CategoryService} from '../../service/category.service';
import {ProductService} from '../../service/product.service';
import {ActivatedRoute, Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  id: number;
  productForm: FormGroup;
  product: IProduct;
  category: ICategory[];

  constructor(private categoryService: CategoryService,
              private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit() {
    this.categoryService.getAll().subscribe(next => {
      this.category = next;
    });
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = +paramMap.get('id');
      this.productService.findById(this.id).subscribe(next => {
        console.log(next);
        this.product = next;
        this.productForm = new FormGroup({
          id: new FormControl(this.product.id, [Validators.required]),
          name: new FormControl(this.product.name, [Validators.required]),
          price: new FormControl(this.product.price, [Validators.required]),
          manufactureDate: new FormControl(this.product.manufactureDate, [Validators.required]),
          expirationDate: new FormControl(this.product.expirationDate, [Validators.required]),
          description: new FormControl(this.product.description, [Validators.required]),
          category: new FormControl(this.product.category.id, [Validators.required]),
        });
      });
    });
  }

  submitUpdateProduct() {
    this.product = this.productForm.value;
    this.categoryService.findById(+this.productForm.get('category').value).subscribe(category => {
      this.product.category = category;
      this.productService.updateProduct(this.product.id, this.product).subscribe(next => {
        Swal.fire({
          position: 'top-end',
          icon: 'success',
          title: 'Your work has been saved',
          showConfirmButton: false,
          timer: 1500
        });
        this.router.navigateByUrl('/product/list');
      });
    });
  }
}
