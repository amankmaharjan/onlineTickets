import {BusType} from "./bus.type";
import {Route} from "./route";
export class Bus {
  busNo: string;
  busName: string;
  departureTime: string;
  busType: BusType;
  services: string;
  route: Route;
}
