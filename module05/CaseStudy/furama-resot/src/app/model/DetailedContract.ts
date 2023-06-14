import {AccompaniedService} from './AccompaniedService';
import {Contract} from './Contract';

export interface DetailedContract {
  id: number;
  idContact?: Contract;
  idAccompaniedService?: AccompaniedService;
  quantity: number;

}
