import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs"
import {Router} from "@angular/router"

@Component({
  selector   : 'app-header',
  templateUrl: './header.component.html',
  styleUrls  : ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  links: any[]
  activeLinkIndex = -1
  private countSubscription: Subscription;

  constructor(private router: Router) {
  }

  ngOnInit() {
    this.init();
    this.activeLinkIndex = this.links.indexOf(this.links.find(tab => tab.link === this.router.url));
  }


  private init() {
    this.links = [
      {
        label: 'Accueil',
        link : 'index',
        index: 0
      }, {
        label: 'Mon environnement',
        link : 'mon-environnement',
        index: 1
      }, {
        label: 'Newsletter',
        index: 2
      }
    ]
  }

}
