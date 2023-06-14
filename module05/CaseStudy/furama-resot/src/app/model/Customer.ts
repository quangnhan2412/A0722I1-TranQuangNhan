import {CustomerType} from './CustomerType';

export interface Customer {
  id?: string;
  customerType?: CustomerType;
  fullName?: string;
  dayOfBirth?: string;
  end?: string;
  CMND?: string;
  numberPhone?: string;
  email?: string;
  address?: string;
}
