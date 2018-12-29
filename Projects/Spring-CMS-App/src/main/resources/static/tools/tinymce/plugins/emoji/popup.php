<?php
require_once( dirname(dirname(dirname(dirname(__FILE__)))) . '/wp-config.php');
load_plugin_textdomain('wp_emoji_one', false, dirname( plugin_basename( __FILE__ ) ) . '/languages/' );
?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><?php _e('WP Emoji One',"wp_emoji_one"); ?></title>
	<script language="javascript" type="text/javascript" src="<?php echo get_option('siteurl') ?>/wp-includes/js/tinymce/tiny_mce_popup.js"></script>
	<script language="javascript" type="text/javascript" src="<?php echo get_option('siteurl') ?>/wp-includes/js/tinymce/utils/form_utils.js"></script>
	<link rel='stylesheet' id='wp_emoji-css'  href='<?php echo plugin_dir_url( __FILE__ ); ?>/css/wp-emoji-one-style.css' type='text/css' media='all' />
	<base target="_self" />

	<script language="javascript" type="text/javascript" src="<?php echo plugin_dir_url( __FILE__ ); ?>/js/InsertEmoji.js"></script>
</head>
<body id="link" onload="tinyMCEPopup.executeOnLoad('init();');document.body.style.display='';" style="display: none">

	<form action="#">
	
  <input id="tab1" type="radio" name="tabs" checked>
  <label for="tab1" title="<?php _e("People", 'wp_emoji_one'); ?>"><img src="<?php echo plugin_dir_url( __FILE__ ); ?>/img/smiley.png" alt="" /></label>
  <input id="tab2" type="radio" name="tabs">
  <label for="tab2" title="<?php _e("Nature and Animals", 'wp_emoji_one'); ?>"><img src="<?php echo plugin_dir_url( __FILE__ ); ?>/img/flower.png" alt="" /></label>
  <input id="tab3" type="radio" name="tabs">
  <label for="tab3" title="<?php _e("Food and Drink", 'wp_emoji_one'); ?>"><img src="<?php echo plugin_dir_url( __FILE__ ); ?>/img/apple.png" alt="" /></label>
  <input id="tab4" type="radio" name="tabs">
  <label for="tab4" title="<?php _e("Celebration", 'wp_emoji_one'); ?>"><img src="<?php echo plugin_dir_url( __FILE__ ); ?>/img/bow.png" alt="" /></label>
  <input id="tab5" type="radio" name="tabs">
  <label for="tab5" title="<?php _e("Activity", 'wp_emoji_one'); ?>"><img src="<?php echo plugin_dir_url( __FILE__ ); ?>/img/swim.png" alt="" /></label>
    <input id="tab6" type="radio" name="tabs">
    <label for="tab6" title="<?php _e("Travel and Places", 'wp_emoji_one'); ?>"><img src="<?php echo plugin_dir_url( __FILE__ ); ?>/img/car.png" alt="" /></label>
  <input id="tab7" type="radio" name="tabs">
  <label for="tab7" title="<?php _e("Objects and Symbols", 'wp_emoji_one'); ?>"><img src="<?php echo plugin_dir_url( __FILE__ ); ?>/img/clock.png" alt="" /></label>
  <hr><br />

	<?php //declaring path to icons 
		// $dir = plugin_dir_url( __FILE__ ).'/icons/'; 
	?>

    <span class="size-box">
		<label for="icon-size"><?php _e("Size:", 'wp_emoji_one'); ?></label></th>
            <select name="size" id="iconsize">
                <option value="16" selected="selected">16</option>
                <option value="18">18</option>
                <option value="24">24</option>
                <option value="32">32</option>
                <option value="64">64</option>
            </select>
            <em><?php _e("Specify the image size to use for the icons.", 'wp_emoji_one'); ?></em><br/>
	</span>

  <section id="content1">

    <p>
    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F600.png')"><div class="emojione-1F600"></div></a>
      <a href="javascript:emojiinsert('1F601.png')"><div class="emojione-1F601"></div></a>
      <a href="javascript:emojiinsert('1F602.png')"><div class="emojione-1F602"></div></a>
      <a href="javascript:emojiinsert('1F603.png')"><div class="emojione-1F603"></div></a>
      <a href="javascript:emojiinsert('1F604.png')"><div class="emojione-1F604"></div></a>
      <a href="javascript:emojiinsert('1F605.png')"><div class="emojione-1F605"></div></a>
      <a href="javascript:emojiinsert('1F606.png')"><div class="emojione-1F606"></div></a>
      <a href="javascript:emojiinsert('1F607.png')"><div class="emojione-1F607"></div></a>
      <a href="javascript:emojiinsert('1F608.png')"><div class="emojione-1F608"></div></a>
      <a href="javascript:emojiinsert('1F47F.png')"><div class="emojione-1F47F"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F609.png')"><div class="emojione-1F609"></div></a>
      <a href="javascript:emojiinsert('1F60A.png')"><div class="emojione-1F60A"></div></a>
      <a href="javascript:emojiinsert('263A.png')"><div class="emojione-263A"></div></a>
      <a href="javascript:emojiinsert('1F60B.png')"><div class="emojione-1F60B"></div></a>
      <a href="javascript:emojiinsert('1F60C.png')"><div class="emojione-1F60C"></div></a>
      <a href="javascript:emojiinsert('1F60D.png')"><div class="emojione-1F60D"></div></a>
      <a href="javascript:emojiinsert('1F60E.png')"><div class="emojione-1F60E"></div></a>
      <a href="javascript:emojiinsert('1F60F.png')"><div class="emojione-1F60F"></div></a>
      <a href="javascript:emojiinsert('1F610.png')"><div class="emojione-1F610"></div></a>
      <a href="javascript:emojiinsert('1F611.png')"><div class="emojione-1F611"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F612.png')"><div class="emojione-1F612"></div></a>
      <a href="javascript:emojiinsert('1F613.png')"><div class="emojione-1F613"></div></a>
      <a href="javascript:emojiinsert('1F614.png')"><div class="emojione-1F614"></div></a>
      <a href="javascript:emojiinsert('1F615.png')"><div class="emojione-1F615"></div></a>
      <a href="javascript:emojiinsert('1F616.png')"><div class="emojione-1F616"></div></a>
      <a href="javascript:emojiinsert('1F617.png')"><div class="emojione-1F617"></div></a>
      <a href="javascript:emojiinsert('1F618.png')"><div class="emojione-1F618"></div></a>
      <a href="javascript:emojiinsert('1F619.png')"><div class="emojione-1F619"></div></a>
      <a href="javascript:emojiinsert('1F61A.png')"><div class="emojione-1F61A"></div></a>
      <a href="javascript:emojiinsert('1F61B.png')"><div class="emojione-1F61B"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F61C.png')"><div class="emojione-1F61C"></div></a>
      <a href="javascript:emojiinsert('1F61D.png')"><div class="emojione-1F61D"></div></a>
      <a href="javascript:emojiinsert('1F61E.png')"><div class="emojione-1F61E"></div></a>
      <a href="javascript:emojiinsert('1F61F.png')"><div class="emojione-1F61F"></div></a>
      <a href="javascript:emojiinsert('1F620.png')"><div class="emojione-1F620"></div></a>
      <a href="javascript:emojiinsert('1F621.png')"><div class="emojione-1F621"></div></a>
      <a href="javascript:emojiinsert('1F622.png')"><div class="emojione-1F622"></div></a>
      <a href="javascript:emojiinsert('1F623.png')"><div class="emojione-1F623"></div></a>
      <a href="javascript:emojiinsert('1F624.png')"><div class="emojione-1F624"></div></a>
      <a href="javascript:emojiinsert('1F625.png')"><div class="emojione-1F625"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F626.png')"><div class="emojione-1F626"></div></a>
      <a href="javascript:emojiinsert('1F627.png')"><div class="emojione-1F627"></div></a>
      <a href="javascript:emojiinsert('1F628.png')"><div class="emojione-1F628"></div></a>
      <a href="javascript:emojiinsert('1F629.png')"><div class="emojione-1F629"></div></a>
      <a href="javascript:emojiinsert('1F62A.png')"><div class="emojione-1F62A"></div></a>
      <a href="javascript:emojiinsert('1F62B.png')"><div class="emojione-1F62B"></div></a>
      <a href="javascript:emojiinsert('1F62C.png')"><div class="emojione-1F62C"></div></a>
      <a href="javascript:emojiinsert('1F62D.png')"><div class="emojione-1F62D"></div></a>
      <a href="javascript:emojiinsert('1F62E.png')"><div class="emojione-1F62E"></div></a>
      <a href="javascript:emojiinsert('1F62F.png')"><div class="emojione-1F62F"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F630.png')"><div class="emojione-1F630"></div></a>
      <a href="javascript:emojiinsert('1F631.png')"><div class="emojione-1F631"></div></a>
      <a href="javascript:emojiinsert('1F632.png')"><div class="emojione-1F632"></div></a>
      <a href="javascript:emojiinsert('1F633.png')"><div class="emojione-1F633"></div></a>
      <a href="javascript:emojiinsert('1F634.png')"><div class="emojione-1F634"></div></a>
      <a href="javascript:emojiinsert('1F635.png')"><div class="emojione-1F635"></div></a>
      <a href="javascript:emojiinsert('1F636.png')"><div class="emojione-1F636"></div></a>
      <a href="javascript:emojiinsert('1F637.png')"><div class="emojione-1F637"></div></a>
      <a href="javascript:emojiinsert('1F641.png')"><div class="emojione-1F641"></div></a>
      <a href="javascript:emojiinsert('1F642.png')"><div class="emojione-1F642"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F638.png')"><div class="emojione-1F638"></div></a>
      <a href="javascript:emojiinsert('1F639.png')"><div class="emojione-1F639"></div></a>
      <a href="javascript:emojiinsert('1F63A.png')"><div class="emojione-1F63A"></div></a>
      <a href="javascript:emojiinsert('1F63B.png')"><div class="emojione-1F63B"></div></a>
      <a href="javascript:emojiinsert('1F63C.png')"><div class="emojione-1F63C"></div></a>
      <a href="javascript:emojiinsert('1F63D.png')"><div class="emojione-1F63D"></div></a>
      <a href="javascript:emojiinsert('1F63E.png')"><div class="emojione-1F63E"></div></a>
      <a href="javascript:emojiinsert('1F63F.png')"><div class="emojione-1F63F"></div></a>
      <a href="javascript:emojiinsert('1F640.png')"><div class="emojione-1F640"></div></a>
      <a href="javascript:emojiinsert('1F463.png')"><div class="emojione-1F463"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F464.png')"><div class="emojione-1F464"></div></a>
      <a href="javascript:emojiinsert('1F465.png')"><div class="emojione-1F465"></div></a>
      <a href="javascript:emojiinsert('1F574.png')"><div class="emojione-1F574"></div></a>
      <a href="javascript:emojiinsert('1F575.png')"><div class="emojione-1F575"></div></a>
      <a href="javascript:emojiinsert('1F476.png')"><div class="emojione-1F476"></div></a>
      <a href="javascript:emojiinsert('1F466.png')"><div class="emojione-1F466"></div></a>
      <a href="javascript:emojiinsert('1F467.png')"><div class="emojione-1F467"></div></a>
      <a href="javascript:emojiinsert('1F468.png')"><div class="emojione-1F468"></div></a>
      <a href="javascript:emojiinsert('1F469.png')"><div class="emojione-1F469"></div></a>
      <a href="javascript:emojiinsert('1F46A.png')"><div class="emojione-1F46A"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F468-1F469-1F467.png')"><div class="emojione-1F468-1F469-1F467"></div></a>
      <a href="javascript:emojiinsert('1F468-1F469-1F467-1F466.png')"><div class="emojione-1F468-1F469-1F467-1F466"></div></a>
      <a href="javascript:emojiinsert('1F468-1F469-1F466-1F466.png')"><div class="emojione-1F468-1F469-1F466-1F466"></div></a>
      <a href="javascript:emojiinsert('1F468-1F469-1F467-1F467.png')"><div class="emojione-1F468-1F469-1F467-1F467"></div></a>
      <a href="javascript:emojiinsert('1F469-1F469-1F466.png')"><div class="emojione-1F469-1F469-1F466"></div></a>
      <a href="javascript:emojiinsert('1F469-1F469-1F467.png')"><div class="emojione-1F469-1F469-1F467"></div></a>
      <a href="javascript:emojiinsert('1F469-1F469-1F467-1F466.png')"><div class="emojione-1F469-1F469-1F467-1F466"></div></a>
      <a href="javascript:emojiinsert('1F469-1F469-1F466-1F466.png')"><div class="emojione-1F469-1F469-1F466-1F466"></div></a>
      <a href="javascript:emojiinsert('1F469-1F469-1F467-1F467.png')"><div class="emojione-1F469-1F469-1F467-1F467"></div></a>
      <a href="javascript:emojiinsert('1F468-1F468-1F466.png')"><div class="emojione-1F468-1F468-1F466"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F468-1F468-1F467.png')"><div class="emojione-1F468-1F468-1F467"></div></a>
      <a href="javascript:emojiinsert('1F468-1F468-1F467-1F466.png')"><div class="emojione-1F468-1F468-1F467-1F466"></div></a>
      <a href="javascript:emojiinsert('1F468-1F468-1F466-1F466.png')"><div class="emojione-1F468-1F468-1F466-1F466"></div></a>
      <a href="javascript:emojiinsert('1F468-1F468-1F467-1F467.png')"><div class="emojione-1F468-1F468-1F467-1F467"></div></a>
      <a href="javascript:emojiinsert('1F46B.png')"><div class="emojione-1F46B"></div></a>
      <a href="javascript:emojiinsert('1F46C.png')"><div class="emojione-1F46C"></div></a>
      <a href="javascript:emojiinsert('1F46D.png')"><div class="emojione-1F46D"></div></a>
      <a href="javascript:emojiinsert('1F46F.png')"><div class="emojione-1F46F"></div></a>
      <a href="javascript:emojiinsert('1F470.png')"><div class="emojione-1F470"></div></a>
      <a href="javascript:emojiinsert('1F471.png')"><div class="emojione-1F471"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F472.png')"><div class="emojione-1F472"></div></a>
      <a href="javascript:emojiinsert('1F473.png')"><div class="emojione-1F473"></div></a>
      <a href="javascript:emojiinsert('1F474.png')"><div class="emojione-1F474"></div></a>
      <a href="javascript:emojiinsert('1F475.png')"><div class="emojione-1F475"></div></a>
      <a href="javascript:emojiinsert('1F46E.png')"><div class="emojione-1F46E"></div></a>
      <a href="javascript:emojiinsert('1F477.png')"><div class="emojione-1F477"></div></a>
      <a href="javascript:emojiinsert('1F478.png')"><div class="emojione-1F478"></div></a>
      <a href="javascript:emojiinsert('1F482.png')"><div class="emojione-1F482"></div></a>
      <a href="javascript:emojiinsert('1F47C.png')"><div class="emojione-1F47C"></div></a>
      <a href="javascript:emojiinsert('1F385.png')"><div class="emojione-1F385"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F47B.png')"><div class="emojione-1F47B"></div></a>
      <a href="javascript:emojiinsert('1F479.png')"><div class="emojione-1F479"></div></a>
      <a href="javascript:emojiinsert('1F47A.png')"><div class="emojione-1F47A"></div></a>
      <a href="javascript:emojiinsert('1F4A9.png')"><div class="emojione-1F4A9"></div></a>
      <a href="javascript:emojiinsert('1F480.png')"><div class="emojione-1F480"></div></a>
      <a href="javascript:emojiinsert('1F47D.png')"><div class="emojione-1F47D"></div></a>
      <a href="javascript:emojiinsert('1F47E.png')"><div class="emojione-1F47E"></div></a>
      <a href="javascript:emojiinsert('1F647.png')"><div class="emojione-1F647"></div></a>
      <a href="javascript:emojiinsert('1F481.png')"><div class="emojione-1F481"></div></a>
      <a href="javascript:emojiinsert('1F645.png')"><div class="emojione-1F645"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F646.png')"><div class="emojione-1F646"></div></a>
      <a href="javascript:emojiinsert('1F64B.png')"><div class="emojione-1F64B"></div></a>
      <a href="javascript:emojiinsert('1F64E.png')"><div class="emojione-1F64E"></div></a>
      <a href="javascript:emojiinsert('1F64D.png')"><div class="emojione-1F64D"></div></a>
      <a href="javascript:emojiinsert('1F486.png')"><div class="emojione-1F486"></div></a>
      <a href="javascript:emojiinsert('1F487.png')"><div class="emojione-1F487"></div></a>
      <a href="javascript:emojiinsert('1F491.png')"><div class="emojione-1F491"></div></a>
      <a href="javascript:emojiinsert('1F469-2764-1F469.png')"><div class="emojione-1F469-2764-1F469"></div></a>
      <a href="javascript:emojiinsert('1F468-2764-1F468.png')"><div class="emojione-1F468-2764-1F468"></div></a>
      <a href="javascript:emojiinsert('1F48F.png')"><div class="emojione-1F48F"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F469-2764-1F48B-1F469.png')"><div class="emojione-1F469-2764-1F48B-1F469"></div></a>
      <a href="javascript:emojiinsert('1F468-2764-1F48B-1F468.png')"><div class="emojione-1F468-2764-1F48B-1F468"></div></a>
      <a href="javascript:emojiinsert('1F64C.png')"><div class="emojione-1F64C"></div></a>
      <a href="javascript:emojiinsert('1F44F.png')"><div class="emojione-1F44F"></div></a>
      <a href="javascript:emojiinsert('1F442.png')"><div class="emojione-1F442"></div></a>
      <a href="javascript:emojiinsert('1F441.png')"><div class="emojione-1F441"></div></a>
      <a href="javascript:emojiinsert('1F440.png')"><div class="emojione-1F440"></div></a>
      <a href="javascript:emojiinsert('1F443.png')"><div class="emojione-1F443"></div></a>
      <a href="javascript:emojiinsert('1F444.png')"><div class="emojione-1F444"></div></a>
      <a href="javascript:emojiinsert('1F48B.png')"><div class="emojione-1F48B"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F445.png')"><div class="emojione-1F445"></div></a>
      <a href="javascript:emojiinsert('1F485.png')"><div class="emojione-1F485"></div></a>
      <a href="javascript:emojiinsert('1F44B.png')"><div class="emojione-1F44B"></div></a>
      <a href="javascript:emojiinsert('1F44D.png')"><div class="emojione-1F44D"></div></a>
      <a href="javascript:emojiinsert('1F44E.png')"><div class="emojione-1F44E"></div></a>
      <a href="javascript:emojiinsert('261D.png')"><div class="emojione-261D"></div></a>
      <a href="javascript:emojiinsert('1F446.png')"><div class="emojione-1F446"></div></a>
      <a href="javascript:emojiinsert('1F447.png')"><div class="emojione-1F447"></div></a>
      <a href="javascript:emojiinsert('1F448.png')"><div class="emojione-1F448"></div></a>
      <a href="javascript:emojiinsert('1F449.png')"><div class="emojione-1F449"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F44C.png')"><div class="emojione-1F44C"></div></a>
      <a href="javascript:emojiinsert('270C.png')"><div class="emojione-270C"></div></a>
      <a href="javascript:emojiinsert('1F44A.png')"><div class="emojione-1F44A"></div></a>
      <a href="javascript:emojiinsert('270A.png')"><div class="emojione-270A"></div></a>
      <a href="javascript:emojiinsert('270B.png')"><div class="emojione-270B"></div></a>
      <a href="javascript:emojiinsert('1F4AA.png')"><div class="emojione-1F4AA"></div></a>
      <a href="javascript:emojiinsert('1F450.png')"><div class="emojione-1F450"></div></a>
      <a href="javascript:emojiinsert('1F58E.png')"><div class="emojione-1F58E"></div></a>
      <a href="javascript:emojiinsert('1F590.png')"><div class="emojione-1F590"></div></a>
      <a href="javascript:emojiinsert('1F595.png')"><div class="emojione-1F595"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F596.png')"><div class="emojione-1F596"></div></a>
      <a href="javascript:emojiinsert('1F64F.png')"><div class="emojione-1F64F"></div></a>
    </div>
    </p>
  </section>

  <section id="content2">

    <p>
    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F331.png')"><div class="emojione-1F331"></div></a>
      <a href="javascript:emojiinsert('1F332.png')"><div class="emojione-1F332"></div></a>
      <a href="javascript:emojiinsert('1F333.png')"><div class="emojione-1F333"></div></a>
      <a href="javascript:emojiinsert('1F334.png')"><div class="emojione-1F334"></div></a>
      <a href="javascript:emojiinsert('1F335.png')"><div class="emojione-1F335"></div></a>
      <a href="javascript:emojiinsert('1F337.png')"><div class="emojione-1F337"></div></a>
      <a href="javascript:emojiinsert('1F338.png')"><div class="emojione-1F338"></div></a>
      <a href="javascript:emojiinsert('1F339.png')"><div class="emojione-1F339"></div></a>
      <a href="javascript:emojiinsert('1F33A.png')"><div class="emojione-1F33A"></div></a>
      <a href="javascript:emojiinsert('1F33B.png')"><div class="emojione-1F33B"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F33C.png')"><div class="emojione-1F33C"></div></a>
      <a href="javascript:emojiinsert('1F490.png')"><div class="emojione-1F490"></div></a>
      <a href="javascript:emojiinsert('1F33E.png')"><div class="emojione-1F33E"></div></a>
      <a href="javascript:emojiinsert('1F33F.png')"><div class="emojione-1F33F"></div></a>
      <a href="javascript:emojiinsert('1F340.png')"><div class="emojione-1F340"></div></a>
      <a href="javascript:emojiinsert('1F341.png')"><div class="emojione-1F341"></div></a>
      <a href="javascript:emojiinsert('1F342.png')"><div class="emojione-1F342"></div></a>
      <a href="javascript:emojiinsert('1F343.png')"><div class="emojione-1F343"></div></a>
      <a href="javascript:emojiinsert('1F344.png')"><div class="emojione-1F344"></div></a>
      <a href="javascript:emojiinsert('1F330.png')"><div class="emojione-1F330"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F400.png')"><div class="emojione-1F400"></div></a>
      <a href="javascript:emojiinsert('1F401.png')"><div class="emojione-1F401"></div></a>
      <a href="javascript:emojiinsert('1F42D.png')"><div class="emojione-1F42D"></div></a>
      <a href="javascript:emojiinsert('1F439.png')"><div class="emojione-1F439"></div></a>
      <a href="javascript:emojiinsert('1F402.png')"><div class="emojione-1F402"></div></a>
      <a href="javascript:emojiinsert('1F403.png')"><div class="emojione-1F403"></div></a>
      <a href="javascript:emojiinsert('1F404.png')"><div class="emojione-1F404"></div></a>
      <a href="javascript:emojiinsert('1F42E.png')"><div class="emojione-1F42E"></div></a>
      <a href="javascript:emojiinsert('1F405.png')"><div class="emojione-1F405"></div></a>
      <a href="javascript:emojiinsert('1F406.png')"><div class="emojione-1F406"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F42F.png')"><div class="emojione-1F42F"></div></a>
      <a href="javascript:emojiinsert('1F43F.png')"><div class="emojione-1F43F"></div></a>
      <a href="javascript:emojiinsert('1F407.png')"><div class="emojione-1F407"></div></a>
      <a href="javascript:emojiinsert('1F430.png')"><div class="emojione-1F430"></div></a>
      <a href="javascript:emojiinsert('1F408.png')"><div class="emojione-1F408"></div></a>
      <a href="javascript:emojiinsert('1F431.png')"><div class="emojione-1F431"></div></a>
      <a href="javascript:emojiinsert('1F40E.png')"><div class="emojione-1F40E"></div></a>
      <a href="javascript:emojiinsert('1F434.png')"><div class="emojione-1F434"></div></a>
      <a href="javascript:emojiinsert('1F40F.png')"><div class="emojione-1F40F"></div></a>
      <a href="javascript:emojiinsert('1F411.png')"><div class="emojione-1F411"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F410.png')"><div class="emojione-1F410"></div></a>
      <a href="javascript:emojiinsert('1F413.png')"><div class="emojione-1F413"></div></a>
      <a href="javascript:emojiinsert('1F414.png')"><div class="emojione-1F414"></div></a>
      <a href="javascript:emojiinsert('1F424.png')"><div class="emojione-1F424"></div></a>
      <a href="javascript:emojiinsert('1F423.png')"><div class="emojione-1F423"></div></a>
      <a href="javascript:emojiinsert('1F425.png')"><div class="emojione-1F425"></div></a>
      <a href="javascript:emojiinsert('1F426.png')"><div class="emojione-1F426"></div></a>
      <a href="javascript:emojiinsert('1F427.png')"><div class="emojione-1F427"></div></a>
      <a href="javascript:emojiinsert('1F418.png')"><div class="emojione-1F418"></div></a>
      <a href="javascript:emojiinsert('1F42A.png')"><div class="emojione-1F42A"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F42B.png')"><div class="emojione-1F42B"></div></a>
      <a href="javascript:emojiinsert('1F417.png')"><div class="emojione-1F417"></div></a>
      <a href="javascript:emojiinsert('1F416.png')"><div class="emojione-1F416"></div></a>
      <a href="javascript:emojiinsert('1F437.png')"><div class="emojione-1F437"></div></a>
      <a href="javascript:emojiinsert('1F43D.png')"><div class="emojione-1F43D"></div></a>
      <a href="javascript:emojiinsert('1F415.png')"><div class="emojione-1F415"></div></a>
      <a href="javascript:emojiinsert('1F429.png')"><div class="emojione-1F429"></div></a>
      <a href="javascript:emojiinsert('1F436.png')"><div class="emojione-1F436"></div></a>
      <a href="javascript:emojiinsert('1F43A.png')"><div class="emojione-1F43A"></div></a>
      <a href="javascript:emojiinsert('1F43B.png')"><div class="emojione-1F43B"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F428.png')"><div class="emojione-1F428"></div></a>
      <a href="javascript:emojiinsert('1F43C.png')"><div class="emojione-1F43C"></div></a>
      <a href="javascript:emojiinsert('1F435.png')"><div class="emojione-1F435"></div></a>
      <a href="javascript:emojiinsert('1F648.png')"><div class="emojione-1F648"></div></a>
      <a href="javascript:emojiinsert('1F649.png')"><div class="emojione-1F649"></div></a>
      <a href="javascript:emojiinsert('1F64A.png')"><div class="emojione-1F64A"></div></a>
      <a href="javascript:emojiinsert('1F412.png')"><div class="emojione-1F412"></div></a>
      <a href="javascript:emojiinsert('1F409.png')"><div class="emojione-1F409"></div></a>
      <a href="javascript:emojiinsert('1F432.png')"><div class="emojione-1F432"></div></a>
      <a href="javascript:emojiinsert('1F40A.png')"><div class="emojione-1F40A"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F40D.png')"><div class="emojione-1F40D"></div></a>
      <a href="javascript:emojiinsert('1F422.png')"><div class="emojione-1F422"></div></a>
      <a href="javascript:emojiinsert('1F438.png')"><div class="emojione-1F438"></div></a>
      <a href="javascript:emojiinsert('1F40B.png')"><div class="emojione-1F40B"></div></a>
      <a href="javascript:emojiinsert('1F433.png')"><div class="emojione-1F433"></div></a>
      <a href="javascript:emojiinsert('1F42C.png')"><div class="emojione-1F42C"></div></a>
      <a href="javascript:emojiinsert('1F419.png')"><div class="emojione-1F419"></div></a>
      <a href="javascript:emojiinsert('1F41F.png')"><div class="emojione-1F41F"></div></a>
      <a href="javascript:emojiinsert('1F420.png')"><div class="emojione-1F420"></div></a>
      <a href="javascript:emojiinsert('1F421.png')"><div class="emojione-1F421"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F41A.png')"><div class="emojione-1F41A"></div></a>
      <a href="javascript:emojiinsert('1F40C.png')"><div class="emojione-1F40C"></div></a>
      <a href="javascript:emojiinsert('1F41B.png')"><div class="emojione-1F41B"></div></a>
      <a href="javascript:emojiinsert('1F41C.png')"><div class="emojione-1F41C"></div></a>
      <a href="javascript:emojiinsert('1F41D.png')"><div class="emojione-1F41D"></div></a>
      <a href="javascript:emojiinsert('1F41E.png')"><div class="emojione-1F41E"></div></a>
      <a href="javascript:emojiinsert('1F577.png')"><div class="emojione-1F577"></div></a>
      <a href="javascript:emojiinsert('1F578.png')"><div class="emojione-1F578"></div></a>
      <a href="javascript:emojiinsert('1F43E.png')"><div class="emojione-1F43E"></div></a>
      <a href="javascript:emojiinsert('26A1.png')"><div class="emojione-26A1"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F525.png')"><div class="emojione-1F525"></div></a>
      <a href="javascript:emojiinsert('1F319.png')"><div class="emojione-1F319"></div></a>
      <a href="javascript:emojiinsert('2600.png')"><div class="emojione-2600"></div></a>
      <a href="javascript:emojiinsert('26C5.png')"><div class="emojione-26C5"></div></a>
      <a href="javascript:emojiinsert('2601.png')"><div class="emojione-2601"></div></a>
      <a href="javascript:emojiinsert('1F327.png')"><div class="emojione-1F327"></div></a>
      <a href="javascript:emojiinsert('1F328.png')"><div class="emojione-1F328"></div></a>
      <a href="javascript:emojiinsert('1F329.png')"><div class="emojione-1F329"></div></a>
      <a href="javascript:emojiinsert('1F32A.png')"><div class="emojione-1F32A"></div></a>
      <a href="javascript:emojiinsert('1F4A7.png')"><div class="emojione-1F4A7"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F4A6.png')"><div class="emojione-1F4A6"></div></a>
      <a href="javascript:emojiinsert('2614.png')"><div class="emojione-2614"></div></a>
      <a href="javascript:emojiinsert('1F32B.png')"><div class="emojione-1F32B"></div></a>
      <a href="javascript:emojiinsert('1F4A8.png')"><div class="emojione-1F4A8"></div></a>
      <a href="javascript:emojiinsert('2744.png')"><div class="emojione-2744"></div></a>
      <a href="javascript:emojiinsert('1F31F.png')"><div class="emojione-1F31F"></div></a>
      <a href="javascript:emojiinsert('2B50.png')"><div class="emojione-2B50"></div></a>
      <a href="javascript:emojiinsert('1F320.png')"><div class="emojione-1F320"></div></a>
      <a href="javascript:emojiinsert('1F304.png')"><div class="emojione-1F304"></div></a>
      <a href="javascript:emojiinsert('1F305.png')"><div class="emojione-1F305"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F308.png')"><div class="emojione-1F308"></div></a>
      <a href="javascript:emojiinsert('1F30A.png')"><div class="emojione-1F30A"></div></a>
      <a href="javascript:emojiinsert('1F30B.png')"><div class="emojione-1F30B"></div></a>
      <a href="javascript:emojiinsert('1F30C.png')"><div class="emojione-1F30C"></div></a>
      <a href="javascript:emojiinsert('1F5FB.png')"><div class="emojione-1F5FB"></div></a>
      <a href="javascript:emojiinsert('1F5FE.png')"><div class="emojione-1F5FE"></div></a>
      <a href="javascript:emojiinsert('1F310.png')"><div class="emojione-1F310"></div></a>
      <a href="javascript:emojiinsert('1F30D.png')"><div class="emojione-1F30D"></div></a>
      <a href="javascript:emojiinsert('1F30E.png')"><div class="emojione-1F30E"></div></a>
      <a href="javascript:emojiinsert('1F30F.png')"><div class="emojione-1F30F"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F311.png')"><div class="emojione-1F311"></div></a>
      <a href="javascript:emojiinsert('1F312.png')"><div class="emojione-1F312"></div></a>
      <a href="javascript:emojiinsert('1F313.png')"><div class="emojione-1F313"></div></a>
      <a href="javascript:emojiinsert('1F314.png')"><div class="emojione-1F314"></div></a>
      <a href="javascript:emojiinsert('1F315.png')"><div class="emojione-1F315"></div></a>
      <a href="javascript:emojiinsert('1F316.png')"><div class="emojione-1F316"></div></a>
      <a href="javascript:emojiinsert('1F317.png')"><div class="emojione-1F317"></div></a>
      <a href="javascript:emojiinsert('1F318.png')"><div class="emojione-1F318"></div></a>
      <a href="javascript:emojiinsert('1F31A.png')"><div class="emojione-1F31A"></div></a>
      <a href="javascript:emojiinsert('1F31D.png')"><div class="emojione-1F31D"></div></a>
    </div>

    <div class="emoji-grid">
      <a href="javascript:emojiinsert('1F31B.png')"><div class="emojione-1F31B"></div></a>
      <a href="javascript:emojiinsert('1F31C.png')"><div class="emojione-1F31C"></div></a>
      <a href="javascript:emojiinsert('1F31E.png')"><div class="emojione-1F31E"></div></a>
      <a href="javascript:emojiinsert('1F32C.png')"><div class="emojione-1F32C"></div></a>
    </div>
    </p>
  </section>

  <section id="content3">

    <p>
      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F345.png', iconsize)"><div class="emojione-1F345"></div></a>
          <a href="javascript:emojiinsert('1F346.png', iconsize)"><div class="emojione-1F346"></div></a>
          <a href="javascript:emojiinsert('1F33D.png', iconsize)"><div class="emojione-1F33D"></div></a>
          <a href="javascript:emojiinsert('1F360.png', iconsize)"><div class="emojione-1F360"></div></a>
          <a href="javascript:emojiinsert('1F336.png', iconsize)"><div class="emojione-1F336"></div></a>
          <a href="javascript:emojiinsert('1F347.png', iconsize)"><div class="emojione-1F347"></div></a>
          <a href="javascript:emojiinsert('1F348.png', iconsize)"><div class="emojione-1F348"></div></a>
          <a href="javascript:emojiinsert('1F349.png', iconsize)"><div class="emojione-1F349"></div></a>
          <a href="javascript:emojiinsert('1F34A.png', iconsize)"><div class="emojione-1F34A"></div></a>
          <a href="javascript:emojiinsert('1F34B.png', iconsize)"><div class="emojione-1F34B"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F34C.png', iconsize)"><div class="emojione-1F34C"></div></a>
          <a href="javascript:emojiinsert('1F34D.png', iconsize)"><div class="emojione-1F34D"></div></a>
          <a href="javascript:emojiinsert('1F34E.png', iconsize)"><div class="emojione-1F34E"></div></a>
          <a href="javascript:emojiinsert('1F34F.png', iconsize)"><div class="emojione-1F34F"></div></a>
          <a href="javascript:emojiinsert('1F350.png', iconsize)"><div class="emojione-1F350"></div></a>
          <a href="javascript:emojiinsert('1F351.png', iconsize)"><div class="emojione-1F351"></div></a>
          <a href="javascript:emojiinsert('1F352.png', iconsize)"><div class="emojione-1F352"></div></a>
          <a href="javascript:emojiinsert('1F353.png', iconsize)"><div class="emojione-1F353"></div></a>
          <a href="javascript:emojiinsert('1F354.png', iconsize)"><div class="emojione-1F354"></div></a>
          <a href="javascript:emojiinsert('1F355.png', iconsize)"><div class="emojione-1F355"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F356.png', iconsize)"><div class="emojione-1F356"></div></a>
          <a href="javascript:emojiinsert('1F357.png', iconsize)"><div class="emojione-1F357"></div></a>
          <a href="javascript:emojiinsert('1F358.png', iconsize)"><div class="emojione-1F358"></div></a>
          <a href="javascript:emojiinsert('1F359.png', iconsize)"><div class="emojione-1F359"></div></a>
          <a href="javascript:emojiinsert('1F35A.png', iconsize)"><div class="emojione-1F35A"></div></a>
          <a href="javascript:emojiinsert('1F35B.png', iconsize)"><div class="emojione-1F35B"></div></a>
          <a href="javascript:emojiinsert('1F35C.png', iconsize)"><div class="emojione-1F35C"></div></a>
          <a href="javascript:emojiinsert('1F35D.png', iconsize)"><div class="emojione-1F35D"></div></a>
          <a href="javascript:emojiinsert('1F35E.png', iconsize)"><div class="emojione-1F35E"></div></a>
          <a href="javascript:emojiinsert('1F35F.png', iconsize)"><div class="emojione-1F35F"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F361.png', iconsize)"><div class="emojione-1F361"></div></a>
          <a href="javascript:emojiinsert('1F362.png', iconsize)"><div class="emojione-1F362"></div></a>
          <a href="javascript:emojiinsert('1F363.png', iconsize)"><div class="emojione-1F363"></div></a>
          <a href="javascript:emojiinsert('1F364.png', iconsize)"><div class="emojione-1F364"></div></a>
          <a href="javascript:emojiinsert('1F365.png', iconsize)"><div class="emojione-1F365"></div></a>
          <a href="javascript:emojiinsert('1F366.png', iconsize)"><div class="emojione-1F366"></div></a>
          <a href="javascript:emojiinsert('1F367.png', iconsize)"><div class="emojione-1F367"></div></a>
          <a href="javascript:emojiinsert('1F368.png', iconsize)"><div class="emojione-1F368"></div></a>
          <a href="javascript:emojiinsert('1F369.png', iconsize)"><div class="emojione-1F369"></div></a>
          <a href="javascript:emojiinsert('1F36A.png', iconsize)"><div class="emojione-1F36A"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F36B.png', iconsize)"><div class="emojione-1F36B"></div></a>
          <a href="javascript:emojiinsert('1F36C.png', iconsize)"><div class="emojione-1F36C"></div></a>
          <a href="javascript:emojiinsert('1F36D.png', iconsize)"><div class="emojione-1F36D"></div></a>
          <a href="javascript:emojiinsert('1F36E.png', iconsize)"><div class="emojione-1F36E"></div></a>
          <a href="javascript:emojiinsert('1F36F.png', iconsize)"><div class="emojione-1F36F"></div></a>
          <a href="javascript:emojiinsert('1F370.png', iconsize)"><div class="emojione-1F370"></div></a>
          <a href="javascript:emojiinsert('1F371.png', iconsize)"><div class="emojione-1F371"></div></a>
          <a href="javascript:emojiinsert('1F372.png', iconsize)"><div class="emojione-1F372"></div></a>
          <a href="javascript:emojiinsert('1F373.png', iconsize)"><div class="emojione-1F373"></div></a>
          <a href="javascript:emojiinsert('1F374.png', iconsize)"><div class="emojione-1F374"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F375.png', iconsize)"><div class="emojione-1F375"></div></a>
          <a href="javascript:emojiinsert('2615.png', iconsize)"><div class="emojione-2615"></div></a>
          <a href="javascript:emojiinsert('1F376.png', iconsize)"><div class="emojione-1F376"></div></a>
          <a href="javascript:emojiinsert('1F377.png', iconsize)"><div class="emojione-1F377"></div></a>
          <a href="javascript:emojiinsert('1F378.png', iconsize)"><div class="emojione-1F378"></div></a>
          <a href="javascript:emojiinsert('1F379.png', iconsize)"><div class="emojione-1F379"></div></a>
          <a href="javascript:emojiinsert('1F37A.png', iconsize)"><div class="emojione-1F37A"></div></a>
          <a href="javascript:emojiinsert('1F37B.png', iconsize)"><div class="emojione-1F37B"></div></a>
          <a href="javascript:emojiinsert('1F37C.png', iconsize)"><div class="emojione-1F37C"></div></a>
      </div>

    </p>
  </section>

  <section id="content4">

    <p>
      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F380.png', iconsize)"><div class="emojione-1F380"></div></a>
          <a href="javascript:emojiinsert('1F381.png', iconsize)"><div class="emojione-1F381"></div></a>
          <a href="javascript:emojiinsert('1F382.png', iconsize)"><div class="emojione-1F382"></div></a>
          <a href="javascript:emojiinsert('1F383.png', iconsize)"><div class="emojione-1F383"></div></a>
          <a href="javascript:emojiinsert('1F384.png', iconsize)"><div class="emojione-1F384"></div></a>
          <a href="javascript:emojiinsert('1F38B.png', iconsize)"><div class="emojione-1F38B"></div></a>
          <a href="javascript:emojiinsert('1F38D.png', iconsize)"><div class="emojione-1F38D"></div></a>
          <a href="javascript:emojiinsert('1F391.png', iconsize)"><div class="emojione-1F391"></div></a>
          <a href="javascript:emojiinsert('1F386.png', iconsize)"><div class="emojione-1F386"></div></a>
          <a href="javascript:emojiinsert('1F387.png', iconsize)"><div class="emojione-1F387"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F389.png', iconsize)"><div class="emojione-1F389"></div></a>
          <a href="javascript:emojiinsert('1F38A.png', iconsize)"><div class="emojione-1F38A"></div></a>
          <a href="javascript:emojiinsert('1F388.png', iconsize)"><div class="emojione-1F388"></div></a>
          <a href="javascript:emojiinsert('1F4AB.png', iconsize)"><div class="emojione-1F4AB"></div></a>
          <a href="javascript:emojiinsert('2728.png', iconsize)"><div class="emojione-2728"></div></a>
          <a href="javascript:emojiinsert('1F4A5.png', iconsize)"><div class="emojione-1F4A5"></div></a>
          <a href="javascript:emojiinsert('1F393.png', iconsize)"><div class="emojione-1F393"></div></a>
          <a href="javascript:emojiinsert('1F451.png', iconsize)"><div class="emojione-1F451"></div></a>
          <a href="javascript:emojiinsert('1F397.png', iconsize)"><div class="emojione-1F397"></div></a>
          <a href="javascript:emojiinsert('1F396.png', iconsize)"><div class="emojione-1F396"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F38E.png', iconsize)"><div class="emojione-1F38E"></div></a>
          <a href="javascript:emojiinsert('1F38F.png', iconsize)"><div class="emojione-1F38F"></div></a>
          <a href="javascript:emojiinsert('1F390.png', iconsize)"><div class="emojione-1F390"></div></a>
          <a href="javascript:emojiinsert('1F38C.png', iconsize)"><div class="emojione-1F38C"></div></a>
          <a href="javascript:emojiinsert('1F3EE.png', iconsize)"><div class="emojione-1F3EE"></div></a>
          <a href="javascript:emojiinsert('1F48D.png', iconsize)"><div class="emojione-1F48D"></div></a>
          <a href="javascript:emojiinsert('2764.png', iconsize)"><div class="emojione-2764"></div></a>
          <a href="javascript:emojiinsert('1F494.png', iconsize)"><div class="emojione-1F494"></div></a>
          <a href="javascript:emojiinsert('1F48C.png', iconsize)"><div class="emojione-1F48C"></div></a>
          <a href="javascript:emojiinsert('1F495.png', iconsize)"><div class="emojione-1F495"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F49E.png', iconsize)"><div class="emojione-1F49E"></div></a>
          <a href="javascript:emojiinsert('1F493.png', iconsize)"><div class="emojione-1F493"></div></a>
          <a href="javascript:emojiinsert('1F497.png', iconsize)"><div class="emojione-1F497"></div></a>
          <a href="javascript:emojiinsert('1F496.png', iconsize)"><div class="emojione-1F496"></div></a>
          <a href="javascript:emojiinsert('1F498.png', iconsize)"><div class="emojione-1F498"></div></a>
          <a href="javascript:emojiinsert('1F49D.png', iconsize)"><div class="emojione-1F49D"></div></a>
          <a href="javascript:emojiinsert('1F49F.png', iconsize)"><div class="emojione-1F49F"></div></a>
          <a href="javascript:emojiinsert('1F49C.png', iconsize)"><div class="emojione-1F49C"></div></a>
          <a href="javascript:emojiinsert('1F49B.png', iconsize)"><div class="emojione-1F49B"></div></a>
          <a href="javascript:emojiinsert('1F49A.png', iconsize)"><div class="emojione-1F49A"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F499.png', iconsize)"><div class="emojione-1F499"></div></a>
      </div>

	</p>
  </section>

  <section id="content5">

    <p>
      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F3C3.png')"><div class="emojione-1F3C3"></div></a>
          <a href="javascript:emojiinsert('1F6B6.png')"><div class="emojione-1F6B6"></div></a>
          <a href="javascript:emojiinsert('1F483.png')"><div class="emojione-1F483"></div></a>
          <a href="javascript:emojiinsert('1F3CB.png')"><div class="emojione-1F3CB"></div></a>
          <a href="javascript:emojiinsert('1F3CC.png')"><div class="emojione-1F3CC"></div></a>
          <a href="javascript:emojiinsert('1F6A3.png')"><div class="emojione-1F6A3"></div></a>
          <a href="javascript:emojiinsert('1F3CA.png')"><div class="emojione-1F3CA"></div></a>
          <a href="javascript:emojiinsert('1F3C4.png')"><div class="emojione-1F3C4"></div></a>
          <a href="javascript:emojiinsert('1F6C0.png')"><div class="emojione-1F6C0"></div></a>
          <a href="javascript:emojiinsert('1F3C2.png')"><div class="emojione-1F3C2"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F3BF.png')"><div class="emojione-1F3BF"></div></a>
          <a href="javascript:emojiinsert('26C4.png')"><div class="emojione-26C4"></div></a>
          <a href="javascript:emojiinsert('1F6B4.png')"><div class="emojione-1F6B4"></div></a>
          <a href="javascript:emojiinsert('1F6B5.png')"><div class="emojione-1F6B5"></div></a>
          <a href="javascript:emojiinsert('1F3CD.png')"><div class="emojione-1F3CD"></div></a>
          <a href="javascript:emojiinsert('1F3CE.png')"><div class="emojione-1F3CE"></div></a>
          <a href="javascript:emojiinsert('1F3C7.png')"><div class="emojione-1F3C7"></div></a>
          <a href="javascript:emojiinsert('26FA.png')"><div class="emojione-26FA"></div></a>
          <a href="javascript:emojiinsert('1F3A3.png')"><div class="emojione-1F3A3"></div></a>
          <a href="javascript:emojiinsert('26BD.png')"><div class="emojione-26BD"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F3C0.png')"><div class="emojione-1F3C0"></div></a>
          <a href="javascript:emojiinsert('1F3C8.png')"><div class="emojione-1F3C8"></div></a>
          <a href="javascript:emojiinsert('26BE.png')"><div class="emojione-26BE"></div></a>
          <a href="javascript:emojiinsert('1F3BE.png')"><div class="emojione-1F3BE"></div></a>
          <a href="javascript:emojiinsert('1F3C9.png')"><div class="emojione-1F3C9"></div></a>
          <a href="javascript:emojiinsert('26F3.png')"><div class="emojione-26F3"></div></a>
          <a href="javascript:emojiinsert('1F3C6.png')"><div class="emojione-1F3C6"></div></a>
          <a href="javascript:emojiinsert('1F3C5.png')"><div class="emojione-1F3C5"></div></a>
          <a href="javascript:emojiinsert('1F3BD.png')"><div class="emojione-1F3BD"></div></a>
          <a href="javascript:emojiinsert('1F3C1.png')"><div class="emojione-1F3C1"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F3B9.png')"><div class="emojione-1F3B9"></div></a>
          <a href="javascript:emojiinsert('1F3B8.png')"><div class="emojione-1F3B8"></div></a>
          <a href="javascript:emojiinsert('1F3BB.png')"><div class="emojione-1F3BB"></div></a>
          <a href="javascript:emojiinsert('1F3B7.png')"><div class="emojione-1F3B7"></div></a>
          <a href="javascript:emojiinsert('1F3BA.png')"><div class="emojione-1F3BA"></div></a>
          <a href="javascript:emojiinsert('1F3B5.png')"><div class="emojione-1F3B5"></div></a>
          <a href="javascript:emojiinsert('1F3B6.png')"><div class="emojione-1F3B6"></div></a>
          <a href="javascript:emojiinsert('1F3BC.png')"><div class="emojione-1F3BC"></div></a>
          <a href="javascript:emojiinsert('1F3A7.png')"><div class="emojione-1F3A7"></div></a>
          <a href="javascript:emojiinsert('1F3A4.png')"><div class="emojione-1F3A4"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F3AD.png')"><div class="emojione-1F3AD"></div></a>
          <a href="javascript:emojiinsert('1F3AB.png')"><div class="emojione-1F3AB"></div></a>
          <a href="javascript:emojiinsert('1F3A9.png')"><div class="emojione-1F3A9"></div></a>
          <a href="javascript:emojiinsert('1F3AA.png')"><div class="emojione-1F3AA"></div></a>
          <a href="javascript:emojiinsert('1F3AC.png')"><div class="emojione-1F3AC"></div></a>
          <a href="javascript:emojiinsert('1F39E.png')"><div class="emojione-1F39E"></div></a>
          <a href="javascript:emojiinsert('1F39F.png')"><div class="emojione-1F39F"></div></a>
          <a href="javascript:emojiinsert('1F3A8.png')"><div class="emojione-1F3A8"></div></a>
          <a href="javascript:emojiinsert('1F3AF.png')"><div class="emojione-1F3AF"></div></a>
          <a href="javascript:emojiinsert('1F3B1.png')"><div class="emojione-1F3B1"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F3B3.png')"><div class="emojione-1F3B3"></div></a>
          <a href="javascript:emojiinsert('1F3B0.png')"><div class="emojione-1F3B0"></div></a>
          <a href="javascript:emojiinsert('1F3B2.png')"><div class="emojione-1F3B2"></div></a>
          <a href="javascript:emojiinsert('1F3AE.png')"><div class="emojione-1F3AE"></div></a>
          <a href="javascript:emojiinsert('1F3B4.png')"><div class="emojione-1F3B4"></div></a>
          <a href="javascript:emojiinsert('1F0CF.png')"><div class="emojione-1F0CF"></div></a>
          <a href="javascript:emojiinsert('1F004.png')"><div class="emojione-1F004"></div></a>
          <a href="javascript:emojiinsert('1F3A0.png')"><div class="emojione-1F3A0"></div></a>
          <a href="javascript:emojiinsert('1F3A1.png')"><div class="emojione-1F3A1"></div></a>
          <a href="javascript:emojiinsert('1F3A2.png')"><div class="emojione-1F3A2"></div></a>
      </div>

    </p>
  </section>

  <section id="content6">

      <p>
      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F683.png')"><div class="emojione-1F683"></div></a>
          <a href="javascript:emojiinsert('1F69E.png')"><div class="emojione-1F69E"></div></a>
          <a href="javascript:emojiinsert('1F682.png')"><div class="emojione-1F682"></div></a>
          <a href="javascript:emojiinsert('1F68B.png')"><div class="emojione-1F68B"></div></a>
          <a href="javascript:emojiinsert('1F69D.png')"><div class="emojione-1F69D"></div></a>
          <a href="javascript:emojiinsert('1F684.png')"><div class="emojione-1F684"></div></a>
          <a href="javascript:emojiinsert('1F685.png')"><div class="emojione-1F685"></div></a>
          <a href="javascript:emojiinsert('1F686.png')"><div class="emojione-1F686"></div></a>
          <a href="javascript:emojiinsert('1F687.png')"><div class="emojione-1F687"></div></a>
          <a href="javascript:emojiinsert('1F688.png')"><div class="emojione-1F688"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F689.png')"><div class="emojione-1F689"></div></a>
          <a href="javascript:emojiinsert('1F68A.png')"><div class="emojione-1F68A"></div></a>
          <a href="javascript:emojiinsert('1F6E4.png')"><div class="emojione-1F6E4"></div></a>
          <a href="javascript:emojiinsert('1F68C.png')"><div class="emojione-1F68C"></div></a>
          <a href="javascript:emojiinsert('1F68D.png')"><div class="emojione-1F68D"></div></a>
          <a href="javascript:emojiinsert('1F68E.png')"><div class="emojione-1F68E"></div></a>
          <a href="javascript:emojiinsert('1F690.png')"><div class="emojione-1F690"></div></a>
          <a href="javascript:emojiinsert('1F691.png')"><div class="emojione-1F691"></div></a>
          <a href="javascript:emojiinsert('1F692.png')"><div class="emojione-1F692"></div></a>
          <a href="javascript:emojiinsert('1F693.png')"><div class="emojione-1F693"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F694.png')"><div class="emojione-1F694"></div></a>
          <a href="javascript:emojiinsert('1F6A8.png')"><div class="emojione-1F6A8"></div></a>
          <a href="javascript:emojiinsert('1F695.png')"><div class="emojione-1F695"></div></a>
          <a href="javascript:emojiinsert('1F696.png')"><div class="emojione-1F696"></div></a>
          <a href="javascript:emojiinsert('1F697.png')"><div class="emojione-1F697"></div></a>
          <a href="javascript:emojiinsert('1F698.png')"><div class="emojione-1F698"></div></a>
          <a href="javascript:emojiinsert('1F699.png')"><div class="emojione-1F699"></div></a>
          <a href="javascript:emojiinsert('1F69A.png')"><div class="emojione-1F69A"></div></a>
          <a href="javascript:emojiinsert('1F69B.png')"><div class="emojione-1F69B"></div></a>
          <a href="javascript:emojiinsert('1F69C.png')"><div class="emojione-1F69C"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F6B2.png')"><div class="emojione-1F6B2"></div></a>
          <a href="javascript:emojiinsert('1F6E3.png')"><div class="emojione-1F6E3"></div></a>
          <a href="javascript:emojiinsert('1F68F.png')"><div class="emojione-1F68F"></div></a>
          <a href="javascript:emojiinsert('26FD.png')"><div class="emojione-26FD"></div></a>
          <a href="javascript:emojiinsert('1F6A7.png')"><div class="emojione-1F6A7"></div></a>
          <a href="javascript:emojiinsert('1F6A6.png')"><div class="emojione-1F6A6"></div></a>
          <a href="javascript:emojiinsert('1F6A5.png')"><div class="emojione-1F6A5"></div></a>
          <a href="javascript:emojiinsert('1F680.png')"><div class="emojione-1F680"></div></a>
          <a href="javascript:emojiinsert('1F681.png')"><div class="emojione-1F681"></div></a>
          <a href="javascript:emojiinsert('2708.png')"><div class="emojione-2708"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F6E9.png')"><div class="emojione-1F6E9"></div></a>
          <a href="javascript:emojiinsert('1F6EB.png')"><div class="emojione-1F6EB"></div></a>
          <a href="javascript:emojiinsert('1F6EC.png')"><div class="emojione-1F6EC"></div></a>
          <a href="javascript:emojiinsert('1F4BA.png')"><div class="emojione-1F4BA"></div></a>
          <a href="javascript:emojiinsert('2693.png')"><div class="emojione-2693"></div></a>
          <a href="javascript:emojiinsert('1F6A2.png')"><div class="emojione-1F6A2"></div></a>
          <a href="javascript:emojiinsert('1F6F3.png')"><div class="emojione-1F6F3"></div></a>
          <a href="javascript:emojiinsert('1F6E5.png')"><div class="emojione-1F6E5"></div></a>
          <a href="javascript:emojiinsert('1F6A4.png')"><div class="emojione-1F6A4"></div></a>
          <a href="javascript:emojiinsert('26F5.png')"><div class="emojione-26F5"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F6A1.png')"><div class="emojione-1F6A1"></div></a>
          <a href="javascript:emojiinsert('1F6A0.png')"><div class="emojione-1F6A0"></div></a>
          <a href="javascript:emojiinsert('1F69F.png')"><div class="emojione-1F69F"></div></a>
          <a href="javascript:emojiinsert('1F6C2.png')"><div class="emojione-1F6C2"></div></a>
          <a href="javascript:emojiinsert('1F6C3.png')"><div class="emojione-1F6C3"></div></a>
          <a href="javascript:emojiinsert('1F6C4.png')"><div class="emojione-1F6C4"></div></a>
          <a href="javascript:emojiinsert('1F6C5.png')"><div class="emojione-1F6C5"></div></a>
          <a href="javascript:emojiinsert('1F4B4.png')"><div class="emojione-1F4B4"></div></a>
          <a href="javascript:emojiinsert('1F4B6.png')"><div class="emojione-1F4B6"></div></a>
          <a href="javascript:emojiinsert('1F4B7.png')"><div class="emojione-1F4B7"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4B5.png')"><div class="emojione-1F4B5"></div></a>
          <a href="javascript:emojiinsert('1F6CE.png')"><div class="emojione-1F6CE"></div></a>
          <a href="javascript:emojiinsert('1F6CF.png')"><div class="emojione-1F6CF"></div></a>
          <a href="javascript:emojiinsert('1F6CB.png')"><div class="emojione-1F6CB"></div></a>
          <a href="javascript:emojiinsert('1F37D.png')"><div class="emojione-1F37D"></div></a>
          <a href="javascript:emojiinsert('1F6CD.png')"><div class="emojione-1F6CD"></div></a>
          <a href="javascript:emojiinsert('1F5FD.png')"><div class="emojione-1F5FD"></div></a>
          <a href="javascript:emojiinsert('1F5FF.png')"><div class="emojione-1F5FF"></div></a>
          <a href="javascript:emojiinsert('1F301.png')"><div class="emojione-1F301"></div></a>
          <a href="javascript:emojiinsert('1F5FC.png')"><div class="emojione-1F5FC"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('26F2.png')"><div class="emojione-26F2"></div></a>
          <a href="javascript:emojiinsert('1F3F0.png')"><div class="emojione-1F3F0"></div></a>
          <a href="javascript:emojiinsert('1F3EF.png')"><div class="emojione-1F3EF"></div></a>
          <a href="javascript:emojiinsert('1F3DB.png')"><div class="emojione-1F3DB"></div></a>
          <a href="javascript:emojiinsert('1F3DF.png')"><div class="emojione-1F3DF"></div></a>
          <a href="javascript:emojiinsert('1F3D4.png')"><div class="emojione-1F3D4"></div></a>
          <a href="javascript:emojiinsert('1F3D5.png')"><div class="emojione-1F3D5"></div></a>
          <a href="javascript:emojiinsert('1F3D6.png')"><div class="emojione-1F3D6"></div></a>
          <a href="javascript:emojiinsert('1F3DC.png')"><div class="emojione-1F3DC"></div></a>
          <a href="javascript:emojiinsert('1F3DD.png')"><div class="emojione-1F3DD"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F3DE.png')"><div class="emojione-1F3DE"></div></a>
          <a href="javascript:emojiinsert('1F3D9.png')"><div class="emojione-1F3D9"></div></a>
          <a href="javascript:emojiinsert('1F307.png')"><div class="emojione-1F307"></div></a>
          <a href="javascript:emojiinsert('1F306.png')"><div class="emojione-1F306"></div></a>
          <a href="javascript:emojiinsert('1F303.png')"><div class="emojione-1F303"></div></a>
          <a href="javascript:emojiinsert('1F309.png')"><div class="emojione-1F309"></div></a>
          <a href="javascript:emojiinsert('1F3E0.png')"><div class="emojione-1F3E0"></div></a>
          <a href="javascript:emojiinsert('1F3D8.png')"><div class="emojione-1F3D8"></div></a>
          <a href="javascript:emojiinsert('1F3E1.png')"><div class="emojione-1F3E1"></div></a>
          <a href="javascript:emojiinsert('1F3DA.png')"><div class="emojione-1F3DA"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F3D7.png')"><div class="emojione-1F3D7"></div></a>
          <a href="javascript:emojiinsert('1F3E2.png')"><div class="emojione-1F3E2"></div></a>
          <a href="javascript:emojiinsert('1F3EC.png')"><div class="emojione-1F3EC"></div></a>
          <a href="javascript:emojiinsert('1F3ED.png')"><div class="emojione-1F3ED"></div></a>
          <a href="javascript:emojiinsert('1F3E3.png')"><div class="emojione-1F3E3"></div></a>
          <a href="javascript:emojiinsert('1F3E4.png')"><div class="emojione-1F3E4"></div></a>
          <a href="javascript:emojiinsert('1F3E5.png')"><div class="emojione-1F3E5"></div></a>
          <a href="javascript:emojiinsert('1F3E6.png')"><div class="emojione-1F3E6"></div></a>
          <a href="javascript:emojiinsert('1F3E8.png')"><div class="emojione-1F3E8"></div></a>
          <a href="javascript:emojiinsert('1F3E9.png')"><div class="emojione-1F3E9"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F492.png')"><div class="emojione-1F492"></div></a>
          <a href="javascript:emojiinsert('26EA.png')"><div class="emojione-26EA"></div></a>
          <a href="javascript:emojiinsert('1F3EA.png')"><div class="emojione-1F3EA"></div></a>
          <a href="javascript:emojiinsert('1F3EB.png')"><div class="emojione-1F3EB"></div></a>
          <a href="javascript:emojiinsert('1F5FA.png')"><div class="emojione-1F5FA"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1FA.png')"><div class="emojione-1F1E6-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1F9.png')"><div class="emojione-1F1E6-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1EA.png')"><div class="emojione-1F1E7-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1F7.png')"><div class="emojione-1F1E7-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1E6.png')"><div class="emojione-1F1E8-1F1E6"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1E8-1F1F1.png')"><div class="emojione-1F1E8-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1F3.png')"><div class="emojione-1F1E8-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1F4.png')"><div class="emojione-1F1E8-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1E9-1F1F0.png')"><div class="emojione-1F1E9-1F1F0"></div></a>
          <a href="javascript:emojiinsert('1F1EB-1F1EE.png')"><div class="emojione-1F1EB-1F1EE"></div></a>
          <a href="javascript:emojiinsert('1F1EB-1F1F7.png')"><div class="emojione-1F1EB-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1E9-1F1EA.png')"><div class="emojione-1F1E9-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1ED-1F1F0.png')"><div class="emojione-1F1ED-1F1F0"></div></a>
          <a href="javascript:emojiinsert('1F1EE-1F1F3.png')"><div class="emojione-1F1EE-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1EE-1F1E9.png')"><div class="emojione-1F1EE-1F1E9"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1EE-1F1EA.png')"><div class="emojione-1F1EE-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1EE-1F1F1.png')"><div class="emojione-1F1EE-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1EE-1F1F9.png')"><div class="emojione-1F1EE-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1EF-1F1F5.png')"><div class="emojione-1F1EF-1F1F5"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1F7.png')"><div class="emojione-1F1F0-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1F4.png')"><div class="emojione-1F1F2-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1FE.png')"><div class="emojione-1F1F2-1F1FE"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1FD.png')"><div class="emojione-1F1F2-1F1FD"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1F1.png')"><div class="emojione-1F1F3-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1FF.png')"><div class="emojione-1F1F3-1F1FF"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F3-1F1F4.png')"><div class="emojione-1F1F3-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1ED.png')"><div class="emojione-1F1F5-1F1ED"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1F1.png')"><div class="emojione-1F1F5-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1F9.png')"><div class="emojione-1F1F5-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1F7.png')"><div class="emojione-1F1F5-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1F7-1F1FA.png')"><div class="emojione-1F1F7-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1E6.png')"><div class="emojione-1F1F8-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1EC.png')"><div class="emojione-1F1F8-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1FF-1F1E6.png')"><div class="emojione-1F1FF-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1EA-1F1F8.png')"><div class="emojione-1F1EA-1F1F8"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F8-1F1EA.png')"><div class="emojione-1F1F8-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1ED.png')"><div class="emojione-1F1E8-1F1ED"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1F7.png')"><div class="emojione-1F1F9-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1E7.png')"><div class="emojione-1F1EC-1F1E7"></div></a>
          <a href="javascript:emojiinsert('1F1FA-1F1F8.png')"><div class="emojione-1F1FA-1F1F8"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1EA.png')"><div class="emojione-1F1E6-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1FB-1F1F3.png')"><div class="emojione-1F1FB-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1EB.png')"><div class="emojione-1F1E6-1F1EB"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1F1.png')"><div class="emojione-1F1E6-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1E9-1F1FF.png')"><div class="emojione-1F1E9-1F1FF"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1E6-1F1E9.png')"><div class="emojione-1F1E6-1F1E9"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1F4.png')"><div class="emojione-1F1E6-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1EE.png')"><div class="emojione-1F1E6-1F1EE"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1EC.png')"><div class="emojione-1F1E6-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1F7.png')"><div class="emojione-1F1E6-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1F2.png')"><div class="emojione-1F1E6-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1FC.png')"><div class="emojione-1F1E6-1F1FC"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1E8.png')"><div class="emojione-1F1E6-1F1E8"></div></a>
          <a href="javascript:emojiinsert('1F1E6-1F1FF.png')"><div class="emojione-1F1E6-1F1FF"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1F8.png')"><div class="emojione-1F1E7-1F1F8"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1E7-1F1ED.png')"><div class="emojione-1F1E7-1F1ED"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1E9.png')"><div class="emojione-1F1E7-1F1E9"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1E7.png')"><div class="emojione-1F1E7-1F1E7"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1FE.png')"><div class="emojione-1F1E7-1F1FE"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1FF.png')"><div class="emojione-1F1E7-1F1FF"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1EF.png')"><div class="emojione-1F1E7-1F1EF"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1F2.png')"><div class="emojione-1F1E7-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1F9.png')"><div class="emojione-1F1E7-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1F4.png')"><div class="emojione-1F1E7-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1E6.png')"><div class="emojione-1F1E7-1F1E6"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1E7-1F1FC.png')"><div class="emojione-1F1E7-1F1FC"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1F3.png')"><div class="emojione-1F1E7-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1EC.png')"><div class="emojione-1F1E7-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1EB.png')"><div class="emojione-1F1E7-1F1EB"></div></a>
          <a href="javascript:emojiinsert('1F1E7-1F1EE.png')"><div class="emojione-1F1E7-1F1EE"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1ED.png')"><div class="emojione-1F1F0-1F1ED"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1F2.png')"><div class="emojione-1F1E8-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1FB.png')"><div class="emojione-1F1E8-1F1FB"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1FE.png')"><div class="emojione-1F1F0-1F1FE"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1EB.png')"><div class="emojione-1F1E8-1F1EB"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F0-1F1F2.png')"><div class="emojione-1F1F0-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1E9.png')"><div class="emojione-1F1E8-1F1E9"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1EC.png')"><div class="emojione-1F1E8-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1E9.png')"><div class="emojione-1F1F9-1F1E9"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1F7.png')"><div class="emojione-1F1E8-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1EE.png')"><div class="emojione-1F1E8-1F1EE"></div></a>
          <a href="javascript:emojiinsert('1F1ED-1F1F7.png')"><div class="emojione-1F1ED-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1FA.png')"><div class="emojione-1F1E8-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1FE.png')"><div class="emojione-1F1E8-1F1FE"></div></a>
          <a href="javascript:emojiinsert('1F1E8-1F1FF.png')"><div class="emojione-1F1E8-1F1FF"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1E9-1F1EF.png')"><div class="emojione-1F1E9-1F1EF"></div></a>
          <a href="javascript:emojiinsert('1F1E9-1F1F2.png')"><div class="emojione-1F1E9-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1E9-1F1F4.png')"><div class="emojione-1F1E9-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1F1.png')"><div class="emojione-1F1F9-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1EA-1F1E8.png')"><div class="emojione-1F1EA-1F1E8"></div></a>
          <a href="javascript:emojiinsert('1F1EA-1F1EC.png')"><div class="emojione-1F1EA-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1FB.png')"><div class="emojione-1F1F8-1F1FB"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1F6.png')"><div class="emojione-1F1EC-1F1F6"></div></a>
          <a href="javascript:emojiinsert('1F1EA-1F1F7.png')"><div class="emojione-1F1EA-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1EA-1F1EA.png')"><div class="emojione-1F1EA-1F1EA"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1EA-1F1F9.png')"><div class="emojione-1F1EA-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1EB-1F1F0.png')"><div class="emojione-1F1EB-1F1F0"></div></a>
          <a href="javascript:emojiinsert('1F1EB-1F1F4.png')"><div class="emojione-1F1EB-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1EB-1F1EF.png')"><div class="emojione-1F1EB-1F1EF"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1EB.png')"><div class="emojione-1F1F5-1F1EB"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1E6.png')"><div class="emojione-1F1EC-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1F2.png')"><div class="emojione-1F1EC-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1EA.png')"><div class="emojione-1F1EC-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1ED.png')"><div class="emojione-1F1EC-1F1ED"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1EE.png')"><div class="emojione-1F1EC-1F1EE"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1EC-1F1F7.png')"><div class="emojione-1F1EC-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1F1.png')"><div class="emojione-1F1EC-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1E9.png')"><div class="emojione-1F1EC-1F1E9"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1FA.png')"><div class="emojione-1F1EC-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1F9.png')"><div class="emojione-1F1EC-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1F3.png')"><div class="emojione-1F1EC-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1FC.png')"><div class="emojione-1F1EC-1F1FC"></div></a>
          <a href="javascript:emojiinsert('1F1EC-1F1FE.png')"><div class="emojione-1F1EC-1F1FE"></div></a>
          <a href="javascript:emojiinsert('1F1ED-1F1F9.png')"><div class="emojione-1F1ED-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1ED-1F1F3.png')"><div class="emojione-1F1ED-1F1F3"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1ED-1F1FA.png')"><div class="emojione-1F1ED-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1EE-1F1F8.png')"><div class="emojione-1F1EE-1F1F8"></div></a>
          <a href="javascript:emojiinsert('1F1EE-1F1F7.png')"><div class="emojione-1F1EE-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1EE-1F1F6.png')"><div class="emojione-1F1EE-1F1F6"></div></a>
          <a href="javascript:emojiinsert('1F1EF-1F1F2.png')"><div class="emojione-1F1EF-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1EF-1F1EA.png')"><div class="emojione-1F1EF-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1EF-1F1F4.png')"><div class="emojione-1F1EF-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1FF.png')"><div class="emojione-1F1F0-1F1FF"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1EA.png')"><div class="emojione-1F1F0-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1EE.png')"><div class="emojione-1F1F0-1F1EE"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1FD-1F1F0.png')"><div class="emojione-1F1FD-1F1F0"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1FC.png')"><div class="emojione-1F1F0-1F1FC"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1EC.png')"><div class="emojione-1F1F0-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1E6.png')"><div class="emojione-1F1F1-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1FB.png')"><div class="emojione-1F1F1-1F1FB"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1E7.png')"><div class="emojione-1F1F1-1F1E7"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1F8.png')"><div class="emojione-1F1F1-1F1F8"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1F7.png')"><div class="emojione-1F1F1-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1FE.png')"><div class="emojione-1F1F1-1F1FE"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1EE.png')"><div class="emojione-1F1F1-1F1EE"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F1-1F1F9.png')"><div class="emojione-1F1F1-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1FA.png')"><div class="emojione-1F1F1-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1F0.png')"><div class="emojione-1F1F2-1F1F0"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1EC.png')"><div class="emojione-1F1F2-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1FC.png')"><div class="emojione-1F1F2-1F1FC"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1FB.png')"><div class="emojione-1F1F2-1F1FB"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1F1.png')"><div class="emojione-1F1F2-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1F9.png')"><div class="emojione-1F1F2-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1ED.png')"><div class="emojione-1F1F2-1F1ED"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1F7.png')"><div class="emojione-1F1F2-1F1F7"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F2-1F1FA.png')"><div class="emojione-1F1F2-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1EB-1F1F2.png')"><div class="emojione-1F1EB-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1E9.png')"><div class="emojione-1F1F2-1F1E9"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1E8.png')"><div class="emojione-1F1F2-1F1E8"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1F3.png')"><div class="emojione-1F1F2-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1EA.png')"><div class="emojione-1F1F2-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1F8.png')"><div class="emojione-1F1F2-1F1F8"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1E6.png')"><div class="emojione-1F1F2-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1FF.png')"><div class="emojione-1F1F2-1F1FF"></div></a>
          <a href="javascript:emojiinsert('1F1F2-1F1F2.png')"><div class="emojione-1F1F2-1F1F2"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F3-1F1E6.png')"><div class="emojione-1F1F3-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1F7.png')"><div class="emojione-1F1F3-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1F5.png')"><div class="emojione-1F1F3-1F1F5"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1E8.png')"><div class="emojione-1F1F3-1F1E8"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1EE.png')"><div class="emojione-1F1F3-1F1EE"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1EA.png')"><div class="emojione-1F1F3-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1EC.png')"><div class="emojione-1F1F3-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1F3-1F1FA.png')"><div class="emojione-1F1F3-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1F5.png')"><div class="emojione-1F1F0-1F1F5"></div></a>
          <a href="javascript:emojiinsert('1F1F4-1F1F2.png')"><div class="emojione-1F1F4-1F1F2"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F5-1F1F0.png')"><div class="emojione-1F1F5-1F1F0"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1FC.png')"><div class="emojione-1F1F5-1F1FC"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1F8.png')"><div class="emojione-1F1F5-1F1F8"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1E6.png')"><div class="emojione-1F1F5-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1EC.png')"><div class="emojione-1F1F5-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1FE.png')"><div class="emojione-1F1F5-1F1FE"></div></a>
          <a href="javascript:emojiinsert('1F1F5-1F1EA.png')"><div class="emojione-1F1F5-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1F6-1F1E6.png')"><div class="emojione-1F1F6-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1F7-1F1F4.png')"><div class="emojione-1F1F7-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1F7-1F1FC.png')"><div class="emojione-1F1F7-1F1FC"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F8-1F1ED.png')"><div class="emojione-1F1F8-1F1ED"></div></a>
          <a href="javascript:emojiinsert('1F1F0-1F1F3.png')"><div class="emojione-1F1F0-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1E8.png')"><div class="emojione-1F1F1-1F1E8"></div></a>
          <a href="javascript:emojiinsert('1F1FB-1F1E8.png')"><div class="emojione-1F1FB-1F1E8"></div></a>
          <a href="javascript:emojiinsert('1F1FC-1F1F8.png')"><div class="emojione-1F1FC-1F1F8"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1F2.png')"><div class="emojione-1F1F8-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1F9.png')"><div class="emojione-1F1F8-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1F3.png')"><div class="emojione-1F1F8-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1F7-1F1F8.png')"><div class="emojione-1F1F7-1F1F8"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1E8.png')"><div class="emojione-1F1F8-1F1E8"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F8-1F1F1.png')"><div class="emojione-1F1F8-1F1F1"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1F0.png')"><div class="emojione-1F1F8-1F1F0"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1EE.png')"><div class="emojione-1F1F8-1F1EE"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1E7.png')"><div class="emojione-1F1F8-1F1E7"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1F4.png')"><div class="emojione-1F1F8-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1F1-1F1F0.png')"><div class="emojione-1F1F1-1F1F0"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1E9.png')"><div class="emojione-1F1F8-1F1E9"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1F7.png')"><div class="emojione-1F1F8-1F1F7"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1FF.png')"><div class="emojione-1F1F8-1F1FF"></div></a>
          <a href="javascript:emojiinsert('1F1F8-1F1FE.png')"><div class="emojione-1F1F8-1F1FE"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1F9-1F1FC.png')"><div class="emojione-1F1F9-1F1FC"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1EF.png')"><div class="emojione-1F1F9-1F1EF"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1FF.png')"><div class="emojione-1F1F9-1F1FF"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1ED.png')"><div class="emojione-1F1F9-1F1ED"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1EC.png')"><div class="emojione-1F1F9-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1F4.png')"><div class="emojione-1F1F9-1F1F4"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1F9.png')"><div class="emojione-1F1F9-1F1F9"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1F3.png')"><div class="emojione-1F1F9-1F1F3"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1F2.png')"><div class="emojione-1F1F9-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1F9-1F1FB.png')"><div class="emojione-1F1F9-1F1FB"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1FB-1F1EE.png')"><div class="emojione-1F1FB-1F1EE"></div></a>
          <a href="javascript:emojiinsert('1F1FA-1F1EC.png')"><div class="emojione-1F1FA-1F1EC"></div></a>
          <a href="javascript:emojiinsert('1F1FA-1F1E6.png')"><div class="emojione-1F1FA-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1FA-1F1FE.png')"><div class="emojione-1F1FA-1F1FE"></div></a>
          <a href="javascript:emojiinsert('1F1FA-1F1FF.png')"><div class="emojione-1F1FA-1F1FF"></div></a>
          <a href="javascript:emojiinsert('1F1FB-1F1FA.png')"><div class="emojione-1F1FB-1F1FA"></div></a>
          <a href="javascript:emojiinsert('1F1FB-1F1E6.png')"><div class="emojione-1F1FB-1F1E6"></div></a>
          <a href="javascript:emojiinsert('1F1FB-1F1EA.png')"><div class="emojione-1F1FB-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1FC-1F1EB.png')"><div class="emojione-1F1FC-1F1EB"></div></a>
          <a href="javascript:emojiinsert('1F1EA-1F1ED.png')"><div class="emojione-1F1EA-1F1ED"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F1FE-1F1EA.png')"><div class="emojione-1F1FE-1F1EA"></div></a>
          <a href="javascript:emojiinsert('1F1FF-1F1F2.png')"><div class="emojione-1F1FF-1F1F2"></div></a>
          <a href="javascript:emojiinsert('1F1FF-1F1FC.png')"><div class="emojione-1F1FF-1F1FC"></div></a>
      </div>
      </p>
  </section>

  <section id="content7">

      <p>
      <div class="emoji-grid">
          <a href="javascript:emojiinsert('231A.png', iconsize)"><div class="emojione-231A"></div></a>
          <a href="javascript:emojiinsert('1F4F1.png', iconsize)"><div class="emojione-1F4F1"></div></a>
          <a href="javascript:emojiinsert('1F4F2.png', iconsize)"><div class="emojione-1F4F2"></div></a>
          <a href="javascript:emojiinsert('1F4BB.png', iconsize)"><div class="emojione-1F4BB"></div></a>
          <a href="javascript:emojiinsert('1F5A5.png', iconsize)"><div class="emojione-1F5A5"></div></a>
          <a href="javascript:emojiinsert('1F5AE.png', iconsize)"><div class="emojione-1F5AE"></div></a>
          <a href="javascript:emojiinsert('1F5B2.png', iconsize)"><div class="emojione-1F5B2"></div></a>
          <a href="javascript:emojiinsert('1F5A8.png', iconsize)"><div class="emojione-1F5A8"></div></a>
          <a href="javascript:emojiinsert('23F0.png', iconsize)"><div class="emojione-23F0"></div></a>
          <a href="javascript:emojiinsert('1F570.png', iconsize)"><div class="emojione-1F570"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('23F3.png', iconsize)"><div class="emojione-23F3"></div></a>
          <a href="javascript:emojiinsert('231B.png', iconsize)"><div class="emojione-231B"></div></a>
          <a href="javascript:emojiinsert('1F4F7.png', iconsize)"><div class="emojione-1F4F7"></div></a>
          <a href="javascript:emojiinsert('1F4F8.png', iconsize)"><div class="emojione-1F4F8"></div></a>
          <a href="javascript:emojiinsert('1F4F9.png', iconsize)"><div class="emojione-1F4F9"></div></a>
          <a href="javascript:emojiinsert('1F3A5.png', iconsize)"><div class="emojione-1F3A5"></div></a>
          <a href="javascript:emojiinsert('1F4FD.png', iconsize)"><div class="emojione-1F4FD"></div></a>
          <a href="javascript:emojiinsert('1F4FA.png', iconsize)"><div class="emojione-1F4FA"></div></a>
          <a href="javascript:emojiinsert('1F399.png', iconsize)"><div class="emojione-1F399"></div></a>
          <a href="javascript:emojiinsert('1F39A.png', iconsize)"><div class="emojione-1F39A"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F39B.png', iconsize)"><div class="emojione-1F39B"></div></a>
          <a href="javascript:emojiinsert('1F4FB.png', iconsize)"><div class="emojione-1F4FB"></div></a>
          <a href="javascript:emojiinsert('1F4DF.png', iconsize)"><div class="emojione-1F4DF"></div></a>
          <a href="javascript:emojiinsert('1F579.png', iconsize)"><div class="emojione-1F579"></div></a>
          <a href="javascript:emojiinsert('1F4DE.png', iconsize)"><div class="emojione-1F4DE"></div></a>
          <a href="javascript:emojiinsert('260E.png', iconsize)"><div class="emojione-260E"></div></a>
          <a href="javascript:emojiinsert('1F4E0.png', iconsize)"><div class="emojione-1F4E0"></div></a>
          <a href="javascript:emojiinsert('1F4BD.png', iconsize)"><div class="emojione-1F4BD"></div></a>
          <a href="javascript:emojiinsert('1F4BE.png', iconsize)"><div class="emojione-1F4BE"></div></a>
          <a href="javascript:emojiinsert('1F4BF.png', iconsize)"><div class="emojione-1F4BF"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4C0.png', iconsize)"><div class="emojione-1F4C0"></div></a>
          <a href="javascript:emojiinsert('1F4FC.png', iconsize)"><div class="emojione-1F4FC"></div></a>
          <a href="javascript:emojiinsert('1F50B.png', iconsize)"><div class="emojione-1F50B"></div></a>
          <a href="javascript:emojiinsert('1F50C.png', iconsize)"><div class="emojione-1F50C"></div></a>
          <a href="javascript:emojiinsert('1F4A1.png', iconsize)"><div class="emojione-1F4A1"></div></a>
          <a href="javascript:emojiinsert('1F526.png', iconsize)"><div class="emojione-1F526"></div></a>
          <a href="javascript:emojiinsert('1F56F.png', iconsize)"><div class="emojione-1F56F"></div></a>
          <a href="javascript:emojiinsert('1F4E1.png', iconsize)"><div class="emojione-1F4E1"></div></a>
          <a href="javascript:emojiinsert('1F6F0.png', iconsize)"><div class="emojione-1F6F0"></div></a>
          <a href="javascript:emojiinsert('1F4B3.png', iconsize)"><div class="emojione-1F4B3"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4B8.png', iconsize)"><div class="emojione-1F4B8"></div></a>
          <a href="javascript:emojiinsert('1F4B0.png', iconsize)"><div class="emojione-1F4B0"></div></a>
          <a href="javascript:emojiinsert('1F48E.png', iconsize)"><div class="emojione-1F48E"></div></a>
          <a href="javascript:emojiinsert('1F302.png', iconsize)"><div class="emojione-1F302"></div></a>
          <a href="javascript:emojiinsert('1F45D.png', iconsize)"><div class="emojione-1F45D"></div></a>
          <a href="javascript:emojiinsert('1F45B.png', iconsize)"><div class="emojione-1F45B"></div></a>
          <a href="javascript:emojiinsert('1F45C.png', iconsize)"><div class="emojione-1F45C"></div></a>
          <a href="javascript:emojiinsert('1F4BC.png', iconsize)"><div class="emojione-1F4BC"></div></a>
          <a href="javascript:emojiinsert('1F392.png', iconsize)"><div class="emojione-1F392"></div></a>
          <a href="javascript:emojiinsert('1F484.png', iconsize)"><div class="emojione-1F484"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F453.png', iconsize)"><div class="emojione-1F453"></div></a>
          <a href="javascript:emojiinsert('1F576.png', iconsize)"><div class="emojione-1F576"></div></a>
          <a href="javascript:emojiinsert('1F452.png', iconsize)"><div class="emojione-1F452"></div></a>
          <a href="javascript:emojiinsert('1F461.png', iconsize)"><div class="emojione-1F461"></div></a>
          <a href="javascript:emojiinsert('1F460.png', iconsize)"><div class="emojione-1F460"></div></a>
          <a href="javascript:emojiinsert('1F462.png', iconsize)"><div class="emojione-1F462"></div></a>
          <a href="javascript:emojiinsert('1F45E.png', iconsize)"><div class="emojione-1F45E"></div></a>
          <a href="javascript:emojiinsert('1F45F.png', iconsize)"><div class="emojione-1F45F"></div></a>
          <a href="javascript:emojiinsert('1F459.png', iconsize)"><div class="emojione-1F459"></div></a>
          <a href="javascript:emojiinsert('1F457.png', iconsize)"><div class="emojione-1F457"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F458.png', iconsize)"><div class="emojione-1F458"></div></a>
          <a href="javascript:emojiinsert('1F45A.png', iconsize)"><div class="emojione-1F45A"></div></a>
          <a href="javascript:emojiinsert('1F455.png', iconsize)"><div class="emojione-1F455"></div></a>
          <a href="javascript:emojiinsert('1F454.png', iconsize)"><div class="emojione-1F454"></div></a>
          <a href="javascript:emojiinsert('1F456.png', iconsize)"><div class="emojione-1F456"></div></a>
          <a href="javascript:emojiinsert('1F6AA.png', iconsize)"><div class="emojione-1F6AA"></div></a>
          <a href="javascript:emojiinsert('1F6BF.png', iconsize)"><div class="emojione-1F6BF"></div></a>
          <a href="javascript:emojiinsert('1F6C1.png', iconsize)"><div class="emojione-1F6C1"></div></a>
          <a href="javascript:emojiinsert('1F6BD.png', iconsize)"><div class="emojione-1F6BD"></div></a>
          <a href="javascript:emojiinsert('1F488.png', iconsize)"><div class="emojione-1F488"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F489.png', iconsize)"><div class="emojione-1F489"></div></a>
          <a href="javascript:emojiinsert('1F48A.png', iconsize)"><div class="emojione-1F48A"></div></a>
          <a href="javascript:emojiinsert('1F52C.png', iconsize)"><div class="emojione-1F52C"></div></a>
          <a href="javascript:emojiinsert('1F52D.png', iconsize)"><div class="emojione-1F52D"></div></a>
          <a href="javascript:emojiinsert('1F52E.png', iconsize)"><div class="emojione-1F52E"></div></a>
          <a href="javascript:emojiinsert('1F527.png', iconsize)"><div class="emojione-1F527"></div></a>
          <a href="javascript:emojiinsert('1F52A.png', iconsize)"><div class="emojione-1F52A"></div></a>
          <a href="javascript:emojiinsert('1F5E1.png', iconsize)"><div class="emojione-1F5E1"></div></a>
          <a href="javascript:emojiinsert('1F529.png', iconsize)"><div class="emojione-1F529"></div></a>
          <a href="javascript:emojiinsert('1F528.png', iconsize)"><div class="emojione-1F528"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F6E0.png', iconsize)"><div class="emojione-1F6E0"></div></a>
          <a href="javascript:emojiinsert('1F6E2.png', iconsize)"><div class="emojione-1F6E2"></div></a>
          <a href="javascript:emojiinsert('1F4A3.png', iconsize)"><div class="emojione-1F4A3"></div></a>
          <a href="javascript:emojiinsert('1F6AC.png', iconsize)"><div class="emojione-1F6AC"></div></a>
          <a href="javascript:emojiinsert('1F52B.png', iconsize)"><div class="emojione-1F52B"></div></a>
          <a href="javascript:emojiinsert('1F516.png', iconsize)"><div class="emojione-1F516"></div></a>
          <a href="javascript:emojiinsert('1F4F0.png', iconsize)"><div class="emojione-1F4F0"></div></a>
          <a href="javascript:emojiinsert('1F5DE.png', iconsize)"><div class="emojione-1F5DE"></div></a>
          <a href="javascript:emojiinsert('1F321.png', iconsize)"><div class="emojione-1F321"></div></a>
          <a href="javascript:emojiinsert('1F3F7.png', iconsize)"><div class="emojione-1F3F7"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F511.png', iconsize)"><div class="emojione-1F511"></div></a>
          <a href="javascript:emojiinsert('1F5DD.png', iconsize)"><div class="emojione-1F5DD"></div></a>
          <a href="javascript:emojiinsert('2709.png', iconsize)"><div class="emojione-2709"></div></a>
          <a href="javascript:emojiinsert('1F4E9.png', iconsize)"><div class="emojione-1F4E9"></div></a>
          <a href="javascript:emojiinsert('1F4E8.png', iconsize)"><div class="emojione-1F4E8"></div></a>
          <a href="javascript:emojiinsert('1F4E7.png', iconsize)"><div class="emojione-1F4E7"></div></a>
          <a href="javascript:emojiinsert('1F4E5.png', iconsize)"><div class="emojione-1F4E5"></div></a>
          <a href="javascript:emojiinsert('1F4E4.png', iconsize)"><div class="emojione-1F4E4"></div></a>
          <a href="javascript:emojiinsert('1F4E6.png', iconsize)"><div class="emojione-1F4E6"></div></a>
          <a href="javascript:emojiinsert('1F4EF.png', iconsize)"><div class="emojione-1F4EF"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4EE.png', iconsize)"><div class="emojione-1F4EE"></div></a>
          <a href="javascript:emojiinsert('1F4EA.png', iconsize)"><div class="emojione-1F4EA"></div></a>
          <a href="javascript:emojiinsert('1F4EB.png', iconsize)"><div class="emojione-1F4EB"></div></a>
          <a href="javascript:emojiinsert('1F4ED.png', iconsize)"><div class="emojione-1F4ED"></div></a>
          <a href="javascript:emojiinsert('1F4EC.png', iconsize)"><div class="emojione-1F4EC"></div></a>
          <a href="javascript:emojiinsert('1F4C4.png', iconsize)"><div class="emojione-1F4C4"></div></a>
          <a href="javascript:emojiinsert('1F4C3.png', iconsize)"><div class="emojione-1F4C3"></div></a>
          <a href="javascript:emojiinsert('1F4D1.png', iconsize)"><div class="emojione-1F4D1"></div></a>
          <a href="javascript:emojiinsert('1F5D1.png', iconsize)"><div class="emojione-1F5D1"></div></a>
          <a href="javascript:emojiinsert('1F5D2.png', iconsize)"><div class="emojione-1F5D2"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4C8.png', iconsize)"><div class="emojione-1F4C8"></div></a>
          <a href="javascript:emojiinsert('1F4C9.png', iconsize)"><div class="emojione-1F4C9"></div></a>
          <a href="javascript:emojiinsert('1F4CA.png', iconsize)"><div class="emojione-1F4CA"></div></a>
          <a href="javascript:emojiinsert('1F4C5.png', iconsize)"><div class="emojione-1F4C5"></div></a>
          <a href="javascript:emojiinsert('1F4C6.png', iconsize)"><div class="emojione-1F4C6"></div></a>
          <a href="javascript:emojiinsert('1F5D3.png', iconsize)"><div class="emojione-1F5D3"></div></a>
          <a href="javascript:emojiinsert('1F5F3.png', iconsize)"><div class="emojione-1F5F3"></div></a>
          <a href="javascript:emojiinsert('1F505.png', iconsize)"><div class="emojione-1F505"></div></a>
          <a href="javascript:emojiinsert('1F506.png', iconsize)"><div class="emojione-1F506"></div></a>
          <a href="javascript:emojiinsert('1F5DC.png', iconsize)"><div class="emojione-1F5DC"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F5BC.png', iconsize)"><div class="emojione-1F5BC"></div></a>
          <a href="javascript:emojiinsert('1F4DC.png', iconsize)"><div class="emojione-1F4DC"></div></a>
          <a href="javascript:emojiinsert('1F4CB.png', iconsize)"><div class="emojione-1F4CB"></div></a>
          <a href="javascript:emojiinsert('1F4D6.png', iconsize)"><div class="emojione-1F4D6"></div></a>
          <a href="javascript:emojiinsert('1F4D3.png', iconsize)"><div class="emojione-1F4D3"></div></a>
          <a href="javascript:emojiinsert('1F4D4.png', iconsize)"><div class="emojione-1F4D4"></div></a>
          <a href="javascript:emojiinsert('1F4D2.png', iconsize)"><div class="emojione-1F4D2"></div></a>
          <a href="javascript:emojiinsert('1F4D5.png', iconsize)"><div class="emojione-1F4D5"></div></a>
          <a href="javascript:emojiinsert('1F4D7.png', iconsize)"><div class="emojione-1F4D7"></div></a>
          <a href="javascript:emojiinsert('1F4D8.png', iconsize)"><div class="emojione-1F4D8"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4D9.png', iconsize)"><div class="emojione-1F4D9"></div></a>
          <a href="javascript:emojiinsert('1F4DA.png', iconsize)"><div class="emojione-1F4DA"></div></a>
          <a href="javascript:emojiinsert('1F4C7.png', iconsize)"><div class="emojione-1F4C7"></div></a>
          <a href="javascript:emojiinsert('1F5C2.png', iconsize)"><div class="emojione-1F5C2"></div></a>
          <a href="javascript:emojiinsert('1F5C3.png', iconsize)"><div class="emojione-1F5C3"></div></a>
          <a href="javascript:emojiinsert('1F517.png', iconsize)"><div class="emojione-1F517"></div></a>
          <a href="javascript:emojiinsert('1F4CE.png', iconsize)"><div class="emojione-1F4CE"></div></a>
          <a href="javascript:emojiinsert('1F587.png', iconsize)"><div class="emojione-1F587"></div></a>
          <a href="javascript:emojiinsert('1F4CC.png', iconsize)"><div class="emojione-1F4CC"></div></a>
          <a href="javascript:emojiinsert('2702.png', iconsize)"><div class="emojione-2702"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4D0.png', iconsize)"><div class="emojione-1F4D0"></div></a>
          <a href="javascript:emojiinsert('1F4CD.png', iconsize)"><div class="emojione-1F4CD"></div></a>
          <a href="javascript:emojiinsert('1F4CF.png', iconsize)"><div class="emojione-1F4CF"></div></a>
          <a href="javascript:emojiinsert('1F6A9.png', iconsize)"><div class="emojione-1F6A9"></div></a>
          <a href="javascript:emojiinsert('1F3F3.png', iconsize)"><div class="emojione-1F3F3"></div></a>
          <a href="javascript:emojiinsert('1F3F4.png', iconsize)"><div class="emojione-1F3F4"></div></a>
          <a href="javascript:emojiinsert('1F573.png', iconsize)"><div class="emojione-1F573"></div></a>
          <a href="javascript:emojiinsert('1F4C1.png', iconsize)"><div class="emojione-1F4C1"></div></a>
          <a href="javascript:emojiinsert('1F4C2.png', iconsize)"><div class="emojione-1F4C2"></div></a>
          <a href="javascript:emojiinsert('1F5C4.png', iconsize)"><div class="emojione-1F5C4"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('2712.png', iconsize)"><div class="emojione-2712"></div></a>
          <a href="javascript:emojiinsert('270F.png', iconsize)"><div class="emojione-270F"></div></a>
          <a href="javascript:emojiinsert('1F58A.png', iconsize)"><div class="emojione-1F58A"></div></a>
          <a href="javascript:emojiinsert('1F58B.png', iconsize)"><div class="emojione-1F58B"></div></a>
          <a href="javascript:emojiinsert('1F58C.png', iconsize)"><div class="emojione-1F58C"></div></a>
          <a href="javascript:emojiinsert('1F58D.png', iconsize)"><div class="emojione-1F58D"></div></a>
          <a href="javascript:emojiinsert('1F4DD.png', iconsize)"><div class="emojione-1F4DD"></div></a>
          <a href="javascript:emojiinsert('1F50F.png', iconsize)"><div class="emojione-1F50F"></div></a>
          <a href="javascript:emojiinsert('1F510.png', iconsize)"><div class="emojione-1F510"></div></a>
          <a href="javascript:emojiinsert('1F512.png', iconsize)"><div class="emojione-1F512"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F513.png', iconsize)"><div class="emojione-1F513"></div></a>
          <a href="javascript:emojiinsert('1F4E3.png', iconsize)"><div class="emojione-1F4E3"></div></a>
          <a href="javascript:emojiinsert('1F4E2.png', iconsize)"><div class="emojione-1F4E2"></div></a>
          <a href="javascript:emojiinsert('1F508.png', iconsize)"><div class="emojione-1F508"></div></a>
          <a href="javascript:emojiinsert('1F509.png', iconsize)"><div class="emojione-1F509"></div></a>
          <a href="javascript:emojiinsert('1F50A.png', iconsize)"><div class="emojione-1F50A"></div></a>
          <a href="javascript:emojiinsert('1F507.png', iconsize)"><div class="emojione-1F507"></div></a>
          <a href="javascript:emojiinsert('1F4A4.png', iconsize)"><div class="emojione-1F4A4"></div></a>
          <a href="javascript:emojiinsert('1F514.png', iconsize)"><div class="emojione-1F514"></div></a>
          <a href="javascript:emojiinsert('1F515.png', iconsize)"><div class="emojione-1F515"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F547.png', iconsize)"><div class="emojione-1F547"></div></a>
          <a href="javascript:emojiinsert('1F549.png', iconsize)"><div class="emojione-1F549"></div></a>
          <a href="javascript:emojiinsert('1F54A.png', iconsize)"><div class="emojione-1F54A"></div></a>
          <a href="javascript:emojiinsert('1F4AD.png', iconsize)"><div class="emojione-1F4AD"></div></a>
          <a href="javascript:emojiinsert('1F4AC.png', iconsize)"><div class="emojione-1F4AC"></div></a>
          <a href="javascript:emojiinsert('1F5EF.png', iconsize)"><div class="emojione-1F5EF"></div></a>
          <a href="javascript:emojiinsert('1F6B8.png', iconsize)"><div class="emojione-1F6B8"></div></a>
          <a href="javascript:emojiinsert('1F6E1.png', iconsize)"><div class="emojione-1F6E1"></div></a>
          <a href="javascript:emojiinsert('1F50D.png', iconsize)"><div class="emojione-1F50D"></div></a>
          <a href="javascript:emojiinsert('1F50E.png', iconsize)"><div class="emojione-1F50E"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F5E3.png', iconsize)"><div class="emojione-1F5E3"></div></a>
          <a href="javascript:emojiinsert('1F6CC.png', iconsize)"><div class="emojione-1F6CC"></div></a>
          <a href="javascript:emojiinsert('1F6AB.png', iconsize)"><div class="emojione-1F6AB"></div></a>
          <a href="javascript:emojiinsert('26D4.png', iconsize)"><div class="emojione-26D4"></div></a>
          <a href="javascript:emojiinsert('1F4DB.png', iconsize)"><div class="emojione-1F4DB"></div></a>
          <a href="javascript:emojiinsert('1F6B7.png', iconsize)"><div class="emojione-1F6B7"></div></a>
          <a href="javascript:emojiinsert('1F6AF.png', iconsize)"><div class="emojione-1F6AF"></div></a>
          <a href="javascript:emojiinsert('1F6B3.png', iconsize)"><div class="emojione-1F6B3"></div></a>
          <a href="javascript:emojiinsert('1F6B1.png', iconsize)"><div class="emojione-1F6B1"></div></a>
          <a href="javascript:emojiinsert('1F4F5.png', iconsize)"><div class="emojione-1F4F5"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F51E.png', iconsize)"><div class="emojione-1F51E"></div></a>
          <a href="javascript:emojiinsert('1F251.png', iconsize)"><div class="emojione-1F251"></div></a>
          <a href="javascript:emojiinsert('1F250.png', iconsize)"><div class="emojione-1F250"></div></a>
          <a href="javascript:emojiinsert('1F4AE.png', iconsize)"><div class="emojione-1F4AE"></div></a>
          <a href="javascript:emojiinsert('3299.png', iconsize)"><div class="emojione-3299"></div></a>
          <a href="javascript:emojiinsert('3297.png', iconsize)"><div class="emojione-3297"></div></a>
          <a href="javascript:emojiinsert('1F234.png', iconsize)"><div class="emojione-1F234"></div></a>
          <a href="javascript:emojiinsert('1F235.png', iconsize)"><div class="emojione-1F235"></div></a>
          <a href="javascript:emojiinsert('1F232.png', iconsize)"><div class="emojione-1F232"></div></a>
          <a href="javascript:emojiinsert('1F236.png', iconsize)"><div class="emojione-1F236"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F21A.png', iconsize)"><div class="emojione-1F21A"></div></a>
          <a href="javascript:emojiinsert('1F238.png', iconsize)"><div class="emojione-1F238"></div></a>
          <a href="javascript:emojiinsert('1F23A.png', iconsize)"><div class="emojione-1F23A"></div></a>
          <a href="javascript:emojiinsert('1F237.png', iconsize)"><div class="emojione-1F237"></div></a>
          <a href="javascript:emojiinsert('1F239.png', iconsize)"><div class="emojione-1F239"></div></a>
          <a href="javascript:emojiinsert('1F233.png', iconsize)"><div class="emojione-1F233"></div></a>
          <a href="javascript:emojiinsert('1F202.png', iconsize)"><div class="emojione-1F202"></div></a>
          <a href="javascript:emojiinsert('1F201.png', iconsize)"><div class="emojione-1F201"></div></a>
          <a href="javascript:emojiinsert('1F22F.png', iconsize)"><div class="emojione-1F22F"></div></a>
          <a href="javascript:emojiinsert('1F4B9.png', iconsize)"><div class="emojione-1F4B9"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('2747.png', iconsize)"><div class="emojione-2747"></div></a>
          <a href="javascript:emojiinsert('2733.png', iconsize)"><div class="emojione-2733"></div></a>
          <a href="javascript:emojiinsert('274E.png', iconsize)"><div class="emojione-274E"></div></a>
          <a href="javascript:emojiinsert('2705.png', iconsize)"><div class="emojione-2705"></div></a>
          <a href="javascript:emojiinsert('2734.png', iconsize)"><div class="emojione-2734"></div></a>
          <a href="javascript:emojiinsert('1F4F3.png', iconsize)"><div class="emojione-1F4F3"></div></a>
          <a href="javascript:emojiinsert('1F4F4.png', iconsize)"><div class="emojione-1F4F4"></div></a>
          <a href="javascript:emojiinsert('1F19A.png', iconsize)"><div class="emojione-1F19A"></div></a>
          <a href="javascript:emojiinsert('1F170.png', iconsize)"><div class="emojione-1F170"></div></a>
          <a href="javascript:emojiinsert('1F171.png', iconsize)"><div class="emojione-1F171"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F18E.png', iconsize)"><div class="emojione-1F18E"></div></a>
          <a href="javascript:emojiinsert('1F191.png', iconsize)"><div class="emojione-1F191"></div></a>
          <a href="javascript:emojiinsert('1F17E.png', iconsize)"><div class="emojione-1F17E"></div></a>
          <a href="javascript:emojiinsert('1F198.png', iconsize)"><div class="emojione-1F198"></div></a>
          <a href="javascript:emojiinsert('1F194.png', iconsize)"><div class="emojione-1F194"></div></a>
          <a href="javascript:emojiinsert('1F17F.png', iconsize)"><div class="emojione-1F17F"></div></a>
          <a href="javascript:emojiinsert('1F6BE.png', iconsize)"><div class="emojione-1F6BE"></div></a>
          <a href="javascript:emojiinsert('1F192.png', iconsize)"><div class="emojione-1F192"></div></a>
          <a href="javascript:emojiinsert('1F193.png', iconsize)"><div class="emojione-1F193"></div></a>
          <a href="javascript:emojiinsert('1F195.png', iconsize)"><div class="emojione-1F195"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F196.png', iconsize)"><div class="emojione-1F196"></div></a>
          <a href="javascript:emojiinsert('1F197.png', iconsize)"><div class="emojione-1F197"></div></a>
          <a href="javascript:emojiinsert('1F199.png', iconsize)"><div class="emojione-1F199"></div></a>
          <a href="javascript:emojiinsert('1F3E7.png', iconsize)"><div class="emojione-1F3E7"></div></a>
          <a href="javascript:emojiinsert('2648.png', iconsize)"><div class="emojione-2648"></div></a>
          <a href="javascript:emojiinsert('2649.png', iconsize)"><div class="emojione-2649"></div></a>
          <a href="javascript:emojiinsert('264A.png', iconsize)"><div class="emojione-264A"></div></a>
          <a href="javascript:emojiinsert('264B.png', iconsize)"><div class="emojione-264B"></div></a>
          <a href="javascript:emojiinsert('264C.png', iconsize)"><div class="emojione-264C"></div></a>
          <a href="javascript:emojiinsert('264D.png', iconsize)"><div class="emojione-264D"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('264E.png', iconsize)"><div class="emojione-264E"></div></a>
          <a href="javascript:emojiinsert('264F.png', iconsize)"><div class="emojione-264F"></div></a>
          <a href="javascript:emojiinsert('2650.png', iconsize)"><div class="emojione-2650"></div></a>
          <a href="javascript:emojiinsert('2651.png', iconsize)"><div class="emojione-2651"></div></a>
          <a href="javascript:emojiinsert('2652.png', iconsize)"><div class="emojione-2652"></div></a>
          <a href="javascript:emojiinsert('2653.png', iconsize)"><div class="emojione-2653"></div></a>
          <a href="javascript:emojiinsert('1F6BB.png', iconsize)"><div class="emojione-1F6BB"></div></a>
          <a href="javascript:emojiinsert('1F6B9.png', iconsize)"><div class="emojione-1F6B9"></div></a>
          <a href="javascript:emojiinsert('1F6BA.png', iconsize)"><div class="emojione-1F6BA"></div></a>
          <a href="javascript:emojiinsert('1F6BC.png', iconsize)"><div class="emojione-1F6BC"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('267F.png', iconsize)"><div class="emojione-267F"></div></a>
          <a href="javascript:emojiinsert('1F6B0.png', iconsize)"><div class="emojione-1F6B0"></div></a>
          <a href="javascript:emojiinsert('1F6AD.png', iconsize)"><div class="emojione-1F6AD"></div></a>
          <a href="javascript:emojiinsert('1F6AE.png', iconsize)"><div class="emojione-1F6AE"></div></a>
          <a href="javascript:emojiinsert('25B6.png', iconsize)"><div class="emojione-25B6"></div></a>
          <a href="javascript:emojiinsert('25C0.png', iconsize)"><div class="emojione-25C0"></div></a>
          <a href="javascript:emojiinsert('1F53C.png', iconsize)"><div class="emojione-1F53C"></div></a>
          <a href="javascript:emojiinsert('1F53D.png', iconsize)"><div class="emojione-1F53D"></div></a>
          <a href="javascript:emojiinsert('23E9.png', iconsize)"><div class="emojione-23E9"></div></a>
          <a href="javascript:emojiinsert('23EA.png', iconsize)"><div class="emojione-23EA"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('23EB.png', iconsize)"><div class="emojione-23EB"></div></a>
          <a href="javascript:emojiinsert('23EC.png', iconsize)"><div class="emojione-23EC"></div></a>
          <a href="javascript:emojiinsert('27A1.png', iconsize)"><div class="emojione-27A1"></div></a>
          <a href="javascript:emojiinsert('2B05.png', iconsize)"><div class="emojione-2B05"></div></a>
          <a href="javascript:emojiinsert('2B06.png', iconsize)"><div class="emojione-2B06"></div></a>
          <a href="javascript:emojiinsert('2B07.png', iconsize)"><div class="emojione-2B07"></div></a>
          <a href="javascript:emojiinsert('2197.png', iconsize)"><div class="emojione-2197"></div></a>
          <a href="javascript:emojiinsert('2198.png', iconsize)"><div class="emojione-2198"></div></a>
          <a href="javascript:emojiinsert('2199.png', iconsize)"><div class="emojione-2199"></div></a>
          <a href="javascript:emojiinsert('2196.png', iconsize)"><div class="emojione-2196"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('2195.png', iconsize)"><div class="emojione-2195"></div></a>
          <a href="javascript:emojiinsert('2194.png', iconsize)"><div class="emojione-2194"></div></a>
          <a href="javascript:emojiinsert('1F504.png', iconsize)"><div class="emojione-1F504"></div></a>
          <a href="javascript:emojiinsert('21AA.png', iconsize)"><div class="emojione-21AA"></div></a>
          <a href="javascript:emojiinsert('21A9.png', iconsize)"><div class="emojione-21A9"></div></a>
          <a href="javascript:emojiinsert('2934.png', iconsize)"><div class="emojione-2934"></div></a>
          <a href="javascript:emojiinsert('2935.png', iconsize)"><div class="emojione-2935"></div></a>
          <a href="javascript:emojiinsert('1F500.png', iconsize)"><div class="emojione-1F500"></div></a>
          <a href="javascript:emojiinsert('1F501.png', iconsize)"><div class="emojione-1F501"></div></a>
          <a href="javascript:emojiinsert('1F502.png', iconsize)"><div class="emojione-1F502"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('0023-20E3.png', iconsize)"><div class="emojione-0023-20E3"></div></a>
          <a href="javascript:emojiinsert('0030-20E3.png', iconsize)"><div class="emojione-0030-20E3"></div></a>
          <a href="javascript:emojiinsert('0031-20E3.png', iconsize)"><div class="emojione-0031-20E3"></div></a>
          <a href="javascript:emojiinsert('0032-20E3.png', iconsize)"><div class="emojione-0032-20E3"></div></a>
          <a href="javascript:emojiinsert('0033-20E3.png', iconsize)"><div class="emojione-0033-20E3"></div></a>
          <a href="javascript:emojiinsert('0034-20E3.png', iconsize)"><div class="emojione-0034-20E3"></div></a>
          <a href="javascript:emojiinsert('0035-20E3.png', iconsize)"><div class="emojione-0035-20E3"></div></a>
          <a href="javascript:emojiinsert('0036-20E3.png', iconsize)"><div class="emojione-0036-20E3"></div></a>
          <a href="javascript:emojiinsert('0037-20E3.png', iconsize)"><div class="emojione-0037-20E3"></div></a>
          <a href="javascript:emojiinsert('0038-20E3.png', iconsize)"><div class="emojione-0038-20E3"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('0039-20E3.png', iconsize)"><div class="emojione-0039-20E3"></div></a>
          <a href="javascript:emojiinsert('1F51F.png', iconsize)"><div class="emojione-1F51F"></div></a>
          <a href="javascript:emojiinsert('1F522.png', iconsize)"><div class="emojione-1F522"></div></a>
          <a href="javascript:emojiinsert('1F524.png', iconsize)"><div class="emojione-1F524"></div></a>
          <a href="javascript:emojiinsert('1F521.png', iconsize)"><div class="emojione-1F521"></div></a>
          <a href="javascript:emojiinsert('1F520.png', iconsize)"><div class="emojione-1F520"></div></a>
          <a href="javascript:emojiinsert('2139.png', iconsize)"><div class="emojione-2139"></div></a>
          <a href="javascript:emojiinsert('1F4F6.png', iconsize)"><div class="emojione-1F4F6"></div></a>
          <a href="javascript:emojiinsert('1F3A6.png', iconsize)"><div class="emojione-1F3A6"></div></a>
          <a href="javascript:emojiinsert('1F523.png', iconsize)"><div class="emojione-1F523"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('2795.png', iconsize)"><div class="emojione-2795"></div></a>
          <a href="javascript:emojiinsert('2796.png', iconsize)"><div class="emojione-2796"></div></a>
          <a href="javascript:emojiinsert('3030.png', iconsize)"><div class="emojione-3030"></div></a>
          <a href="javascript:emojiinsert('2797.png', iconsize)"><div class="emojione-2797"></div></a>
          <a href="javascript:emojiinsert('2716.png', iconsize)"><div class="emojione-2716"></div></a>
          <a href="javascript:emojiinsert('2714.png', iconsize)"><div class="emojione-2714"></div></a>
          <a href="javascript:emojiinsert('1F503.png', iconsize)"><div class="emojione-1F503"></div></a>
          <a href="javascript:emojiinsert('2122.png', iconsize)"><div class="emojione-2122"></div></a>
          <a href="javascript:emojiinsert('00A9.png', iconsize)"><div class="emojione-00A9"></div></a>
          <a href="javascript:emojiinsert('00AE.png', iconsize)"><div class="emojione-00AE"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4B1.png', iconsize)"><div class="emojione-1F4B1"></div></a>
          <a href="javascript:emojiinsert('1F4B2.png', iconsize)"><div class="emojione-1F4B2"></div></a>
          <a href="javascript:emojiinsert('27B0.png', iconsize)"><div class="emojione-27B0"></div></a>
          <a href="javascript:emojiinsert('27BF.png', iconsize)"><div class="emojione-27BF"></div></a>
          <a href="javascript:emojiinsert('303D.png', iconsize)"><div class="emojione-303D"></div></a>
          <a href="javascript:emojiinsert('2757.png', iconsize)"><div class="emojione-2757"></div></a>
          <a href="javascript:emojiinsert('2753.png', iconsize)"><div class="emojione-2753"></div></a>
          <a href="javascript:emojiinsert('2755.png', iconsize)"><div class="emojione-2755"></div></a>
          <a href="javascript:emojiinsert('2754.png', iconsize)"><div class="emojione-2754"></div></a>
          <a href="javascript:emojiinsert('203C.png', iconsize)"><div class="emojione-203C"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('2049.png', iconsize)"><div class="emojione-2049"></div></a>
          <a href="javascript:emojiinsert('274C.png', iconsize)"><div class="emojione-274C"></div></a>
          <a href="javascript:emojiinsert('2B55.png', iconsize)"><div class="emojione-2B55"></div></a>
          <a href="javascript:emojiinsert('1F4AF.png', iconsize)"><div class="emojione-1F4AF"></div></a>
          <a href="javascript:emojiinsert('1F51A.png', iconsize)"><div class="emojione-1F51A"></div></a>
          <a href="javascript:emojiinsert('1F519.png', iconsize)"><div class="emojione-1F519"></div></a>
          <a href="javascript:emojiinsert('1F51B.png', iconsize)"><div class="emojione-1F51B"></div></a>
          <a href="javascript:emojiinsert('1F51D.png', iconsize)"><div class="emojione-1F51D"></div></a>
          <a href="javascript:emojiinsert('1F51C.png', iconsize)"><div class="emojione-1F51C"></div></a>
          <a href="javascript:emojiinsert('1F300.png', iconsize)"><div class="emojione-1F300"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('24C2.png', iconsize)"><div class="emojione-24C2"></div></a>
          <a href="javascript:emojiinsert('26CE.png', iconsize)"><div class="emojione-26CE"></div></a>
          <a href="javascript:emojiinsert('1F52F.png', iconsize)"><div class="emojione-1F52F"></div></a>
          <a href="javascript:emojiinsert('1F530.png', iconsize)"><div class="emojione-1F530"></div></a>
          <a href="javascript:emojiinsert('1F531.png', iconsize)"><div class="emojione-1F531"></div></a>
          <a href="javascript:emojiinsert('26A0.png', iconsize)"><div class="emojione-26A0"></div></a>
          <a href="javascript:emojiinsert('2668.png', iconsize)"><div class="emojione-2668"></div></a>
          <a href="javascript:emojiinsert('1F3F5.png', iconsize)"><div class="emojione-1F3F5"></div></a>
          <a href="javascript:emojiinsert('267B.png', iconsize)"><div class="emojione-267B"></div></a>
          <a href="javascript:emojiinsert('1F4A2.png', iconsize)"><div class="emojione-1F4A2"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F4A0.png', iconsize)"><div class="emojione-1F4A0"></div></a>
          <a href="javascript:emojiinsert('2660.png', iconsize)"><div class="emojione-2660"></div></a>
          <a href="javascript:emojiinsert('2663.png', iconsize)"><div class="emojione-2663"></div></a>
          <a href="javascript:emojiinsert('2665.png', iconsize)"><div class="emojione-2665"></div></a>
          <a href="javascript:emojiinsert('2666.png', iconsize)"><div class="emojione-2666"></div></a>
          <a href="javascript:emojiinsert('2611.png', iconsize)"><div class="emojione-2611"></div></a>
          <a href="javascript:emojiinsert('26AA.png', iconsize)"><div class="emojione-26AA"></div></a>
          <a href="javascript:emojiinsert('26AB.png', iconsize)"><div class="emojione-26AB"></div></a>
          <a href="javascript:emojiinsert('1F518.png', iconsize)"><div class="emojione-1F518"></div></a>
          <a href="javascript:emojiinsert('1F534.png', iconsize)"><div class="emojione-1F534"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F535.png', iconsize)"><div class="emojione-1F535"></div></a>
          <a href="javascript:emojiinsert('1F53A.png', iconsize)"><div class="emojione-1F53A"></div></a>
          <a href="javascript:emojiinsert('1F53B.png', iconsize)"><div class="emojione-1F53B"></div></a>
          <a href="javascript:emojiinsert('1F538.png', iconsize)"><div class="emojione-1F538"></div></a>
          <a href="javascript:emojiinsert('1F539.png', iconsize)"><div class="emojione-1F539"></div></a>
          <a href="javascript:emojiinsert('1F536.png', iconsize)"><div class="emojione-1F536"></div></a>
          <a href="javascript:emojiinsert('1F537.png', iconsize)"><div class="emojione-1F537"></div></a>
          <a href="javascript:emojiinsert('25AA.png', iconsize)"><div class="emojione-25AA"></div></a>
          <a href="javascript:emojiinsert('25AB.png', iconsize)"><div class="emojione-25AB"></div></a>
          <a href="javascript:emojiinsert('2B1B.png', iconsize)"><div class="emojione-2B1B"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('2B1C.png', iconsize)"><div class="emojione-2B1C"></div></a>
          <a href="javascript:emojiinsert('25FC.png', iconsize)"><div class="emojione-25FC"></div></a>
          <a href="javascript:emojiinsert('25FB.png', iconsize)"><div class="emojione-25FB"></div></a>
          <a href="javascript:emojiinsert('25FE.png', iconsize)"><div class="emojione-25FE"></div></a>
          <a href="javascript:emojiinsert('25FD.png', iconsize)"><div class="emojione-25FD"></div></a>
          <a href="javascript:emojiinsert('1F532.png', iconsize)"><div class="emojione-1F532"></div></a>
          <a href="javascript:emojiinsert('1F533.png', iconsize)"><div class="emojione-1F533"></div></a>
          <a href="javascript:emojiinsert('1F550.png', iconsize)"><div class="emojione-1F550"></div></a>
          <a href="javascript:emojiinsert('1F551.png', iconsize)"><div class="emojione-1F551"></div></a>
          <a href="javascript:emojiinsert('1F552.png', iconsize)"><div class="emojione-1F552"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F553.png', iconsize)"><div class="emojione-1F553"></div></a>
          <a href="javascript:emojiinsert('1F554.png', iconsize)"><div class="emojione-1F554"></div></a>
          <a href="javascript:emojiinsert('1F555.png', iconsize)"><div class="emojione-1F555"></div></a>
          <a href="javascript:emojiinsert('1F556.png', iconsize)"><div class="emojione-1F556"></div></a>
          <a href="javascript:emojiinsert('1F557.png', iconsize)"><div class="emojione-1F557"></div></a>
          <a href="javascript:emojiinsert('1F558.png', iconsize)"><div class="emojione-1F558"></div></a>
          <a href="javascript:emojiinsert('1F559.png', iconsize)"><div class="emojione-1F559"></div></a>
          <a href="javascript:emojiinsert('1F55A.png', iconsize)"><div class="emojione-1F55A"></div></a>
          <a href="javascript:emojiinsert('1F55B.png', iconsize)"><div class="emojione-1F55B"></div></a>
          <a href="javascript:emojiinsert('1F55C.png', iconsize)"><div class="emojione-1F55C"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F55D.png', iconsize)"><div class="emojione-1F55D"></div></a>
          <a href="javascript:emojiinsert('1F55E.png', iconsize)"><div class="emojione-1F55E"></div></a>
          <a href="javascript:emojiinsert('1F55F.png', iconsize)"><div class="emojione-1F55F"></div></a>
          <a href="javascript:emojiinsert('1F560.png', iconsize)"><div class="emojione-1F560"></div></a>
          <a href="javascript:emojiinsert('1F561.png', iconsize)"><div class="emojione-1F561"></div></a>
          <a href="javascript:emojiinsert('1F562.png', iconsize)"><div class="emojione-1F562"></div></a>
          <a href="javascript:emojiinsert('1F563.png', iconsize)"><div class="emojione-1F563"></div></a>
          <a href="javascript:emojiinsert('1F564.png', iconsize)"><div class="emojione-1F564"></div></a>
          <a href="javascript:emojiinsert('1F565.png', iconsize)"><div class="emojione-1F565"></div></a>
          <a href="javascript:emojiinsert('1F566.png', iconsize)"><div class="emojione-1F566"></div></a>
      </div>

      <div class="emoji-grid">
          <a href="javascript:emojiinsert('1F567.png', iconsize)"><div class="emojione-1F567"></div></a>
      </div>
      </p>
      
  </section>

