<template>
  <div class="main-content">
    <div id="main" style="width: 1200px; height: 600px; margin: 0 auto"></div>
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
  methods: {
    getData1() {
      this.$nextTick(() => {
        this.$http({
          url: "list/getData3",
          method: "get",
        }).then(({ data }) => {
          console.log("🚀 ~ this.$nextTick ~ data:", data);
          var myChart = echarts.init(document.getElementById("main"));
          myChart.setOption({
            title: {
              text: "不同日期销售金额",
              left: "center",
            },
            tooltip: {
              trigger: "axis",
              axisPointer: {
                type: "shadow", // 鼠标悬浮时，显示阴影指示器
              },
            },
            toolbox: {
              show: true, // 显示工具栏
              feature: {
                saveAsImage: { show: true, title: "保存为图片" }, // 保存为图片按钮
                dataView: { show: true, readOnly: false, title: "数据视图" }, // 数据视图按钮
                magicType: {
                  show: true,
                  type: ["line", "bar"],
                  title: { line: "切换为折线图", bar: "切换为柱状图" },
                }, // 切换图表类型按钮
                restore: { show: true, title: "重置" }, // 重置按钮
                mark: { show: true, title: "辅助线标志开关" }, // 辅助线标志开关按钮
              },
              left: "right", // 工具栏组件离容器右侧的距离
              top: "top", // 工具栏组件离容器顶部的距离
            },
            grid: {
              left: "3%", // 图表距离左侧的距离
              right: "4%", // 图表距离右侧的距离
              bottom: "3%", // 图表距离底部的距离
              containLabel: true, // 包含坐标轴的刻度标签
            },
            xAxis: {
              type: "category",
              data: data.data.key,
              axisLabel: {
                rotate: 45, // 坐标轴刻度标签旋转角度
                interval: 0, // 强制显示所有标签
              },
              splitLine: {
                show: false, // 不显示网格线
              },
            },
            yAxis: {
              type: "value",
              splitLine: {
                show: true, // 显示纵向网格线
              },
              axisLabel: {
                formatter: "{value} %", // 格式化y轴标签为百分比形式
              },
              axisPointer: {
                label: {
                  formatter: function (params) {
                    return params.value.toFixed(2) + " %"; // 控制提示框显示的数值格式
                  },
                },
              },
              axisTick: {
                show: false, // 不显示刻度
              },
              nameLocation: "middle", // y轴名称位置
              nameGap: 35, // y轴名称与轴线之间的距离
            },
            series: [
              {
                name: "金额",
                data: data.data.val,
                type: "bar",
                barWidth: "60%", // 柱状图宽度
                itemStyle: {
                  color: function (params) {
                    // 自定义颜色函数，根据数值不同显示不同颜色
                    var colorList = ["#C1232B", "#B5C334", "#FCCE10", "#E87C25", "#27727B", "#FE8463", "#9BCA63", "#FAD860", "#F3A43B", "#60C0DD"];
                    return colorList[params.dataIndex % colorList.length];
                  },
                },
              },
            ],
          });
        });
      });
    },
  },
};
</script>
<style lang="scss" scoped></style>
