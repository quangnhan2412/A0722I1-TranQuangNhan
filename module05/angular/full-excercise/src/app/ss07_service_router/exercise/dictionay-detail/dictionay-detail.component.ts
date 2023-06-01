import {Component, OnInit} from '@angular/core';
import {Iword} from '../model/iword';
import {ActivatedRoute, ParamMap, Params} from '@angular/router';
import {DictionaryService} from '../service/dictionary.service';
import {id, th} from 'date-fns/locale';

@Component({
  selector: 'app-dictionay-detail',
  templateUrl: './dictionay-detail.component.html',
  styleUrls: ['./dictionay-detail.component.css']
})
export class DictionayDetailComponent implements OnInit {
  wordDetail: Iword | undefined;
  id: number | undefined;

  constructor(private activatedRoute: ActivatedRoute,
              private dictionaryService: DictionaryService) {
  }

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = parseInt(paramMap.get('id'), 10);
      console.log(this.id);
      this.wordDetail = this.dictionaryService.getFindByIndex(this.id);
    });
  }

}
