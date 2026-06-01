// This file is for the JavaScript code that will run on the webpage
// Step 1 find the button on webpage
const submitButton = document.getElementById("submit");

// Step 2 wait for the click event on the button
submitButton.addEventListener("click", function(event) {

    // Stop button from refreshing the page
    event.preventDefault();

    // Step 3 take the data
    const studentName = document.getElementById("name").value;
    const studentMajor = document.getElementById("major").value;
    const studentRole = document.getElementById("targetRole").value;

    // print it to prove we caught it
    console.log("Caught the data:" + studentName + " " + studentMajor + " " + studentRole);

    // Step 4 Configure the data for spring boot
    // We create a Java Script object to hold the data
    // The keys on the left must match the variable names in the Student class in Spring Boot
    const newStudent = {
   
    name: studentName,
    major: studentMajor,
    targetRole: studentRole,
    };
    // Springboot dosent speak in JavaScript, so we need to convert our JavaScript object into a JSON string
    // We use a built in tool called JSON.stringify to do this
    const payload = JSON.stringify(newStudent);
    // Print the payload to prove we made it
    console.log("JSON Payload: " + payload);

    // Step 5 Send the data to Spring Boot
    // We use a built in tool called fetch to send the data to Spring Boot
    // The first parameter is the URL we want to send the data to
    fetch("http://localhost:8082/api/students", {
        method: "POST", // POST method because we are sending data to the server aka adding new student
        headers: {  
            // This tells Spring Boot that we are sending JSON data, not plain text
            "Content-Type": "application/json"
        },
        body: payload // This is the data we are sending, the JSON string we created above
})
.then(function(response) { // This is a callback function that will run when we get a response from Spring Boot
    if (response.ok) { // If the response is successful (status code 200-299)
        console.log("Student added successfully!, added to database");
        alert("Student added successfully!, added to database"); // Pops up an alert to the user to confirm the student was added   
    } else { // If the response is not successful (status code outside of 200-299)
        console.error("The server rejected our data");
    }


})
});
