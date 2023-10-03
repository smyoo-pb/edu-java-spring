import { useEffect, useState } from "react";

const btnStyle = {
    backgroundColor: "#6499E9",
    color: "white",
    padding: "10px 20px",
    border: "none",
    borderRadius: "5px",
    cursor: "pointer",
    marginTop: "10px",
    marginLeft: "10px",
    marginRight: "10px"
};

const incrementBtnStyle = btnStyle;

const decrementBtnStyle = {
    ...btnStyle,
    backgroundColor: "#04364A"
}

const resetBtnStyle = {
    ...btnStyle,
    backgroundColor: "#C4C4C4"
}

export default function Counter() {
    const [totalCount, setTotalCount] = useState<number>(0);

    function handleChange(value: number) {
        setTotalCount(totalCount + value > 0 ? totalCount + value : 0);
    }

    function handleReset() {
        setTotalCount(0);
    }

    return (
        <>
            <div className="totalCount">
                totalCount: {totalCount}
            </div>
            <CounterElement onChange={handleChange} />
            <CounterElement by={2} onChange={handleChange} />
            <CounterElement by={5} onChange={handleChange} />
            <button
                style={resetBtnStyle}
                onClick={handleReset}
            >
                Reset
            </button>
        </>
    )
}

interface CounterProps {
    by?: number;
    onChange: (value: number) => void;
}

function CounterElement({ by = 1, onChange }: CounterProps) {
    function increment() {
        onChange(by);
    }

    function decrement() {
        onChange(-1 * by);
    }

    return (
        <div className="Counter">
            {/* <p>Count: {count}</p> */}
            <button
                style={incrementBtnStyle}
                onClick={increment}>
                Increment By {by}
            </button>
            <button
                style={decrementBtnStyle}
                onClick={decrement}
            >
                Decrement By {by}
            </button>
        </div>
    )
}