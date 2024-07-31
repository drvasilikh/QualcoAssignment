import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CountryService } from '../../services/country.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-filtered-stats',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './filtered-stats.component.html',
  styleUrls: ['./filtered-stats.component.css']
})
export class FilteredStatsComponent implements OnInit {

  form: FormGroup;
  regions: any;
  stats: any;

  constructor(private fb: FormBuilder, private countryService: CountryService) {
    this.form = this.fb.group({
      region: ['', Validators.required],
      dateFrom: ['', [Validators.required, Validators.min(1), Validators.max(9999)]],
      dateTo: ['', [Validators.required, Validators.min(1), Validators.max(9999)]]
    });
  }

  ngOnInit(): void {
    this.countryService.getRegions().subscribe(data => {
      this.regions = data;
    });
  }

  onFilter(): void {
    if (this.form.valid) {
      const { region, dateFrom, dateTo } = this.form.value;
      this.countryService.getFilteredStats(region, dateFrom, dateTo).subscribe(data => {
        this.stats = data;
      });
    }
  }
}
