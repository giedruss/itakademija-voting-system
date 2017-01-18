var AddPartyContainer = React.createClass({
    
    getInitialState: function() {
        return {
            party: {
                title: '',
                party_abbreviation: ''
            }
        }
    },
    
    handleFieldChange: function(fieldName) {
        var self = this;
        return function(e) {
          var party = self.state.party;
          party[fieldName] = e.target.value;
          self.setState({ party: party });
        };
    },
    
    handleAddParty: function(e) {
        e.preventDefault();
        var self = this;
        axios.post('/api/party', this.state.party).then(function () {
            console.log('party added');
            self.context.router.push('/parties');
          });
    },
    
    handleCancel: function() {
        this.context.router.push('/parties');
    },
    

    render: function() {
        return <AddPartyComponent 
            party={this.state.party} 
            onFieldChange={this.handleFieldChange}
            onAddClick={this.handleAddParty}
            onCancel={this.handleCancel}/>
    }
});


AddPartyContainer.contextTypes = {
        router: React.PropTypes.object.isRequired,
};

window.AddPartyContainer = AddPartyContainer;