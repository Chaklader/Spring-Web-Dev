import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import { Cookie } from 'ng2-cookies';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { OAuthService } from 'angular-oauth2-oidc';
 
 export class Foo {
  constructor(
    public id: number,
    public name: string) { }
} 

@Injectable()
export class AppService {
 
  constructor(
    private _router: Router, private _http: Http, private oauthService: OAuthService){
        this.oauthService.loginUrl = 'http://localhost:8081/spring-security-oauth-server/oauth/authorize'; 
        this.oauthService.redirectUri = 'http://localhost:8086/';
        this.oauthService.clientId = "sampleClientId";
        this.oauthService.scope = "read write foo bar";    
        this.oauthService.setStorage(sessionStorage);
        this.oauthService.tryLogin({});      
    }
 
  obtainAccessToken(){
      this.oauthService.initImplicitFlow();
  }

  getResource(resourceUrl) : Observable<Foo>{
    var headers = new Headers({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8', 'Authorization': 'Bearer '+this.oauthService.getAccessToken()});
    var options = new RequestOptions({ headers: headers });
    return this._http.get(resourceUrl, options)
                   .map((res:Response) => res.json())
                   .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  isLoggedIn(){
console.log(this.oauthService.getAccessToken());  
    if (this.oauthService.getAccessToken() === null){
       return false;
    }
    return true;
  } 

  logout() {
      this.oauthService.logOut();
      location.reload();
  }
}