import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import NoTransfer from "../Transfer/NoTransfer";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('NoTransfer: can render and select a button', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<NoTransfer />, container);
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