</form>
<div style="float: right; margin:5px 35px 0 0;">
    <input type="button" id="cancel" name="cancel" value="<?php _e("Cancel", 'wp_emoji_one'); ?>" onclick="tinyMCEPopup.close();" />
</div>

    <script type="text/javascript">
        //<![CDATA[
        var wpemojionedomain = "<?php echo plugin_dir_url( __FILE__ ); ?>";

        function saveSize() {
            var opt = document.getElementById("iconsize");
            var si = opt.selectedIndex;
            window.sessionStorage.setItem("emojiSize", si);
        }

        function saveCategory() {
            var category = document.getElementsByName("tabs");
            for (var x = 0; x < category.length; x++) {
                if (category[x].checked) {
                    var ci = x;
                }
            }
            window.sessionStorage.setItem("emojiCategory", ci);
        }

        var size = document.getElementById("iconsize");
        var category = document.getElementsByName("tabs");

        size.addEventListener("change", saveSize, false);
        for (var x = 0; x < category.length; x++)
            category[x].addEventListener("change", saveCategory, false);

        window.onload = function() {
            var sizeIndex = window.sessionStorage.getItem("emojiSize");
            var categoryIndex = window.sessionStorage.getItem("emojiCategory");
            if (sizeIndex) {
                var sizeSelect = document.getElementById("iconsize");
                size.selectedIndex = sizeIndex;
            }
            var tabIndex = "tab" + (parseInt(categoryIndex) + 1);
            if (categoryIndex) {
                var tab = document.getElementById(tabIndex);
                tab.checked = true;
            }
        };

        window.onunload = function () {
            size.removeEventListener("change", saveSize, false);
            for (var x = 0; x < category.length; x++)
                category[x].removeEventListener("change", saveCategory, false);
        };
        //]]>
    </script>

</body>
</html>
