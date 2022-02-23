// compoments/bookItem/book-item.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    //图片url
      img_url:{
        type: String,
        value: '../../images/user.png'
      },
      //标题 名字
      name: {
        type: String,
        value: '名字'
      },
      //属性一 0不显示
      type_one:{
        type: Number,
        value: 0
      },
      type_two:{
        type: Number,
        value: 0
      },
      //编号
      no: {
        type: String,
        value: "#000"
      }
  },

  /**
   * 组件的初始数据
   */
  data: {
    
  },

  /**
   * 组件的方法列表
   */
  methods: {

  }
})
