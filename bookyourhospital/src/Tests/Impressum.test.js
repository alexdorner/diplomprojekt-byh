import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import Impressum from "../components/Impressum";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('Impressum: can render and select a button', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<Impressum />, container);
    });
});

