
class Mask extends React.Component{
    constructor(props){
        super(props);
        this.state = {};

    }

    render() {
        return (
            <div className={this.state.show?"mask show":"mask"} onClick={this.props.handleClick}></div>
        )
    }
}
