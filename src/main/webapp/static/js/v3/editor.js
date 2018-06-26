class EditorPane extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            updatedData: props.selectedData
        }

        this.cancel = this.cancel.bind(this)
        this.save = this.save.bind(this)
    }

    componentWillReceiveProps(props) {
        let tmp = {};
        for (var name in props.selectedData) {
            tmp[name] = props.selectedData[name]
        }
        this.setState({
            updatedData: tmp
        })
    }

    save = () => {
        this.props.removeEditable();
        console.log(JSON.stringify(this.state.updatedData))
        $.ajax({
            url: this.props.updateUrl,
            type: "post",
            // Form数据
            data: JSON.stringify(this.state.updatedData),
            async: false,
            cache: false,
            contentType: "application/json; charset=utf-8",
            processData: false,
            success: (data) => {
                console.log(data)
                if (data == 'success') {
                    alert(window.string.tips.updateSuccess)
                    this.props.refreshTable(this.state.updatedData);
                }
                else
                    alert(window.string.tips.failed);
            }
        })
    }

    cancel = () => {
        this.setState({
            updatedData: this.props.selectedData
        })
        this.props.removeEditable();
    }

    change = (e) => {
        let tmp = this.state.updatedData;
        if(e.target.type=='checkbox')
            tmp[e.target.name] = e.target.checked;
        else
            tmp[e.target.name] = e.target.value;
        console.log(e.target.checked);
        this.setState({
            updatedData: tmp
        })
    }

    getInputType(type) {
        switch (type) {
            case "double", "text", "barcode", "qrcode":
                return "text";
            case "boolean":
                return "checkbox";
            case "image":
                return "file";
        }
    }

    render() {

        let list = this.props.headers.map((header) => {
            return (
                <li className="editorElement">
                    <label className="editorLabel" for={header.name}>{header.alias}:</label>
                    {header.type=='boolean'?
                    <input className={((this.props.editable && header.editable) ? "editorInput" : "editorInput disabled")}
                        type={this.getInputType(header.type)} id={header.name} name={header.name} disabled={(!this.props.editable) || !header.editable}
                        checked={this.state.updatedData||this.state.updatedData[header.name]}
                        onChange={this.change} />
                    :
                    <input className={((this.props.editable && header.editable) ? "editorInput" : "editorInput disabled")}
                        type={this.getInputType(header.type)} id={header.name} name={header.name} disabled={(!this.props.editable) || !header.editable}
                        value={!(this.state.updatedData == null || Object.keys(this.state.updatedData).length == 0) ? this.state.updatedData[header.name] : ""}
                        onChange={this.change} />
                    }
                </li>
            )
        })

        return (
            <div className="editorPane">
                <div className="editorTitle">{window.string.tableName.editorTitle}</div>
                <form ref="form">
                    <ul className="editorList" style={{ "margin-top": "10px" }}>
                        {list}
                    </ul>
                </form>
                {this.props.editable ? (
                    <div className="row">
                        <span className="btn btn-primary keyword-button" onClick={this.save}>{window.string.function.confirm}</span>
                        <span className="btn btn-primary keyword-button"
                            onClick={this.cancel}>{window.string.function.cancel}</span>
                    </div>
                ) : null}
            </div>
        );
    }
}