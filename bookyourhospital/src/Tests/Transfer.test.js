import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import Transfer from "../Transfer/Transfer";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('Transfer: can render and select a button', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<Transfer />, container);
    });

    //get elements and set values
    const button = container.querySelector('Button');
    //const input = container.querySelector('input');
    //input.value = "34565";

    //simulate click
    act(() => {
        if(button != null)
            button.dispatchEvent(new MouseEvent('click', {bubbles: true}));
    });
});

