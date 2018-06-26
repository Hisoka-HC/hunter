window.rootUrl = ""

window.dataUrls = []
window.dataUrls.storeList = window.rootUrl + "/service/store/select.do";
window.dataUrls.goodsList = window.rootUrl + "/service/goods/select.do";
window.dataUrls.skuList = window.rootUrl + "/service/sku/select.do";
window.dataUrls.authorizedProvinceList = window.rootUrl + "/service/geo/province/select.do";
window.dataUrls.authorizedCityList = window.rootUrl + "/service/geo/province/city/select.do";
window.dataUrls.authorizedStoreList = window.rootUrl + "/service/geo/province/city/store/select.do";
window.dataUrls.headers = window.rootUrl + "/service/goods/header/select.do";
window.dataUrls.userList = window.rootUrl + "/service/user/select.do";
window.dataUrls.labelList = window.rootUrl + "/service/esl/select.do"

window.urls = [];
window.urls.addStore = rootUrl + "/service/store/insert.do";
window.urls.updateStore = rootUrl + "/service/store/update.do";
window.urls.addSku = rootUrl + "/service/sku/insert.do";
window.urls.updateSku = rootUrl + "/service/sku/update.do";
window.urls.addGoods = rootUrl + "/service/goods/insert.do";
window.urls.updateGoods = rootUrl + "/service/goods/update.do";
window.urls.importGoods = rootUrl + "/service/goods/safeUpdateList.do";
window.urls.importSku = rootUrl + "/service/sku/safeUpdateList.do";
window.urls.importGoodsFetchStatus = rootUrl + "/service/goods/fetchUpdateStatus.do";
window.urls.importSkuFetchStatus = rootUrl + "/service/sku/fetchUpdateStatus.do";
window.urls.addUser = rootUrl + "/service/user/insert.do";
window.urls.updateUser = rootUrl + "/service/user/update.do";
window.urls.refreshAllGoods = rootUrl + "/service/goods/refreshAll.do";
window.urls.waitingCount = "/service/esl/selectWaitingCount.do"
window.urls.deleteSku = rootUrl + "/service/sku/delete.do";
window.urls.export = rootUrl + "/service/esl/export.do";

window.headers = [];
window.headers.store = [
    {
        name: "code",
        alias: window.string.headers.code,
        editable: true,
        type: "text"
    },
    {
        name: "name",
        alias: window.string.headers.name,
        editable: true,
        type: "text"
    }, {
        name: "provinceName",
        alias: window.string.headers.provinceName,
        editable: false,
        type: "text"
    }, {
        name: "cityName",
        alias: window.string.headers.cityName,
        editable: false,
        type: "text"
    }, {
        name: "key",
        alias: window.string.headers.key,
        editable: false,
        type: "text"
    }]
window.headers.user = [
    {
        name: "name",
        alias: window.string.headers.name,
        editable: true,
        type: "text"
    },
    {
        name: "email",
        alias: window.string.headers.email,
        editable: true,
        type: "text"
    }, {
        name: "mobile",
        alias: window.string.headers.mobile,
        editable: true,
        type: "text"
    }]
window.headers.label = [
    {
        name: "tinyIp",
        alias: window.string.headers.tinyIp,
        editable: false,
        type: "text"
    },
    {
        name: "tagType",
        alias: window.string.headers.tagType,
        editable: false,
        type: "text"
    },
    {
        name: "updateState",
        alias: window.string.headers.updatedState,
        editable: false,
        type: "boolean"
    }, {
        name: "eslRssi",
        alias: window.string.headers.eslRssi,
        editable: false,
        type: "text"
    }, {
        name: "goodsSku",
        alias: window.string.headers.goodsSku,
        editable: false,
        type: "text"
    }, {
        name: "goodsBarcode",
        alias: window.string.headers.goodsBarcode,
        editable: false,
        type: "text"
    }, {
        name: "goodsName",
        alias: window.string.headers.goodsName,
        editable: false,
        type: "text"
    },

]


