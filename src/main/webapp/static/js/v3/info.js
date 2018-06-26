class Info extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            waitingCount: 0
        }
        setInterval(() => {
            $.get(window.urls.waitingCount, (data) => {
                this.setState({
                    waitingCount: data
                })
            })
        },5000)
    }

    render() {
        let className = this.props.showMenu ? "info showMenu" : "info notShowMenu"
        return (
            <div className={className}>
                <div className="infoHeader">{window.string.tableName.labelStatus}</div>
                <div style={{ margin: "20px" }}>{window.string.function.waitingCount} : {this.state.waitingCount}</div>
            </div>
        )
    }
}