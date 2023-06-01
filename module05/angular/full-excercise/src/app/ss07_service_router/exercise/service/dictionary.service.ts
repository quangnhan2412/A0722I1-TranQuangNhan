import {Injectable} from '@angular/core';
import {Iword} from '../model/iword';
import {id} from 'date-fns/locale';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  wordList: Iword[] = [
    {
      id: 12, word: 'dog', mean: 'con chó'
    }, {
      id: 22, word: 'chicken', mean: 'con gà'
    }, {
      id: 32, word: 'tiger', mean: 'con hổ'
    },
  ];

  constructor() {
  }

  getFindByIndex(index: number) {
    return this.wordList.filter(item => item.id === index)[0];
  }
}
