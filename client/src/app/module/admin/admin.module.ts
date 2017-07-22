import {NgModule} from "@angular/core";
import {BusComponent} from "./component/bus/bus.component";
import {BusTypeComponent} from "./component/busType/bus.type.component";
import {FareComponent} from "./component/fare/fare.component";
import {ReservationComponent} from "./component/reservation/reservation.component";
import {PassengerComponent} from "./component/passenger/passenger.component";
import {RouteComponent} from "./component/route/route.component";
import {AdminComponent} from "./admin.component";
import {BusTypeService} from "../../services/bus.type.service";
import {BusService} from "../../services/bus.service";
import {RouteService} from "../../services/route.service";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AppRoutingModule} from "../../app-routing.module";
import {NgGridModule} from "angular2-grid";

@NgModule({
  declarations: [
    BusComponent,
    BusTypeComponent,
    FareComponent,
    PassengerComponent,
    ReservationComponent,
    RouteComponent,
    AdminComponent
  ],
  providers: [BusTypeService, BusService, RouteService],
  imports: [CommonModule,FormsModule,AppRoutingModule, NgGridModule]
})
export class AdminModule {
}
