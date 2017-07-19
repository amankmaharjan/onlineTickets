import {Component, OnInit} from '@angular/core';
import {Bus} from "../../../../model/bus";
import {BusType} from "../../../../model/bus.type";
import {Route} from "@angular/router";
import {BusService} from "../../../../services/bus.service";
import {BusTypeService} from "../../../../services/bus.type.service";
import {RouteService} from "../../../../services/route.service";

@Component({
  selector: 'app-bus',
  templateUrl: './bus.component.html'
})
export class BusComponent implements OnInit {

  bus: Bus = new Bus();
  busList: Bus[];
  selectedBus: Bus;
  updatedBusType: Bus;
  busTypeList: BusType[];
  routeList: Route[];


  constructor(private busService: BusService, private busTypeService: BusTypeService,private  routeService:RouteService) {
  }

  ngOnInit(): void {
    this.setBusTypesList();
    this.setBuses();
    this.setRouteList();
  }

  createBus(): void {
    console.log(this.bus);
    this.busService.createBus(this.bus).then(res => {
      this.setBuses();
      this.selectedBus = null;
    });

  }

  setBuses(): void {
    this.busService.getBuses().then(busList => this.busList = busList);
  }


  deleteBus(selectedBus: Bus): void {
    console.log(selectedBus);
    this.busService.deleteBus(selectedBus.busNo).then(() => {
      this.setBuses();
      this.selectedBus = null;
    });

  }

  goDetail(selectedBus: Bus): void {
    this.selectedBus = selectedBus;
  }


  updateBus(type: string): void {
    console.log(type);
  }

  setBusTypesList(): void {
    this.busTypeService.getBusTypes().then(busTypeList => this.busTypeList = busTypeList);
  }

  setRouteList(): void {
    this.routeService.getRoutesList().then(routeList => this.routeList = routeList);
  }

}