class Main extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            selectedData: null,
            editable: false
        }

        this.refreshTable = this.refreshTable.bind(this);
        this.selectRow = this.selectRow.bind(this);
        this.removeEditable = this.removeEditable.bind(this);

        this.state.authorizedProvinces || this.fetchGeoInfo()
    }

    removeEditable = () => {
        this.setState({ editable: false })
    }

    fetchGeoInfo() {
        $.get(window.dataUrls.authorizedProvinceList, (data) => {
            this.setState({
                authorizedProvinces: JSON.parse(data)
            })
        });

        $.get(window.dataUrls.authorizedCityList, (data) => {
            this.setState({
                authorizedCities: JSON.parse(data)
            })
        });

        $.get(window.dataUrls.authorizedStoreList, (data) => {
            console.log(data)
            this.setState({
                authorizedStores: JSON.parse(data)
            })
        });
    }

    selectRow = (row) => {
        this.setState({ selectedData: row })
    }

    refreshTable = (selectedData) => {
        this.refs.table.fetchData();
        if (selectedData)
            this.setState({ selectedData: selectedData })
    }

    render() {
        if (!this.props) return null;
        let headers = (() => {
            switch (this.props.content) {
                case "storeTable":
                    return window.headers.store
                case "goodsTable":
                    return window.headers.goods
                case "skuTable":
                    return window.headers.sku
                case "userTable":
                    return window.headers.user
                case "labelTable":
                    return window.headers.label
            }
        })()

        let table = (() => {
            switch (this.props.content) {
                case "storeTable":
                    if (!this.state.authorizedCities)
                        return "";
                    return (
                        <Table ref="table" tableName={window.string.tableName.store}
                            headers={headers} dataUrl={window.dataUrls.storeList}
                            geo={this.state.authorizedCities} selectRow={this.selectRow}
                            limit={50} content={this.props.content} removeEditable={this.removeEditable}
                            all={true} editable={true} />
                    )
                case "goodsTable":
                    if (!this.state.authorizedStores)
                        return "";
                    return (
                        <Table ref="table" tableName={window.string.tableName.goods}
                            headers={headers} dataUrl={window.dataUrls.goodsList}
                            geo={this.state.authorizedStores} selectRow={this.selectRow}
                            limit={50} content={this.props.content} removeEditable={this.removeEditable} editable={true} />
                    )
                case "skuTable":
                    return (
                        <Table ref="table" tableName={window.string.tableName.sku}
                            headers={headers} dataUrl={window.dataUrls.skuList} selectRow={this.selectRow} limit={50}
                            content={this.props.content} removeEditable={this.removeEditable} editable={true} />
                    )
                case "userTable":
                    if (!this.state.authorizedStores)
                        return "";
                    return (
                        <Table ref="table" tableName={window.string.tableName.user}
                            headers={headers} dataUrl={window.dataUrls.userList}
                            geo={this.state.authorizedStores} selectRow={this.selectRow}
                            limit={50} content={this.props.content} removeEditable={this.removeEditable} editable={true} all={true} />
                    )
                case "labelTable":
                    if (!this.state.authorizedStores)
                        return "";
                    return (
                        <Table ref="table" tableName={window.string.tableName.label}
                            headers={headers} dataUrl={window.dataUrls.labelList}
                            geo={this.state.authorizedStores} selectRow={this.selectRow}
                            limit={50} content={this.props.content} removeEditable={this.removeEditable} editable={false} all={true} />
                    )
            }
        })();


        let addUrl = (() => {
            switch (this.props.content) {
                case "storeTable":
                    return window.urls.addStore;
                case "skuTable":
                    return window.urls.addSku;
                case "userTable":
                    return window.urls.addUser;
                default:
                    return null;
            }
        })();

        let updateUrl = (() => {
            switch (this.props.content) {
                case "storeTable":
                    return window.urls.updateStore;
                case "goodsTable":
                    return window.urls.updateGoods;
                case "skuTable":
                    return window.urls.updateSku;
                case "userTable":
                    return window.urls.updateUser;
                default:
                    return null;
            }
        })();


        return (
            <div onClick={this.click} className={this.props.showMenu ? "showMenu" : "notShowMenu"} id="main">
                <div id="mainTablePane" className="container">
                    {table}
                    <FunctionPane
                        content={this.props.content}
                        addUrl={addUrl}

                        selectedData={this.state.selectedData}
                        edit={(() => {
                            this.setState({ editable: true })
                        })}
                        authorizedCities={this.state.authorizedCities}
                        authorizedStores={this.state.authorizedStores}
                        refreshTable={this.refreshTable}
                        headers={headers}
                    />
                    <EditorPane
                        selectedData={this.state.selectedData}
                        updateUrl={updateUrl}
                        headers={headers}
                        editable={this.state.editable}
                        removeEditable={this.removeEditable}
                        refreshTable={this.refreshTable} content={this.props.content} />
                </div>
                {this.props.showMenu ? "" :
                    <i className="fa fa-list-ul button" aria-hidden="true" onClick={this.props.menuToggle}
                        id="menu-trigger">&nbsp;{window.string.function.toggleMenu}</i>}

            </div>
        )
    }
};

