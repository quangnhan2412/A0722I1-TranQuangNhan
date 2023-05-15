"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Sharp = void 0;
var Sharp = /** @class */ (function () {
    function Sharp(x, y) {
        this._x = x;
        this._y = y;
    }
    Object.defineProperty(Sharp.prototype, "x", {
        get: function () {
            return this._x;
        },
        set: function (value) {
            this._x = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Sharp.prototype, "y", {
        get: function () {
            return this._y;
        },
        set: function (value) {
            this._y = value;
        },
        enumerable: false,
        configurable: true
    });
    return Sharp;
}());
exports.Sharp = Sharp;
