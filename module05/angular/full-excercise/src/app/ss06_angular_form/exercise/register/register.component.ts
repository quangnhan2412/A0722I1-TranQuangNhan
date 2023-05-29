import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators} from '@angular/forms';


// export const reConfirmPass: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
//   const passWord = control.get('password');
//   const confirmPassword = control.get('confirmPassword');
//   // tslint:disable-next-line:triple-equals
//   if (passWord === confirmPassword) {
//     return null;
//   }
//   return {reConfirmPassValidName: true};
// };

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  rfRegister: FormGroup;

  constructor() {
  }

  ngOnInit() {
    this.rfRegister = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl('', [Validators.required]),
      country: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required, this.checkDateOfBirth]),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, Validators.pattern(/(((\+|)84)|0)(3|5|7|8|9)+([0-9]{8})\b/)]),
    });
  }

  onSubmit() {
    console.log(this.rfRegister.value);
  }

  checkDateOfBirth(control: AbstractControl): ValidationErrors | null {
    const value = control.value;

    if (value !== null && value !== undefined) {
      const currentDate = new Date();
      const birthDate = new Date(value);


      const yearsDiff = currentDate.getFullYear() - birthDate.getFullYear();
      const monthsDiff = currentDate.getMonth() - birthDate.getMonth();
      const daysDiff = currentDate.getDate() - birthDate.getDate();

      if (yearsDiff > 18 || (yearsDiff === 18 && monthsDiff > 0) || (yearsDiff === 18 && monthsDiff === 0 && daysDiff >= 0)) {
        return null;
      }
    }
    return {checkAge: true}; // user trên 18 tuổi
  }

  get age() {
    return this.rfRegister.get('age');
  }
}
