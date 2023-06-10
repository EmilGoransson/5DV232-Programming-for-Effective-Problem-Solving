const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
const lines = [];

rl.on('line', (line) => {
    lines.push(line);
});

rl.on('close', () => {
    const isCoffeeMachine = String(lines[1]);

    const isCoffeeArray = isCoffeeMachine.split("");
    let totalDaysAwake = 0;
    let currentCountCoffee = 0;

    isCoffeeArray.forEach((isMachine) =>{
        if(currentCountCoffee>0 || isMachine === "1"){
            totalDaysAwake++
            currentCountCoffee--;
        }
        if(isMachine === "1"){
            currentCountCoffee = 2;
        }
    })
    console.log(totalDaysAwake)
});
