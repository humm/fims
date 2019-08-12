/** fims自定义方法 */
;layui.define(function (e) {
    var $ = layui.$;

    var obj = {
        isBlank: function (parameter) {
            if (parameter == null || parameter == '' || parameter == undefined || parameter == 'undefined') {
                return true;
            }
        },
        setAuthority: function (isAdmin, buttonId) {
            if (isAdmin && !this.isBlank(buttonId)) {
                var ids = buttonId.split(",");
                for (var i = 0; i < ids.length; i++) {
                    $("#" + ids[i]).remove();
                }
            }
        }
    };

    e('fims', obj);
});