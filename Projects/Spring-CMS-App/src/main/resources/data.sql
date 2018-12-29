/*INSERT IGNORE INTO user VALUES (1, '$2a$10$Z/ZmQPEtyWqrie0KGhfAM.h2.al2N0nks9Tz.tJYSbFTmhnrRm8b2', '', 'mohsenkw', 'mohsen.jahan01@gmail.com', 1);
*/
INSERT IGNORE INTO module VALUES 
(1, NULL, 'user', 1, 'user'), 
(2, NULL, 'category', 1, 'category'), 
(3, NULL, 'content', 1, 'content');

INSERT IGNORE INTO category VALUES 
(1, 1, 'Articles', 0, 'Articles', 3),
(2, 1, 'News', 0, 'News', 3);

INSERT IGNORE INTO menu VALUES 
(1, 1, NULL, NULL, 0, NULL, NULL, NULL, 1, 'mainmenu'),
(2, 0, NULL, '/', 1, 1, NULL, 'Home', 1, 'Home'),  
(3, 0, 'content_list_khabar', '/content/catList/1/Articles', 1, 1, 1, 'Articles', 1, 'Articles'),
(4, 0, 'content_list_khabar', '/content/catList/2/News', 1, 1, 2, 'News', 1, 'News'),
(5, 0, 'page', '/p-1/faq', 10, 1, 1, 'faq', 1, 'faq'),
(6, 0, 'page', '/p-2/Services', 11, 1, 2, 'services', 1, 'Services'),
(7, 0, 'page', '/p-3/privacy-policy', 13, 1, 3, 'privacy-policy', 1, 'Privacy Policy'),
(8, 0, 'page', '/p-4/about-us', 14, 1, 3, 'about-us', 1, 'About Us')
;


INSERT IGNORE INTO content VALUES 
(1, 'Lorem ipsum dolor sit amet, mel an tamquam intellegebat, eam at porro falli. Amet omnis et eos. Ius no porro velit definitiones, ea suas agam tincidunt mel. Reque nulla mei cu, duo ei dolorem habemus tacimates. At omnis dolorum copiosae nec, quot scripta no sed.',
 '2017-04-28 00:00:00', 'blog1.jpg', 'Lorem-Ipsum-common-examples', 1, 'Lorem Ipsum: common examples', 1),
 
(2, 'Lorem ipsum dolor sit amet, mel an tamquam intellegebat, eam at porro falli. Amet omnis et eos. Ius no porro velit definitiones, ea suas agam tincidunt mel. Reque nulla mei cu, duo ei dolorem habemus tacimates. At omnis dolorum copiosae nec, quot scripta no sed.',
 '2017-04-28 00:00:00', 'blog2.jpg', 'Lorem-Ipsum-translation', 1, 'Lorem Ipsum: translation', 1),
 
(3, 'Has illud fuisset menandri ad, te ludus suscipiantur vis, latine singulis vix in. Est meliore comprehensam ne, est luptatum constituam cu. Simul praesent vix te, qui te case iriure animal. Quodsi patrioque ad eam, duo in nusquam recteque omittantur. Quo dicunt salutatus ne, cum tation everti aperiam no.',
 '2017-04-28 00:00:00', 'blog1.jpg', 'Lorem-Ipsum-when-and-when-not-to-use-it', 1, 'Lorem Ipsum: when, and when not to use it', 2);


INSERT IGNORE INTO comment VALUES 
(1, 'claims of duty or the obligations of business it will frequently occur that pleasures have', '2017-04-28 00:00:00', 1, 'CONTENT', 1);


INSERT IGNORE INTO slideshow VALUES 
(1, 'homepage slider');

INSERT IGNORE INTO slideshowitem VALUES 
(1, NULL, 'g5hjemy0ed3bdkh7esec.jpg', 1, 'Powerful and Responsive Web Design', 1),
(2, NULL, 'bhg4v5k2u4dogsm8w72s.jpg', 2, 'Clean, Crisp, Powerful and Responsive Web Design', 1);

INSERT IGNORE INTO permission VALUES 
(1, 'admin_content_manage', 1, 'مدیریت مطالب'),
(2, 'admin_content_delete', 1, 'حذف مطالب'),
(3, 'admin_category_manage', 1, 'مدیریت دسته بندی');

INSERT IGNORE INTO role VALUES 
(1, 'super_admin', 1, 'super admin'),
(2, 'normal_user', 0, 'normal user');

INSERT IGNORE INTO user_role VALUES 
(1, 1);

INSERT IGNORE INTO role_permission VALUES 
(1, 1),
(1, 2),
(1, 3);

