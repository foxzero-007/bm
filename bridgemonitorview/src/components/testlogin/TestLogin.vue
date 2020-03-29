<template>
  <div>
    <div class="outer_label">
      <img class="inner_label login_logo" src="../../assets/logo.png">
    </div>
    <div class="login_form">
      <input type="text"  class="qxs-ic_user qxs-icon"  placeholder="用户名" v-model="userName">
      <input type="password"  class="qxs-ic_password qxs-icon"  placeholder="密码" v-model="password">
      <!--<button class="login_btn el-button el-button&#45;&#45;primary is-round" type="primary" round>登录</button>-->
      <el-button class="login_btn" @click.native="login" type="primary" round :loading="isBtnLoading">登录</el-button>
      <div style="margin-top: 10px">
      <span style="float: right;color: #A9A9AB">忘记密码？</span>
      </div>
    </div>
  </div>
</template>

<!-- 通过CDN引入Vue.js -->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<!-- 通过CDN引入axios -->
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="//cdn.bootcss.com/qs/6.5.2/qs.min.js"></script>
<script>
  export default {
    data() {
      return {
        userName: '',
        password: '',
        isBtnLoading: false
      }
      users: []
    },
    created () {
      if(JSON.parse( localStorage.getItem('user')) && JSON.parse( localStorage.getItem('user')).userName){
        this.userName = JSON.parse( localStorage.getItem('user')).userName;
        this.password = JSON.parse( localStorage.getItem('user')).password;
      }
    },
    computed: {
      btnText() {
        if (this.isBtnLoading) return '登录中...';
        return '登录';
      }
    },
    methods: {
      login() {
        if(!this.userName || !this.password) {
          this.$message.error('用户名和密码不能为空！');
          return;
        }
        // 将输入的用户名和密码post到后端接口
    this.$axios({
        method: 'post',     // 通过设置type，来选择是get还是post请求
        url: 'http://localhost:8888/api/userLogin',    // 访问的后端接口地址
        data: {
          userName: this.userName,
          password: this.password
        },// get请求使用params,post请求使用data(data为json格式)
    }).then(res => {
        console.log(res)    // 请求成功打印res
        //post成功后获取返回数据
        this.$axios({
            type: 'get',     // 通过设置type，来选择是get还是post请求
            url: 'http://localhost:8888/api/retForeEnd',    // 访问的后端接口地址
            params: { }     // get请求使用params,post请求使用data(data为json格式)
        }).then(res => {
            console.log(res)    //成功打印res
            if (res.data == '1') {
              this.$router.push({ path: '/TestResult'});
            }else if(res.data == '0' ){
              this.$message.error('用户名或密码错误');
              return;
            }else {
              this.$message.error('系统异常，请稍后再试');
              return;
              }
              return;
        }).catch(err => {
            console.log(err)    //错误打印err
            })
    }).catch(err => {
        console.log(err) //错误打印err
        })
      }//login end
    }
  }
</script>
<style>
  .login_form {
    padding-top: 5%;
    padding-left: 35%;
    padding-right: 35%;
  }
  .qxs-ic_user {
    background: url("../../assets/testlogin/ic_user.png") no-repeat;
    background-size: 13px 15px;
    background-position: 3%;
  }
  .qxs-ic_password {
    background: url("../../assets/testlogin/ic_password.png") no-repeat;
    background-size: 13px 15px;
    background-position: 3%;
    margin-bottom: 20px;
  }
  .login_logo {
    height: 100%;
  }
  .login_btn {
    width: 100%;
    font-size: 16px;
    background: -webkit-linear-gradient(left, #000099, #2154FA); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(right, #000099, #2154FA); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(right, #000099, #2154FA); /* Firefox 3.6 - 15 */
    background: linear-gradient(to right, #000099 , #2154FA); /* 标准的语法 */
    filter: brightness(1.4);
  }
</style>
