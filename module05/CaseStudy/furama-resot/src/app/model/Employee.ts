import {EducationLevel} from './EducationLevel';
import {Part} from './Part';
import {Position} from './Position';

export interface Employee {
  id: number;
  name: string;
  idPosition?: Position;
  idEducationLv?: EducationLevel;
  idPart?: Part;
  dayOfBirth: string;
  CMND: string;
  Salary: number;
  numberPhone: string;
  email: string;
  address: string;
}
