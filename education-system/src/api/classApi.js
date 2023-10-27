import Http from "./../commons/http";

export default {
  save(request) {
    return Http.POST('/classroom/add', request);
  },
  getList() {
    return Http.GET('/classroom/report');
  }
}
