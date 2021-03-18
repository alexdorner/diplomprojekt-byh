import React, { Component } from 'react';

class Impressum extends Component {
    render() {
        return (
            <center >
                <div>
                    <h2>Impressum</h2>
                </div>
                <div>
                    <p>
                        In Österreich muss jede Webseite ein Impressum haben,
                    </p>
                    <p>
                        umgangssprachlich wird dies auch Offenlegungspflicht genannt.
                    </p>
                    <p>
                        In jenes sollte folgende Inhalte gewährleistet sein.
                    </p>
                    <p>
                        Name laut Firmenbuch, Rechtsform, Sitz laut Firmenbuch, Firmenbuchnummer und Gericht.
                    </p>
                    <p>
                        Jedoch können sich diese Angaben je nach Anwendungsbereich ändern.
                    </p>
                </div>
            </center>
        );
    }
}

export default Impressum;