import React, { useState } from "react";
import './Counter.css';
import PropTypes from 'prop-types'
export default function Counter({by}) {

    const [count, setState] = useState(0)

    function incrementCounte() {
        setState(count + by)
        console.log("Counter: "+count)
    }

    function decrementCounter() {
        console.log("Counter: "+count)
        if (count === 0) {
            setState(0)
        } else {
            setState(count - by)
        }
    

    }

    return (
        <div className="Counter">
            <span className="count">{count}</span>
            <div>
                <button className="counterButton"
                    onClick={incrementCounte}
                >+{by}</button>
                <button className="counterButton"
                    onClick={decrementCounter}
                >-{by}</button>
            </div>
        </div>
    );
}

Counter.proptypes = {
    by : PropTypes.number
}

Counter.defaultProps = {
    by: 1
}