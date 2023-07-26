import React, { useState } from "react";
import './Counter.css';
import PropTypes from 'prop-types'
export default function CounterButton({by, incremetMethod,  decrementMethod}) {

    return (
        <div className="Counter">
            <div>
                <button className="counterButton"
                    onClick={() => incremetMethod(by)}
                >+{by}</button>
                <button className="counterButton"
                    onClick={() => decrementMethod(by)}
                >-{by}</button>
            </div>
        </div>
    );
}

CounterButton.proptypes = {
    by: PropTypes.number
}

CounterButton.defaultProps = {
    by: 1
}