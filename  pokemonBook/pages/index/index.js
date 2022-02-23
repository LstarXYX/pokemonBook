// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    current: 'main'
  },
  handleChange ({ detail }) {
    this.setData({
        current: detail.key
    });
}
})
