import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import TanError from "../TanService/TanError";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('TanError: can render', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<TanError />, container);
    });
});
