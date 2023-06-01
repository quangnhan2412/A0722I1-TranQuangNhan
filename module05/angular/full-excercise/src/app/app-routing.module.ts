import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TimelinesAppComponent} from './ss07_service_router/pratice/timelines-app/timelines-app.component';
import {YoutubePlaylistComponent} from './ss07_service_router/pratice/youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './ss07_service_router/pratice/youtube-player/youtube-player.component';
import {ProductListComponent} from './ss07_service_router/pratice/product-manager/product/product-list/product-list.component';
import {ProductCreateComponent} from './ss07_service_router/pratice/product-manager/product/product-create/product-create.component';
import {DictionayPageComponent} from './ss07_service_router/exercise/dictionay-page/dictionay-page.component';
import {DictionayDetailComponent} from './ss07_service_router/exercise/dictionay-detail/dictionay-detail.component';
import {ProductEditComponent} from './ss07_service_router/pratice/product-manager/product/product-edit/product-edit.component';
import {ProductDeleteComponent} from './ss07_service_router/pratice/product-manager/product/product-delete/product-delete.component';


const routes: Routes = [
  // practice 7
  {
    path: 'timelines',
    component: TimelinesAppComponent
  },
  {
    path: 'youtube',
    component: YoutubePlaylistComponent,
    children: [{
      path: ':id',
      component: YoutubePlayerComponent
    }]
  },
  {
    path: 'product/list',
    component: ProductListComponent
  },
  {
    path: 'product/create',
    component: ProductCreateComponent
  },
  {
    path: 'product/edit/:id',
    component: ProductEditComponent
  },
  {
    path: 'product/delete/:id',
    component: ProductDeleteComponent
  },
  {
    path: 'dictionary',
    component: DictionayPageComponent
  },
  {
    path: 'detail/:id',
    component: DictionayDetailComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
