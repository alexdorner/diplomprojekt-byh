import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import DSGVO from "../components/DSGVO";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('DSGVO: can render and select a button', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<DSGVO />, container);
    });
});

