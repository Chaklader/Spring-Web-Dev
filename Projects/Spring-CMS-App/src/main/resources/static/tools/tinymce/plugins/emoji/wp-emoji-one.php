<?php
/**
 * Plugin Name: WP Emoji One
 * Plugin URI: http://labs.monchito.net/wp-emoji-one/
 * Description: Add open source Emoji One emoticons to your posts and pages.
 * Version: 0.6.0
 * Author: Monchito.net
 * Author URI: http://www.monchito.net
 * License: GPLv2
 * Text Domain: wp_emoji_one
 * Domain Path: /languages/
 */

/*  Copyright 2014  Monchito.net  (email : hola@monchito.net)

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License, version 2, as 
    published by the Free Software Foundation.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

defined('ABSPATH') or die("Nothing to see here!");

#------------------------------------------------------------------------------
# Plugin init
#------------------------------------------------------------------------------
load_plugin_textdomain('wp_emoji_one', false, dirname( plugin_basename( __FILE__ ) ) . '/languages/' );
$wp_emoji_one_plugin_url = plugin_dir_url( __FILE__ );
$wp_emoji_one_ver = "0.5.0";
$wp_emoji_one_setting_opt = get_option('wp_emoji_one_setting_opt');

#------------------------------------------------------------------------------
# version check
#------------------------------------------------------------------------------
add_action('plugins_loaded', 'wp_emoji_one_check_ver');

function wp_emoji_one_check_ver(){
	global $wp_emoji_one_ver;
	if ($wp_emoji_one_ver != get_option('wp_emoji_one_checkver_stamp')) {
		wp_emoji_one_setting_init();
		add_action('admin_notices', 'wp_emoji_one_admin_updated_notice');
	}
}

#------------------------------------------------------------------------------
# setting init
#------------------------------------------------------------------------------
function wp_emoji_one_setting_init(){
	global $wp_emoji_one_ver;

	$wp_emoji_one_setting_opt['wp_emoji_one_button_line'] = "1";

	update_option('wp_emoji_one_setting_opt', $wp_emoji_one_setting_opt);
	update_option('wp_emoji_one_checkver_stamp', $wp_emoji_one_ver);
}

#------------------------------------------------------------------------------
# table updated message
#------------------------------------------------------------------------------
function wp_emoji_one_admin_updated_notice(){
    echo '<div id="message" class="updated"><p>'.__("WP Emoji One has successfully created a new DB table.(If you updated, plugin settings were reset to default.)<br />Go to the settings panel and <strong>configure WP Emoji One</strong> now.","wp_emoji_one").'</p></div>';
}

#------------------------------------------------------------------------------
# plugin footer
#------------------------------------------------------------------------------
function wp_emoji_one_admin_footer(){
	$wp_emoji_one_plugin_data = get_plugin_data(__FILE__);
	printf('%1$s by %2$s<br />', $wp_emoji_one_plugin_data['Title'].' '.$wp_emoji_one_plugin_data['Version'], $wp_emoji_one_plugin_data['Author'] . '<br>Emoji provided free by <a href="http://emojione.com" target="_blank">Emoji One</a>.');
}

#------------------------------------------------------------------------------
# add links option menu
#------------------------------------------------------------------------------
add_action('admin_menu', 'wp_emoji_one_register_menu_item');

function wp_emoji_one_register_menu_item() {
	$wp_emoji_one_adv_page_hook = add_options_page('WP Emoji One Options', __("WP Emoji One","wp_emoji_one"), 'manage_options', 'wp_emoji_one-button-options', 'wp_emoji_one_options_panel');
	if ($wp_emoji_one_adv_page_hook != null) {
		$wp_emoji_one_adv_page_hook = '-'.$wp_emoji_one_adv_page_hook;
	}
}

#------------------------------------------------------------------------------
# Setting panel
#------------------------------------------------------------------------------
function wp_emoji_one_options_panel(){
	global $wp_emoji_one_plugin_url, $wp_emoji_one_ver;
	if (!function_exists('current_user_can') || !current_user_can('manage_options')) {
		die(__('Security Error.'));
	}
	add_action('in_admin_footer', 'wp_emoji_one_admin_footer');

	if (isset($_POST['wp_emoji_one_Setting_Submit']) && $_POST['wp_emoji_one_hidden_value'] == "true") {
		echo "<div id='setting-error-settings_updated' class='updated fade'><p><strong>".__("Settings saved.","wp_emoji_one")."</strong></p></div>";
	} elseif (isset($_POST['wp_emoji_one_ADV_Reset']) && $_POST['wp_emoji_one_adv_reset']='true') {
		echo "<div id='setting-error-settings_updated' class='updated fade'><p><strong>".__("All settings were reset. Please <a href=\"options-general.php?page=wp_emoji_one-button-options\">reload the page</a>.","wp_emoji_one")."</strong></p></div>";
	}

	$wp_emoji_one_setting_opt = get_option('wp_emoji_one_setting_opt');

	if ((!is_array($wp_emoji_one_setting_opt) || $wp_emoji_one_ver != get_option('wp_emoji_one_checkver_stamp')) && !isset($_POST['SHTB_ADV_Reset'])) {
		echo "<div id='setting-error-settings_updated' class='updated settings-error'><p><strong>".__("Error: Missing Database Table. The plugin may fail to create the database table when install or update. Please re-install.","wp_emoji_one")."</strong></p></div>";
	}

	// Update setting options
	if (isset($_POST['wp_emoji_one_Setting_Submit']) && $_POST['wp_emoji_one_hidden_value'] == "true") {
		$wp_emoji_one_setting_opt['wp_emoji_one_button_line'] = $_POST['wp_emoji_one_button_line'];

		update_option('wp_emoji_one_setting_opt', $wp_emoji_one_setting_opt);
	}

	// Reset all settings
	if (isset($_POST['wp_emoji_one_ADV_Reset']) && $_POST['wp_emoji_one_adv_reset']='true') {
		include_once('uninstall.php');
		wp_emoji_one_setting_init();
	}


	?> 
	<div class="wrap">
	<h2><?php _e("WP Emoji One Options", "wp_emoji_one")?></h2>
	<form method="post" action="<?php echo($_SERVER['REQUEST_URI']);?>">
	<input type="hidden" name="wp_emoji_one_hidden_value" value="true" />
	<h3><?php _e("1. Basic settings", 'wp_emoji_one') ?></h3> 
		<table class="form-table">
			<tr valign="top">
				<th scope="row"><strong><?php _e('Place the buttons in', 'wp_emoji_one') ?></strong></th> 
				<td>
					<select name="wp_emoji_one_button_line">
						<option value="1" <?php if ($wp_emoji_one_setting_opt['wp_emoji_one_button_line'] == "1") {echo 'selected="selected"';} ?>><?php _e("1st row", "wp_emoji_one") ?></option>
						<option value="2" <?php if ($wp_emoji_one_setting_opt['wp_emoji_one_button_line'] == "2") {echo 'selected="selected"';} ?>><?php _e("2nd row", "wp_emoji_one") ?></option>
						<option value="3" <?php if ($wp_emoji_one_setting_opt['wp_emoji_one_button_line'] == "3") {echo 'selected="selected"';} ?>><?php _e("3rd row", "wp_emoji_one") ?></option>
						<option value="4" <?php if ($wp_emoji_one_setting_opt['wp_emoji_one_button_line'] == "4") {echo 'selected="selected"';} ?>><?php _e("4th row", "wp_emoji_one") ?></option>
					</select> <?php _e("of TinyMCE toolbar.", "wp_emoji_one") ?>
					<p><small><?php _e("Choose TinyMCE toolbar row which buttons will be placed in.", "wp_emoji_one") ?></small></p>
				</td>
			</tr>
		</table>
		<p class="submit">
		<input type="submit" name="wp_emoji_one_Setting_Submit" value="<?php _e('Save Changes', 'wp_emoji_one') ?>" />
		</p>
	</form>
	<h3><?php _e("2. Icons List", 'wp_emoji_one') ?></h3>
	<p>
	<img src="<?php echo $wp_emoji_one_plugin_url; ?>/img/emojione-icons.png">
	</p>
	<h3><?php _e("3. Your System Info", 'wp_emoji_one') ?></h3>
	<p>
	<?php _e('Server OS:', 'wp_emoji_one') ?> <?php echo php_uname('s').' '.php_uname('r'); ?><br />
	<?php _e('PHP version:', 'wp_emoji_one') ?> <?php echo phpversion(); ?><br />
	<?php _e('MySQL version:', 'wp_emoji_one') ?> <?php echo mysql_get_server_info(); ?><br />
	<?php _e('WordPress version:', 'wp_emoji_one') ?> <?php bloginfo("version"); ?><br />
	<?php _e('Site URL:', 'wp_emoji_one') ?> <?php bloginfo("url"); ?><br />
	<?php _e('WordPress URL:', 'wp_emoji_one') ?> <?php bloginfo("wpurl"); ?><br />
	<?php _e('WordPress language:', 'wp_emoji_one') ?> <?php bloginfo("language"); ?><br />
	<?php _e('WordPress character set:', 'wp_emoji_one') ?> <?php bloginfo("charset"); ?><br />
	<?php _e('WordPress theme:', 'wp_emoji_one') ?> <?php $wp_emoji_one_theme = wp_get_theme(); echo $wp_emoji_one_theme['Name'].' '.$wp_emoji_one_theme['Version']; ?><br />
	<?php _e('WP Emoji One version:', 'wp_emoji_one') ?> <?php $wp_emoji_one_plugin_data = get_plugin_data(__FILE__); echo $wp_emoji_one_plugin_data['Version']; ?><br />
	<?php _e('WP Emoji One URL:', 'wp_emoji_one') ?> <?php echo $wp_emoji_one_plugin_url; ?><br />
	<?php _e('Your browser:', 'wp_emoji_one') ?> <?php echo $_SERVER['HTTP_USER_AGENT']; ?>
	</p>
	<h3><?php _e("4. Contact us", 'wp_emoji_one') ?></h3>
	<p>
	<?php _e("Monchito.net", 'wp_emoji_one') ?> [ <a href="http://www.monchito.net">http://www.monchito.net</a> ] 
	</p>
	<p>
	<?php _e("To report a bug, submit requests and feedback, ", 'wp_emoji_one') ?><?php _e('use <a href="http://www.monchito.net/contacto">our contact form</a>', 'wp_emoji_one') ?>
	</p>
	</div>
<?php } 

#------------------------------------------------------------------------------
# Insert WP Emoji One Icon for tinyMCE
#------------------------------------------------------------------------------
function wp_emoji_one_addbuttons() {
	// Don't bother doing this stuff if the current user lacks permissions
	if ( !current_user_can('edit_posts') && !current_user_can('edit_pages') ) return;
	// Add only in Rich Editor mode
	if ( get_user_option('rich_editing') == 'true') {
	// add the button for wp25 in a new way
		add_filter("mce_external_plugins", 'add_wp_emoji_one_tinymce_plugin');
		$wp_emoji_one_setting_opt = get_option('wp_emoji_one_setting_opt');
		$button_line = $wp_emoji_one_setting_opt['wp_emoji_one_button_line'];
		if ($button_line == "2" || $button_line == "3" || $button_line == "4") {
			add_filter('mce_buttons_'.$button_line, 'register_wp_emoji_one_button');
		} else {
			add_filter('mce_buttons', 'register_wp_emoji_one_button');
		}
	}
}

#------------------------------------------------------------------------------
# register WP Emoji One button
#------------------------------------------------------------------------------
function register_wp_emoji_one_button($buttons) {
	array_push($buttons, "separator", "wp_emoji_one");
	return $buttons;
}

#------------------------------------------------------------------------------
# Load editor_plugin.js
#------------------------------------------------------------------------------
function add_wp_emoji_one_tinymce_plugin($plugin_array) {
	global $wp_emoji_one_plugin_url;
	$wp_emoji_one_setting_opt = get_option('wp_emoji_one_setting_opt');
	$plugin_array['wp_emoji_one'] = $wp_emoji_one_plugin_url.'/js/editor_plugin.js';
	return $plugin_array;
}

#------------------------------------------------------------------------------
# change version
#------------------------------------------------------------------------------
function wp_emoji_one_change_tinymce_version($version) {
	return ++$version;
}

#------------------------------------------------------------------------------
# WordPress filter and action
#------------------------------------------------------------------------------
add_filter('tiny_mce_version', 'wp_emoji_one_change_tinymce_version');
add_action('init', 'wp_emoji_one_addbuttons');
?>
