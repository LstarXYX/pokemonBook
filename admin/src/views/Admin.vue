<template>
    <div>
        <Header></Header>
        <SideBar></SideBar>
    </div>
</template>

<script>
import SideBar from '../components/SideBar';
import Header from '../components/Header';

export default {
    components: {
        SideBar,
        Header
    },
    data: function() {
        return {
            title: '管理员界面'
        }
    }
}
</script>

<style>

</style>