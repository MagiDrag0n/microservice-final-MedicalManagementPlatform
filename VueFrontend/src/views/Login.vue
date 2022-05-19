<template>
    <div class="login-container">
        <el-form :model="ruleForm" :rules="rules"
                 status-icon
                 ref="ruleForm"
                 label-position="left"
                 label-width="0px"
                 class="demo-ruleForm login-page">
            <h3 class="title">系统登录</h3>
            <el-form-item prop="id">
                <el-input type="text"
                          v-model="ruleForm.id"
                          auto-complete="off"
                          placeholder="用户 id"
                ></el-input>
            </el-form-item>
            <el-form-item prop="name">
                <el-input type="password"
                          v-model="ruleForm.name"
                          auto-complete="off"
                          placeholder="身份码"
                ></el-input>
            </el-form-item>
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:100%;" @click="handleSubmit" >登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data(){
            return{
                ruleForm: {
                    id: '441900',
                    name: 'magi'
                },
                rules: {
                    id: [{required: true, message: '请输入用户名', trigger: 'blur'}],
                    name: [{required: true, message: '请输入密码', trigger: 'blur'}]
                }
            }
        },
        methods: {
            handleSubmit(){
                this.$refs.ruleForm.validate((valid) => {
                    if(valid){
                        let _this = this
                        axios.post('http://192.168.172.130:7501/user/login',
                        _this.ruleForm).then(function (response){
                            console.log(response.data.data)
                            if(response.data!=null){
                                console.log(response)
                                localStorage.setItem('access-admin',JSON.stringify(response.data.data))
                                localStorage.setItem("access-id",_this.ruleForm.id)
                                _this.$router.replace({path:'/'})
                            }
                        })
                        // axios.get('http://localhost:7501/user/login',{params:_this.ruleForm}).then(function (response) {
                        //     console.log(response.data.data)
                        //     if(response.data!=null){
                        //         localStorage.setItem('access-admin',JSON.stringify(response.data.data))
                        //         _this.$router.replace({path:'/'})
                        //     }
                        // })
                    }else{
                        console.log('error submit!');
                        return false;
                    }
                })
            }
        }
    };
</script>

<style scoped>
    .login-container {
        width: 100%;
        height: 100%;
    }
    .login-page {
        -webkit-border-radius: 5px;
        border-radius: 5px;
        margin: 180px auto;
        width: 350px;
        padding: 35px 35px 15px;
        background: #fff;
        border: 1px solid #eaeaea;
        box-shadow: 0 0 25px #cac6c6;
    }
    label.el-checkbox.rememberme {
        margin: 0px 0px 15px;
        text-align: left;
    }
</style>
