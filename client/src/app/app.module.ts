import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {AgmCoreModule} from "@agm/core";
import {UserModule} from "./module/user/user.module";
import {AdminModule} from "./module/admin/admin.module";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserModule,
    AdminModule,
    HttpModule,
    FormsModule, AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCsbI9I3rWS_OL_gvenIAo17xHoG__sMV4'
    })

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
