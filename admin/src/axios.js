import axios from "axios";
import { Message } from "element-ui";
import store from './store'

const base_url = "127.0.0.1:8080"

const service = axios.create({
   baseURL: base_url,
   timeout: 30000
});

service.interceptors.request.use(
  config => {
    config.headers["Content-Type"] = "application/json;charset=UTF-8";

    if (config.method === 'get' && config.data) {
      config.url = `${config.url}?${qs.stringify(config.data, { indices: false })}`
      config.headers["Content-Type"] = "application/x-www-form-urlencoded";
    }

    if(store.getters.getToken){
      config.headers["token"] = store.getters.getToken;
    }

    return config;
  }
);

service.interceptors.response.use(
  response => {
    if(response.code == 0)
    {
       return {
         msg: response.msg,
         data: response.data
       }
    }
    Message({
      message: response.msg,
      center: true
    });
  },
  error => {
    if (error.response.status == 400) {
      Message({
        message: "参数信息有误",
        center: true
      });
      return;
    } else if (error.response.status == 302) {
      Message({
        message: "用户未登录",
        center: true
      });
      router.push("/login");
      setStore({ name: 'TOKEN', content: '', type: 'session' })
      return;
    } else if (error.response.status == 404) {
      Message({
        message: "连接失败",
        center: true
      });
      return;
    } else if (error.response.status == 500) {
      Message({
        message: "服务器内部错误",
        center: true
      });
      return;
    } else if (error.response.status == 560) {
      Message({
        message: "数据库异常",
        center: true
      });
      return;
    }
    Message({
      message: error.message,
      type: "error",
      duration: 5 * 1000
    });
    return Promise.reject(error);
  }
);

export default service;