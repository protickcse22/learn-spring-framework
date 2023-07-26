import React, { useState } from "react";
import CounterButton from "./CounterButton";

export default function Counter() {
    const [count, setState] = useState(0)
    function incrementCounte(by) {
        setState(count + by)
        console.log("Counter: " + count)
    }

    function decrementCounter(by) {
        console.log("Counter: " + count)
        if (count === 0) {
            setState(0)
        } else {
            setState(count - by)
        }


    }

    function resetCounter() {
        setState(0)
    }
    return (
        <div>
            <div>
                <CounterButton incremetMethod={incrementCounte} decrementMethod={decrementCounter}/>
                <CounterButton by={2} incremetMethod={incrementCounte} decrementMethod={decrementCounter}/>
                <CounterButton by={5} incremetMethod={incrementCounte} decrementMethod={decrementCounter}/>
            </div>
            <span className="count">{count}</span>
            <div>
                <button className="resetButton" onClick={resetCounter}>Reset</button>
            </div>
        </div>

    );
}