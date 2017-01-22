var AddDistrictContainer = React.createClass({
    
    getInitialState: function() {
        return {
            district: {
                title: '',
                voters: '',
                address: ''                
            }
        }
    },
    
    handleFieldChange: function(fieldName) {
        var self = this;
        return function(e) {
          var district = self.state.district;
          district[fieldName] = e.target.value;
          self.setState({ district: district });
        };
    },
    
    handleAddDistrict: function(e) {
        e.preventDefault();
        var self = this;
        axios.post('/api/district', this.state.district).then(function () {
            console.log('district added');
            self.context.router.push('/dis');
          });
    },
    
    handleCancel: function() {
        this.context.router.push('/dis');
    },
    
    render: function() {
        return <AddDistrictComponent 
            district={this.state.district} 
            onFieldChange={this.handleFieldChange}
            onAddClick={this.handleAddDistrict}
            onCancel={this.handleCancel}/>
    }
});

AddDistrictContainer.contextTypes = {
        router: React.PropTypes.object.isRequired,
};

window.AddDistrictContainer = AddDistrictContainer;