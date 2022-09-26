const jsonData = '{"team":[' +
'{"firstName":"Jhon", "lastName": "Doe", "age": 10, "phone": "(49)1234-1234"},'+
'{"firstName":"Anna", "lastName": "Smith", "age": 25, "phone": "(49)3213-3123"},'+
'{"firstName":"Peter", "lastName": "Jones", "age": 70, "phone": "(49)5555-6666"}]}';

var jsonObj = JSON.parse(jsonData);

console.log(jsonObj.team[0]);

document.getElementById("nome").innerHTML = '<h2>' + jsonObj.team[0].firstName + '</h2>';
