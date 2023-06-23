import {IBenhNhan} from './i-benh-nhan';

export interface IBenhAn {
  id?: string;
  maBenhNhan?: IBenhNhan;
  ngayNhapVien?: string;
  ngayRaVien?: string;
  lyDoNhapVien?: string;
  phuongPhapDieuTri?: string;
  bacSiDieuTri?: string;
}
