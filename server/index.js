const express = require("express");

const lab2 = require("./src/routes/route.lab2.js");

const app = express();
const PORT = process.env.PORT || 3000;

//use route
app.use("/api/lab2", lab2);

//Khởi tạo server
app.listen(PORT, () => {
  console.log(`Đã kết nối với PORT = ${PORT}`);
});
