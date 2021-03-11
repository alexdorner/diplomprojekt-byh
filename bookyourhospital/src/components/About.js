import React, {Component} from 'react';
import {InputGroup} from "react-bootstrap";
import {text} from './AboutBYH.txt';

class About extends Component {
    /*
        onLoad = function (event){
            var file = fileInput.files[0];
            var textType = /text.*/
    //;

    /*
            if (file.type.match(textType)) {
                var reader = new FileReader();

                reader.onload = function(e) {
                    var content = reader.result;
                    //Here the content has been read successfully
                    alert(content);
                }

                reader.readAsText(file);
            }
        }*/

    render() {
        return (
            <center>
                <div style={{display: 'flex', justifyContent: 'center', padding: 30}}>
                    <h2>Über BookYourHospital!</h2>
                </div>
                <div>
                    <input type="file" id="fileInput" onChange="onLoad(event)"></input>
                </div>
            </center>
        );
    }
}

export default About;
