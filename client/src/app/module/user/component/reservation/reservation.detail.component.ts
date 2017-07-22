import {Component, OnInit} from '@angular/core';
import {Reservation} from "../../../../model/reservation";
import {ReservationData} from "../../../../services/reservation.data";

@Component({
  selector: 'app-reservation-detail',
  templateUrl: 'reservation.detail.component.html'
})
export class ReservationDetailComponent implements OnInit {

  reservation: Reservation;

  constructor(private  reservationData: ReservationData) {
  }

  ngOnInit(): void {
    this.reservation = this.reservationData.storage;
  }

}
