import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import TanServiceSMS from "../TanService/TanServiceSMS";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('TanServiceSMS: can render and send sms', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<TanServiceSMS />, container);
    });

    //get elements and set values
    const button = container.querySelector('button');
    const input = container.querySelector('input');
    input.value = "+4369911345176";

    //simulate click
    act(() => {
        button.dispatchEvent(new MouseEvent('click', {bubbles: true}));
    });
});
