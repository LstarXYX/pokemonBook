<template>
    <div>
        <Header></Header>
        <SideBar></SideBar>
        <div class="content-box" :class="{'content-collapse':collapse}">
            <!-- <Tags></Tags> -->
            <div class="content">
                <transition name="move" mode="out-in">
                    <keep-alive :include="tagsList">
                        <router-view></router-view>
                    </keep-alive>
                </transition>
                <el-backtop target=".content"></el-backtop>
            </div>
        </div>
    </div>
</template>

<script>
import SideBar from '../components/SideBar';
import Header from '../components/Header';
// import Tags from '../components/Tags';
import bus from '../bus';

export default {
    components: {
        SideBar,
        Header,
        // Tags
    },
    data: function() {
        return {
            tagsList: [],
             collapse: false
        }
    },
    created(){
        bus.$on('collapse-content', msg => {
            this.collapse = msg;
        });

         // 只有在标签页列表里的页面才使用keep-alive，即关闭标签之后就不保存到内存中了。
        bus.$on('tags', msg => {
            let arr = [];
            for (let i = 0, len = msg.length; i < len; i++) {
                msg[i].name && arr.push(msg[i].name);
            }
            this.tagsList = arr;
        });
    }
}
</script>

<style>
.content-box {
    position: absolute;
    left: 250px;
    right: 0;
    top: 70px;
    bottom: 0;
    padding-bottom: 30px;
    -webkit-transition: left .3s ease-in-out;
    transition: left .3s ease-in-out;
    background: #f0f0f0;
}

.content {
    width: auto;
    height: 100%;
    padding: 10px;
    overflow-y: scroll;
    box-sizing: border-box;
}

.content-collapse {
    left: 65px;
}

.container {
    padding: 30px;
    background: #fff;
    border: 1px solid #ddd;
    border-radius: 5px;
}
</style>