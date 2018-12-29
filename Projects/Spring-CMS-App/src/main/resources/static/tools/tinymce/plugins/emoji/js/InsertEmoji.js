function init() {
	if (tinymce.isIE) {
		tinymce.get('content').focus();
		tinymce.activeEditor.windowManager.bookmark = tinyMCE.activeEditor.selection.getBookmark();
	}
	tinyMCEPopup.resizeToInnerSize();
}

function emojiinsert(icon) {

	var icontag = '<img src="'+wpemojionedomain+'icons/'+icon+'" width="'+document.getElementById('iconsize').value+'" height="'+document.getElementById('iconsize').value+'" style="margin-left:3px; margin-right:3px; vertical-align:middle; -webkit-box-shadow:none; -moz-box-shadow:none; box-shadow:none;">';

	if (parent.tinymce.isIE) {
		parent.tinymce.activeEditor.focus();
		parent.tinymce.activeEditor.selection.moveToBookmark(parent.tinymce.EditorManager.activeEditor.windowManager.bookmark);
	}

//	window.tinymce.execInstanceCommand('content', 'mceInsertContent', false, icontag);
	if ('function' === typeof window.tinymce.EditorCommands.execCommand) {
		// TinyMCE 3.x
		window.tinymce.EditorCommands.execCommand('content', 'mceInsertContent', false, icontag);
	} else {
		// TinyMCE 4.x
		tinymce.execCommand('mceInsertContent', false, icontag);
	}

	tinyMCEPopup.editor.execCommand('mceRepaint');
	tinyMCEPopup.close();
	return;
}
