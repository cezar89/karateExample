var http = require("http");

var app = http.createServer(function(req,res){
    res.setHeader('Content-Type', 'application/json');
    console.log("I was called!!");
    res.end(JSON.stringify({ response: "hello world" }, null, 3));
});
app.listen(8081);

// Console will print the message
console.log('Server running at http://127.0.0.1:8081/');