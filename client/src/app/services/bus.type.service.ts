import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import {BusType} from "../model/bus.type";
import "rxjs/add/operator/toPromise";

@Injectable()
export class BusTypeService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private apiUrl = 'http://localhost:8080/bustype/'

  constructor(private http: Http) {
  }

  createBusType(bustype: BusType): Promise<void> {
    return this.http
      .post(this.apiUrl, bustype, {headers: this.headers})
      .toPromise()
      .then(res => console.log(res))
      .catch(this.handleError);

  }

  getBusTypes(): Promise<BusType[]> {
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json() as BusType[])
      .catch(this.handleError);
  }

  updateBusType(busType: BusType): Promise<void> {
    const url = `${this.apiUrl}/${busType.id}`;
    return this.http
      .put(url, busType, {headers: this.headers})
      .toPromise()
      .then(res => console.log(res))
      .catch(this.handleError);
  }

  deleteBusType(id: number): Promise<void> {
    const url = `${this.apiUrl}/${id}`;
    return this.http
      .delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);

  }


  getBusType(type: String): Promise<BusType> {
    const url = `${this.apiUrl}/${type}`;
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json() as BusType)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
