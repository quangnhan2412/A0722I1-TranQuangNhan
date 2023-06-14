import {RentalTypeService} from './RentalTypeService';

export interface Service {
  id: number;
  nameService: string;
  area: number;
  floor: number;
  maxPeople: number;
  cost: number;
  rentalType?: RentalTypeService;
  status: string;
}
