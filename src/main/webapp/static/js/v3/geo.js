/** 
 * Constructor : requires (stores)
*/
class Geo extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <ul className="geo">
                {this.props.stores.map((province) => {
                    return <Province province={province} />
                })}
            </ul>
        )
    }
}

class Province extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            expanded:false
        }
    }

    render() {
        return (
            <li className="geoProvince">
                <span className="geoProvinceText">{this.props.province.name}</span><input className="geoProvinceIn" type="checkbox" provinceId={this.props.province.id} />
                <ul className="geoCities">
                    {this.props.province.cities.map((city) => {
                        return <City city={city} />
                    })}
                </ul>
            </li>
        )
    }
}


class City extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            expanded:false
        }
    }


    render() {
        return (
            <li className="geoCity">
                <span className="geoCityText">{this.props.city.name}</span><input className="geoCityIn" type="checkbox" cityId={this.props.city.id} />
                <ul className="geoStores">
                    {this.props.city.stores.map((store) => {
                        return <Store store={store} />
                    })}
                </ul>
            </li>
        )
    }
}


class Store extends React.Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <li className="geoStore">
                <span className="geoCityText">{this.props.store.name}</span> <input className="geoStoreIn" type="checkbox" storeId={this.props.store.id} />
            </li>
        )
    }
}

