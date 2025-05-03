const menu = {
	list() {
		return [{
				"backMenu": [],
				"frontMenu": [],
				"hasBackLogin": "是",
				"hasBackRegister": "否",
				"hasFrontLogin": "否",
				"hasFrontRegister": "否",
				"roleName": "管理员",
				"tableName": "users"
			},
			{
				"backMenu": [{
						"child": [{
							"appFrontIcon": "cuIcon-addressbook",
							"buttons": [
								"查看"
							],
							"menu": "收货地址",
							"menuJump": "列表",
							"tableName": "address"
						}],
						"menu": "收货地址"
					},
					{
						"child": [{
							"appFrontIcon": "cuIcon-cart",
							"buttons": [
								"查看",
								"删除"
							],
							"menu": "购物车",
							"menuJump": "列表",
							"tableName": "cart"
						}],
						"menu": "购物车"
					},
					{
						"child": [{
							"appFrontIcon": "cuIcon-activity",
							"buttons": [
								"查看"
							],
							"menu": "公告信息",
							"menuJump": "列表",
							"tableName": "news"
						}],
						"menu": "公告信息"
					},
					{
						"child": [{
							"appFrontIcon": "cuIcon-goods",
							"buttons": [
								"查看",
							],
							"menu": "卡券商品",
							"menuJump": "列表",
							"tableName": "shangpin"
						}],
						"menu": "卡券商品"
					},
					{
						"child": [{
							"appFrontIcon": "cuIcon-favor",
							"buttons": [
								"查看",
								"删除"
							],
							"menu": "卡券商品收藏",
							"menuJump": "列表",
							"tableName": "shangpinCollection"
						}],
						"menu": "卡券商品收藏"
					},
					{
						"child": [{
							"appFrontIcon": "cuIcon-evaluate",
							"buttons": [
								"查看",
								"删除"
							],
							"menu": "卡券商品评价",
							"menuJump": "列表",
							"tableName": "shangpinCommentback"
						}],
						"menu": "卡券商品评价"
					},
					{
						"child": [{
							"appFrontIcon": "cuIcon-order",
							"buttons": [
								"查看",
								"删除"
							],
							"menu": "卡券商品订单",
							"menuJump": "列表",
							"tableName": "shangpinOrder"
						}],
						"menu": "卡券商品订单"
					},
					
					{
						"child": [{
							"appFrontIcon": "cuIcon-evaluate",
							"buttons": [
								"查看",
								"删除"
							],
							"menu": "卡券商品举报",
							"menuJump": "列表",
							"tableName": "shangpinReport"
						}],
						"menu": "卡券商品举报"
					},
					
					{
						"child": [{
							"appFrontIcon": "cuIcon-evaluate",
							"buttons": [
								"查看",
								"删除"
							],
							"menu": "商家举报",
							"menuJump": "列表",
							"tableName": "shangjiaReport"
						}],
						"menu": "商家举报"
					},
				],
				"frontMenu": [],
				"hasBackLogin": "是",
				"hasBackRegister": "否",
				"hasFrontLogin": "是",
				"hasFrontRegister": "是",
				"roleName": "用户",
				"tableName": "yonghu"
			}
		]

	}
}
export default menu;