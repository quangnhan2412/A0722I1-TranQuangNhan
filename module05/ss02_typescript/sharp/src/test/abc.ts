import * as readline from 'readline';

async function prompt(question: string) {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  return new Promise<string>((resolve) => {
    rl.question(question, (answer) => {
      rl.close();
      resolve(answer);
    });
  });
}

async function main() {
  const answer = await prompt('Nhập vào một chuỗi: ');
  console.log(`Bạn đã nhập: ${answer}`);
}

main();
