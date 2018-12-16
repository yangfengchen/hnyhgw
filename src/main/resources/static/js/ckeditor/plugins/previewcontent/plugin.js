CKEDITOR.plugins.add( 'previewcontent', {
    icons: 'previewcontent',
    init: function( editor ) {
        editor.addCommand( 'insertPreviewcontent', {
            exec: function( editor ) {
                /*var now = new Date();
                editor.insertHtml( 'The current date and time is: <em>' + now.toString() + '</em>' );*/
                layer.msg("该功能还未实现");
            }
        });
        editor.ui.addButton( 'previewcontent', {
            label: '预览',
            command: 'insertPreviewcontent',
            toolbar: 'insert'
        });
    }
});