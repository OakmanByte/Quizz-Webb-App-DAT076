/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Load_Second_Page()
{
    location.href = "newhtml.html";
}

function login(){
    
   
     $(document).ready(function(){
      
                //If any password has been entered, load quiz page
                if($('#password').val() != ""){
                    Load_Second_Page();
                }else{
                    //If nothing has been entered into the password field do not
                    //start a quiz
                     alert("You need to enter a password!");
                }
            });
}