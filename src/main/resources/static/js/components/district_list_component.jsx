var DistrictListComponent = React.createClass({
    render: function() {

        var self = this;
        var districtList = this.props.districts.map( function( district, index ) {
          return (
              <tr key={index}>
              <td>{district.title}</td>
              <td>0</td>
              <td>{district.voters}</td>
              <td>atstovas</td>
              <td><button type="button" className="btn btn-primary" onClick={self.props.onAdministerRepresentative}>Administruoti atstovą</button></td>
              <td>
              <button type="button" className="btn btn-default">
              <span className="glyphicon glyphicon-remove"></span>
              </button></td></tr>
          );
        });
        
      return (
              <div className="panel panel-default">
              <h3>Naujamiesčio apygarda</h3>
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
              
{/*             <tr>
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

ConstituencyListComponent.propTypes = {
        districts: React.PropTypes.array.isRequired
};


window.DistrictListComponent = DistrictListComponent;