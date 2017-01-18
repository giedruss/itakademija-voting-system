var RegisterVotesMultiContainer = React.createClass({
    
    getInitialState: function() {
        return {
            parties: [] 
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
    
    render: function() {
        return <RegisterVotesMultiComponent parties={this.state.parties}  />
    }
});


window.RegisterVotesMultiContainer = RegisterVotesMultiContainer;