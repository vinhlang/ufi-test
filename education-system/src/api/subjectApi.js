import Http from "./../commons/http";

export default {
  save(request) {
    return Http.POST('/student/onboard', request);
  },
  getList() {
    return Http.GET('/subject/getAll');
  }
}
