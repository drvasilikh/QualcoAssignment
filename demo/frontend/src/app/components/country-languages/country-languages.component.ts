import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CountryService } from '../../services/country.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-country-languages',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './country-languages.component.html',
  styleUrls: ['./country-languages.component.css'],
})
export class CountryLanguagesComponent implements OnInit {
  countryId: number;
  languages: any;

  constructor(
    private route: ActivatedRoute,
    private countryService: CountryService
  ) {
    this.countryId = this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.countryService.getLanguagesByCountryId(this.countryId).subscribe((data) => {
      this.languages = data;
    });
  }
}
