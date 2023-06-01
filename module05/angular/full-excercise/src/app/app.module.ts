import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FontSizeEditorComponent} from './ss03_angular_overview/practice/font-size-editor/font-size-editor.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {PetComponent} from './ss03_angular_overview/practice/pet/pet.component';
import {CalculatorSimpleComponent} from './ss03_angular_overview/exercise/calculator-simple/calculator-simple.component';
import {LikeComponent} from './ss04_angular_component_and_template/practice/like/like.component';
import {NavbarComponent} from './ss04_angular_component_and_template/practice/navbar/navbar.component';
import {FooterComponent} from './ss04_angular_component_and_template/practice/footer/footer.component';
import {AngularNameCardComponent} from './ss05_componets_interaction/practice/angular-name-card/angular-name-card.component';
import {ProgressBarComponent} from './ss05_componets_interaction/practice/progress-bar/progress-bar.component';
import {RatingBarComponent} from './ss05_componets_interaction/exercise/rating-bar/rating-bar.component';
import {CountdownTimerComponent} from './ss05_componets_interaction/exercise/countdown-timer/countdown-timer.component';
import {AngularNameCard2Component} from './ss06_angular_form/practice/angular-name-card2/angular-name-card2.component';
import {LoginComponent} from './ss06_angular_form/exercise/login/login.component';
import {
  AngularHackernewsAppComponent
} from './ss04_angular_component_and_template/practice/angular-hackernews-app/angular-hackernews-app.component';
import {
  UseBtContructionDisplayListProductComponent
} from './ss03_angular_overview/practice/use-bt-contruction-display-list-product/use-bt-contruction-display-list-product.component';
import {RouterModule} from '@angular/router';
import {RegisterComponent} from './ss06_angular_form/exercise/register/register.component';
import {TimelinesAppComponent} from './ss07_service_router/pratice/timelines-app/timelines-app.component';
import {AppRoutingModule} from './app-routing.module';
import { YoutubePlaylistComponent } from './ss07_service_router/pratice/youtube-playlist/youtube-playlist.component';
import { YoutubePlayerComponent } from './ss07_service_router/pratice/youtube-player/youtube-player.component';
import { ProductListComponent } from './ss07_service_router/pratice/product-manager/product/product-list/product-list.component';
import {ProductCreateComponent} from './ss07_service_router/pratice/product-manager/product/product-create/product-create.component';
import { DictionayPageComponent } from './ss07_service_router/exercise/dictionay-page/dictionay-page.component';
import { DictionayDetailComponent } from './ss07_service_router/exercise/dictionay-detail/dictionay-detail.component';
import { ProductEditComponent } from './ss07_service_router/pratice/product-manager/product/product-edit/product-edit.component';
import { ProductDeleteComponent } from './ss07_service_router/pratice/product-manager/product/product-delete/product-delete.component';


@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    PetComponent,
    UseBtContructionDisplayListProductComponent,
    CalculatorSimpleComponent,
    AngularHackernewsAppComponent,
    LikeComponent,
    NavbarComponent,
    FooterComponent,
    AngularNameCardComponent,
    ProgressBarComponent,
    RatingBarComponent,
    CountdownTimerComponent,
    AngularNameCard2Component,
    RegisterComponent,
    LoginComponent,
    TimelinesAppComponent,
    YoutubePlaylistComponent,
    YoutubePlayerComponent,
    ProductListComponent,
    ProductCreateComponent,
    DictionayPageComponent,
    DictionayDetailComponent,
    ProductEditComponent,
    ProductDeleteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
