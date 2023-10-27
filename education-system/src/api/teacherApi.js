import Http from "./../commons/http";

export default {
  save(request) {
    return Http.POST('/teacher/onboard', request);
  },
  getList() {
    return Http.GET('/teacher/getAll');
  }
}