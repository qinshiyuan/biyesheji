<template>
  <div class="main-content">
    <div id="main" style="height: 600px; width: 1200px; margin: auto;"></div>
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
          url: "list/getData1",
          method: "get",
        }).then(({ data }) => {
          console.log("🚀 ~ this.$nextTick ~ data:", data);
          var option = {
            tooltip: {
              trigger: "item",
            },
            legend: {
              orient: "vertical",
              left: 10,
              textStyle: {
                color: "#333",
                fontSize: 14,
              },
              data: data.data.map((item) => item.name),
            },
            series: [
              {
                name: "数量",
                type: "pie",
                radius: ["40%", "70%"], // 调整内外半径
                data: data.data,
                emphasis: {
                  itemStyle: {
                    shadowBlur: 20, // 增加阴影模糊度
                    shadowOffsetX: 0,
                    shadowColor: "rgba(0, 0, 0, 0.5)",
                  },
                },
                label: {
                  // 增加标签配置
                  show: true,
                  position: "outside", // 标签位置
                  formatter: "{b}: {c} ({d}%)", // 标签内容格式
                },
                labelLine: {
                  // 标签线配置
                  show: true,
                },
                itemStyle: {
                  // 饼图样式配置
                  borderRadius: 10, // 边角圆度
                  borderColor: "#fff",
                  borderWidth: 2,
                },
                animationType: "scale", // 添加缩放动画效果
                animationEasing: "elasticOut",
                animationDelay: function (idx) {
                  return Math.random() * 200;
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
