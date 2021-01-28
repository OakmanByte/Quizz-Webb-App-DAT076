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

function showCorrectAnswer(checkboxes){
     
        var values = [];
        var correctAnswer = [];
        
    for (i = 0; i < checkboxes.length; i++) {
        
        if (checkboxes[i].checked == true ) {
            values.push((i+1));
        }
        
        if(checkboxes[i].value == "true"){
            correctAnswer.push((i+1))
            }
        
    }

    if (correctAnswer.some(v => values.includes(v))){
        
        alert("You choose the correct answer!");
    }
    else
        alert("Wrong answer!");
    
    
}  




