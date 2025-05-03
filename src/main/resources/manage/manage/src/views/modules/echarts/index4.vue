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
          url: "list/getData4",
          method: "get",
        }).then(({ data }) => {
          console.log("🚀 ~ this.$nextTick ~ data:", data);
          var option = {
            title: {
              text: "不同状态订单占比",

              left: "center",
              textStyle: {
                color: "#333",
                fontSize: 20,
                fontWeight: "bold",
              },
            },
            tooltip: {
              trigger: "item",
            },
            legend: {
              orient: "vertical",
              left: "left",
            },
            toolbox: {
              // 添加工具栏
              feature: {
                saveAsImage: {}, // 添加保存为图片功能
                dataView: {}, // 添加数据视图功能
              },
            },
            series: [
              {
                name: "数量",
                type: "pie",
                radius: "50%",
                data: data.data,
                emphasis: {
                  itemStyle: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: "rgba(0, 0, 0, 0.5)",
                  },
                },
                label: {
                  // 添加标签
                  show: true,
                  formatter: "{b}: {c} ({d}%)",
                },
                labelLine: {
                  // 添加标签线
                  show: true,
                },
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
