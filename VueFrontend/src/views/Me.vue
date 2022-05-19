<template>
  <div class="about">
    祝您身体健康{{admin.username}}
    <div id="nav">
      <router-link to="/about">返回就诊</router-link>
    </div>
    <div style="width:50%;margin:auto;">
      <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="就诊卡 ID"
        width="180">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="birth"
        label="生日">
      </el-table-column>
      <el-table-column
        prop="wallet"
        label="卡内余额 （元）">
      </el-table-column>
    </el-table>
    </div>
    <!-- <div style="padding:10px">
      <el-button type="success" round @click="handleTopup">充值</el-button>
    </div> -->
  </div>
</template>

<script>
  export default {
    data(){
      return {
        tableData:null
      }
    },
    created() {
      this.admin = JSON.parse(window.localStorage.getItem('access-admin'))
      let access_id = localStorage.getItem('access-id')
      let _this = this
      let requestURL = 'http://localhost:7501/user/getUser/'+access_id
      axios.get(requestURL).then(resp => {
        let cache = [resp.data.data]
        _this.tableData=cache
    })
    }
  }
</script>