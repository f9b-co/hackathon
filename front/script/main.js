function onSubmit() {
  let formClientNumb = document.forms["shop"].elements["client"].value;
  let formCheckoutNumb = document.forms["shop"].elements["checkout"].value;
  const maxItemPerClient = 10;
  const maxCheckout = 3;

  const clients = new Array(formClientNumb);
  const checkouts = new Array(formCheckoutNumb);

  const client = { id: 0, items: 0 };
  const checkout = { id: 0, velocity: 0 };

  for (let i = 0; i < clients.length; i++) {
    let tmpClient = Object.create(client);
    tmpClient.id = i + 1;
    tmpClient.items = Math.round(Math.random() * maxItemPerClient + 1);
    clients[i] = tmpClient;
  }
  for (let i = 0; i < checkouts.length; i++) {
    let tmpCheckout = Object.create(checkout);
    tmpCheckout.id = i + 1;
    tmpCheckout.velocity = Math.round(Math.random() * maxCheckout + 1);
    checkouts[i] = tmpCheckout;
  }

  const zupermarket = [clients, checkouts];
  const data = JSON.stringify(zupermarket);

  console.log();

  ajaxPost("http://localhost:8080/api/shop", data);
}

function ajaxPost(url, data) {
  var req = new XMLHttpRequest();
  req.open("POST", url);
  req.setRequestHeader("Content-Type", "application/json");
  req.onreadystatechange = function() {
    if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
      console.warn("data sent");
    } else {
      console.warn("!!! data don't sent !!!");
    }
  };
  req.send(data);
}
