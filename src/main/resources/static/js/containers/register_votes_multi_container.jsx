var RegisterVotesMultiContainer = React.createClass({
            
    getInitialState: function() { 
        var voteList = [];
       for (var i = 0; i < 3; i++) {
       var vote = 'vote' + i;
       voteList.push(vote);
        return {            
            parties: [],
            election: {  
                vote: ''
            }
        };  
        
       }        
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

        for(var i=0; i < this.state.parties.length; i++) {

        axios.post('/api/reg-votes-multi', {

            votes: this.state.election.vote0, 
            party: {id: this.state.parties[i].id},
            district: { id: '1'},
            enetered_date: Date.now()
        })
            .then(function () {
            console.log('vote added');
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