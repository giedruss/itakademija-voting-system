var DistrictListContainer = React.createClass({

    getInitialState: function() {
        return {
            districts: [] ,
            constit: []
        };
    },
    
    componentWillMount: function() {
        var self = this;
        var conId = this.props.params.conId;
        axios.get('/api/constituency/' + conId)
        .then(function (response) {
            self.setState({ 
                districts: response.data.districts,
                constit: response.data
            });
        });

    },
    
    handleAdministerRepresentative: function() {
        this.context.router.push('/repres');
    },
    
    handleAddRepresentative: function() {
        this.context.router.push('/add-rep');
    },
    
    render: function() {
        return (
        <div>
        <DistrictListComponent 
            districts={this.state.districts} 
            constit={this.state.constit}
            representative={this.state.representative}   
            onAdministerRepresentative={this.handleAdministerRepresentative} 
            onAddRepresentative={this.handleAddRepresentative}/>
        <AddNewContainer redirectTo={'/add-dis'}/>
        </div>
        )
  }
});

DistrictListContainer.contextTypes = {
        router: React.PropTypes.object.isRequired
};


window.DistrictListContainer = DistrictListContainer;