<template>
  <div class="about">
    祝您身体健康{{admin.username}}
    <div id="nav">
      <router-link to="/">返回首页</router-link>
    </div>
    <a href="/me">查看个人信息</a> |
    <a href="/doctor">查看医生/挂号</a> |
    <a href="">资源3</a> |
    <a href="">资源4</a> |
    <a href="">资源5</a> |
    <a href="">资源6</a>
  </div>
</template>

<script>
  export default {
    data(){
      return {
        admin: ''
      }
    },
    created() {
      this.admin = JSON.parse(window.localStorage.getItem('access-admin'))
    }
  }
</script>