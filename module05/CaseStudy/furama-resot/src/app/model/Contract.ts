import {Employee} from './Employee';
import {Customer} from './Customer';
import {Service} from './Service';

export interface Contract {
  id: number;
  idEmployee?: Employee;
  idCustomer?: Customer;
  idService?: Service;
  contractDateStart: string;
  contractDateEnd: string;
  deposits: number;
  totalMoney: number;
}
