let sumFibonacci: number = 0;
let numberA: number = 0;
let numberB: number = 1;
let fibonacci: number;
let n: number = 20;
let arrFibonacci: number[] = [];
for (let i = 0; i < n; i++) {
    fibonacci = numberA + numberB;
    arrFibonacci.push(fibonacci);
    numberA = numberB;
    numberB = fibonacci;
}
for (let i = 0; i < arrFibonacci.length; i++) {
    sumFibonacci += arrFibonacci[i];
}
console.log(arrFibonacci)
console.log("Sum 20 number Fibonacci fist is : " + sumFibonacci)


