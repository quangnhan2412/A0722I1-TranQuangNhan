import {Component, OnInit} from '@angular/core';
import {IProduct} from '../../model/i-product';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {ICategory} from '../../model/i-category';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: IProduct [] = [];
  category: ICategory[] = [];
  product: IProduct;
  p = 1;

  constructor(private productService: ProductService,
              private categoryService: CategoryService
  ) {
  }

  ngOnInit() {
    this.findAllProduct();
  }

  findAllProduct() {
    this.productService.getAll().subscribe(item => {
      this.products = item;
    });
  }

  findAllCategory() {
    this.categoryService.getAll().subscribe(item => {
      this.category = item;
    });
  }

  search(input: HTMLInputElement) {
    this.productService.search(input.value).subscribe(next => {
      this.products = next;
    });
  }

  getProduct(id: number) {
    this.productService.findById(id).subscribe(data => {
      this.product = data;
    });
  }

  searchDate(dateFrom: HTMLInputElement, dateTo: HTMLInputElement) {
    if (dateFrom.value === '' || dateTo.value === '') {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Vui lòng nhập đầy đủ Date star - Date End!',
      });
      this.findAllProduct();
    } else {
      this.productService.searchDate(dateFrom.value, dateTo.value).subscribe(next => {
        this.products = next;
      });
    }
  }


  deleteProduct() {
    this.productService.deleteProduct(this.product.id).subscribe(item => {
      this.findAllProduct();
    });
  }
}
