import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Bus} from "../../../../model/bus";
import {BusType} from "../../../../model/bus.type";
import {Route} from "@angular/router";
import {BusService} from "../../../../services/bus.service";
import {BusTypeService} from "../../../../services/bus.type.service";
import {RouteService} from "../../../../services/route.service";
import {Seat} from "../../../../model/seat";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-bus',
  templateUrl: './bus.component.html',
  styleUrls: ['./bus.component.css']

})
export class BusComponent implements OnInit {

  bus: Bus = new Bus();
  busList: Bus[];
  selectedBus: Bus;
  updatedBusType: Bus;
  busTypeList: BusType[];
  routeList: Route[];
  seatsArray: Number[][];
  selectedSeatMapValueX: number;
  selectedSeatMapValueY: number;

  constructor(private busService: BusService, private busTypeService: BusTypeService, private  routeService: RouteService) {
  }

  ngOnInit(): void {
    this.setBusTypesList()
    this.setBuses();
    this.setRouteList();
    this.initialiseSeatArray();
  };

  initialiseSeatArray(): void {
    this.seatsArray = [];
    for (var i: number = 0; i < this.bus.seatRow; i++) {
      this.seatsArray[i] = [];
      for (var j: number = 0; j < this.bus.seatColumn; j++) {
        this.seatsArray[i][j] = 10;
      }
    }

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

  openDialog(x: number, y: number): void {
    this.selectedSeatMapValueX = x;
    this.selectedSeatMapValueY = y;

  }

  addSeat(seatName: string): void {
    var seat = new Seat();
    seat.seatName = seatName;
    seat.seatMapValueX = this.selectedSeatMapValueX;
    seat.seatMapValueY = this.selectedSeatMapValueY;
    this.bus.seatList.push(seat);
    console.log(this.bus.seatList);


  }

  seatListName(seatList: Seat[]): string {
    var seatListName: string = "{";
    for (var i: number = 0; i < seatList.length; i++) {
      seatListName += seatList[i].seatName;
      if (i != seatList.length - 1) {
        seatListName += ',';
      }
    }
    seatListName += "}";
    return seatListName;
  }
}
