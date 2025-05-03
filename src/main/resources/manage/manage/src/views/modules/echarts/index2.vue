<template>
  <div class="main-content">
    <div id="main" style="height: 600px; width: 1200px; margin: auto"></div>
  </div>
</template>
<script>
import * as echarts from "echarts";
export default {
  data() {
    return {};
  },
  created() {
    this.getData1();
  },
  mounted() {},
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g, "");
    },
  },
  components: {},
  computed: {},
  methods: {
    getData1() {
      this.$nextTick(() => {
        this.$http({
          url: "list/getData2",
          method: "get",
        }).then(({ data }) => {
          console.log("🚀 ~ this.$nextTick ~ data:", data);
          var option = {
            title: {
              text: "不同日期订单数量",
          
              left: "center",
              textStyle: {
                color: "#333",
                fontSize: 20,
                fontWeight: "bold",
              },
              subtextStyle: {
                color: "#666",
                fontSize: 14,
              },
            },
            tooltip: {
              trigger: "axis",
              axisPointer: {
                type: "line",
                lineStyle: {
                  color: "#6a7985",
                  width: 1,
                  type: "solid",
                },
              },
              backgroundColor: "rgba(255, 255, 255, 0.7)",
              borderColor: "#ccc",
              borderWidth: 1,
              padding: [10, 15],
              textStyle: {
                color: "#333",
              },
            },
            legend: {
              data: ["数量"],
              top: "5%",
              left: "center",
              textStyle: {
                color: "#333",
                fontSize: 14,
              },
            },
            grid: {
              left: "3%",
              right: "4%",
              bottom: "3%",
              containLabel: true,
            },
            xAxis: {
              type: "category",
              boundaryGap: false,
              data:data.data.key,
              axisLine: {
                lineStyle: {
                  color: "#ccc",
                },
              },
              axisLabel: {
                textStyle: {
                  color: "#333",
                  fontSize: 12,
                },
              },
              axisTick: {
                show: false,
              },
            },
            yAxis: {
              type: "value",
              axisLine: {
                show: false,
              },
              axisLabel: {
                textStyle: {
                  color: "#333",
                  fontSize: 12,
                },
              },
              splitLine: {
                lineStyle: {
                  type: "dashed",
                  color: "#eee",
                },
              },
            },
            series: [
              {
                name: "数量",
                type: "line",
                smooth: true,
                lineStyle: {
                  color: "rgb(0, 136, 255)",
                  width: 3,
                },
                itemStyle: {
                  color: "rgb(0, 136, 255)",
                  borderWidth: 2,
                  borderColor: "rgba(0, 136, 255, 0.2)",
                },
                areaStyle: {
                  color: "rgba(0, 136, 255, 0.2)",
                },
                data: data.data.val,
              },
            ],
          };

          var myChart = echarts.init(document.getElementById("main"));
          myChart.setOption(option);
        });
      });
    },
  },
};
</script>
<style lang="scss" scoped></style>
