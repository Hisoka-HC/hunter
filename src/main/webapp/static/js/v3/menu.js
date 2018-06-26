window.menu = [
    {
        text: window.string.menu.storeManagement,
        submenu: [
            {
                text: window.string.menu.storeTable,
                value: "storeTable"
            }
        ]
    },
    {
        text: window.string.menu.goodsManagement,
        submenu: [
            {
                text: window.string.menu.skuTable,
                value: "skuTable"
            }, {
                text: window.string.menu.goodsTable,
                value: "goodsTable"
            }
        ]
    },
    {
        text: window.string.menu.labelManagement,
        submenu: [
            {
                value:"labelTable",
                text: window.string.menu.labelTable
            }
        ]
    },
    {
        text: window.string.menu.userManagement,
        submenu: [
            {
                text: window.string.menu.userTable,
                value: "userTable"
            }
        ]
    }
];

console.log(window.menu)

var Logout = React.createClass({
    logout: function () {
        window.location.href = "/service/logout.do"
    },
    render: function () {
        return <i className="fa fa-sign-out button" aria-hidden="true" id="logout" onClick={this.logout}>&nbsp;{window.string.logout}</i>
    }
})

class SubMenuItem extends React.Component {

    render() {
        return <li className="submenu-item button" value={this.props.value.value} onClick={((e) => {
            this.props.menuToggle();
            this.props.setContent(this.props.value.value);
        })}>{this.props.value.text}</li>
    }
}

class MenuItem extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            expanded: false
        }
    }

    toggle = () => {
        this.setState({ expanded: !this.state.expanded })
    }

    render() {
        if (this.props.value.submenu == null) {
            return <li className="menu-item button"><div className="menu-item-trigger">{this.props.value.text}</div></li>
        }
        let submenuClassName = "submenu-wrapper " + (this.state.expanded ? "expanded" : "shrunk")
        return (
            <li className="menu-item">
                <div className="menu-item-trigger button" onClick={this.toggle}>{this.props.value.text}</div>
                <ul className={submenuClassName}>
                    {this.props.value.submenu.map((submenuItem) => {
                        return <SubMenuItem value={submenuItem} setContent={this.props.setContent} menuToggle={this.props.menuToggle} />
                    })}
                </ul>
            </li>
        )
    }
}

class Menu extends React.Component {

    constructor(props) {
        super(props);
    }

    switchLang() {
        console.log(window.string.switchLang)
        console.log(window.string.switchLangTarget)

        window.location.href = "/service/main?lang=" + window.string.switchLangTarget
    }

    render() {

        let className = this.props.show ? "menu shown" : "menu hided";
        let menuitems = window.menu.map(
            (menuitem) => {
                return <MenuItem value={menuitem} setContent={this.props.setContent} menuToggle={this.props.menuToggle} />
            });

        return (
            <div className={className}>
                <ul className="menu-wrapper">{menuitems}</ul>
                <Logout />
                <div className="button switchLang" onClick={this.switchLang}>{window.string.switchLang}</div>
            </div>)
    }
}