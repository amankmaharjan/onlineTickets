import {Seat} from "./seat";
import {Passenger} from "./passenger";
import {Bus} from "./bus";

export class Reservation {
  tickedId: String;
  passenger: Passenger;
  fare: number;
  bus: Bus;
  seatList: Seat[];

}