class FunctionPane extends React.Component {

    constructor(props) {
        super(props);


        this.state = {
            loading: false
        }
        this.add = this.add.bind(this)
        this.specific = this.specific.bind(this)
        this.showLoading = this.showLoading.bind(this)
        this.hideLoading = this.hideLoading.bind(this)
    }

    showLoading = () => {
        this.setState({ loading: true })
    }

    hideLoading = () => {
        this.setState({ loading: false })
    }

    add() {
        if (!this.props.addUrl)
            return;
        else {
            $("#addModal").modal("show");
        }
    }

    getEditableHeaders = (headers) => {
        let copy = [];
        for (let header of headers) {
            if (header.editable || header.name == 'sku')
                copy.push(header);
        }
        return copy;
    }



    specific() {
        let specific = (() => {
            switch (this.props.content) {
                case "goodsTable":
                    return (
                        [
                            <i className="fa fa-file tableFunctionButton" onClick={() => {
                                $("#goodsImportModal").modal("show")
                            }}>&nbsp;{window.string.function.importOnsale}</i>,
                            <i className="fa fa-file tableFunctionButton" onClick={() => {
                                $("#goodsImportModal").modal("show")
                            }}>&nbsp;{window.string.function.importStockAndOthers}</i>,

                            <GoodsImportModal importUrl={window.urls.importGoods}
                                fetchStatusUrl={window.urls.importGoodsFetchStatus}
                                title={window.string.function.importGoods} headers={this.getEditableHeaders(this.props.headers)}
                                showLoading={this.showLoading} hideLoading={this.hideLoading}
                                refreshTable={this.props.refreshTable} content={this.props.content} />
                        ]
                    )
                case "skuTable":
                    return (
                        [
                            < i className="fa fa-file tableFunctionButton" onClick={() => {
                                $("#goodsImportModal").modal("show")
                            }}>&nbsp;{window.string.function.importGoods}</i>,
                            <GoodsImportModal importUrl={window.urls.importSku}
                                fetchStatusUrl={window.urls.importSkuFetchStatus}
                                title={window.string.function.importSku} headers={this.getEditableHeaders(this.props.headers)}
                                showLoading={this.showLoading} hideLoading={this.hideLoading}
                                refreshTable={this.props.refreshTable} content={this.props.content} />
                        ]
                    );
                case "labelTable":
                    return (
                        [
                            < i className="fa fa-file tableFunctionButton" onClick={() => {
                                this.setState({ "export": null });
                                setTimeout(
                                    () => { this.setState({ "export": window.urls.export }); }
                                    , 1000);
                                // this.refs.file.props.src = window.urls.export;
                            }}>&nbsp;{window.string.function.exportReport}</i>,
                            <iframe ref="file" src={this.state.export}></iframe>
                        ]
                    );
                default:
                    return null;
            }
        })();
        return specific;
    }

