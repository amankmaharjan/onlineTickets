import {Component, Input, OnInit} from "@angular/core";
import {Bus} from "../../../../model/bus";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {BusService} from "../../../../services/bus.service";
import 'rxjs/add/operator/switchMap';
import {Seat} from "../../../../model/seat";


@Component({
  selector: 'app-bus-detail',
  templateUrl: 'bus.detail.html',
  styleUrls: ['bus.detail.css']

})
export class BusDetailComponent implements OnInit {
  @Input() bus: Bus;
  seatsArray: Number[][];
  selectedSeat:Seat[]=[];


  constructor(private busService: BusService,
              private route: ActivatedRoute,) {
  }

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.busService.getBus(params.get('busNo')))
      .subscribe(bus => {
        this.bus = bus;
        this.initialiseSeatArray();
      });
  }

  initialiseSeatArray(): void {
    console.log("array intialised");
    this.seatsArray = [];
    for (var i: number = 0; i < this.bus.seatRow; i++) {
      this.seatsArray[i] = [];
      for (var j: number = 0; j < this.bus.seatColumn; j++) {
        this.seatsArray[i][j] = 10;
      }
    }

  }
  selectSeat(seat: Seat):void{
    console.log(seat.seatName)
    console.log(seat.seatId);
   this.selectedSeat.push(seat);

  }

}
