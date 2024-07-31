import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CountryListComponent } from './components/country-list/country-list.component';
import { CountryLanguagesComponent } from './components/country-languages/country-languages.component';
import { CountryStatsComponent } from './components/country-stats/country-stats.component';
import { FilteredStatsComponent } from './components/filtered-stats/filtered-stats.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'countries', component: CountryListComponent },
  { path: 'countries/:id/languages', component: CountryLanguagesComponent },
  { path: 'stats', component: CountryStatsComponent },
  { path: 'filtered-stats', component: FilteredStatsComponent },
];
