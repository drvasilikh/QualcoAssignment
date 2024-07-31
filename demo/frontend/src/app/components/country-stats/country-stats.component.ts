import { Component, OnInit } from '@angular/core';
import { CountryService } from '../../services/country.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-country-stats',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './country-stats.component.html',
  styleUrls: ['./country-stats.component.css'],
})
export class CountryStatsComponent implements OnInit {
  stats: any;

  constructor(private countryService: CountryService) {}

  ngOnInit(): void {
    this.countryService.getMaxGdpPerPopulation().subscribe((data) => {
      this.stats = data;
    });
  }
}
