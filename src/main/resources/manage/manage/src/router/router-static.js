import Vue from "vue";
//配置路由
import VueRouter from "vue-router";
Vue.use(VueRouter);
// 解决多次点击左侧菜单报错问题
const VueRouterPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(to) {
  return VueRouterPush.call(this, to).catch((err) => err);
};
//1.创建组件
import NotFound from "@/views/404";
import center from "@/views/center";
import Home from "@/views/home";
import Index from "@/views/index";
import Login from "@/views/login";
import beifen from "@/views/modules/databaseBackup/beifen";
import huanyuan from "@/views/modules/databaseBackup/huanyuan";
import pay from "@/views/pay";
import register from "@/views/register";
import UpdatePassword from "@/views/update-password";

import address from "@/views/modules/address/list";
import cart from "@/views/modules/cart/list";
import config from "@/views/modules/config/list";
import dictionary from "@/views/modules/dictionary/list";
import dictionaryForumState from "@/views/modules/dictionaryForumState/list";
import dictionaryIsdefault from "@/views/modules/dictionaryIsdefault/list";
import dictionaryNews from "@/views/modules/dictionaryNews/list";
import dictionarySex from "@/views/modules/dictionarySex/list";
import dictionaryShangjia from "@/views/modules/dictionaryShangjia/list";
import dictionaryShangjiaChat from "@/views/modules/dictionaryShangjiaChat/list";
import dictionaryShangpin from "@/views/modules/dictionaryShangpin/list";
import dictionaryShangpinCollection from "@/views/modules/dictionaryShangpinCollection/list";
import dictionaryShangpinOrder from "@/views/modules/dictionaryShangpinOrder/list";
import dictionaryShangpinOrderPayment from "@/views/modules/dictionaryShangpinOrderPayment/list";
import dictionaryShangxia from "@/views/modules/dictionaryShangxia/list";
import dictionaryZhuangtai from "@/views/modules/dictionaryZhuangtai/list";
import index1 from "@/views/modules/echarts/index1.vue";
import index2 from "@/views/modules/echarts/index2.vue";
import index3 from "@/views/modules/echarts/index3.vue";
import index4 from "@/views/modules/echarts/index4.vue";
import forum from "@/views/modules/forum/list";
import news from "@/views/modules/news/list";
import shangjia from "@/views/modules/shangjia/list";
import shangjiaChat from "@/views/modules/shangjiaChat/list";
import shangjiaReport from "@/views/modules/shangjiaReport/list";
import shangpin from "@/views/modules/shangpin/list";
import shangpinCollection from "@/views/modules/shangpinCollection/list";
import shangpinCommentback from "@/views/modules/shangpinCommentback/list";
import shangpinOrder from "@/views/modules/shangpinOrder/list";
import shangpinReport from "@/views/modules/shangpinReport/list";
import users from "@/views/modules/users/list";
import yonghu from "@/views/modules/yonghu/list";
//2.配置路由   注意：名字
const routes = [
  {
    path: "/index",
    name: "首页",
    component: Index,
    children: [
      {
        // 这里不设置值，是把main作为默认页面
        path: "/",
        name: "首页",
        component: Home,
        meta: { icon: "", title: "center" },
      },
      {
        path: "/updatePassword",
        name: "修改密码",
        component: UpdatePassword,
        meta: { icon: "", title: "updatePassword" },
      },
      {
        path: "/pay",
        name: "支付",
        component: pay,
        meta: { icon: "", title: "pay" },
      },
      {
        path: "/center",
        name: "个人信息",
        component: center,
        meta: { icon: "", title: "center" },
      },
      {
        path: "/huanyuan",
        name: "数据还原",
        component: huanyuan,
      },
      {
        path: "/beifen",
        name: "数据备份",
        component: beifen,
      },
      {
        path: "/users",
        name: "管理信息",
        component: users,
      },
      {
        path: "/shangjiaReport",
        name: "商家举报管理",
        component: shangjiaReport,
      },
      {
        path: "/shangpinReport",
        name: "商品举报管理",
        component: shangpinReport,
      },
      {
        path: "/dictionaryForumState",
        name: "帖子状态",
        component: dictionaryForumState,
      },
      {
        path: "/dictionaryIsdefault",
        name: "是否默认地址",
        component: dictionaryIsdefault,
      },
      {
        path: "/dictionaryNews",
        name: "公告类型",
        component: dictionaryNews,
      },
      {
        path: "/dictionarySex",
        name: "性别类型",
        component: dictionarySex,
      },
      {
        path: "/dictionaryShangjia",
        name: "商家类型",
        component: dictionaryShangjia,
      },
      {
        path: "/dictionaryShangjiaChat",
        name: "数据类型",
        component: dictionaryShangjiaChat,
      },
      {
        path: "/dictionaryShangpin",
        name: "卡券商品类型",
        component: dictionaryShangpin,
      },
      {
        path: "/dictionaryShangpinCollection",
        name: "收藏表类型",
        component: dictionaryShangpinCollection,
      },
      {
        path: "/dictionaryShangpinOrder",
        name: "订单类型",
        component: dictionaryShangpinOrder,
      },
      {
        path: "/dictionaryShangpinOrderPayment",
        name: "订单支付类型",
        component: dictionaryShangpinOrderPayment,
      },
      {
        path: "/dictionaryShangxia",
        name: "上下架",
        component: dictionaryShangxia,
      },
      {
        path: "/dictionaryZhuangtai",
        name: "状态",
        component: dictionaryZhuangtai,
      },
      {
        path: "/config",
        name: "轮播图",
        component: config,
      },

      {
        path: "/address",
        name: "收货地址",
        component: address,
      },
      {
        path: "/cart",
        name: "购物车",
        component: cart,
      },
      {
        path: "/dictionary",
        name: "字典",
        component: dictionary,
      },
      {
        path: "/forum",
        name: "论坛",
        component: forum,
      },
      {
        path: "/news",
        name: "公告信息",
        component: news,
      },
      {
        path: "/shangjia",
        name: "商家",
        component: shangjia,
      },
      {
        path: "/shangjiaChat",
        name: "用户咨询",
        component: shangjiaChat,
      },
      {
        path: "/shangpin",
        name: "卡券商品",
        component: shangpin,
      },
      {
        path: "/shangpinCollection",
        name: "卡券商品收藏",
        component: shangpinCollection,
      },
      {
        path: "/shangpinCommentback",
        name: "卡券商品评价",
        component: shangpinCommentback,
      },
      {
        path: "/shangpinOrder",
        name: "卡券商品订单",
        component: shangpinOrder,
      },
      {
        path: "/yonghu",
        name: "用户",
        component: yonghu,
      },
      {
        path: "/index1",
        name: "不同种类卡券商品占比",
        component: index1,
      },
      {
        path: "/index2",
        name: "不同日期订单数量分析",
        component: index2,
      },
      {
        path: "/index3",
        name: "不同日期销售金额分析",
        component: index3,
      },
      {
        path: "/index4",
        name: "不同状态订单占比分析",
        component: index4,
      },
    ],
  },
  {
    path: "/login",
    name: "login",
    component: Login,
    meta: { icon: "", title: "login" },
  },
  {
    path: "/register",
    name: "register",
    component: register,
    meta: { icon: "", title: "register" },
  },
  {
    path: "/",
    name: "首页",
    redirect: "/index",
  } /*默认跳转路由*/,
  {
    path: "*",
    component: NotFound,
  },
];
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: "hash",
  /*hash模式改为history*/
  routes, // （缩写）相当于 routes: routes
});

export default router;
