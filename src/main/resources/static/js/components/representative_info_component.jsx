var RepresentativeInfoComponent = React.createClass({
    render: function() {
        return (
                <div>
                <p>Vardas: {this.props.representative.name}</p>
                <p>Pavardė: {this.props.representative.surname}</p>
                <p>Prisijungimo vardas: {this.props.representative.loginName}</p>
                <p>Slaptažodis: {this.props.representative.password}</p>
                <p>El. paštas: {this.props.representative.email}@vrk.lt</p>
                <button className="btn btn-success" >Redaguoti</button>
                <button className="btn btn-info">Siųsti prisijungimus atstovui</button>
                <button className="btn btn-danger">Trinti atstovą</button>
                <button className="btn btn-warning">Grįžti</button>
                </div>
        
        )
    }
});

window.RepresentativeInfoComponent = RepresentativeInfoComponent;