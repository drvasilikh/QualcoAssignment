import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CountryService } from '../../services/country.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-country-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css'],
})
export class CountryListComponent implements OnInit {
  countries: any;

  constructor(private countryService: CountryService, private router: Router) {}

  ngOnInit(): void {
    this.countryService.getAllCountries().subscribe((data) => {
      this.countries = data;
    });
  }

  onCountryClick(countryId: number) {
    console.log(countryId)
    this.router.navigate(['/countries', countryId, 'languages']);
  }
}