INSERT IGNORE INTO page VALUES 
(1, '<section id="faqs" class="container">
        <ul class="faq unstyled">
            <li>
                <span class="number">01</span>
                <div>
                    <h4>Lorem ipsum dolor sit amet, consectetuer adipiscing elit</h4>
                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
                </div>
            </li>
            <li>
                <span class="number">02</span>
                <div>
                    <h4>consectetuer ipsum dolor sit amet</h4>
                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra.</p>
                </div>
            </li>
            <li>
                <span class="number">03</span>
                <div>
                    <h4>adipiscing ipsum dolor sit amet, consectetuer</h4>
                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis.</p>
                </div>
            </li>
            <li>
                <span class="number">04</span>
                <div>
                    <h4>Lorem ipsum dolor sit amet, consectetuer adipiscing</h4>
                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
                </div>
            </li>
            <li>
                <span class="number">05</span>
                <div>
                    <h4>Lorem ipsum dolor sit amet, consectetuer adipiscing elit</h4>
                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
                </div>
            </li>
            <li>
                <span class="number">06</span>
                <div>
                    <h4>Lorem ipsum dolor sit amet, consectetuer adipiscing elit</h4>
                    <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
                </div>
            </li>
        </ul>
    </section><!--#faqs-->', 'faq', 'faq'),
(2, '<section id="services">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="center gap">
                        <h2>What we do</h2>
                        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                    </div>                
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-sm-6">
                    <div class="media">
                        <div class="pull-left">
                            <i class="icon-windows icon-md"></i>
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Windows Development</h3>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->
                <div class="col-md-4 col-sm-6">
                    <div class="media">
                        <div class="pull-left">
                            <i class="icon-android icon-md"></i>
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Android Development</h3>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->
                <div class="col-md-4 col-sm-6">
                    <div class="media">
                        <div class="pull-left">
                            <i class="icon-apple icon-md"></i>
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">iOS Development</h3>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->
            </div><!--/.row-->
            <div class="gap"></div>
            <div class="row">
                <div class="col-md-4 col-sm-6">
                    <div class="media">
                        <div class="pull-left">
                            <i class="icon-linux icon-md"></i>
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Linux Development</h3>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->
                <div class="col-md-4 col-sm-6">
                    <div class="media">
                        <div class="pull-left">
                            <i class="icon-dribbble icon-md"></i>
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">Graphic Design</h3>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->
                <div class="col-md-4 col-sm-6">
                    <div class="media">
                        <div class="pull-left">
                            <i class="icon-google-plus icon-md"></i>
                        </div>
                        <div class="media-body">
                            <h3 class="media-heading">SEO Services</h3>
                            <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae.</p>
                        </div>
                    </div>
                </div><!--/.col-md-4-->
            </div><!--/.row-->
            <hr>
            <div class="row">
                <div class="col-lg-12">
                    <div class="center">
                        <h2>What our clients say</h2>
                        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                    </div>
                    <div class="gap"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <blockquote>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                                <small>Someone famous in <cite title="Source Title">Source Title</cite></small>
                            </blockquote>
                        </div>
                        <div class="col-md-6">
                            <blockquote>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
                                <small>Someone famous in <cite title="Source Title">Source Title</cite></small>
                            </blockquote>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section><!--/#services-->', 'Services', 'Services'),
    (3, '<section id="privacy-policy" class="container">
        <h3>Introduction</h3>
        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>

        <p>&nbsp;</p>

        <h3>Types of information we collect</h3>
        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>

        <p>&nbsp;</p>

        <h3>Use of Information</h3>
        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>

        <p>&nbsp;</p>
        <h3>Children</h3>
        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo.</p>

        <p>&nbsp;</p>
        <h3>Contact information</h3>
        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>
        <p>&nbsp;</p>
    </section><!--/#privacy-policy-->', 'privacy-policy', 'Privacy Policy'),
    (4, '<section id="about-us" class="container">
        <div class="row">
            <div class="col-sm-6">
                <h2>What we are</h2>
                <p>Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Mauris in erat justo. Nullam ac urna eu felis dapibus condimentum sit amet a augue. Sed non neque elit. Sed ut imperdiet nisi. Proin condimentum fermentum nunc. Etiam pharetra, erat sed fermentum feugiat, velit mauris egestas quam, ut aliquam massa nisl quis neque. Suspendisse in orci enim.</p>
            </div><!--/.col-sm-6-->
            <div class="col-sm-6">
                <h2>Our Skills</h2>
                <div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">
                            <span>HTML/CSS</span>
                        </div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;">
                            <span>Wordpress</span>
                        </div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
                            <span>Joomla</span>
                        </div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100" style="width: 55%;">
                            <span>Drupal</span>
                        </div>
                    </div>
                    <div class="progress">
                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
                            <span>PHP</span>
                        </div>
                    </div>
                </div>
            </div><!--/.col-sm-6-->
        </div><!--/.row-->
    </section><!--/#about-us-->', 'about-us', 'About Us');

