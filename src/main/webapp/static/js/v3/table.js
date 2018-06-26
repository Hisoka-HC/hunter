class Table extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            dataUrl: this.props.dataUrl + "?limit=" + (props.limit ? props.limit : 5) + "&offset=0",
            data: props.data,
            limit: props.limit ? props.limit : 5,
            showStore: props.showStore,
            geo: props.geo,
            // provinces: props.provinces,
            // cities: props.cities,
            // stores: props.stores,

            total: null,
            offset: 0,
            keyword: ""
        }
        
        this.setPage = this.setPage.bind(this);
        this.resetPage = this.resetPage.bind(this);
        this.state.data || this.fetchData();

    }

    componentWillReceiveProps(props) {
        if (props.dataUrl != this.props.dataUrl) {
            this.setState({
                dataUrl: props.dataUrl + "?limit=" + (props.limit ? props.limit : 5) + "&offset=0",
                // provinces: props.provinces,
                // cities: props.cities,
                // stores: props.stores,
                geo: props.geo,
                offset: 0,
                limit: props.limit ? props.limit : 5
            })
            setTimeout(this.fetchData, 0)
        }
    }

    setKeyword = (keyword) => {
        let info = this.refs.helper.getGeoInfo();
        this.setState({
            keyword: keyword,
            offset: 0,
            dataUrl: this.props.dataUrl + "?limit=" + this.state.limit + "&offset=" + 0 +
            (info.provinceId ? ("&provinceId=" + info.provinceId) : "") + (info.cityId ? "&cityId=" + info.cityId : "") +
            (info.storeId ? ("&storeId=" + info.storeId) : "") + "&keyword=" + keyword
        })
        setTimeout(() => {
            this.fetchData();
        }, 0)
    }

    geoChanged = (info) => {
        this.setState({
            offset: 0,
            dataUrl: this.props.dataUrl + "?limit=" + this.state.limit + "&offset=" + 0 +
            (info.provinceId ? ("&provinceId=" + info.provinceId) : "") + (info.cityId ? "&cityId=" + info.cityId : "") +
            (info.storeId ? ("&storeId=" + info.storeId) : "") + "&keyword=" + this.state.keyword
        });
        setTimeout(() => {
            this.fetchData();
        }, 0)
    }

    fetchData = () => {
        this.props.selectRow(null);
        this.props.removeEditable();
        $.ajax({
            url: this.state.dataUrl,
            async: true,
            cache: false,
            contentType: "application/json; charset=utf-8",
            processData: false,
            success: (data) => {
                let obj = JSON.parse(data);
                console.log(obj)

                if (obj.rows != null) {
                    let rows = obj.rows.map((row) => {
                        return (
                            <tr onClick={() => { this.props.selectRow(row) }}>
                                {this.props.headers.map((header) => {
                                    if(header.type=='boolean')
                                        return <td>{row[header.name]==true||row[header.name]=='1'?<span>&radic;</span>:""}</td>
                                    return <td>{row[header.name]}</td>
                                })}
                            </tr>
                        )
                    })
                    this.setState({ data: rows, total: obj.total })
                }
            }
        })
    }

    resetPage() {
        this.refs.footer.selectPage(1);
    }

    setPage = (page) => {
        let info = this.refs.helper.getGeoInfo();
        this.setState({
            offset: (page - 1) * this.state.limit,
            dataUrl: this.props.dataUrl + "?limit=" + this.state.limit + "&offset=" + (page - 1) * this.state.limit +
            (info.provinceId ? ("&provinceId=" + info.provinceId) : "") + (info.cityId ? "&cityId=" + info.cityId : "") +
            (info.storeId ? ("&storeId=" + info.storeId) : "") + "&keyword=" + this.state.keyword
        })
        setTimeout(this.fetchData, 0)
    }

    render() {
        return (
            <div>
                <TableName name={this.props.tableName} fetchData={this.fetchData}/>
                <TableHelper ref="helper"
                    geo={this.props.geo}
                    geoChanged={this.geoChanged}
                    setKeyword={this.setKeyword}
                    content={this.props.content}
                    resetPage={this.resetPage}
                    all={this.props.all} />
                <div className="container-fluid" className="realTablePane">
                    <table className="table table-striped main-table">
                        <thead>
                            <tr>{this.props.headers.map((header) => { return <th name={header.name}>{header.alias}</th> })}</tr>
                        </thead>
                        <tbody>
                            {this.state.data}
                        </tbody>
                    </table>
                </div>
                {this.state.data ? <TableFooter ref="footer" total={this.state.total} limit={this.state.limit} setPage={this.setPage} /> : null}
            </div>
        )
    }
}

