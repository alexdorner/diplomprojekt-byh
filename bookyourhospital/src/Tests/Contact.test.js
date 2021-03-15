import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import Contact from "../components/Contact";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('Contact: can render and select a button', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<Contact />, container);
    });
});

