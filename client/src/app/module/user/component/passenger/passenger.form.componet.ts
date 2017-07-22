import {Component, OnInit} from "@angular/core";
import {BusService} from "../../../../services/bus.service";
import {ActivatedRoute, Router} from "@angular/router";
import {ReservationData} from "../../../../services/reservation.data";
import {Reservation} from "../../../../model/reservation";
import {Passenger} from "../../../../model/passenger";
import {ReservationService} from "../../../../services/reservation.service";

@Component({
  selector: 'app-passenger-form',
  templateUrl: 'passenger.form.component.html'
})
export class PassengerFormComponent implements OnInit {

  reservation: Reservation;
  passenger: Passenger = new Passenger;

  constructor(private busService: BusService,
              private route: ActivatedRoute,
              private router: Router,
              private  reservationData: ReservationData,
              private  reservationService: ReservationService) {
  }

  ngOnInit(): void {
    this.reservation = this.reservationData.storage;
    console.log(this.reservation);
  }

  book(): void {

    this.reservation.passenger = this.passenger;
    this.reservationService.createReservation(this.reservation).then(reservation => {
      this.reservationData.storage = reservation;
      let link = ['/reservationDetail'];
      this.router.navigate(link);
    });

  }
}
