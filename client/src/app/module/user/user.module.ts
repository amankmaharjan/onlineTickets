import {NgModule} from "@angular/core";
import {UserComponent} from "./user.component";
import {BusSearchComponent} from "./component/bussearch/bus.search";
import {FormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {BusDetailComponent} from "./component/busdetail/bus.detail";
import {RouterModule} from "@angular/router";
import {ReservationDetailComponent} from "./component/reservation/reservation.detail.component";
import {PassengerFormComponent} from "./component/passenger/passenger.form.componet";
import {ReservationData} from "../../services/reservation.data";
import {ReservationService} from "../../services/reservation.service";
import {MdButtonModule, MdCardModule, MdInputModule} from "@angular/material";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

@NgModule({
  declarations: [
    UserComponent,
    BusSearchComponent,
    BusDetailComponent, PassengerFormComponent, ReservationDetailComponent
  ],
  imports: [CommonModule, FormsModule, RouterModule, MdCardModule,MdInputModule,MdButtonModule,BrowserAnimationsModule],
  providers: [ReservationData,ReservationService]
})
export class UserModule {
}
