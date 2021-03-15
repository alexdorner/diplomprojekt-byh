import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import About from "../components/About";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('About: can render and select a button', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<About />, container);
    });
});

