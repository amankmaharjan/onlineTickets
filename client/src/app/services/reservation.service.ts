import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Reservation} from "../model/reservation";

@Injectable()
export class ReservationService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private apiUrl = 'http://localhost:8080/reservation/'

  constructor(private http: Http) {
  }

  createReservation(reservation: Reservation): Promise<Reservation> {
    return this.http
      .post(this.apiUrl, reservation, {headers: this.headers})
      .toPromise()
      .then(res =>res.json() as Reservation)
      .catch(this.handleError);

  }

  getReservationList(): Promise<Reservation[]> {
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json() as Reservation[])
      .catch(this.handleError);
  }

  // updateReservation(reservation: Reservation): Promise<void> {
  //   const url = `${this.apiUrl}/${reservation.}`;
  //   return this.http
  //     .put(url,reservation, {headers: this.headers})
  //     .toPromise()
  //     .then(res => console.log(res))
  //     .catch(this.handleError);
  // }

  deleteRoute(reservationId: string): Promise<void> {
    const url = `${this.apiUrl}/${reservationId}`;
    return this.http
      .delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);

  }


  getReservation(routeId: String): Promise<Reservation> {
    const url = `${this.apiUrl}/${routeId}`;
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json() as Reservation)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
