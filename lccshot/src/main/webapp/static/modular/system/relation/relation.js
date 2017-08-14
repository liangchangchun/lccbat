/**
 * 权限管理管理初始化
 */
var Relation = {
    id: "RelationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Relation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Relation.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Relation.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加权限管理
 */
Relation.openAddRelation = function () {
    var index = layer.open({
        type: 2,
        title: '添加权限管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/relation/relation_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看权限管理详情
 */
Relation.openRelationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '权限管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/relation/relation_update/' + Relation.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除权限管理
 */
Relation.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/relation/delete", function (data) {
            Feng.success("删除成功!");
            Relation.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("relationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询权限管理列表
 */
Relation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Relation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Relation.initColumn();
    var table = new BSTable(Relation.id, "/relation/list", defaultColunms);
    table.setPaginationType("client");
    Relation.table = table.init();
});
