import {NgModule} from "@angular/core";
import {UserComponent} from "./user.component";
import { BusSearchComponent} from "./component/bussearch/bus.search";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {BusDetailComponent} from "./component/busdetail/bus.detail";
import {RouterModule} from "@angular/router";

@NgModule({
  declarations: [
    UserComponent,
    BusSearchComponent,
    BusDetailComponent
  ],
  imports: [CommonModule, FormsModule,RouterModule]
})
export class UserModule {
}
