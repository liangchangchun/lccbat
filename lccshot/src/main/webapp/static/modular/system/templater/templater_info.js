/**
 * 初始化模板管理详情对话框
 */
var TemplaterInfoDlg = {
    templaterInfoData : {}
};

/**
 * 清除数据
 */
TemplaterInfoDlg.clearData = function() {
    this.templaterInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TemplaterInfoDlg.set = function(key, val) {
    this.templaterInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TemplaterInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TemplaterInfoDlg.close = function() {
    parent.layer.close(window.parent.Templater.layerIndex);
}

/**
 * 收集数据
 */
TemplaterInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
TemplaterInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/templater/add", function(data){
        Feng.success("添加成功!");
        window.parent.Templater.table.refresh();
        TemplaterInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.templaterInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TemplaterInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/templater/update", function(data){
        Feng.success("修改成功!");
        window.parent.Templater.table.refresh();
        TemplaterInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.templaterInfoData);
    ajax.start();
}

$(function() {

});
