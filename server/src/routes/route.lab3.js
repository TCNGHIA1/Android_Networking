const route = require("express")();
const fs = require("fs");
const products = require("../database/database.example");
const path = require("path");

route.get("/contacts", (req, res) => {
  const filePath = path.join(__dirname, "../database/json_data.json");
  fs.readFile(filePath, "utf8", (err, data) => {
    if (err) {
      console.log(err);
      return;
    }
    const jsonData = JSON.parse(data);
    res.json(jsonData);
    console.log(jsonData);
  });
});
route.get("/products/all", (req, res) => {
  res.json(products);
});

route.get("/array", (req, res) => {
  const filePath = path.join(__dirname, "../database/person_array.json");
  fs.readFile(filePath, "utf8", (err, data) => {
    if (err) {
      console.log(err);
      return;
    }
    const jsonData = JSON.parse(data);
    res.json(jsonData);
    console.log(jsonData);
  });
});
route.get("/object", (req, res) => {
  const filePath = path.join(__dirname, "../database/person_object.json");

  fs.readFile(filePath, "utf8", (err, data) => {
    if (err) {
      console.log(err);
      return;
    }
    const jsonData = JSON.parse(data);
    res.json(jsonData);
    console.log(jsonData);
  });
});
module.exports = route;