    delete = () => {
        let flag = confirm("是否确认删除：" + this.props.selectedData.name + "(" + this.props.selectedData.barcode + ")");
        if (flag)
            $.get(window.urls.deleteSku, this.props.selectedData, (data) => {
                if (data == 'success') {
                    alert("删除成功")
                } else {
                    alert(data);
                }
                this.props.refreshTable();
            })
    }

    render() {

        let modal = (() => {
            switch (this.props.content) {
                case "storeTable":
                    return <StoreAddModal dataUrl={this.props.addUrl} cities={this.props.authorizedCities}
                        refreshTable={this.props.refreshTable}
                        title={window.string.tableName.addStore} />;
                case "goodsTable":
                    return <GoodsAddModal refreshTable={this.props.refreshTable} dataUrl={this.props.addUrl}
                        headers={this.props.headers} title={window.string.tableName.addGoods}
                        type="goods" />
                case "skuTable":
                    return <GoodsAddModal refreshTable={this.props.refreshTable} dataUrl={this.props.addUrl}
                        headers={this.props.headers} title={window.string.tableName.addSku}
                        type="sku" />
                case "userTable":
                    return <UserAddModal dataUrl={this.props.addUrl} stores={this.props.authorizedStores}
                        refreshTable={this.props.refreshTable}
                        title={window.string.tableName.addUser} />;
            }
        })();
        let addClassName = this.props.addUrl ? "fa fa-plus-circle tableFunctionButton" : "fa fa-plus-circle tableFunctionButton transparent";
        return (
            <div className="functionPane">
                {this.props.content == 'labelTabel' ? null : (
                    <div>
                        <i className={addClassName} aria-hidden="true" onClick={this.add}>&nbsp;{window.string.function.add}</i>
                        <i className={this.props.selectedData ? "fa fa-pencil-square-o tableFunctionButton" : "fa fa-pencil-square-o tableFunctionButton disabled"}
                            aria-hidden="true" onClick={this.props.edit}>&nbsp;{window.string.function.edit}</i>
                        <i className={this.props.selectedData ? "fa fa-trash tableFunctionButton" : "fa fa-trash tableFunctionButton disabled"}
                            aria-hidden="true" onClick={this.delete}>&nbsp;{window.string.function.delete}</i>
                        {this.specific()}
                        {modal}
                            {this.state.loading ?
                                (
                                    <div className="mask show">
                                        <i className="fa fa-spinner fa-pulse fa-lg fa-fw loading"></i>
                                    </div>
                                ) : null}
                    </div>
                )}
            </div>
        )
    }
}

