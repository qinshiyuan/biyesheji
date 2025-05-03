<template>
  <div class="content" style="background-image: url(https://img95.699pic.com/xsj/17/tq/q2.jpg%21/fh/300);background-repeat: no-repeat;background-size: cover;">
    <!--  <div style="width: 100%;height: 100%" v-if="sessionTable!='users'">-->
    <div style="width: 100%; height: 100%">
      <div class="text main-text">欢迎使用 {{ this.$project.projectName }}</div>
    </div>
    <div style="width: 100%; height: 100%; display: flex" v-if="sessionTable == 'users' && false">
      <div style="width: 50%; height: 100%">
        <div id="statistic1" style="width: 100%; height: 600px"></div>
      </div>
      <div style="width: 50%; height: 100%">
        <el-date-picker v-model="echartsDate" type="month" placeholder="选择月"> </el-date-picker>
        <el-button @click="chartDialog2()">查询</el-button>
        <div id="statistic2" style="width: 100%; height: 600px"></div>
      </div>
    </div>
  </div>
</template>
<script>
import router from "@/router/router-static";
export default {
  data() {
    return {
      sessionTable: "", //登录账户所在表名
      role: "", //权限
      userId: "", //当前登录人的id

      echartsDate: new Date(), //echarts的时间查询字段
    };
  },
  mounted() {
    //获取当前登录用户的信息
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    this.userId = this.$storage.get("userId");

    this.init();
    this.chartDialog1();
    this.chartDialog2();
  },
  methods: {
    chartDialog1() {
      let _this = this;
    },
    chartDialog2() {
      let _this = this;
    },
    init() {
      if (this.$storage.get("Token")) {
        this.$http({
          url: `${this.$storage.get("sessionTable")}/session`,
          method: "get",
        }).then(({ data }) => {
          if (data && data.code != 0) {
            router.push({ name: "login" });
          }
        });
      } else {
        router.push({ name: "login" });
      }
    },
  },
};
</script>

<style lang="scss" scoped>
.content {
  display: flex;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 100%;
  min-height: 500px;
  text-align: center;
  .main-text {
    font-size: 38px;
    font-weight: bold;
    margin-top: 10%;
  }
  .text {
    font-size: 24px;
    font-weight: bold;
    color: #333;
  }
}
</style>
