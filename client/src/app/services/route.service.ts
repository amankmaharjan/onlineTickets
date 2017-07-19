import {Injectable} from "@angular/core";
import {Http, Headers} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Route} from "../model/route";

@Injectable()
export class RouteService {

  private headers = new Headers({'Content-Type': 'application/json'});
  private apiUrl = 'http://localhost:8080/route/'

  constructor(private http: Http) {
  }

  createRoute(route: Route): Promise<void> {
    return this.http
      .post(this.apiUrl, route, {headers: this.headers})
      .toPromise()
      .then(res => console.log(res))
      .catch(this.handleError);

  }

  getRoutesList(): Promise<Route[]> {
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json() as Route[])
      .catch(this.handleError);
  }

  updateRoute(route: Route): Promise<void> {
    const url = `${this.apiUrl}/${route.routeId}`;
    return this.http
      .put(url, route, {headers: this.headers})
      .toPromise()
      .then(res => console.log(res))
      .catch(this.handleError);
  }

  deleteRoute(routeId: string): Promise<void> {
    const url = `${this.apiUrl}/${routeId}`;
    return this.http
      .delete(url, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);

  }


  getRoute(routeId: String): Promise<Route> {
    const url = `${this.apiUrl}/${routeId}`;
    return this.http.get(this.apiUrl)
      .toPromise()
      .then(response => response.json() as Route)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