class GoodsImportModal extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            dataHeaders: [],
            data: [],
            exampleData: [],
            total: 0,
            errors: [],
            successed: false
        }

        this.selectFile = this.selectFile.bind(this);
        this.save = this.save.bind(this);
        this.cancel = this.cancel.bind(this);
    }

    cancel = () => {
        this.refs.file.value = "";
        this.setState({
            dataHeaders: [],
            data: [],
            exampleData: [],
            total: 0,
            message: null,
            errors: [],
            successed: false

        })
    }

    save = () => {
        if (this.state.data.length == 0) {
            $("#goodsImportModal").modal("hide");
            this.refs.file.value = "";

            this.setState({
                dataHeaders: [],
                data: [],
                exampleData: [],
                total: 0,
                message: null,
                errors: [],
                successed: false
            })
            return;
        }
        let errorbuff = "";
            let skuList = {};
        let errors = [];
        let barcodes = [];
        for (let index in this.state.data) {
            let datum = this.state.data[index]
            let realIndex = (parseInt(index) + 1);
            if (this.props.content == "skuTable") {
                if (!(datum.sku && datum.sku.length > 0)) {
                    errors.push({ goods: datum, error: "SKU不能为空" })
                    continue;
                }
                if (barcodes.find((barcode) => { return barcode == datum.barcode })) {
                    errors.push({ goods: datum, error: "条码重复" })
                    continue;
                }
                barcodes.push(datum.barcode);
                if (skuList[datum.sku] != null) {
                    let tmp = skuList[datum.sku].datum;
                    let flag = false;
                    for (let field in datum) {
                        if (field == 'barcode')
                            continue;
                        else if (datum[field] != tmp[field]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        errors.push({ goods: datum, error: "第" + (parseInt(skuList[datum.sku].index) + 1) + "行与第" + (realIndex + 1) + "行SKU一致，但数据不同" })
                        continue;
                    }
                }
                skuList[datum.sku] = { index: realIndex, datum: datum };
            } else if (this.props.content == "goodsTable") {
                if (!(datum.sku && datum.sku.length > 0)) {
                    errors.push({ goods: datum, error: "SKU不能为空" })
                    continue;
                }
                if (datum.onsale == 1 && !datum.priceOnsale) {
                    errors.push({ goods: datum, error: "促销时促销价格不能为空" })
                    continue;
                }
                if (datum.onsale == 1 && (datum.onsaleDescription == null || datum.onsaleDescription.length == 0)) {
                    errors.push({ goods: datum, error: "促销时促销说明不能为空" })
                    continue;
                }
                if ((datum.onsale == 0 || datum.onsale == null) && datum.priceOnsale) {
                    errors.push({ goods: datum, error: "设置促销请将（是否促销）设为1" })
                    continue;
                } if ((datum.onsale == 0 || datum.onsale == null) && datum.onsaleDescription) {
                    errors.push({ goods: datum, error: "设置促销请将（是否促销）设为1" })
                    continue;
                }


                if (skuList[datum.code] != null && skuList[datum.sku] != null) {
                    let tmp = skuList[datum.code][datum.sku].datum;
                    let flag = false;
                    for (let field in datum) {
                        if (field == 'barcode')
                            continue;
                        else if (datum[field] != tmp[field]) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        errors.push({ goods: datum, error: "第" + (parseInt(skuList[datum.code][datum.sku].index) + 1) + "行与第" + (realIndex + 1) + "行SKU一致，但数据不同" });
                        continue;
                    }
                }
                skuList[datum.sku] = { index: realIndex, datum: datum };
            }
        }
        if (errors.length != 0) {
            this.setState({ errors: errors });
            return;
        }

        $.ajax({
            url: this.props.importUrl,
            type: "post",
            // Form数据
            data: JSON.stringify(this.state.data),
            async: false,
            cache: false,
            contentType: "application/json; charset=utf-8",
            processData: false,
            success: (data) => {
                if (data != 'success') {
                    alert(data);
                } else {
                    var loop = setInterval(() => {
                        $.get(this.props.fetchStatusUrl, (data) => {
                            console.log(data)
                            var obj = JSON.parse(data);
                            if (obj.status == 'success') {
                                clearInterval(loop);

                                this.setState({
                                    successed: true
                                })
                                this.props.hideLoading();
                                this.props.refreshTable();
                            } else if (obj.status == 'failed') {
                                clearInterval(loop);
                                let buff = "";
                                let array = obj.error;
                                console.log(JSON.stringify(array))
                                this.setState({
                                    errors: array
                                })
                                this.props.hideLoading();
                                this.props.refreshTable();
                            } else {
                            }
                        })
                    }, 1000);
                }
            }
        })

        this.props.showLoading();
    }

    selectFile = (file) => {
        if (!file)
            return;
        this.setState({
            message: null,
            errors: [],
            successed: false
        })
        let reader = new FileReader();
        reader.onload = (e) => {
            let content = e.target.result;

            let wb = XLSX.read(content, {
                type: 'binary'
            });
            let excelData = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]);
            if (excelData.length == 0)
                return;
            let sheet = wb.Sheets[wb.SheetNames[0]];
            let letters = "ABCDEFGHIJKLMNOPQRSTUVWXXYZ";
            let dataHeaders = [];
            let headerObj = {};
            let exampleData = [];

            for (var z = 0; z < 26; z++) {
                let headObj = sheet[letters.charAt(z) + "1"];
                if (headObj == null)
                    continue;
                let head = headObj.v;
                if (head == '门店编号') {
                    dataHeaders.push({ alias: '门店编号', name: 'storeCode' })
                    headerObj['门店编号'] = 'storeCode';
                    continue;
                }
                let target = this.props.headers.find((header) => {
                    return header.alias == head;
                })
                if (!target)
                    continue;
                dataHeaders.push(target);
                headerObj[target.alias] = target.name;
            }
            let data = excelData.map((datum) => {
                let tmp = {};
                for (let alias in datum) {
                    tmp[headerObj[alias]] = datum[alias].trim();
                }
                if (exampleData.length < 5) {
                    let tmpExample = [];
                    for (let alias in headerObj) {
                        tmpExample.push(tmp[headerObj[alias]])
                    }
                    exampleData.push(tmpExample);
                }
                return tmp;
            })

            this.setState({
                dataHeaders: dataHeaders,
                data: data,
                exampleData: exampleData,
                total: data.length
            })
        }
        reader.readAsBinaryString(file);
    }

    render() {

        return (
            <div className="modal fade" tabindex="-1" role="dialog" id="goodsImportModal" aria-hidden="true"
                data-backdrop="static">
                <div className="modal-dialog" style={{ "width": "90%" }}>
                    <div className="modal-content">
                        <div className="modal-header">
                            <button type="button" className="close" data-dismiss="modal" aria-hidden="true"
                                onClick={(e) => {
                                    this.cancel();
                                }}>
                                &times;
                            </button>
                            <h4 className="modal-title">{this.props.title}</h4>
                        </div>
                        <div className="modal-body" style={{ "overflow-x": "scroll" }}>
                            <input ref="file" type="file" className="form-control no-border"
                                accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                                onChange={(e) => {
                                    this.selectFile(e.target.files[0])
                                }} />
                            <table className="table table-striped table-bordered importTable">
                                <caption>预览&nbsp;&nbsp;&nbsp;<span
                                    className="modalTableTotal">{this.state.total > 0 ? ("共计" + this.state.total + "条数据") : null}</span>
                                </caption>
                                <thead>
                                    {this.state.dataHeaders ?
                                        this.state.dataHeaders.map((header) => {
                                            return <th value={header.name}>{header.alias}</th>
                                        })
                                        : null}
                                </thead>
                                <tbody>
                                    {
                                        this.state.exampleData
                                            ? this.state.exampleData.map((exampleDatum) => {
                                                return (<tr>
                                                    {exampleDatum.map((item) => {
                                                        return <td>{item}</td>
                                                    })}
                                                </tr>
                                                )
                                            })
                                            : null
                                    }
                                </tbody>
                            </table>
                        </div>
                        {
                            this.state.successed ? <div className="importModalResult">{string.tips.importSuccess}</div> :
                                (
                                    this.state.errors.length > 0 ? <div className="importModalResult">{string.tips.importFailed}</div> : null
                                )
                        }
                        {
                            this.state.errors.length > 0 ?
                                (
                                    <div className="importModalResult">
                                        <table className="table table-striped table-bordered importTable">
                                            <caption>错误详情</caption>
                                            <thead>
                                                {this.state.dataHeaders ?
                                                    this.state.dataHeaders.map((header) => {
                                                        return <th value={header.name}>{header.alias}</th>
                                                    })
                                                    : null}
                                                <th>error</th>
                                            </thead>
                                            <tbody>
                                                {
                                                    this.state.errors.length > 0
                                                        ? this.state.errors.map((error) => {
                                                            return (<tr>
                                                                {this.state.dataHeaders.map((header) => {
                                                                    return <td>{error.goods[header.name]}</td>
                                                                })}
                                                                <td>{error.error}</td>
                                                            </tr>
                                                            )
                                                        })
                                                        : null
                                                }
                                            </tbody>
                                        </table>

                                    </div>
                                ) : null
                        }

                        <div className="modal-footer">
                            <div className="row">
                                <div type="button" className="btn btn-primary" data-dismiss="modal" onClick={(e) => {
                                    this.cancel();
                                }}>{string.function.cancel}
                                </div>

                                {
                                    this.state.errors.length == 0 ? (
                                        this.state.successed ? (
                                            <div type="button" className="btn btn-primary" data-dismiss="modal" onClick={(e) => {
                                                this.cancel();
                                            }}>{string.function.close}</div>
                                        ) : (
                                                <div type="button" className="btn btn-primary" onClick={(e) => {
                                                    this.save()
                                                }}>{string.function.confirm}
                                                </div>
                                            )
                                    ) : (
                                            <div type="button" className="btn btn-primary" onClick={(e) => {
                                                this.selectFile(this.refs.file.files[0])
                                            }}>{string.function.reloadFile}
                                            </div>
                                        )
                                }
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        )
    }
}

