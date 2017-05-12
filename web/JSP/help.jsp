<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>InDango</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="resources/css/layout.css" rel="stylesheet" type="text/css">
        <link href="resources/css/colors.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Bitter:700" rel="stylesheet">
        <link href="resources/css/fonts.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Fjalla+One" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container extra-space-top">
            <h1 class="fjalla">GENERAL QUESTIONS</h1>
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                1. HOW DO I PURCHASE MOVIE TICKETS?</a>
                        </h4>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse in">
                        <div class="panel-body"><p>1. Use the search box at the top of the Fandango website or in the mobile app to find a show time and theater near you.<br><br>
                                2. Select a show time to begin checkout. Choose the number of tickets you want to purchase and pick your seat(s) (if reserved seating is available). How do you know if reserved seating is available? Look for the “Reserved Seating” icon next to show times to find theaters that offer it. After you select a show time and ticket quantity, you’ll see a seatmap on the following page where you can pick from available seats.<br><br>
                                3. Log in to your VIP account or checkout as a guest, and complete the information on the payment section with a valid method of accepted payment. <br><br>
                                4. Review your order, complete your purchase and enjoy the show! You’ll find instructions on how to pick up your tickets on the confirmation page after purchase, and we’ll also send an email confirmation to the email address you provided during checkout.</p>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                                2. WHEN WILL I GET MY EMAIL ORDER CONFIRMATION?</a>
                        </h4>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse">
                        <div class="panel-body"><p>Shortly after you complete your ticket purchase, an email confirmation will be sent to the email address that you provided during checkout, and will also be stored in your Fandango VIP account information under purchase history.
                                <br><br>
                                If you lost or can't find your confirmation email, please check your SPAM folder. You can also sign in to your Fandango VIP account to see your purchase history.
                                <br><br>
                                If you checked out as a guest – just sign up for a Fandango VIP account with the same email address you used during checkout, and we’ll automatically link your previous purchases to your Fandango VIP account.</p></div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                                3. HOW DO I PICK UP MY TICKETS?</a>
                        </h4>
                    </div>
                    <div id="collapse3" class="panel-collapse collapse">
                        <div class="panel-body"><p>After you complete your purchase, you’ll see a confirmation page that tells you exactly how to pick up your tickets. Depending on the theater and device you’re on, you may print your tickets at home, pick up at a box office or kiosk with a valid credit card, or use a mobile ticket (if available). This information is also available on your confirmation email.</p></div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">
                                4. ARE THERE ANY DISCOUNTS FOR CHILDREN, SERNIORS, STUDENTS, MILITARY, OR GROUPS?</a>
                        </h4>
                    </div>
                    <div id="collapse4" class="panel-collapse collapse">
                        <div class="panel-body">
                            <p>
                                Generally, a child ticket is available for children between 2 and 11 years old and a senior ticket is available for adults aged 65 years old and over. However, some theaters may have additional restrictions or use a different age break, so please check with your local theater.
                                <br><br>
                                To see if any discounts are being offered for your theater for purchases made via Fandango, click on a show time to begin the purchase process. All available ticket categories will be displayed on the subsequent page. Look for ticket categories labeled "child", "senior", "military", "student", or similarly named categories which would indicate a specially priced ticket.
                                <br><br>
                                Please be aware that not all theaters make discounts available through Fandango. Many theaters offer these discounts exclusively at their box office. We suggest that you check with your local theater for their discount policy, identification requirements, and availability.
                                <br><br>
                                Group discount policies also vary by theater and are not offered on Fandango. Please check with your local theater for group discount availability.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <h1 class="fjalla">REFUNDS & EXCHANGES</h1>
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">
                                1. ARE TICKETS REFUNDABLE?</a>
                        </h4>
                    </div>
                    <div id="collapse5" class="panel-collapse collapse">
                        <div class="panel-body"><p>
                                Yes, you may exchange or request a refund for your entire order, less the convenience fee, through Fandango up until the posted showtime. You'll have to complete your refund and exchange before the posted showtime. For full terms and conditions, please see our Fandango Movie Ticket Policy.
                                <br><br>
                                Just sign in or create your free Fandango VIP account using the same email address that was used to purchase your tickets. Please note that for some orders, you may be asked to contact our Customer Service team or your local theater to complete your refund.
                                <br><br>
                                In order to continue to provide movie fans with showtimes, exclusive content and easy-to-use tools, our tickets include a non-refundable convenience fee. A refund of your order, in most cases, returns the cost of your ticket(s) back to your original payment method, less the convenience fee. An exchange allows you to recoup both the cost of your ticket(s), as well as your convenience fee, in the form of a Fandango credit that may be used for a future purchase at any Fandango-ticketing theater.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse6">
                                2. HOW DO I GET A REFUND OR EXCHANGE?</a>
                        </h4>
                    </div>
                    <div id="collapse6" class="panel-collapse collapse">
                        <div class="panel-body"><p>
                                You may exchange or request a refund for your entire order, less the convenience fee, through Fandango up until the posted showtime. You'll have to complete your refund and exchange before the posted showtime. For full terms and conditions, please see our Fandango Movie Ticket Policy.
                                <br><br>
                                Don't have a Fandango VIP account? No problem. You may create your new Fandango VIP account for free using the same email address you used to complete your purchase.
                                <br><br>
                                In certain circumstances, you may be asked to contact our Customer Service team or the theater before the refund or exchange can be completed. 
                            </p></div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse7">
                                3. HOW DO I PICK UP MY TICKETS?</a>
                        </h4>
                    </div>
                    <div id="collapse7" class="panel-collapse collapse">
                        <div class="panel-body">
                            <p>
                                Fandango Credits are dollar value balances that are deposited and stored within your Fandango VIP account after you make an exchange. These credits never expire and can be used towards any ticket purchase on Fandango.
                                <br><br>
                                You can use your Fandango Credits by logging in with your Fandango VIP account during checkout. Your Fandango Credit balance will automatically be applied towards your purchase.
                                <br><br>
                                Have a Fandango promo code or gift card you want to use? No problem. You can still add promo codes and gift cards to your order and they will be applied before your Fandango Credit is applied.
                            </p></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> 
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed --> 
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
    integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
