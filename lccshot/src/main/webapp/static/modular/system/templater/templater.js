/**
 * 模板管理管理初始化
 */
var Templater = {
    id: "TemplaterTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Templater.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'templaterid', visible: false, align: 'center', valign: 'middle'}
 		,{title: '模板名称', field: 'templaterName', visible: false, align: 'center', valign: 'middle'}
 		,{title: '模板类型', field: 'templaterType', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Templater.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Templater.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加模板管理
 */
Templater.openAddTemplater = function () {
    var index = layer.open({
        type: 2,
        title: '添加模板管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/templater/templater_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看模板管理详情
 */
Templater.openTemplaterDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '模板管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/templater/templater_update/' + Templater.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除模板管理
 */
Templater.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/templater/delete", function (data) {
            Feng.success("删除成功!");
            Templater.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("templaterId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询模板管理列表
 */
Templater.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Templater.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Templater.initColumn();
    var table = new BSTable(Templater.id, "/templater/list", defaultColunms);
    table.setPaginationType("client");
    Templater.table = table.init();
});