class AddModal extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className="modal fade" tabindex="-1" role="dialog" id="addModal">
                <div className="modal-dialog">
                    <div className="modal-content">
                        <div className="modal-header">
                            <button type="button" className="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 className="modal-title">{this.props.title}</h4>
                        </div>
                        <div className="modal-body">
                            {this.props.form}
                        </div>

                        <div className="modal-footer">
                            <div className="row">
                                <div type="button" className="btn btn-primary"
                                    data-dismiss="modal">{window.string.function.cancel}</div>
                                <div type="button" className="btn btn-primary" data-dismiss="modal"
                                    onClick={this.props.save}>{window.string.function.confirm}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}


class StoreAddModal extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            // provinces: props.cities,
            cities: props.cities ? props.cities[0].cities : null
        }

        this.save = this.save.bind(this)
    }

    componentWillReceiveProps = (props) => {
        this.setState({
            provinces: props.cities,
            cities: props.cities ? props.cities[0].cities : null
        })
    }

    save = () => {
        console.log($(this.refs.form).serializeArray())
        if ($(this.refs.form).serializeArray().find((item) => { return item.name == "name" }).value.length == 0) {
            return;
        }
        $.get(window.urls.addStore + "?" + $(this.refs.form).serialize(), (data) => {
            if (data == 'success') {
                alert(window.string.tips.insertSuccess)
                location.reload();
            }
            else
                alert(window.string.tips.insertFailed)
        });
    }

    inputProvinceChanged = (provinceId) => {
        let cities = this.state.provinces.find((value) => {
            return value.id == provinceId;
        }).cities;
        this.setState({
            cities: cities
        })
    }

    form() {
        return (
            <form ref="form">
                <div className="form-group">
                    <label for="nameIn">{window.string.headers.name}</label><input className="form-control" type="text"
                        id="nameIn" name="name" />
                </div>
                <div className="form-group">
                    <label for="codeIn">{window.string.headers.code}</label><input className="form-control" type="text"
                        id="codeIn" name="code" />
                </div>
                <div className="form-group">
                    <label for="provinceId">{window.string.headers.provinceName}</label>
                    <select ref="provinceSelector" className="form-control" id="provinceIn" name="provinceId"
                        onChange={(() => {
                            this.inputProvinceChanged(this.refs.provinceSelector.value)
                        })}>
                        {
                            this.props.cities ? this.props.cities.map(function (province) {
                                return <option value={province.id}>{province.name}</option>
                            }) : null
                        }
                    </select>
                </div>
                <div className="form-group">
                    <label for="cityId">{window.string.headers.cityName}</label>
                    <select className="form-control" id="cityIn" name="cityId">
                        {
                            this.state.cities ? this.state.cities.map(function (province) {
                                return <option value={province.id}>{province.name}</option>
                            }) : null
                        }
                    </select>
                </div>
                <div className="form-group">
                    <label for="addressIn">{window.string.headers.address}</label><input className="form-control"
                        type="text" id="addressIn"
                        name="address" />
                </div>
            </form>
        )
    }

    render() {
        return <AddModal form={this.form()} title={window.string.tableName.addStore} id="form" save={this.save} />
    }
}

