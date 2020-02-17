function onSubmit() {
  const formClientNumb = document.forms["shop"].elements["client"].value;
  const formCheckoutNumb = document.forms["shop"].elements["checkout"].value;
  const maxItemPerClient = 10;
  const maxCheckout = 3;

  const clients = new Array(formClientNumb);
  const checkouts = [];

  const client = { id: 0, items: 0 };
  const checkout = { id: 0, velocity: 0 };
  const zupermarket = { clients: clients, checkouts: checkouts };

  for (let i = 0; i < formClientNumb; i++) {
    let tmpClient = Object.create(client);
    tmpClient.id = i + 1;
    tmpClient.items = Math.round(Math.random() * maxItemPerClient + 1);
    clients[i] = tmpClient;
  }
  for (let i = 0; i < formCheckoutNumb; i++) {
    let tmpCheckout = Object.create(checkout);
    tmpCheckout.id = i + 1;
    tmpCheckout.velocity = Math.round(Math.random() * maxCheckout + 1);
    checkouts[i] = tmpCheckout;
  }
  console.log("clients:",clients);
  console.log("checkouts:",checkouts);

  const data = JSON.stringify(zupermarket);

  console.log(data);

  ajaxPost("http://localhost:8082/api/shop", data);
}

function ajaxPost(url, data) {
  const req = new XMLHttpRequest();
  req.open("POST", url);
  req.setRequestHeader("Content-Type", "application/json");
  req.onreadystatechange = function() {
    if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
      console.warn("data sent");
    } else {
      console.warn("!!! data not sent !!!");
    }
  };
  req.send(data);
}
