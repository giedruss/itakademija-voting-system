var AddPartyComponent = React.createClass({
    render: function() {
        return (
                <form>         
                <label>Partijos pavadinimas</label><br />
                <input className="form-control" type="text" value={this.props.party.title} onChange={this.props.onFieldChange('title')} /><br />
                
                <label>Trumpinys</label><br />
                <input className="form-control" type="text" /><br />
                
                <button className="btn btn-success"  onClick={this.props.onAddClick}>Pridėti</button>
                <button className="btn btn-danger" onClick={this.props.onCancel}>Atšaukti</button>
                </form>
                
        
        )
    }
});

AddPartyComponent.propTypes = {
        party: React.PropTypes.object.isRequired,
        onFieldChange: React.PropTypes.func.isRequired,
        onAddClick: React.PropTypes.func.isRequired
};

window.AddPartyComponent = AddPartyComponent;