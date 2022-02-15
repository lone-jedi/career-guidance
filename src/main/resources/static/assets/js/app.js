window.addEventListener('DOMContentLoaded', function() {
    let previousStepButton = document.querySelector('#previousStepButton');
    let nextStepButton = document.querySelector('#nextStepButton');
    let stepper = new Stepper(document.querySelector('#bs-stepper'));

    previousStepButton.addEventListener('click', function() {
        stepper.previous();
    });
    
    nextStepButton.addEventListener('click', function() {
        stepper.next();
    });
});
