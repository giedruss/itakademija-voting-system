var RegisterVotesMultiComponent = React.createClass({
    render: function() {
        
        var self = this;
        var partyList = this.props.parties.map( function( party, index ) {
          return (
                  <div>
                  <label>{party.title}</label>
                  <input className="form-control" type="number" /><br />
                  </div>
          );
        });
        

        return (
                <form>         
                <h3>Daugiamandatės</h3>
                <h4>Apygarda: ...</h4>
                <h4>Apylinkė: ...</h4><br />
                {partyList}
                
                <input type="checkbox" /> Patvirtinu, kad įvesti duomenys teisingi.<br />
                
                <button className="btn btn-success" >Pateikti rezultatus</button>
                <button className="btn btn-danger">Atšaukti</button>
                </form>
                
        
        )
    }
});

RegisterVotesMultiComponent.propTypes = {
        parties: React.PropTypes.array.isRequired
};

window.RegisterVotesMultiComponent = RegisterVotesMultiComponent;