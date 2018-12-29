(function() {
	tinymce.create('tinymce.plugins.wp_emoji_one', {
		
		init : function(ed, url) {
		// Register the command so that it can be invoked by using tinyMCE.activeEditor.execCommand('mceExample');

			ed.addCommand('wp_emoji_one', function() {
				ed.windowManager.open({
					file : url + '../../popup.php',
					width : 630,
					height : 350,
					inline : 1
				}, {
					plugin_url : url // Plugin absolute URL
				});
			});

			// Register example button
			ed.addButton('wp_emoji_one', {
				title : 'WP Emoji One',
				cmd : 'wp_emoji_one',
				image : url + '../../icons/1F600.png'
			});
			
			// Add a node change handler, selects the button in the UI when a image is selected
			ed.onNodeChange.add(function(ed, cm, n) {
				cm.setActive('wp_emoji_one', n.nodeName == 'IMG');
			});
		},
		createControl : function(n, cm) {
			return null;
		},
		getInfo : function() {
			return {
					longname  : 'wp_emoji_one',
					author 	  : 'Monchito.net',
					authorurl : 'http://www.monchito.net',
					infourl   : 'http://labs.monchito.net/wp-emoji-one/',
					version   : "0.5.0"
			};
		}
	});

	// Register plugin
	tinymce.PluginManager.add('wp_emoji_one', tinymce.plugins.wp_emoji_one);
})();


