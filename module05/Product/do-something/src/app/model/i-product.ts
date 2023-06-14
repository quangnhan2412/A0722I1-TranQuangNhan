import {ICategory} from './i-category';

export interface IProduct {
  id?: number;
  name?: string;
  price?: number;
  manufactureDate?: string;
  expirationDate?: string;
  description?: string;
  category?: ICategory;
}
