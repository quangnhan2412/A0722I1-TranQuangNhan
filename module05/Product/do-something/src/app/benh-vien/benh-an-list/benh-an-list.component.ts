import {Component, OnInit} from '@angular/core';
import {IProduct} from '../../model/i-product';
import {ICategory} from '../../model/i-category';
import {IBenhAn} from '../../model/i-benh-an';
import {IBenhNhan} from '../../model/i-benh-nhan';
import {ProductService} from '../../service/product.service';
import {BenhAnService} from '../../service/benh-an.service';
import {BenhNhanService} from '../../service/benh-nhan.service';

@Component({
  selector: 'app-benh-an-list',
  templateUrl: './benh-an-list.component.html',
  styleUrls: ['./benh-an-list.component.css']
})
export class BenhAnListComponent implements OnInit {
  benhAns: IBenhAn [] = [];
  benhNhan: IBenhNhan[] = [];
  benhAn: IBenhNhan;
  p = 1;

  constructor(private benhAnService: BenhAnService,
              private benhNhanService: BenhNhanService
  ) {
  }

  ngOnInit() {
   this.findAllBenhAn();
  }

  findAllBenhAn() {
    this.benhAnService.getAll().subscribe(item => {
      this.benhAns = item;
    });
  }
  getBenhAn(id: any) {
    this.benhAnService.findById(id).subscribe(data => {
      this.benhAn = data;
    });
  }

  deleteBenhAn() {
    this.benhAnService.deleteBenhAn(this.benhAn.id).subscribe(item => {
      this.findAllBenhAn();
    });
  }
}
