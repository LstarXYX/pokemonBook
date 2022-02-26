// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    itemList:[
      {
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    },{
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    },{
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    },{
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    },{
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    },{
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    },{
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    },{
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    },{
      image: '../../images/book.png',
      title: '显瘦中长款系带风衣',
      describe: '柔软顺滑、上身挺括显瘦，垂坠飘逸、不易皱好打理。',
      count: '888',
      delCount: '666'
    }
  
  ]
  },
  //首次加载数据
  onLoad(options) {
    // 从缓存获取数据 如果没有 请求一次性加载(数据量不大)
      var cacheList = wx.getStorageSync('itemList');
      if(cacheList != null && cacheList != "")
      {
        cacheList = JSON.parse(cacheList);
        this.itemList = cacheList;
      }
      else
      {
          //请求数据
      }
      
      wx.lin.renderWaterFlow(this.data.itemList, false ,()=>{
        console.log('渲染成功')
      })
  }
})
