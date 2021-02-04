import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import TanServiceEmail from "../TanService/TanServiceEmail";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('TanServiceEmail: can render and send email', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<TanServiceEmail />, container);
    });

    //get elements and set values
    const button = container.querySelector('button');
    const input = container.querySelector('input');
    input.value = "gru18163@spengergasse.at";

    //simulate click
    act(() => {
        button.dispatchEvent(new MouseEvent('click', {bubbles: true}));
    });
});
