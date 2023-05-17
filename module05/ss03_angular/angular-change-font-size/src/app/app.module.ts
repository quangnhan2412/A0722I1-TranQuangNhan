import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FontSizeEditorComponent } from './ss03_angular_overview/practice/font-size-editor/font-size-editor.component';
import {FormsModule} from '@angular/forms';
import {PetComponent} from './ss03_angular_overview/practice/pet/pet.component';
import { UseBtContructionDisplayListProductComponent } from './ss03_angular_overview/practice/use-bt-contruction-display-list-product/use-bt-contruction-display-list-product.component';
import { CalculatorSimpleComponent } from './ss03_angular_overview/exercise/calculator-simple/calculator-simple.component';


@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    PetComponent,
    UseBtContructionDisplayListProductComponent,
    CalculatorSimpleComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
