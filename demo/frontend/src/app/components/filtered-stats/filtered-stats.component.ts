import { Component, OnInit } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, FormGroup } from '@angular/forms';
import { CountryService } from '../../services/country.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-filtered-stats',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './filtered-stats.component.html',
  styleUrls: ['./filtered-stats.component.css'],
})
export class FilteredStatsComponent implements OnInit {
  form: FormGroup;
  stats: any;
  regions: any;

  constructor(private fb: FormBuilder, private countryService: CountryService) {
    this.form = this.fb.group({
      region: [''],
      dateFrom: [''],
      dateTo: [''],
    });
  }

  ngOnInit(): void {
    this.countryService.getRegions().subscribe((data) => {
      this.regions = data;
    });
  }

  onFilter(): void {
    const { region, dateFrom, dateTo } = this.form.value;
    this.countryService.getFilteredStats(region, dateFrom, dateTo).subscribe((data) => {
      this.stats = data;
    });
  }
}
