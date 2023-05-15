var sumFibonacci = 0;
var numberA = 0;
var numberB = 1;
var fibonacci;
var n = 20;
var arrFibonacci = [];
for (var i = 0; i < n; i++) {
    fibonacci = numberA + numberB;
    arrFibonacci.push(fibonacci);
    numberA = numberB;
    numberB = fibonacci;
}
for (var i = 0; i < arrFibonacci.length; i++) {
    sumFibonacci += arrFibonacci[i];
}
console.log(arrFibonacci);
console.log("Sum 20 number Fibonacci fist is : " + sumFibonacci);
