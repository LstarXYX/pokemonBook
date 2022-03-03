<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">后台登录</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <!-- 用户名 -->
                <el-form-item prop="username">
                    <el-input v-model="param.username" placeholder="username">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <!-- 密码 -->
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="password"
                        v-model="param.password"
                        @keyup.enter.native="submitForm()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="code">
                        <el-input v-model="param.code" placeholder="验证码"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-image  :src="codeSrc" @click.native="getCode"></el-image>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                </div>
                <p class="login-tips">Tips : 默认超级管理员</p>
                <p class="login-tips">普通管理员用户名：test1</p>   
                <p class="login-tips"> 密码：test1</p>
            </el-form>
        </div>
    </div>
</template>

<script>
let Base64 = require('js-base64').Base64;
export default {
    data: function() {
        return {
            param: {
                username: 'admin',
                password: '111',
                code:'',
                uuid:''
            },
            rules: {
                username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            },
            codeSrc:'', //验证码的src
        };
    },
    methods: {
        submitForm() {
            this.$axios({
                url:'/api/adminlogin',
                method:'post',
                data:JSON.stringify(this.param)
            }).then((response) =>{
                if(response.status==200){
                    if(response.data.code==200){
                        var data = response.data.data;
                        var session = window.sessionStorage;
                        //保存登录信息
                        session.setItem("id",data.userInfo.id);
                        session.setItem("username",data.userInfo.username);
                        session.setItem("gender",data.userInfo.gender);
                        session.setItem("isblack",data.userInfo.isblack);
                        session.setItem("allowLend",data.userInfo.allowLend);
                        session.setItem("registerDate",data.userInfo.registerDate);
                        session.setItem("roleName",data.role.roleName);
                        session.setItem("roleId",data.role.roleId);
                        this.$store.commit('login');
                        //判断是否sp管理员 如果是 设置
                        if(data.role.roleName == '超级管理员'){
                            this.$store.commit('becomeSP')
                        }
                        this.$message.success('登录成功');
                        //跳转
                        this.$router.push('/');
                    }else{
                        this.$message.error(response.data.msg);
                    }
                }else{
                    this.$message.error('用户名或密码错误');
                }
            });
        },
        //获取验证码
        getCode(){
            this.$axios({
                url:'/api/code',
                method:'get'
            }).then((resp)=>{
                console.log(resp);
                if(resp.status==200){
                    if(resp.data.code==200){
                        var data = resp.data.data;
                        this.codeSrc = data['base64Str'];
                        this.param.uuid = data['uuid'];
                    }else{
                        this.$message.error("无权限");
                    }
                }else{
                    this.$message.error("发生了点错误,请联系管理员");
                }
            })
        }
    },
    mounted(){
        // this.getCode();
    }
};
</script>

<style scoped>
/* .login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(http://yxstudy.cn/img/login-bg.jpeg);
    background-size: 100%;
}*/
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: black;
    border-bottom: 1px solid #ddd;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
} 
</style>