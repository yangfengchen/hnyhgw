/**
 * @license Copyright (c) 2003-2018, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
    config.language = 'zh-cn';
    /*去掉图片预览框的文字*/
    config.image_previewText = ' ';
    /*开启工具栏“图像”中文件上传功能，后面的url为图片上传要指向的的action或servlet*/
    config.filebrowserImageUploadUrl= $ctx+"/attachment/uploadFile";
    config.resize_enabled = false;                    //禁止拖拽改变尺寸
    config.removePlugins = 'elementspath';            //删除底边栏
    config.image_prefillDimensions = false;            //禁止图片上传完毕后自动填充图片长和宽
    config.extraPlugins = 'previewcontent';
    config.toolbar = 'Full';
    config.toolbar_Full = [
        ['previewcontent','Bold','Italic','Underline'],
        ['NumberedList','BulletedList'],
        ['Link','Unlink'],
        ['Image'],
        ['Font','FontSize'],
        ['TextColor','BGColor'],
        ['JustifyLeft','JustifyCenter','JustifyRight'],
        ['Source'],
        ['Replace'],
        ['Maximize']
];
   /* config.extraPlugins = 'wordcount,notification,notificationaggregator';        //其他插件：字数统计、提示信息
    config.wordcount = {
        showParagraphs: false,                    // 是否统计段落数
        showWordCount: false,                    // 是否统计词数
        showCharCount: true,                    // 是否统计字符数
        countSpacesAsChars: false,                // 是否统计空间字符
        countHTML: false,                    // 是否统计包括HTML字符的字符数
        maxWordCount: -1,                    // 最大允许词数，-1表示无上限
        maxCharCount: -1,                    //最大允许字符数，-1表示无上限
        filter: new CKEDITOR.htmlParser.filter({        //添加筛选器添加或删除元素之前计数（CKEDITOR.htmlParser.filter），默认值：null (no filter)
            elements: {
                div: function( element ) {
                    if(element.attributes.class == 'mediaembed') {
                        return false;
                    }
                }
            }
        })
    };*/
};
