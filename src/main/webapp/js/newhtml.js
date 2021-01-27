/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function goToNextQuestion() {

    alert("No more questions!");
    window.history.forward();
}

function goBack() {

    window.history.back()
}

function showCorrectAnswer(){
    
            var alternatives = [];
            $.each($("input[name='alternativ']:checked"), function() {
                alternatives.push($(this).val());
            });
            alert("The checked alternatives were: " + alternatives.join(", "));
}


