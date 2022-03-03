<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            background-color="#324157"
            text-color="#bfcbd9"
            active-text-color="#20a0ff"
            unique-opened
            router
        >
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu
                                v-if="subItem.subs"
                                :index="subItem.index"
                                :key="subItem.index"
                            >
                                <template slot="title">{{ subItem.title }}</template>
                                <el-menu-item
                                    v-for="(threeItem,i) in subItem.subs"
                                    :key="i"
                                    :index="threeItem.index"
                                >{{ threeItem.title }}</el-menu-item>
                            </el-submenu>
                            <el-menu-item
                                v-else
                                :index="subItem.index"
                                :key="subItem.index"
                            >{{ subItem.title }}</el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from '../common/bus';
export default {
    data() {
        return {
            collapse: false,
            items: [
                {
                    icon: 'el-icon-lx-home',
                    index: 'dashboard',
                    title: '系统首页'
                },
                // 用户管理
                {
                    icon: 'el-icon-user-solid',
                    index: '3',
                    title: '用户管理',
                    subs: [
                        {
                            index: 'userlist',
                            title: '用户信息'
                        },
                        {
                            index: 'adduser',
                            title: '添加用户'
                        }
                    ]
                },
                // 图书管理
                {
                    icon: 'el-icon-notebook-2',
                    index: '4',
                    title: '图书管理',
                    subs: [
                        {
                            index: 'booklist',
                            title: '图书信息'
                        },
                        {
                            index: 'addbook',
                            title: '添加图书'
                        }
                    ]
                },
                //借书记录
                {
                    icon: 'el-icon-s-order',
                    index: 'lendlist',
                    title: '借书记录'
                },
                //黑名单记录
                {
                    icon: 'el-icon-warning-outline',
                    index: 'blacklist',
                    title: '黑名单记录'
                },
                //数据分析
                {
                    icon: 'el-icon-s-data',
                    index: 'dataAnalysis',
                    title: '数据分析',
                    subs: [
                        {
                            index: 'categoryData',
                            title: '图书类别分析'
                        },
                        {
                            index: 'lendBookNumData',
                            title: '借阅人数分析'
                        }
                    ]
                },
                //操作日志
                 {
                    icon: 'el-icon-lx-cascades',
                    index: 'syslog',
                    title: '操作日志'
                },
                //定时任务
                {
                    icon: 'el-icon-cpu',
                    index: 'jobs',
                    title: '定时任务'
                }
            ]
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path.replace('/', '');
        }
    },
    created() {
        // 通过 Event Bus 进行组件间通信，来折叠侧边栏
        bus.$on('collapse', msg => {
            this.collapse = msg;
            bus.$emit('collapse-content', msg);
        });
    }
};
</script>

<style scoped>
.sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
    width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
}
.sidebar > ul {
    height: 100%;
}
</style>
