
class Root extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            menuToggle: false,
            content: "storeTable"
        }
    }

    setContent = (content) => {
        if (!content)
            return;
        this.setState({ content: content });
    }

    render() {
        let root = this;
        let menuToggle = function () {
            root.setState({ menuToggle: !root.state.menuToggle })
        }

        let mask = <Mask ref="mask" handleClick={menuToggle} />
        if (this.state.menuToggle)
            setTimeout(() => {
                this.refs.mask.setState({ "show": true });
            }, 0);
        return (
            <div id="body">
                <Menu show={this.state.menuToggle ? true : false} menuToggle={menuToggle} setContent={this.setContent} />
                <Main menuToggle={menuToggle} showMenu={this.state.menuToggle} content={this.state.content} />
                <Info showMenu={this.state.menuToggle} />
                {this.state.menuToggle ? mask : ""}
            </div>
        )
    }
}

