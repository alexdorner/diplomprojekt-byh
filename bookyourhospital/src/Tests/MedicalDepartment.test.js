import React from 'react';
import ReactDOM from 'react-dom';
import { act } from 'react-dom/test-utils';
import MedicalDepartment from "../Selection/MedicalDepartment";
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

it('MedicalDepartment: can render and select a button', () => {
    // Test first render and componentDidMount
    act(() => {
        ReactDOM.render(<MedicalDepartment />, container);
    });

    //get elements and set values
    const dropdown = getByText(container, "Abteilung auswählen")
    fireEvent.change(dropdown, {target: {value: "Orthopäde"} });
});

