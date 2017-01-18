var DistrictListComponent = React.createClass({
    render: function() {     

       var self = this;
        var districtList = this.props.constituency.map( function( district, index ) {
            var rep_name = "nepriskirta";
            if (district.representative != null) {
                rep_name = district.representative.name;
            }
          return (
              <tr key={index}>
              <td>{district.title}</td>
              <td>{district.address}</td>
              <td>{district.voters}</td>
              <td>{rep_name}</td>
              <td><button type="button" className="btn btn-primary" onClick={self.props.onAdministerRepresentative}>Administruoti atstovą</button></td>
              <td>
              <button type="button" className="btn btn-default">
              <span className="glyphicon glyphicon-remove"></span>
              </button></td></tr>
          );
        });

      return (
              <div className="panel panel-default">
              <h3>{this.props.constit.title}</h3>

              <table className="table">     
              <thead>  
              <tr>
                  <th>Alinkės pavadinimas</th>
                  <th>Adresas</th>
                  <th>Rinkėjų skaičius</th>
                  <th>Atstovas</th>
                  <th></th>
                  <th>Trinti</th>
                </tr>
                  </thead>
                  <tbody>
                  {districtList}
{/*             
              <tr>
              <td>L. Giros</td>
              <td>L. Giros g. 5, Vilnius</td>
              <td>4523</td>
              <td>nepriskirta</td>
              <td><button type="button" className="btn btn-primary" onClick={this.props.onAddRepresentative}>Pridėti atstovą</button></td>
              <td>
              <button type="button" className="btn btn-default">
              <span className="glyphicon glyphicon-remove"></span>
              </button></td></tr>
*/}
                  </tbody>
              </table>
            </div>
              )
    }
});




window.DistrictListComponent = DistrictListComponent;