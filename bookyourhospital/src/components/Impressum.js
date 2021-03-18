import React, { Component } from 'react';

class Impressum extends Component {
    render() {
        return (
            <div style={{ display: 'flex', justifyContent: 'center', padding: 30 }}>
                <div>
                    <h2>Impressum</h2>
                </div>
                <div>
                    <a>
                        In Österreich muss jede Webseite ein Impressum haben,
                    </a>
                    <a>
                        umgangssprachlich wird dies auch Offenlegungspflicht genannt.
                    </a>
                    <a>
                        In jene sollte folgende Inhalte gewährleistet sein.
                    </a>
                    <a>
                        Name laut Firmenbuch, Rechtsform, Sitz laut Firmenbuch, Firmenbuchnummer und Gericht.
                    </a>
                    <a>
                        Jedoch können sich diese Angaben je nach Anwendungsbereich ändern.
                    </a>
                </div>
            </div>
        );
    }
}

export default Impressum;