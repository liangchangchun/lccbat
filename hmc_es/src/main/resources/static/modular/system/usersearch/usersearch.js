/**
 * 角色管理的单例
 */
var Search = {
    id: "searchTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Search.initColumn = function () {
    var columns = [
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '手机号码', field: 'userPhone', align: 'center', valign: 'middle', sortable: true},
        {title: '搜索内容', field: 'askerInfo', align: 'center', valign: 'middle', sortable: true},
        {title: '搜索时间', field: 'searchTime', align: 'center', valign: 'middle', sortable: true}]
    return columns;
};

/**
 * 搜索文本
 */
Search.search = function () {
    var queryData = {};
    queryData['info'] = $("#info").val();
    Search.table.refresh({query: queryData});
}
/**
 * 
 */
Search.exportExcel = function () {
	   var ajax = new $ax(Feng.ctxPath + "/usersearch/createXls", function (data) {
	        Feng.success("下载成功!");
	       // alert(data.content);
	        //文件下载路径
	        $("#adownloadExcel").attr("href",data.content);
	       // $("#adownloadExcel").click();
	        document.getElementById("adownloadExcel").click();
	    }, function (data) {
	        Feng.error("下载失败!" + data.responseJSON.message + "!");
	    });
	    ajax.start();
}

$(function () {
	init();
    var defaultColunms = Search.initColumn();
    var table = new BSTable(Search.id, "/usersearch/list", defaultColunms);
   // table.setAskerInfo("askerInfo");
    table.setPaginationType("server");
    table.init();
    //table.data['info'] = $("#info").val();
    Search.table = table;
});


function init() {

    var BootstrapTable = $.fn.bootstrapTable.Constructor;
    BootstrapTable.prototype.onSort = function (event) {
        var $this = event.type === "keypress" ? $(event.currentTarget) : $(event.currentTarget).parent(),
            $this_ = this.$header.find('th').eq($this.index()),
            sortName = this.header.sortNames[$this.index()];

        this.$header.add(this.$header_).find('span.order').remove();

        if (this.options.sortName === $this.data('field')) {
            this.options.sortOrder = this.options.sortOrder === 'asc' ? 'desc' : 'asc';
        } else {
            this.options.sortName = sortName || $this.data('field');
            this.options.sortOrder = $this.data('order') === 'asc' ? 'desc' : 'asc';
        }
        this.trigger('sort', this.options.sortName, this.options.sortOrder);

        $this.add($this_).data('order', this.options.sortOrder);

        // Assign the correct sortable arrow
        this.getCaret();

        if (this.options.sidePagination === 'server') {
            this.initServer(this.options.silentSort);
            return;
        }

        this.initSort();
        this.initBody();
    };
    BootstrapTable.prototype.getCaret = function () {
        var that = this;

        $.each(this.$header.find('th'), function (i, th) {
            var sortName = that.header.sortNames[i];
            $(th).find('.sortable').removeClass('desc asc').addClass((sortName || $(th).data('field')) === that.options.sortName ? that.options.sortOrder : 'both');
        });
    };
}
