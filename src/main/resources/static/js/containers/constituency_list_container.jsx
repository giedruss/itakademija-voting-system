var ConstituencyListContainer = React.createClass({

    getInitialState: function() {
        return {
            constituencies: [] 
        };
    },
    
    componentWillMount: function() {
        var self = this;
        axios.get('/api/constituency')
        .then(function (response) {
            self.setState({ 
                constituencies: response.data 
            });
        });

    },
    
    handleAdministerDistricts: function(constituency) {
        var self = this;
        return function() {
                self.context.router.push('/dis/' + constituency.id);
        }
    },
    
    render: function() {
        return (
                <div>
                <ConstituencyListComponent constituencies={this.state.constituencies} onAdministerDistricts={this.handleAdministerDistricts}/>
                <AddNewContainer redirectTo={'/add-con'}/>
                </div>
                )
  }
});

ConstituencyListContainer.contextTypes = {
        router: React.PropTypes.object.isRequired
};


window.ConstituencyListContainer = ConstituencyListContainer;