class UserAddModal extends React.Component {
    constructor(props) {
        super(props);
        console.log(props);
        this.save = this.save.bind(this)
    }

    save = () => {
        $.get(this.props.dataUrl + "?" + $(this.refs.form).serialize(), (data) => {
            if (data == 'success') {
                alert(window.string.tips.insertSuccess)
                this.props.refreshTable();
            }
            else
                alert(window.string.tips.insertFailed);
        });
    }

    form() {
        if (!this.props.stores)
            return null;

        return (
            <form ref="form">
                <div className="form-group">
                    <label for="nameIn">{window.string.headers.name}</label><input className="form-control" type="text"
                        id="nameIn" name="name" />
                </div>
                <div className="form-group">
                    <label for="emailIn">{window.string.headers.email}</label><input className="form-control"
                        type="text" id="emailIn"
                        name="email" />
                </div>
                <div className="form-group">
                    <label for="mobileIn">{window.string.headers.mobile}</label><input className="form-control"
                        type="text" id="mobileIn"
                        name="mobile" />
                </div>
                <div className="form-group">
                    <label for="rootManagerIn">{window.string.headers.rootManager}</label><input
                        className="managerInput" type="checkbox" id="rootManagerIn" name="rootManager" />
                </div>
                <div className="form-group">
                    <label for="skuManagerIn">{window.string.headers.skuManager}</label><input className="managerInput"
                        type="checkbox"
                        id="skuManagerIn"
                        name="skuManager" />
                </div>
                <div className="form-group">
                    <label for="goodsManagerIn">{window.string.headers.goodsManager}</label><input
                        className="managerInput" type="checkbox" id="goodsManagerIn" name="goodsManager" />
                </div>
                <div className="form-group">
                    <label for="userManagerIn">{window.string.headers.userManager}</label><input
                        className="managerInput" type="checkbox" id="userManagerIn" name="userManager" />
                </div>

                <Geo stores={this.props.stores} />
            </form>
        )
    }

