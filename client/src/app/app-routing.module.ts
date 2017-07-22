import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BusComponent} from "./module/admin/component/bus/bus.component";
import {BusTypeComponent} from "./module/admin/component/busType/bus.type.component";
import {FareComponent} from "./module/admin/component/fare/fare.component";
import {PassengerComponent} from "./module/admin/component/passenger/passenger.component";
import {ReservationComponent} from "./module/admin/component/reservation/reservation.component";
import {RouteComponent} from "./module/admin/component/route/route.component";
import {UserComponent} from "./module/user/user.component";
import {AdminComponent} from "./module/admin/admin.component";
import {BusDetailComponent} from "./module/user/component/busdetail/bus.detail";
import {PassengerFormComponent} from "./module/user/component/passenger/passenger.form.componet";
import {ReservationDetailComponent} from "./module/user/component/reservation/reservation.detail.component";


const routes: Routes = [
    {path: '', redirectTo: 'admin', pathMatch: 'full'},
    {
      path: 'user', component: UserComponent
    },
    {
      path: 'passengerForm', component: PassengerFormComponent
    },
    {
      path: 'reservationDetail', component: ReservationDetailComponent
    },
    {
      path: 'admin',
      component:
      AdminComponent,
      children:
        [{path: 'bus', component: BusComponent},
          {path: 'busType', component: BusTypeComponent},
          {path: 'fare', component: FareComponent},
          {path: 'passenger', component: PassengerComponent},
          {path: 'reservation', component: ReservationComponent},
          {path: 'route', component: RouteComponent},
        ]
    }
    ,
    {
      path: 'detail/:busNo', component:
    BusDetailComponent
    }
  ]
;

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
