import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import ServiceUnit from "../Selection/ServiceUnit";
import {fireEvent, getByText} from "@testing-library/react";

let container;

beforeEach(() => {
    container = document.createElement('div');
    document.body.appendChild(container);
});

afterEach(() => {
    document.body.removeChild(container);
    container = null;
});

it('ServiceUnit: can render and select a button', () => {
    
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<ServiceUnit />, container);
    });

    //get elements and set values
    const dropdown = getByText(container, "Fachbereich auswählen")
    fireEvent.change(dropdown, {target: {value: "Mittelfuß"} });
});

