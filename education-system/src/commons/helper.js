import { useCookies } from "vue3-cookies";

const { cookies } = useCookies();

const HttpHelper = {
  configHeaderApi: (data) => {
    let headers = {
      'Cache-Control': 'no-cache, no-store, must-revalidate',
      'Pragma': 'no-cache',
      'Expires': '0',
      'Authorization': cookies.isKey('Authorization') ? cookies.get('Authorization') : '',
    };
    if (typeof(data) === 'number' || typeof(data) === 'string') {
      headers["Content-Type"] = "application/json";
    }
    return headers;
  }
}

const ArrayHelper = {
  remove: (arr, el, key) => {
    let index = arr.findIndex(item => item[key] === el[key]);
    if (index > -1) {
      arr.splice(index, 1);
    }
  },
  removeByKey: (arr, field, value) => {
    let index = arr.findIndex(item => item[field] === value);
    if (index > -1) {
      arr.splice(index, 1);
    }
  }
}

export {
  ArrayHelper,
  HttpHelper
}
