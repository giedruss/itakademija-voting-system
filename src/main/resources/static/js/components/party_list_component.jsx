var PartyListComponent = React.createClass({
    render: function() {

        var self = this;
        var partyList = this.props.parties.map( function( party, index ) {
          return (
              <tr key={index}>
              <td>{party.title}</td>
              <td>{party.party_abbreviation}</td>
              <td>
              <button type="button" className="btn btn-default"  onClick={self.props.onRemoveItem(party)}>
              <span className="glyphicon glyphicon-remove"></span>
              </button></td></tr>
          );
        });
 
      return (
              <div className="panel panel-default">

              <table className="table table-hover">     
              <thead>  
                  <tr>
                      <th>Partijos pavadinimas</th>
                      <th>Trumpinys</th>
                      <th>Trinti</th>
                  </tr>
              </thead>
              <tbody>
                      {partyList}
                  
              </tbody>
              </table>
            </div>
              )
    }
  });

ConstituencyListComponent.propTypes = {
        parties: React.PropTypes.array.isRequired
};


window.PartyListComponent = PartyListComponent;