import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import TanOK from "../TanService/TanOK";

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
        ReactDOM.render(<TanOK />, container);
    });
});