import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Bus} from "../model/bus";
import {Route} from "../model/route";

@Injectable()
export class BusService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private apiUrl = 'http://localhost:8080/bus/'

  constructor(private http: Http) {
  }

  createBus(bus: Bus): Promise<void> {
    return this.http
      .post(this.apiUrl, bus, {headers: this.headers})
      .toPromise()
      .then(res => console.log(res))
      .catch(this.handleError);

  }

  getBuses(): Promise<Bus[]> {
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json() as Bus[])
      .catch(this.handleError);
  }

  updateBus(bus: Bus): Promise<void> {
    const url = `${this.apiUrl}/${bus.busNo}`;
    return this.http
      .put(url, bus, {headers: this.headers})
      .toPromise()
      .then(res => console.log(res))
      .catch(this.handleError);
  }

  deleteBus(busNo: string): Promise<void> {
    const url = `${this.apiUrl}/${busNo}`;
    return this.http
      .delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);

  }


  getBus(busNo: String): Promise<Bus> {
    const url = `${this.apiUrl}/${busNo}`;
    return this.http.get(url)
      .toPromise()
      .then(response => response.json() as Bus)
      .catch(this.handleError);
  }

  getBusesByRoute(route: Route): Promise<Bus[]> {
    const url = `${this.apiUrl}/route/`;
    console.log(url);
    return this.http.post(url, route)
      .toPromise()
      .then(response => response.json() as Bus[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
