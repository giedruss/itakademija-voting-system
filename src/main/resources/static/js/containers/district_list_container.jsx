var DistrictListContainer = React.createClass({

    getInitialState: function() {
        return {
            districts: [] 
        };
    },
    
    componentWillMount: function() {
        var self = this;
        axios.get('/api/district')
        .then(function (response) {
            self.setState({ 
                districts: response.data 
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
        <h3>Naujamiesčio apygarda</h3>
        <DistrictListComponent 
            districts={this.state.districts} 
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