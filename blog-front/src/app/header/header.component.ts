import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router"
import {UserService} from "../service/user.service"

@Component({
    selector   : 'app-header',
    templateUrl: './header.component.html',
    styleUrls  : ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

    links: any[]
    activeLinkIndex = -1

    constructor(private router: Router, private userService: UserService) {
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
                label: 'S\'abonner à la newsletter',
                link : 'newsletter',
                index: 2
            }
        ]
    }

}
