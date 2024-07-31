import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountryService {

  private baseUrl = 'http://localhost:8080/countries';

  constructor(private http: HttpClient) { }

  getAllCountries(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  getLanguagesByCountryId(countryId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${countryId}/languages`);
  }

  getMaxGdpPerPopulation(): Observable<any> {
    return this.http.get(`${this.baseUrl}/max-gdp-per-population`);
  }

  getRegions(): Observable<any> {
    return this.http.get(`http://localhost:8080/regions`);
  }

  getFilteredStats(region: string, dateFrom: string, dateTo: string): Observable<any> {
    return this.http.get(`http://localhost:8080/filtered-stats`, {
      params: { region, dateFrom, dateTo },
    });
  }
}
