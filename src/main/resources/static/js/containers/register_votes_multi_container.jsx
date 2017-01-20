var RegisterVotesMultiContainer = React.createClass({
    
    getInitialState: function() {
        return {
            parties: [],
            election: {                             
                votes: '',
                enetered_date: Date.now(),
                party: {
                    id: '1'
                },
                district: {
                    id: '1'
                }
            }
        };
    },
    
    componentWillMount: function() {
        var self = this;
        axios.get('/api/party')
        .then(function (response) {
            self.setState({ 
                parties: response.data
            });
        });

    },
    
    handleFieldChange: function(fieldName) {
        var self = this;
        return function(e) {
          var election = self.state.election;
          election[fieldName] = e.target.value;
          self.setState({ election: election });
        };
    },
    
    handleVoteClick: function(e) {
        e.preventDefault();
        var self = this;
        for(var i=0; i < this.state.parties.length; i++) {
        axios.post('/api/reg-votes-multi', this.state.election).then(function () {
            console.log('vote added');
/*            self.context.router.push('/parties');*/
          });
        };
        this.context.router.push('/parties');
    },
    
    render: function() {
        return <RegisterVotesMultiComponent 
        parties={this.state.parties} 
        election={this.state.election}
        onFieldChange={this.handleFieldChange}
        onVoteClick={this.handleVoteClick}
        />
    }
});

RegisterVotesMultiContainer.contextTypes = {
        router: React.PropTypes.object.isRequired,
};

window.RegisterVotesMultiContainer = RegisterVotesMultiContainer;