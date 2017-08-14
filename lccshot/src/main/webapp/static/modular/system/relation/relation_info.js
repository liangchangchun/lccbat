/**
 * 初始化权限管理详情对话框
 */
var RelationInfoDlg = {
    relationInfoData : {}
};

/**
 * 清除数据
 */
RelationInfoDlg.clearData = function() {
    this.relationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RelationInfoDlg.set = function(key, val) {
    this.relationInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RelationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RelationInfoDlg.close = function() {
    parent.layer.close(window.parent.Relation.layerIndex);
}

/**
 * 收集数据
 */
RelationInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
RelationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/relation/add", function(data){
        Feng.success("添加成功!");
        window.parent.Relation.table.refresh();
        RelationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.relationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
RelationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/relation/update", function(data){
        Feng.success("修改成功!");
        window.parent.Relation.table.refresh();
        RelationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.relationInfoData);
    ajax.start();
}

$(function() {

});
