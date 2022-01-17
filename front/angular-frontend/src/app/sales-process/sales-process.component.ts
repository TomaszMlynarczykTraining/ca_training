import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { ProcessService } from '../process.service';
import { Product } from '../product';
import { FormBuilder, FormGroup, FormControl, Validators, FormArray} from '@angular/forms';


@Component({
  selector: 'app-sales-process',
  templateUrl: './sales-process.component.html',
  styleUrls: ['./sales-process.component.css']
})
export class SalesProcessComponent implements OnInit {

  products: Product[];
  public isChecked$ = new BehaviorSubject(false);


  constructor(private processService: ProcessService,
    private router: Router) { }


  ngOnInit(): void {
    this.getProducts();
  }

  private getProducts(){
    this.processService.getProductList().subscribe(data => {
      this.products = data;
    });
  }

  onCheckboxChange(productId: any, e: any ){

     console.log (e.target.checked);
     let checked=e.target.checked;
     let prodToUpdate=this.products.find(product=>product.id===productId);
     prodToUpdate!.isChecked=checked;
  }


  onSubmit(){
    console.log(this.products);
    this.products.forEach(product => {
      this.processService.submitProducts(product);
    });
    
  }
}
