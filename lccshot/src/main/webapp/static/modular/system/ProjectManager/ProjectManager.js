/**
 * 项目管理管理初始化
 */
var ProjectManager = {
    id: "ProjectManagerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ProjectManager.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ProjectManager.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ProjectManager.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加项目管理
 */
ProjectManager.openAddProjectManager = function () {
    var index = layer.open({
        type: 2,
        title: '添加项目管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/ProjectManager/ProjectManager_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看项目管理详情
 */
ProjectManager.openProjectManagerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '项目管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/ProjectManager/ProjectManager_update/' + ProjectManager.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除项目管理
 */
ProjectManager.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/ProjectManager/delete", function (data) {
            Feng.success("删除成功!");
            ProjectManager.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("ProjectManagerId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询项目管理列表
 */
ProjectManager.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ProjectManager.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ProjectManager.initColumn();
    var table = new BSTable(ProjectManager.id, "/ProjectManager/list", defaultColunms);
    table.setPaginationType("client");
    ProjectManager.table = table.init();
});
