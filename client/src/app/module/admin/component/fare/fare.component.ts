import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-fare',
  template: ' fare',
})
export class FareComponent implements OnInit{
  ngOnInit(): void {
  this.getDistanceFromLatLonInKm(this.lat1,this.lon1,this.lat2,this.lon2)
  }

  lat1: number=27.43;
  lat2: number=28.14;
  lon1: number=85.19;
  lon2: number=83.59;

  getDistanceFromLatLonInKm(lat1, lon1, lat2, lon2): void {
    var R = 6371; // Radius of the earth in km
    var dLat = this.deg2rad(lat2 - lat1);  // deg2rad below
    var dLon = this.deg2rad(lon2 - lon1);
    var a =
      Math.sin(dLat / 2) * Math.sin(dLat / 2) +
      Math.cos(this.deg2rad(lat1)) * Math.cos(this.deg2rad(lat2)) *
      Math.sin(dLon / 2) * Math.sin(dLon / 2)
    ;
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    var d = R * c; // Distance in km\
    console.log(d);
  }

  deg2rad(deg): number {
    return deg * (Math.PI / 180)
  }
}
