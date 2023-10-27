import Http from "./../commons/http";

export default {
  login(request) {
    return Http.POST('/login', request);
  }
}