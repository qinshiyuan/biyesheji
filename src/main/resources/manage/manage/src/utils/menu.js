const menu = {
  list() {
    return [
      {
        backMenu: [
          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "商家管理",
                menuJump: "列表",
                tableName: "shangjia",
              },
            ],
            menu: "商家管理",
          },
          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "用户管理",
                menuJump: "列表",
                tableName: "yonghu",
              },
            ],
            menu: "用户管理",
          },
          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "卡券商品管理",
                menuJump: "列表",
                tableName: "shangpin",
              },
              {
                buttons: ["查看", "修改", "删除"],
                menu: "卡券商品评价管理",
                menuJump: "列表",
                tableName: "shangpinCommentback",
              },
              {
                buttons: ["查看", "删除"],
                menu: "卡券商品收藏管理",
                menuJump: "列表",
                tableName: "shangpinCollection",
              },
            ],
            menu: "卡券商品管理",
          },

          {
            child: [
              {
                buttons: ["查看", "处理", "删除"],
                menu: "商品举报管理",
                menuJump: "列表",
                tableName: "shangpinReport",
              },
              {
                buttons: ["查看","处理", "删除"],
                menu: "商家举报管理",
                menuJump: "列表",
                tableName: "shangjiaReport",
              },
            ],
            menu: "举报管理",
          },
          {
            child: [
              {
                buttons: ["订单", "查看", "删除"],
                menu: "卡券商品订单管理",
                menuJump: "列表",
                tableName: "shangpinOrder",
              },
            ],
            menu: "卡券商品订单管理",
          },
          {
            child: [
              {
                buttons: ["查看", "新增", "删除", "修改"],
                menu: "公告类型管理",
                menuJump: "列表",
                tableName: "dictionaryNews",
              },
              {
                buttons: ["查看", "新增", "删除", "修改"],
                menu: "商家类型管理",
                menuJump: "列表",
                tableName: "dictionaryShangjia",
              },
              {
                buttons: ["查看", "新增", "删除", "修改"],
                menu: "卡券商品类型管理",
                menuJump: "列表",
                tableName: "dictionaryShangpin",
              },
            ],
            menu: "类型管理",
          },
          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "论坛管理",
                menuJump: "列表",
                tableName: "forum",
              },
            ],
            menu: "论坛管理",
          },
          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "公告信息管理",
                menuJump: "列表",
                tableName: "news",
              },
            ],
            menu: "公告信息管理",
          },
          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "不同种类卡券商品占比",
                menuJump: "列表",
                tableName: "index1",
              },
              {
                buttons: ["查看", "修改", "删除"],
                menu: "不同日期订单数量分析",
                menuJump: "列表",
                tableName: "index2",
              },
              {
                buttons: ["查看", "删除"],
                menu: "不同日期销售金额分析",
                menuJump: "列表",
                tableName: "index3",
              },
              {
                buttons: ["查看", "删除"],
                menu: "不同状态订单占比分析",
                menuJump: "列表",
                tableName: "index4",
              },
            ],
            menu: "数据分析",
          },

          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "轮播图管理",
                menuJump: "列表",
                tableName: "config",
              },
            ],
            menu: "系统管理",
          },
        ],
        frontMenu: [],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "管理员",
        tableName: "users",
      },
      {
        backMenu: [
          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "用户咨询管理",
                menuJump: "列表",
                tableName: "shangjiaChat",
              },
            ],
            menu: "用户咨询管理",
          },
          {
            child: [
              {
                buttons: ["查看", "新增", "修改", "删除"],
                menu: "卡券商品管理",
                menuJump: "列表",
                tableName: "shangpin",
              },
              {
                buttons: ["查看", "修改"],
                menu: "卡券商品评价管理",
                menuJump: "列表",
                tableName: "shangpinCommentback",
              },
              {
                buttons: ["查看"],
                menu: "卡券商品收藏管理",
                menuJump: "列表",
                tableName: "shangpinCollection",
              },
            ],
            menu: "卡券商品管理",
          },
          {
            child: [
              {
                buttons: ["订单", "查看", "删除"],
                menu: "卡券商品订单管理",
                menuJump: "列表",
                tableName: "shangpinOrder",
              },
            ],
            menu: "卡券商品订单管理",
          },
          {
            child: [
              {
                buttons: ["查看",],
                menu: "商家举报管理",
                menuJump: "列表",
                tableName: "shangjiaReport",
              },
            ],
            menu: "举报管理",
          },
          {
            child: [
              {
                buttons: ["查看", "新增", "删除"],
                menu: "论坛管理",
                menuJump: "列表",
                tableName: "forum",
              },
            ],
            menu: "论坛管理",
          },
          {
            child: [
              {
                buttons: ["查看"],
                menu: "公告信息管理",
                menuJump: "列表",
                tableName: "news",
              },
            ],
            menu: "公告信息管理",
          },
        ],
        frontMenu: [],
        hasBackLogin: "是",
        hasBackRegister: "否",
        hasFrontLogin: "否",
        hasFrontRegister: "否",
        roleName: "商家",
        tableName: "shangjia",
      },
    ];
  },
};
export default menu;
