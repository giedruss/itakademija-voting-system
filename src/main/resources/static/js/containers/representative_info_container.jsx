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
    
    render: function() {
        return <RepresentativeInfoComponent 
        representative={this.state.representative}
        />
    }
});


window.RepresentativeInfoContainer = RepresentativeInfoContainer;