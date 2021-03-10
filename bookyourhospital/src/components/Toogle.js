import React from 'react'
import { func, string } from 'prop-types';
import styled from 'styled-components';
// Import a couple of SVG files we'll use in the design: https://www.flaticon.com
import { ReactComponent as MoonIcon } from './moon.svg';
import { ReactComponent as SunIcon } from './sun.svg';
import './Toggle.styled';
import {Button, ToggleButton, ToogleButtonGroup} from "react-bootstrap";
import ToggleButtonGroup from 'react-bootstrap/ToggleButtonGroup'

const Toggle = ({ theme, toggleTheme }) => {
    const isLight = theme === 'light';
    return (
        <button onClick={toggleTheme} >
            <SunIcon />
            <MoonIcon />
        </button>
    );
};

Toggle.propTypes = {
    theme: string.isRequired,
    toggleTheme: func.isRequired,
}

export default Toggle;