    render() {
        return <AddModal form={this.form()} title={window.string.tableName.addUser} id="form" save={this.save} />
    }
}

class GoodsAddModal extends React.Component {

    constructor(props) {
        super(props);

        this.save.bind(this);
    }

    save = () => {
        let url = ""
        $.get(this.props.dataUrl + "?" + $(this.refs.form).serialize(), (data) => {
            if (data == 'success') {
                alert(window.string.tips.insertSuccess)
                this.props.refreshTable();
            }
            else
                alert(window.string.tips.insertFailed);
        });
    }


    form() {
        return (
            <form ref="form">
                {
                    this.props.headers.map((header) => {
                        if (header.name.toLowerCase().indexOf("onsale") > -1)
                            return null;
                        let type = (() => {
                            switch (header.type) {
                                case "double", "text", "barcode", "qrcode":
                                    return "text";
                                case "boolean":
                                    return "checkbox";
                                case "image":
                                    return "file";
                            }
                        })()
                        return (
                            <div className="form-group">
                                <label for={header.name + "Add"}>{header.alias}</label><input className="form-control"
                                    type={type}
                                    id={header.name + "Add"}
                                    name={header.name} />
                            </div>
                        )
                    })
                }
            </form>
        )
    }

    render() {
        return <AddModal form={this.form()} title={this.props.title} id="form" save={this.save} />
    }
}