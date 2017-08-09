import {Component, Input, OnInit} from "@angular/core";
import {Bus} from "../../../../model/bus";
import {BusService} from "../../../../services/bus.service";
import {Route} from "../../../../model/route";


@Component({
  selector: 'app-bus-search',
  templateUrl: 'bus.search.html',
  styleUrls: ['bus.search.css']
})

export class BusSearchComponent implements OnInit {
  busList: Bus[];
  route: Route = new Route();
  @Input()
  color:"red";

  constructor(private busService: BusService) {
  }

  ngOnInit(): void {
    this.setBuses();
  }

  setBuses(): void {
    this.busService.getBuses().then(busList => this.busList = busList);
  }

  searchBus(): void {
    console.log(this.route);
    this.busService.getBusesByRoute(this.route).then(busList => this.busList = busList);
  }
}
