import {Customer} from '../../customer/model/customer';
import {Facility} from '../../facility/model/facility';

export interface Contract {
  id?: number;
  startDate?: string;
  endDate?: string;
  deposit?: number;
  customer?: Customer;
  facility?: Facility;
}
