import {Component, OnInit} from '@angular/core';
import {Route} from "../../../../model/route";
import {RouteService} from "../../../../services/route.service";

@Component({
  selector: 'app-route',
  templateUrl: './route.component.html',
})
export class RouteComponent implements OnInit {
  route: Route = new Route();
  routeList: Route[];
  selectedRoute: Route;


  constructor(private routeService: RouteService) {
  }

  ngOnInit(): void {
    this.setRouteList();
  }


  createRoute(): void {
    console.log(this.route);
    this.routeService.createRoute(this.route).then(res => {
      this.setRouteList();
      this.selectedRoute = null;
    });

  }

  setRouteList(): void {
    this.routeService.getRoutesList().then(routeList => this.routeList = routeList);
  }

  deleteRoute(selectedRoute: Route): void {
    console.log(selectedRoute);
    this.routeService.deleteRoute(selectedRoute.routeId).then(() => {
      this.setRouteList();
      this.selectedRoute = null;
    });

  }

  goDetail(selectedRoute: Route): void {
    this.selectedRoute = selectedRoute;
  }


  updateRoute(type: string): void {
    console.log(type);
  }


}
