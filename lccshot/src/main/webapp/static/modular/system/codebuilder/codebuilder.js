/**
 * 代码全自动管理初始化
 */
var Codebuilder = {
		domainName: '',			//字典的名称
	    mutiString: '',		//拼接字符串内容(拼接字典条目)
	    itemTemplate: $("#itemTemplate").html()
};

/**
 * item获取新的id
 */
Codebuilder.newId = function () {
    if(this.count == undefined){
        this.count = 0;
    }
    this.count = this.count + 1;
    return "dictItem" + this.count;
};

/**
 * 添加条目
 */
Codebuilder.addItem = function () {
    $("#itemsArea").append(this.itemTemplate);
    $("#dictItem").attr("id", this.newId());
};

/**
 * 删除item
 */
Codebuilder.deleteItem = function (event) {
    var obj = Feng.eventParseObject(event);
    obj.parent().parent().remove();
};

/**
 * 清除为空的item Dom
 */
Codebuilder.clearNullDom = function(){
    $("[name='dictItem']").each(function(){
        var num = $(this).find("[name='itemNum']").val();
        var name = $(this).find("[name='itemName']").val();
        var type = $(this).find("[name='itemType']").val();
        var length = $(this).find("[name='itemLength']").val();
        if(num == '' || name == '' || type == ''){
            $(this).remove();
        }
    });
};

/**
 * 收集添加字典的数据
 */
Codebuilder.collectData = function () {
    this.clearNullDom();
    var mutiString = "";
    $("[name='dictItem']").each(function(){
        var num = $(this).find("[name='itemNum']").val();
        var name = $(this).find("[name='itemName']").val();
        var type = $(this).find("[name='itemType']").val();
        var length = $(this).find("[name='itemLength']").val();
        mutiString = mutiString + (num + ":" + name + ":" + type + ":" + length + ";");
    });
    this.domainName = $("#domainName").val();
    this.mutiString = mutiString;
};

/**
 * 提交代码生成
 */
Codebuilder.create = function () {
    var baseAjax = Feng.baseAjax("/codebuilder/create","生成代码");
    baseAjax.set("bizChName");
    baseAjax.set("bizEnName");
    baseAjax.set("path");
    baseAjax.set('domainName',this.domainName);
    baseAjax.set('domainValues',this.mutiString);
    baseAjax.start();
};

