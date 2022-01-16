import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  user: User = new User();
  constructor(private userService: UserService,
    private router: Router) { }

  ngOnInit(): void {
  }

  loginUser(){
    this.userService.login(this.user).subscribe( data =>{
      console.log(data);

      this.goToProcess();
    },
    error => console.log(error));
  }

  goToProcess(){
    this.router.navigate(['/process']);
  }
  
  onSubmit(){
    console.log(this.user);
    this.loginUser();
  }

}
