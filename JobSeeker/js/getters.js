function getUserId() {
  return sessionStorage.getItem("userId");
}

function getUserName() {
  return sessionStorage.getItem("userName");
}

function getUserType() {
  return sessionStorage.getItem("userType");
}

function logout() {
  sessionStorage.clear();
  sessionStorage.setItem("loggedOut", "true");
  window.location.href = "login.html";
}

function getUserEmail() {
  return sessionStorage.getItem("userEmail");
}

function getUserPassword() {
  return sessionStorage.getItem("userPassword");
}

function getBasicAuth() {
  const username = getUserEmail();
  const password = getUserPassword();
  const basicAuth = btoa(`$(username):$(password)`);
  return Basic `${basicAuth}`;
}
