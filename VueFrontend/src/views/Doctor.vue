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
      let requestURL = 'http://192.168.172.130:7501/doctor/getDoctor/1'
      axios.get(requestURL).then(resp => {
        let cache = [resp.data.data]
        _this.tableData=cache
        console.log(_this.tableData)
        console.log(_this.tableData[0].length)

    })
    }
  }
</script>