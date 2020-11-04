import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {
  id: string = "";
  product: any;
  constructor(private http: HttpClient) { }

  getAll() {
    this.http.get("http://127.0.0.1:8081/product/" + this.id).subscribe((response) => {
      this.product = response;
      console.log(response);
    });
  }

  ngOnInit(): void {
  }

}
