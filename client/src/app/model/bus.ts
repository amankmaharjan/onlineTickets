import {BusType} from "./bus.type";
import {Route} from "./route";
import {Seat} from "./seat";
export class Bus {
  busNo: string;
  busName: string;
  departureTime: string;
  busType: BusType;
  services: string;
  route: Route;
  seatList: Seat[] = [];
  seatRow: number = 5;
  seatColumn: number = 10;
}
