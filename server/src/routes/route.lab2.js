const route = require("express")();

//xử lý yêu cầu POST width và height từ client
route.post("/rectangle/post", (req, res) => {
  let width = parseFloat(req.body.width);
  let height = parseFloat(req.body.height);

  let chuvi = (width + height) * 2;
  let dientich = width * height;

  console.log(`POST: ${width} + ${height}`);

  res.json(`Chu vi: ${chuvi}; dien tich : ${dientich}`);
});

//xử lý yêu cầu GET width và height từ client
route.get("/rectangle/get", (req, res) => {
  //nhận dữ liệu từ GET
  let width = parseFloat(req.query.width);
  let height = parseFloat(req.query.height);

  let chuvi = (width + height) * 2;
  let dientich = width * height;

  console.log(`${width} + ${height}`);
  res.json(`Chu vi: ${chuvi}; dien tich : ${dientich}`);
});

//xử lý yêu cầu tính thể tích với POsT
route.post("/cube/volume", (req, res) => {
  let edge = req.body.edge;

  let volume = Math.pow(edge, 3);

  res.send(`Thể tích lập phương: ${volume}`);
});
//xử lý phương trình bậc 2
route.post("/quadratic", (req, res) => {
  let { a, b, c } = req.body;
  let result;

  let delta = Math.pow(b, 2) - 4 * a * c;

  if (a == 0) {
    result = oneFunction(b, c, result);
  } else {
    if (delta < 0) {
      result = "Vô số nghiệm";
    } else if (delta == 0) {
      result = `Có nghiệm kép ${numberFix(-b / (2 * a))}`;
    } else {
      let x1 = (-b + Math.sqrt(delta)) / (2 * a);
      let x2 = (-b - Math.sqrt(delta)) / (2 * a);
      result = `Có hai nghiệm là:${numberFix(x1)} và ${numberFix(x2)}`;
    }
  }
  res.send(result);
});

function oneFunction(b, c, result) {
  if (b == 0) {
    if (c == 0) {
      result = "Vô số nghiệm";
    } else {
      result = "Vô nghiệm";
    }
  } else {
    result = `Có một nghiệm: ${numberFix(-c / b)}`;
  }
  return result;
}

const numberFix = (num, n = 2) => {
  return num.toFixed(n);
};
module.exports = route;
