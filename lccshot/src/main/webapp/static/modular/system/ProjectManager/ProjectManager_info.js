/**
 * 初始化项目管理详情对话框
 */
var ProjectManagerInfoDlg = {
    ProjectManagerInfoData : {}
};

/**
 * 清除数据
 */
ProjectManagerInfoDlg.clearData = function() {
    this.ProjectManagerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProjectManagerInfoDlg.set = function(key, val) {
    this.ProjectManagerInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ProjectManagerInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ProjectManagerInfoDlg.close = function() {
    parent.layer.close(window.parent.ProjectManager.layerIndex);
}

/**
 * 收集数据
 */
ProjectManagerInfoDlg.collectData = function() {
    this.set('projectId').set('projectName').set('businessName').set('description').set('projectType').set('projectTemplateId');
}

/**
 * 提交添加
 */
ProjectManagerInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();
    
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ProjectManager/add", function(data){
        Feng.success("添加成功!");
        window.parent.ProjectManager.table.refresh();
        ProjectManagerInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ProjectManagerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ProjectManagerInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ProjectManager/update", function(data){
        Feng.success("修改成功!");
        window.parent.ProjectManager.table.refresh();
        ProjectManagerInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ProjectManagerInfoData);
    ajax.start();
}

$(function() {
	$("#projectTemplateId").val($("#projectTemplateIdValue").val());
	$("#projectType").val($("#projectTypeValue").val());
});
