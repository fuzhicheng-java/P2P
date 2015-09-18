<%-- 
    Document   : login
    Created on : Sep 17, 2015, 5:17:32 PM
    Author     : zhichengfu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head><title>
	MobileTrans Login 
</title><meta http-equiv="content-type" content="text/html; charset=UTF-8" /><link type="text/css" rel="stylesheet" href="css/NewDefault.css" /> 
    <script src="js/zhezhao.js" type="text/javascript"></script>
   
</head>
<body>
    <style type="text/css">
	html,body
	{
	    height:100%;padding:0; margin:0;
	}
	 #BS {
        margin: 0 auto -210px;
        padding: 0;
        width: 100%;
        min-height:100%;
        height: auto !important;
        height: 100%;
        min-width: 980px;
        }
    </style>
      
    <div id="BS">
        <div class="headerwraper">
            <div id="header">
                <div class="sojump_logo" style="_margin-left:35px;">
                    <div class="sojump_image">
                        <h1>
                            专业的交通系统调查网站</h1>
                        <a style="background:url('/images/8year/wjx8-ico.gif') no-repeat;width: 135px;height: 56px;position: absolute;display: inline-block;bottom: -3px;right: -134px;" href="/html/8year.html" target="_blank"></a>
                    </div>
                </div>
                <div class="Header_r">
                    <div id="ctl00_divLogin" class="header_reg">
                        <ul>
                            <li style="position: relative">
                                <input type="text" style="color: #9a9a9a;" class="header_input" value="搜索180万问卷模板"
                                    onblur="if(value==''){value='搜索180万问卷模板'}" onfocus="if(value=='搜索180万问卷模板'){value='';}"
                                    onkeydown="enter_click(event,'search_input');" id="search_input" /><a href="#" onclick="search_click('search_input');"
                                        class="header_go"></a>
                                <script type="text/javascript">
                                    function enter_click(a, b) {
                                        a = window.event || a;
                                        if (a.keyCode == 13) {
                                            search_click(b);
                                        }
                                    }
                                    function search_click(a) {
                                        var val = document.getElementById(a).value;
                                        if (val == "搜索180万问卷模板") val = "";
                                        if (val) {
                                            var b = /^\d{4,8}$/;
                                            if (b.exec(val)) {
                                                window.location = "/jq/" + val + ".aspx";
                                            } else {
                                                window.location = "/publicsurveys.aspx?keyword=" + encodeURIComponent(val);
                                            }
                                        } else {
                                            window.location.href = "/publicsurveys.aspx";
                                        }
                                    }
                                </script>
                            </li>
                            <li><a href="/register/register.aspx?type=1"><span style="cursor: pointer;" class="header_btn">
                                注册</span></a></li>
                            <li id="ctl00_liLogin"><a href="/login.aspx" class="new_titxt" style="font-size: 14px;">登录</a></li>
                            <li id="ctl00_hrefQQ" style="margin-right:0;"><a href="/connectnew.aspx" class="link-666"style="background:url(/images/wjx/ico_share/ico_qq.gif) no-repeat; padding-left:17px; font-size:12px;">QQ登录</a></li>
                        </ul>
                    </div>
                    <div id="NMenu">
                        <ul>
                            <li id="ctl00_liIndex"><i></i><a href="/" class="indexnav">首&nbsp;&nbsp;&nbsp;&nbsp;页&nbsp;</a></li>
                            <li id="ctl00_liQCenter"><i></i><a href="/app/survey.aspx" class="indexnav">
                                应用展示</a></li>
                            <li id="ctl00_liPrice"><i></i><a href="/intro.aspx" title="人工客服、尊享服务"
                                class="indexnav">商业服务</a></li>
                            <li id="ctl00_liUseCase"><i></i><a href="/html/promote/info.aspx" title="邀请问卷星样本库中的会员回答您的问卷，快速回收到所需数据"
                                class="indexnav">数据中心</a></li>
                            <li id="ctl00_liCustomer" style="border: 0; padding-right: 0;"><i></i><a
                                href="/publicsurveys.aspx" class="indexnav">技术支持</a></li>
                        </ul>
                    </div>
                </div>
                <div class="divclear">
                </div>
                
            </div>
            <div style="background: url(/images/indexnew/title-btt.png) repeat-x; width: 100%;
                    height: 13px; margin: 0 auto">
                </div>
        </div>
        <div style="margin:0 auto;  width:945px; text-align:left; margin-top:30px;;">
            
  <form name="aspnetForm" method="post" action="login.aspx" id="aspnetForm">
