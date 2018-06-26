eslChartOption = {
    title: {
        text: '价签状态',
        // subtext: '测试',
        x: 'center'
    },
    series: [
        {
            name: 'eslStatus',
            type: 'pie',
            radius: '40%',
            data: [
                {value: 0, name: '停用'},
                {value: 310, name: '正常工作'},
                {value: 234, name: '电量不足'}
            ],
            color: ["#555", "green", "#C00"]
        }]
};

mapOption = {
    textStyle: {
        "fontSize": 12,
        "color": "#005eb2",
        "fontFamily": "Microsoft YaHei"
    },
    tooltip: {
        trigger: 'item',
        formatter: '{b}'
    },
    series: [
        {
            name: '中国',
            type: 'map',
            mapType: 'china',
            selectedMode: 'single',
            data: []
        }
    ]
};

mapOption.series[0].data.push({
    name: "南海诸岛",
    itemStyle: {
        normal: {
            opacity: 0,
            label: {show: false},
        }
    }
});

storeTableParams = {
    method: 'get',
    pageSize: 5,
    pageNumber: 1,
    sidePagination: 'server',
    pagination: true,
    cache: false,
    pageList: [5],
    onClickRow: function (row) {
        selectStore(row);
        // $("#store-edit-submit").attr("name", row.id);
    }
};

eslTableParams = {
    method: 'get',
    pageSize: 5,
    pageNumber: 1,
    sidePagination: 'server',
    pagination: true,
    cache: false,
    pageList: [5],
    onClickRow: function (row) {
        selectEsl(row);
        // $("#store-edit-submit").attr("name", row.id);
    },
    responseHandler: function (data) {
        console.log(data);
        return data;
    }
};

userTableParams = {
    method: 'get',
    pageSize: 5,
    pageNumber: 1,
    sidePagination: 'server',
    pagination: true,
    cache: false,
    pageList: [5],
    onClickRow: function (row) {
        selectUser(row);
        showElement($("#user-structure-pane"));
        showLeftPane($("#user-info-pane"));
    }
};

goodsTableParams = {
    method: 'get',
    pageSize: 5,
    pageNumber: 1,
    sidePagination: 'server',
    pagination: true,
    cache: false,
    pageList: [5],
    onClickRow: function (row) {
        selectGoods(row);
    },
    responseHandler: function (data) {

        for (var camel in headers) {
            if (headers[camel].type == 'boolean') {
                for (var index in data.rows) {
                    data.rows[index][camel + "-boolean"] = data.rows[index][camel] == true ? '<i class="fa fa-check" aria-hidden="true"></i>' : "";
                }
            } else if (headers[camel].type == 'double') {
                for (var index in data.rows) {
                    data.rows[index][camel + "-double"] = data.rows[index][camel] == null ? "" : data.rows[index][camel].toFixed(2);
                }
            } else if (headers[camel].type == "datetime") {
                for (var index in data.rows) {
                    data.rows[index][camel + "-datetime"] = data.rows[index][camel] == null ? "" : date2str(new Date(data.rows[index][camel]));
                }
            } else if (headers[camel].type == "image") {
                for (var index in data.rows) {
                    var url = window.location.href.replace("/main", "").replace("#","");
                    data.rows[index][camel + "-image"] = data.rows[index][camel] == null ? "" : "<img src='" + url + "/goods/fetchImage.do?barcode=" + data.rows[index].barcode + "' style='height:30px'/>";
                }
            }
        }
        if (JSON.stringify(data) == "{}") {
            return {
                rows: [],
                total: 0
            }
        }
        return {
            rows: data.rows,
            total: data.total
        }
    }
};

datetimePickerParams = {
    format: 'yyyy-mm-dd hh:ii',
    autoclose: true
};
