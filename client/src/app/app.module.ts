import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AppRoutingModule} from "./app-routing.module";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {AgmCoreModule} from "@agm/core";
import {UserModule} from "./module/user/user.module";
import {AdminModule} from "./module/admin/admin.module";
import {
  MdButtonModule, MdCheckboxModule, MdIconModule, MdMenuModule, MdSidenavModule,
  MdToolbarModule
} from "@angular/material";
import {NavbarComponent} from "./navbar/navbar.component";
import {FooterComponent} from "./navbar/footer.component";

@NgModule({
  declarations: [
    AppComponent,NavbarComponent,FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserModule,
    AdminModule,
    HttpModule,
    FormsModule,
    MdButtonModule, MdCheckboxModule,
    MdMenuModule,
    MdToolbarModule,
    MdSidenavModule,
    MdIconModule,

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
