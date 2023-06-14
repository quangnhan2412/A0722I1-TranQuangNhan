// import {Pipe, PipeTransform} from '@angular/core';
//
// @Pipe({
//   name: 'search'
// })
// export class SearchPipe implements PipeTransform {
//
//   transform(value: any, args?: string): any {
//     // if no data,return null
//     if (!value) {
//       return null;
//     }
//     // if no search return data
//     if (!args) {
//       return value;
//     }
//     args = args.toLowerCase();
//     return value.filter((item: any) => {
//       return JSON.stringify(item).toLowerCase().includes(args);
//     });
//   }
//
// }
