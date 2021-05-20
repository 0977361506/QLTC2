$(document).ready(function(){
	$(".Competition").click(function(){
		 var s =`
                 <li>
                      <i class="fa fa-phone" aria-hidden="true"></i>
                      <div><a href="tel:1900 54 54 81">Hotline 1: 1900 54 54 81</a> | <a href="tel:">Hotline 2: </a></div>
                  </li>
                  <li>
                      <i class="fa fa-envelope-o" aria-hidden="true"></i>
                      <div><a href="mailto:vanphong@vnpost.vn">vanphong@vnpost.vn</a></div>
                  </li>
              `;  

$(".top_bar_contact_list ").html(s);
	});

	

	
});