const base = {
    get() {
        return {
            url : "http://localhost:8080/fangyuanguanli/",
            name: "fangyuanguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/fangyuanguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "房源管理系统"
        } 
    }
}
export default base
