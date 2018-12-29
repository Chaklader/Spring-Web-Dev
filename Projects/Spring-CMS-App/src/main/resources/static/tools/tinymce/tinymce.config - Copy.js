tinymce.init({
    selector: ".tinytextarea",
    menubar : true,
   // width: '70%',
    skin: "lightgray",
    theme: "modern",
    language : 'fa_IR',
    directionality : 'rtl',
    theme_advanced_font_sizes: "10px,12px,13px,14px,16px,18px,20px",
        font_size_style_values: "12px,13px,14px,16px,18px,20px",   
    
    theme_advanced_buttons3_add : "emotions",
    plugins: [
         "advlist autolink link image lists charmap print preview hr anchor ",
         "searchreplace wordcount visualblocks visualchars insertdatetime media nonbreaking code ",
         "table contextmenu directionality  emoticons paste textcolor  fullscreen autoresize wordcount "
   ],
    
    toolbar1: "undo redo | bold italic underline | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | print preview code sizeselect |styleselect  ",
    toolbar2: "| link unlink anchor | fullscreen | image media | youTube | forecolor backcolor | bold italic | fontselect |  fontsizeselect  | emoticons"
});


