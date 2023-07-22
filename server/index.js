const express = require("express");
const dotenv = require("dotenv").config();
const lab2 = require("./src/routes/route.lab2.js");
const lab3 = require("./src/routes/route.lab3.js");
const bodyParser = require("body-parser");

const app = express();

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

const PORT = process.env.PORT || 5000;

//use route
app.use("/api/lab2", lab2);
app.use("/api/lab3", lab3);

//Khởi tạo server
app.listen(PORT, () => {
  console.log(`Đã kết nối với PORT = ${PORT}`);
});
