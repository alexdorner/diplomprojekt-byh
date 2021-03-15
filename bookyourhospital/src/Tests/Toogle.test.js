import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import Toogle from "../components/Toogle";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('Toogle: can render and select a button', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<Toogle />, container);
    });
});