class TableName extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return <div className="tableName">{this.props.name}&nbsp;&nbsp;<i className="fa fa-refresh tableFunctionButton" aria-hidden="true" onClick={this.props.fetchData}></i></div>
    }
}

class TableFooter extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            page: 1
        }
    }

    selectPage = (page) => {
        this.setState({
            page: parseInt(page)
        })
        this.props.setPage(page)
    }

    getPageList() {
        let last = Math.ceil(this.props.total / this.props.limit);
        let list = [];

        for (let i = (this.state.page > 3 ? this.state.page - 3 : 1); i < this.state.page; i++) {
            list.push(i)
        }
        let left = 6 - list.length; // total:7

        for (let i = this.state.page; i <= ((this.state.page + left) < last ? (this.state.page + left) : last); i++) {
            list.push(i)
        }
        let pageList = list.map((item) => {
            return <li><button className={this.state.page == item ? "theone" : ""} value={item} onClick={((e) => { this.selectPage(e.target.value) })}> {item}</button></li>
        })
        if (pageList.length == 4 && list[3] < last) {
            pageList.push(<li>&nbsp;<i className="fa fa-ellipsis-h" aria-hidden="true"></i></li>)
        }

        return pageList;
    }

    render() {
        // let pages = <ul>{for()}</ul>

        return (
            <div className="tableFooter">
                <span>共{this.props.total}条数据,共{Math.ceil(this.props.total / this.props.limit)}页</span>
                <ul>
                    {this.getPageList()}
                </ul>
            </div>
        )
    }
}

class TableHelper extends React.Component {
    constructor(props) {
        super(props);
        let geo = props.geo;
        let provinces = props.all ? [{ name: '所有', id: -1 }, ...geo] : geo;
        let cities = props.all ? null : (geo ? (geo[0] ? geo[0].cities : null) : null);
        let stores = cities ? (cities[0] ? cities[0].stores : null) : null;

        this.state = {
            provinces: provinces,
            cities: cities,
            stores: stores,
            provinceId: provinces[0].id,
            cityId: cities ? cities[0].id : null,
            storeId: stores ? stores[0].id : null
        }
        this.provinceChanged = this.provinceChanged.bind(this);
        this.cityChanged = this.cityChanged.bind(this);
        this.storeChanged = this.storeChanged.bind(this);

        setTimeout(() => { props.geoChanged(this.getGeoInfo()) }, 0);
    }


    componentWillReceiveProps(props) {

        if (props.content != this.props.content) {
            let geo = props.geo;
            let provinces = props.all ? [{ name: '所有', id: -1 }, ...geo] : geo;
            let cities = props.all ? null : (geo ? (geo[0] ? geo[0].cities : null) : null);
            let stores = cities ? (cities[0] ? cities[0].stores : null) : null;

            // if (provinces != null) {
            //     cities = props.stores ? props.stores[0].cities : props.cities[0].cities;
            //     stores = props.stores ? (props.stores[0] && props.stores[0].cities[0].stores) : null;
            // }
            this.setState({
                provinces: provinces,
                cities: cities,
                stores: stores,
                provinceId: provinces ? provinces[0].id : null,
                cityId: cities ? cities[0].id : null,
                storeId: stores ? stores[0].id : null
            })
            setTimeout(() => { props.geoChanged(this.getGeoInfo()) }, 0);
        }

    }

    provinceChanged(provinceId) {

        let cities = provinceId == -1 ? null : this.state.provinces.find((value) => { return value.id == provinceId; }).cities;
        let stores = cities ? (cities[0] ? cities[0].stores : null) : null;
        this.setState({
            provinceId: provinceId,
            cities: cities,
            cityId: cities ? cities[0].id : null,
            stores: stores,
            storeId: stores ? stores[0].id : null
        })
        setTimeout(() => {
            this.geoChanged();

        }, 0);
    }

