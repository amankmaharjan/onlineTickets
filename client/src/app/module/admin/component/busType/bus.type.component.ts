import {Component, OnInit} from '@angular/core';
import {BusTypeService} from "../../../../services/bus.type.service";
import {BusType} from "../../../../model/bus.type";

@Component({
  selector: 'app-bus-type',
  templateUrl: 'bus.type.component.html',
})
export class BusTypeComponent implements OnInit {

  public busType: BusType = new BusType();
  busTypeList: BusType[];
  selectedBusType: BusType;
  edit: boolean;
  updatedBusType: BusType;


  constructor(private busTypeService: BusTypeService) {
  }

  ngOnInit(): void {
    this.setBusTypesList();
  }

  showEdit(): void {
    if (this.edit)
      this.edit = false;
    else
      this.edit = true;

  }

  createBusType(): void {
    console.log(this.busType);
    this.busTypeService.createBusType(this.busType).then(res => {
      this.setBusTypesList();
      this.selectedBusType = null;
      this.busType.type = "";
    });

  }

  setBusTypesList(): void {
    this.busTypeService.getBusTypes().then(busTypeList => this.busTypeList = busTypeList);
  }


  deleteBusType(selectedBusType: BusType): void {
    console.log(selectedBusType.id);
    this.busTypeService.deleteBusType(selectedBusType.id).then(() => {
      this.setBusTypesList();
      this.selectedBusType = null;
    });

  }

  goDetail(selectedBusType: BusType): void {
    this.selectedBusType = selectedBusType;
  }

  cancel(): void {
    this.edit = false;

  }

  updateBusType(type: string): void {
    console.log(type);
    this.updatedBusType = new BusType();
    this.updatedBusType.id = this.selectedBusType.id;
    this.updatedBusType.type = type;
    this.busTypeService.updateBusType(this.updatedBusType).then(res => {
        this.setBusTypesList();
        this.selectedBusType = null;
        this.updatedBusType = null;
      }
    );
  }

  setBusType(): void {
    this.busTypeService.getBusType(this.selectedBusType.type).then(busType => {
      this.selectedBusType = busType;
      console.log(busType);
    })
  }

}