<div>
<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="/wEPDwUKLTI5Mjc1MTEwNmQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFJGN0bDAwJENvbnRlbnRQbGFjZUhvbGRlcjEkUmVtZW1iZXJNZQ==" />
</div>

<div>

	<input type="hidden" name="__EVENTVALIDATION" id="__EVENTVALIDATION" value="/wEWBgKTpcu2BALN49KjCQL+wobfCgLo0YK0CQKznbH7BAKh5/XjDQ==" />
</div>
  <div id="MainDiv">
    <div id="ctl00_ContentPlaceHolder1_divSojump" style="padding-top:10px;">
     <link href="css/nlogin.css" type="text/css" rel="stylesheet" />
    <div id="LoginDiv">
            <div class="login_lbg"></div>
             
            <div id="LoginBox">
                <div id="LoginBox-title">登录 MobileTrans</div>
                <div id="LoginBox-con">
                    <ul>
                        <li>
                            <label>
                                用 户 名</label><input name="ctl00$ContentPlaceHolder1$UserName" type="text" id="ctl00_ContentPlaceHolder1_UserName" class="username_input" onfocus="if(value=='用户名/Email/手机'){value='';}" onblur="if(value==''){value='用户名/Email/手机'}" /><input type="hidden" name="ctl00$ContentPlaceHolder1$hfUserName" id="ctl00_ContentPlaceHolder1_hfUserName" /></li>
                        <li>密&nbsp;&nbsp;&nbsp;&nbsp;码<input name="ctl00$ContentPlaceHolder1$Password" type="password" id="ctl00_ContentPlaceHolder1_Password" class="passward_input" style="margin-left:13px;" /></li>
                        
                        
                       <li id="ctl00_ContentPlaceHolder1_trRemember" style="padding-left:45px;">
                           <span>
                              
                           <span style="display:inline-block; margin-left:50px;"><a id="ctl00_ContentPlaceHolder1_PasswordRecoveryLink" href="register/forgetpassword.aspx">忘记密码？</a></span>
                       </li>
                        <li class="centertxt" style="padding-left:45px;">
                            <div style="float:left;padding-right:50px;"><input type="submit" name="ctl00$ContentPlaceHolder1$LoginButton" value="登 录" id="ctl00_ContentPlaceHolder1_LoginButton" class="submitbutton" onmouseover="this.className='submitbutton submitbutton_hover';" onmouseout="this.className='submitbutton';" style="padding:0 25px;" /></div>
                            <div class="divclear"></div>
                          </li>
                        
                        
                    </ul>
                   
                </div>
                <div id="LoginBox-bottom" style="text-align:center;">
                    <a href="/register/register.aspx?type=1" id="ctl00_ContentPlaceHolder1_hrefRegister" style="color:#fff; display:inline-block;width:344px; margin-top:8px; font-size:16px;" title="只需２０秒，就可完成注册">立即注册</a>
                </div>
                   <script type="text/javascript">
                       var UserName = document.getElementById("ctl00_ContentPlaceHolder1_UserName");
                       var hfUserName = document.getElementById("ctl00_ContentPlaceHolder1_hfUserName");
                       var Password = document.getElementById("ctl00_ContentPlaceHolder1_Password");
                       var LoginButton = document.getElementById("ctl00_ContentPlaceHolder1_LoginButton");
                       var txtCode = document.getElementById("ctl00_ContentPlaceHolder1_txtCode");
                       var hrefGetCode = document.getElementById("hrefGetCode");
                       function getCode() {
                           if (!UserName.value) {
                               alert("请先输入用户名"); UserName.focus(); return;
                           }
                           txtCode.focus();
                           PDF_launch("/register/getcode.aspx?username=" + encodeURIComponent(hfUserName.value), 500, 150, codeCallBack);
                       }
                       function codeCallBack() {
                           txtCode.focus();
                       }
                       UserName.onkeydown = Password.onkeydown = function (e) {
                           e = e || window.event;
                           if (e && e.keyCode == 13) {
                               LoginButton.click();
                           }
                       }
                       if (txtCode) txtCode.onkeydown = UserName.onkeydown;
                       if (UserName.value) Password.focus();
                       else UserName.focus();
                        </script> 
                <div style="clear:both;"></div>
            </div>
           
        </div>
      
    </div>
  </div>
  
    
   </form>
   

        </div>
        <div style="height:240px;"></div>
    </div>
    <div id="footer" style="height:210px;">
        <div id="contact">
            <ul class="ulCons">
                <li style="background: url(/images/indexnew/NContact.gif) no-repeat; height: 24px;">
                    <b>产品</b></li>
                <li><a href="/intro.aspx">自助服务</a></li>
                <li><a href="/html/promote/info.aspx">样本服务</a></li>
              <li><a href="/app/exam.aspx">在线考试系统</a></li> 
            </ul>
            <ul class="ulCons">
                <li style="background: url(/images/indexnew/NContact2.gif) no-repeat; height: 24px;">
                    <b>客户</b></li>
                <li><a href="/client.aspx">客户展示</a></li>
                <li><a href="/html/media.aspx">媒体报道</a></li>
            </ul>
            <ul class="ulCons">
                <li style="background: url(/images/indexnew/NContact3.gif) no-repeat; height: 24px;">
                    <b>支持</b></li>
                <li><a href="/html/contactus.aspx">客服中心</a></li>
                <li><a href="/help/help.aspx">帮助中心</a>&nbsp;&nbsp;<a href="/api.aspx">API</a></li>
                
            </ul>
            <ul class="ulCons" style="width: 105px">
                <li style="background: url(/images/indexnew/NContact4.gif) no-repeat; height: 24px;">
                    <b>团队</b></li>
                <li><a href="/html/aboutus.aspx">关于我们</a></li>
                
                <li><a href="/recentupdate.aspx">最新动态</a><link title="RSS 2.0" type="application/rss+xml" href="http://www.sojump.com/feed.aspx" rel="alternate">
                        <a href="http://www.sojump.com/feed.aspx" target="_blank">
                            <img src="http://image.sojump.com/images/rss/icon_sub_c1s11.gif" width="16px" alt="RSS订阅最新调查问卷" title="RSS订阅最新调查问卷" height="16px" class="alCons_img" style=""></a></li>
            </ul>
        </div>
        <div class="coypright">
            <div style="float: left;">
                <img width="127" height="49" alt="" src="/images/indexnew/bottomlogo.gif"></div>
            <ul class="alCons">
                <li>Contact US</li>
                <li>Tel：400-6300-886</li>
                <li>E-mail：cs@sojump.com</li>
            </ul>
          
            <ul class="alCons alcons_txt">
                <li style="letter-spacing: 13px;">
                    <img width="210" height="25" alt="" src="http://image.sojump.com/images/MasterNew/bottom_right.gif"><br>
                    专业的问卷调查网站</li>
            </ul>
        </div>
        
    </div>
       <div style='display:none;'>
<script src="http://s20.cnzz.com/stat.php?id=4478442&web_id=4478442" language="JavaScript"></script>
</div>

</body>
</html>

