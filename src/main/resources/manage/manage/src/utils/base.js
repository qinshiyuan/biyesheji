const base = {
    get() {
        return {
            url : "http://localhost:8080/card_coupons/",
            name: "card_coupons",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/card_coupons/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "卡券商城销售系统"
        } 
    }
}
export default base
