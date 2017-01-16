var AddConstituencyContainer = React.createClass({
    
    getInitialState: function() {
        return {
            constituency: {
                name: ''
            }
        }
    },
    
    handleFieldChange: function(fieldName) {
        var self = this;
        return function(e) {
          var constituency = self.state.constituency;
          constituency[fieldName] = e.target.value;
          self.setState({ constituency: constituency });
        };
    },
    
    handleAddConstituency: function(e) {
        e.preventDefault();
        var self = this;
        axios.post('/api/constituency', this.state.constituency).then(function () {
            console.log('constituency added');
            self.context.router.push('/con');
          });
    },
    
    handleCancel: function() {
        this.context.router.push('/con');
    },
    

    render: function() {
        return <AddConstituencyComponent 
            constituency={this.state.constituency} 
            onFieldChange={this.handleFieldChange}
            onAddClick={this.handleAddConstituency}
            onCancel={this.handleCancel} 
              />
    }
});


AddConstituencyContainer.contextTypes = {
        router: React.PropTypes.object.isRequired,
};

window.AddConstituencyContainer = AddConstituencyContainer;