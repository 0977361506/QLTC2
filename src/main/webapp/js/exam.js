$(document).ready(function() {
	 
	  $("body").bind('beforeunload', function(){
          return 'leave?';
        });
  $('.star').on('click',function() {

    $(this).find('[data-prefix="fas"]').css('display','inline-block');
    $(this).find('[data-prefix="far"]').css('display','none');
    $(this).css('color','#FCB71E');
    var id = $(this).attr('data-id');
    $('.result-set').find('[q-id="'+id+'"]').css('border-color','#FCB71E');
  });
  $('input.answer').click(function() {
    var id = $(this).attr('name');
    $('.result-set').find('[q-id="#'+id+'"]').css('background-color','#004793');
    $('.result-set').find('[q-id="#'+id+'"]').css('color','#fff');

  
  });
  
  var phut = 0 ;
  var giay = 0 ;
  var mm = $('.countdown-test .m').html();
  function countDown() {
    var countDown = new Date().getTime() + Number(mm)*60*1000 + 1000;


    // Update the count down every 1 second
    var x = setInterval(function() {

      // Get today's date and time
      var now = new Date().getTime();

      // Find the distance between now and the count down date
      var distance = countDown - now;

      // Time calculations for days, hours, minutes and seconds
      if (distance >= 0) {
        var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)).toString();

        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60)).toString();
        var seconds = Math.floor((distance % (1000 * 60)) / 1000).toString();

        if(hours.length == 1) {
          hours = '0'+hours;
        }
        if(minutes.length == 1) {
          minutes = '0'+minutes;
        }
        if(seconds.length == 1) {
          seconds = '0'+seconds;
        }
        // Display the result in the element with id="demo"
        // console.log( hours + "h "
        // + minutes + "m " + seconds + "s ")
        $('.countdown-test .h').html(hours);
        $('.countdown-test .m').html(minutes);
        $('.countdown-test .s').html(seconds);
         phut =$('.countdown-test .m').html();
        giay =  $('.countdown-test .s').html();
        createCookie("ex",phut+","+giay, 30);
        

      }
    
      // If the count down is finished, write some text
      if (distance < 0) {
        clearInterval(x);
        alert('out of time');
      }
    }, 1000);
  }
  countDown();
  
  
  var cook = readCookie("ex");
  alert(cook);
 
  
  
  //côkkei
  function createCookie(name, value, days) {
      if (days) {
          var date = new Date();
          date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
          var expires = "; expires=" + date.toGMTString();
      }
      else var expires = "";               

      document.cookie = name + "=" + value + expires + "; path=/";
  }

  function readCookie(name) {
      var nameEQ = name + "=";
      var ca = document.cookie.split(';');
      for (var i = 0; i < ca.length; i++) {
          var c = ca[i];
          while (c.charAt(0) == ' ') c = c.substring(1, c.length);
          if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
      }
      return null;
  }

  function eraseCookie(name) {
      createCookie(name, "", -1);
  }
})
 
