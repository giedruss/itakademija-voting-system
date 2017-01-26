var RepresentativeInfoContainer = React.createClass({
    
    getInitialState: function() {
        return {
            representative: []
        };
    },
    
    componentWillMount: function() {
        var self = this;
        var repId = this.props.params.repId;
        axios.get('/api/representative/' + repId)
        .then(function (response) {
            self.setState({ 
                representative: response.data
            });
        });
        

    },
    
    handleDelete: function() {
        var self = this; 
        var repId = this.props.params.repId;
         
          axios.delete('/api/representative/'+ repId).then(function(response) { 
              console.log('item deleted'); 
              
              var district = self.state.representative.districtId;
              
/*              var constituency = axios.get('/api/district/' + district)
              .then(function (response) {
                      response.data.constituencyId
              });*/
              
              console.log(district);
              self.context.router.push( '/con' );
/*              self.context.router.push( '/con/' +  constituency);*/
          }); 
        
        
    },
    
    handleCancel: function() {

        
    },
    
    render: function() {
        return <RepresentativeInfoComponent 
        representative={this.state.representative}
        onDelete={this.handleDelete}
        onCancel={this.handleCancel}
        />
    }
});

RepresentativeInfoContainer.contextTypes = {
        router: React.PropTypes.object.isRequired,
};

window.RepresentativeInfoContainer = RepresentativeInfoContainer;