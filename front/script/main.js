function onSubmit() {
  let formClientNumb = document.forms["shop"].elements["client"].value;
  let formCheckoutNumb = document.forms["shop"].elements["checkout"].value;
  const maxItemPerClient = 10;
  const maxCheckout = 3;

  const clients = new Array(formClientNumb);
  const checkouts = new Array(formCheckoutNumb);

  for (let i = 0; i < clients.length; i++) {
    clients[i] =
      "{" + i + 1 + ", " + Math.random() * maxItemPerClient + 1 + "}";
  }
  for (let i = 0; i < checkouts.length; i++) {
    checkouts[i] = "{" + i + 1 + ", " + Math.random() * maxCheckout + 1 + "}";
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
