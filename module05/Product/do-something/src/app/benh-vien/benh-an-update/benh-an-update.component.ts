import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {IBenhAn} from '../../model/i-benh-an';
import {IBenhNhan} from '../../model/i-benh-nhan';
import {BenhNhanService} from '../../service/benh-nhan.service';
import {BenhAnService} from '../../service/benh-an.service';
import {ActivatedRoute, Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-benh-an-update',
  templateUrl: './benh-an-update.component.html',
  styleUrls: ['./benh-an-update.component.css']
})
export class BenhAnUpdateComponent implements OnInit {
  id: string;
  benhAnForm: FormGroup;
  benhAn: IBenhAn;
  benhNhan: IBenhNhan[];

  constructor(private benhNhanService: BenhNhanService,
              private benhAnService: BenhAnService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    this.benhNhanService.getAll().subscribe(next => {
      this.benhNhan = next;
    });
    this.activatedRoute.paramMap.subscribe(paramMap => {
      this.id = paramMap.get('id');
      this.benhAnService.findById(this.id).subscribe(next => {
        this.benhAn = next;
        this.benhAnForm = new FormGroup({
          id: new FormControl(this.benhAn.id, [Validators.required, Validators.pattern('^BA-[0-9]{3}$')]),
          maBenhNhan: new FormControl(this.benhAn.maBenhNhan.id, [Validators.required, Validators.pattern('^BN-[0-9]{3}$')]),
          tenBenhNhan: new FormControl(this.benhAn.maBenhNhan.name, [Validators.required]),
          ngayNhapVien: new FormControl(this.benhAn.ngayNhapVien, [Validators.required]),
          ngayRaVien: new FormControl(this.benhAn.ngayRaVien, [Validators.required]),
          lyDoNhapVien: new FormControl(this.benhAn.lyDoNhapVien, [Validators.required]),
          phuongPhapDieuTri: new FormControl(this.benhAn.phuongPhapDieuTri, [Validators.required]),
          bacSiDieuTri: new FormControl(this.benhAn.bacSiDieuTri, [Validators.required])
        });
      });
    });
  }

  updateBenhAn() {
    this.benhAn = this.benhAnForm.value;
    this.benhNhanService.findById(this.benhAn.maBenhNhan.id).subscribe(next => {
        this.benhAn = next;
        this.benhAnService.updateBenhAn(this.benhAn.id, this.benhAn).subscribe();
      }
    );
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Your work has been saved',
      showConfirmButton: false,
      timer: 1500
    });
    this.router.navigateByUrl('/benhAn/list');

  }
}
