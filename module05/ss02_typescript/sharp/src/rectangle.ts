import { Sharp } from "./Sharp";
import { IArea } from "./IArea";

export class Rectangle extends Sharp implements IArea{

  constructor(x: number, y: number,private _width:number,private _height:number) {
    super(x, y);
  }

  area(): number {
    return  this.x*this.y;
  }

  get width() {
    return this._width;
  }

  set width(value) {
    this._width = value;
  }

  get height() {
    return this._height;
  }

  set height(value) {
    this._height = value;
  }

 toString(): string {
    return "width: " +this.x +
            " height: "+this.y ;
  }
}