    cityChanged(cityId) {
        let stores = this.state.cities.find((value) => { return value.id == cityId; }).stores;
        this.setState({
            cityId: cityId,
            stores: stores,
            storeId: stores ? stores[0].id : null
        })
        setTimeout(() => {
            this.geoChanged();
        }, 0);
    }

    storeChanged(storeId) {
        this.setState({
            storeId: storeId
        })
        setTimeout(() => {
            this.geoChanged();
        }, 0);
    }


    makeStandardGeoList(list) {
        if (!list)
            return null;

        let anotherList = [];
        list.forEach((item, index) => {
            anotherList[index] = item
        });

        return anotherList;
    }

    getGeoInfo() {
        return {
            provinceId: this.state.provinceId == -1 ? null : this.state.provinceId,
            cityId: this.state.cityId || null,
            storeId: this.state.storeId || null
        }
    }

    geoChanged() {
        this.props.geoChanged(this.getGeoInfo());
        this.props.resetPage();
    }

    render() {
        return (
            <div className="tableHelper row">
                <ProvinceSelector ref="provinceSelector" provinces={this.state.provinces}
                    provinceChanged={this.provinceChanged} provinceId={this.state.provinceId} />
                <CitySelector ref="citySelector" cities={this.state.cities}
                    cityChanged={this.cityChanged} cityId={this.state.cityId} />
                <StoreSelector ref="storeSelector" stores={this.state.stores} storeChanged={this.storeChanged} storeId={this.state.storeId} />

                <span for="store-keyword-in" className='keyword-label'>{window.string.keyword}:&nbsp;</span>
                <input ref="keywordIn" type="text" className="form-inline keyword-input" name="keyword" />
                <span className="btn btn-primary keyword-button" onClick={(() => { this.props.setKeyword(this.refs.keywordIn.value) })}>
                    {window.string.function.search}
                </span>
            </div>
        )
    }
}

class ProvinceSelector extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            provinceId: props.provinceId
        }
        this.change = this.change.bind(this)
    }

    change(provinceId) {

        this.setState({ provinceId: provinceId })
        this.props.provinceChanged(provinceId);
    }

    getValue() {
        return this.refs.selector.value
    }

    render() {
        return (
            <select ref="selector" className={"province-selector" + (this.props.provinces ? "" : " transparent")}
                onChange={(e) => { this.change(e.target.value) }}
                value={this.state.provinceId}>
                {this.props.provinces ?
                    this.props.provinces.map((province, index) => { return <option value={province.id}>{province.name}</option> }) : ""}
            </select>
        )
    }
}

class CitySelector extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            cityId: props.cityId
        }
        this.change = this.change.bind(this)
    }

    change(cityId) {
        this.setState({ cityId: cityId })
        this.props.cityChanged(cityId);
    }

    getValue() {
        return this.refs.selector.value
    }

    render() {
        return (
            <select ref="selector" className={"city-selector" + (this.props.cities ? "" : " transparent")} onChange={(e) => { this.change(e.target.value) }} value={this.state.provinccityIdeId}>
                {this.props.cities ?
                    this.props.cities.map((city, index) => { return <option value={city.id} index={city.index}>{city.name}</option> }) : ""}
            </select>
        )
    }
}

class StoreSelector extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            storeId: props.storeId
        }
        this.change = this.change.bind(this)
    }

    change(storeId) {
        this.setState({ storeId: storeId })
        this.props.storeChanged(storeId);
    }

    getValue() {
        return this.refs.selector.value
    }

    render() {
        return (
            <select ref="selector" className={"store-selector" + (this.props.stores ? "" : " transparent")} disabled={this.props.stores ? false : true} onChange={(e) => { this.change(e.target.value) }} >
                {this.props.stores ?
                    this.props.stores.map((store, index) => { return <option value={store.id} index={store.index}>{store.name}</option> }) : ""}
            </select>
        )
    }
}
