import Library from 'axios';
import Properties from '../constants/properties';
import { HttpHelper } from './helper';

let http = Library.create({
  baseURL: Properties.SERVER_LINK
});
http.defaults.timeout = 3600000;

// TODO handle interceptors

const GET = (url, params = {}) => {
  return new Promise((resolve, rejected) => {
    http.get(
      url,
      {
        headers: HttpHelper.configHeaderApi(),
        params: {...params}
      })
      .then(rawResponse => {
        resolve(rawResponse.data);
      })
      .catch(error => {
        checkError(error);
        rejected(error);
      });
  });
};

const POST = (url, data) => {
  return new Promise((resolve, rejected) => {
    http.post(url, data, {
      headers: HttpHelper.configHeaderApi()
    })
      .then(rawResponse => {
        resolve(rawResponse.data);
      })
      .catch(error => {
        checkError(error);
        rejected(error);
      });
  });
};

const PUT = (url, data) => {
  return new Promise((resolve, rejected) => {
    http.put(url, data, {
      headers: HttpHelper.configHeaderApi()
    })
      .then(rawResponse => {
        resolve(rawResponse.data);
      })
      .catch(error => {
        checkError(error);
        rejected(error);
      })
  });
};

const DELETE = (url, data) => {
  return new Promise((resolve, rejected) => {
    http.delete(url, {
      headers: HttpHelper.configHeaderApi(),
      data: data
    })
      .then(rawResponse => {
        resolve(rawResponse.data);
      })
      .catch(error => {
        checkError(error);
        rejected(error);
      });
  });
};

const checkError = (error) => {
  if (error.message.includes('401')) {
    // TODO
  }
  if (error.message.includes('403')) {
    // TODO
  }
};

export default {GET, POST, PUT, DELETE}
