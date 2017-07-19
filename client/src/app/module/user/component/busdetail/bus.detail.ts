import {Component, Input, OnInit} from "@angular/core";
import {Bus} from "../../../../model/bus";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {BusService} from "../../../../services/bus.service";
import 'rxjs/add/operator/switchMap';


@Component({
  selector: 'app-bus-detail',
  templateUrl: 'bus.detail.html'
})
export class BusDetailComponent implements OnInit {
  @Input() bus: Bus;

  constructor(private busService: BusService,
              private route: ActivatedRoute,) {
  }

  ngOnInit(): void {
    this.route.paramMap
      .switchMap((params: ParamMap) => this.busService.getBus(params.get('busNo')))
      .subscribe(bus => this.bus = bus);
  }
}
