import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { CarouselComponent } from './carousel/carousel.component';
import { CasesComponent } from './cases/cases.component';
import { FooterComponent } from './footer/footer.component';
import { DetailsComponent } from './details/details.component';

const appRoutes: Routes = [
  {path: '', component: CasesComponent},
  {path: 'details', component: DetailsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CarouselComponent,
    CasesComponent,
    FooterComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent,
    HeaderComponent]
})
export class AppModule { }
