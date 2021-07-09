
 <h1 class="curproject-name"> ERP-METRICS </h1> 
 erp-metrics XX架构组项目


# 应用异常监控报表相关的接口

## 按应用维度统计
<a id=按应用维度统计> </a>
### 基本信息

**Path：** /app/monitor/report/reportByApp

**Method：** POST

**接口描述：**
<p>按应用维度统计</p>


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> deptId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">归属项目部的ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> appOwner</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用负责人</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> appId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用的ID</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> startDate</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">开始日期</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> endDate</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">结束日期</span></td><td key=5></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> status</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">状态：0表示未完成，1表示完成</span></td><td key=5></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
  "msg": "成功",
  "result": 1,
  "data": {
    "XX项目部": [
      {
        "deptId": "1",
        "deptName": "XX项目部",
        "appOwner": "张三",
        "appId": "18",
        "appName": "ld-erp-hr线上应用异常监控",
        "createDate": "2021-01-10",
        "times": 4,
        "total": 21
      }
    ]
  }
}
```
## 按应用负责人维度统计
<a id=按应用负责人维度统计> </a>
### 基本信息

**Path：** /app/monitor/report/reportByOwner

**Method：** POST

**接口描述：**
<p>按应用负责人维度统计</p>


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> deptId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">归属项目部的ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> appOwner</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用负责人</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> startDate</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">开始日期，格式yyyy-MM-dd</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> endDate</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">结束日期，格式yyyy-MM-dd</span></td><td key=5></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> status</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">状态：0表示未完成，1表示完成</span></td><td key=5></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
"msg": "成功",
"result": 1,
"data": {
"XX项目部": [
{
"deptId": "1",
"deptName": "XX项目部",
"appOwner": "张三",
"createDate": "2021-01-10",
"times": 4,
"total": 21
},
{
"deptId": "1",
"deptName": "XX项目部",
"appOwner": "张三",
"createDate": "2021-01-09",
"times": 3,
"total": 18
},
{
"deptId": "1",
"deptName": "XX项目部",
"appOwner": "张三",
"createDate": "2021-01-08",
"times": 8,
"total": 71
},
{
"deptId": "1",
"deptName": "XX项目部",
"appOwner": "张三",
"createDate": "2021-01-07",
"times": 4,
"total": 21
},
{
"deptId": "1",
"deptName": "XX项目部",
"appOwner": "张三",
"createDate": "2021-01-06",
"times": 1,
"total": 7
}
]
}
}
```
## 按归属项目部维度统计
<a id=按归属项目部维度统计> </a>
### 基本信息

**Path：** /app/monitor/report/reportByDept

**Method：** POST

**接口描述：**
<p>按归属项目部维度统计</p>


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> deptId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> startDate</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">开始日期，格式yyyy-MM-dd</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> endDate</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">结束日期，格式yyyy-MM-dd</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> status</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">状态：0表示未完成，1表示完成</span></td><td key=5></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
"msg": "成功",
"result": 1,
"data": {
"XX项目部": [
{
"deptId": "1",
"deptName": "XX项目部",
"createDate": "2021-01-10",
"times": 12,
"total": 32
},
{
"deptId": "1",
"deptName": "XX项目部",
"createDate": "2021-01-09",
"times": 12,
"total": 32
},
{
"deptId": "1",
"deptName": "XX项目部",
"createDate": "2021-01-08",
"times": 84,
"total": 395
},
{
"deptId": "1",
"deptName": "XX项目部",
"createDate": "2021-01-07",
"times": 62,
"total": 207
},
{
"deptId": "1",
"deptName": "XX项目部",
"createDate": "2021-01-06",
"times": 32,
"total": 93
}
]
}
}
```
## 按日期维度统计
<a id=按日期维度统计> </a>
### 基本信息

**Path：** /app/monitor/report/reportByDate

**Method：** POST

**接口描述：**
<p>按日期维度统计</p>


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |  application/json |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> startDate</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">开始时间，格式yyyy-MM-dd</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> endDate</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">结束时间，格式yyyy-MM-dd</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> status</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">状态：0表示未完成，1表示完成</span></td><td key=5></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
"msg": "成功",
"result": 1,
"data": [
{
"createDate": "2021-01-10",
"times": 12,
"total": 32
},
{
"createDate": "2021-01-09",
"times": 12,
"total": 32
},
{
"createDate": "2021-01-08",
"times": 84,
"total": 395
},
{
"createDate": "2021-01-07",
"times": 62,
"total": 207
},
{
"createDate": "2021-01-06",
"times": 32,
"total": 93
}
]
}
```
# 应用异常监控

## 拉取esIndex和KibanaId的映射关系
<a id=拉取esIndex和KibanaId的映射关系> </a>
### 基本信息

**Path：** /app/monitor/config/fetch/es/kibana

**Method：** GET

**接口描述：**
<pre><code>{
</code></pre>
<p>"msg": "成功",<br>
&nbsp; "result": 1,<br>
&nbsp; "data": [&nbsp;&nbsp;&nbsp; {<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "esIndex": "ld-message-platform*",<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "kibanaId": "ld-message-platform"<br>
&nbsp;&nbsp;&nbsp; },<br>
&nbsp;&nbsp;&nbsp; {&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "esIndex": "ld-base-task*",<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "kibanaId": "ld-base-task"<br>
&nbsp;&nbsp;&nbsp; }&nbsp; ]<br>
}</p>


### 请求参数

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
            
## 修改应用配置
<a id=修改应用配置> </a>
### 基本信息

**Path：** /app/monitor/config/update

**Method：** POST

**接口描述：**


### 请求参数
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
    "msg": "成功",
    "result": 1,
    "data": true
}
```
## 应用监控数据列表
<a id=应用监控数据列表> </a>
### 基本信息

**Path：** /app/monitor/data/list

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> configId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用配置的id</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> startTime</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">起始时间</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> endTime</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">起止时间</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pageNum</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">第几页</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pageSize</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">每页大小</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>10</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> appOwner</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用配置负责人</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>李四</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> deptId</span></td><td key=1><span>number</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用归属项目部ID</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>1</span></p></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
    "msg": "成功",
    "result": 1,
    "data": {
        "records": [
            {
                "id": "1640",
                "appName": "ERP应用空指针异常监控",
                "appOwner": "李四",
                "errCount": 4,
                "kibanaUrl": "http://es.inside.imlaidian.com/app/kibana#/discover?_a=(columns:!(_source),filters:!(('$state':(store:appState),meta:(alias:!n,disabled:!f,index:'44104a00-b46b-11ea-8e34-23aecccf7569',key:query,negate:!f,type:custom,value:'{\"bool\":{\"must_not\":[{\"term\":{\"fields.service.keyword\":{\"value\":\"ld-erp-devops\"}}}],\"must\":[{\"wildcard\":{\"message\":{\"value\":\"*nullpointerexception*\"}}}]}}'),query:(bool:(must_not:!((term:(fields.service.keyword:(value:ld-erp-devops)))),must:!((wildcard:(message:(value:'*nullpointerexception*')))))))),index:'44104a00-b46b-11ea-8e34-23aecccf7569',interval:auto,query:(language:kuery,query:''),sort:!('@timestamp',desc))&_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:'2021-01-14T15:21:00',to:'2021-01-14T15:31:00'))",
                "remark": null,
                "status": 0,
                "closeTime": null,
                "startTime": "2021-01-14 15:21:00",
                "endTime": "2021-01-14 15:31:00",
		"deptId":1,
		"deptName":"XX项目部"
            },
            {
                "id": "1616",
                "appName": "ERP表情符号异常监控",
                "appOwner": "李四",
                "errCount": 2,
                "kibanaUrl": "http://es.inside.imlaidian.com/app/kibana#/discover?_a=(columns:!(_source),filters:!(('$state':(store:appState),meta:(alias:!n,disabled:!f,index:'44104a00-b46b-11ea-8e34-23aecccf7569',key:query,negate:!f,type:custom,value:'{\"bool\":{\"must\":[{\"wildcard\":{\"message\":{\"value\":\"*incorrect*\"}}},{\"wildcard\":{\"message\":{\"value\":\"*string*\"}}}]}}'),query:(bool:(must:!((wildcard:(message:(value:'*incorrect*'))),(wildcard:(message:(value:'*string*')))))))),index:'44104a00-b46b-11ea-8e34-23aecccf7569',interval:auto,query:(language:kuery,query:''),sort:!('@timestamp',desc))&_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:'2021-01-14T12:02:00',to:'2021-01-14T12:12:00'))",
                "remark": null,
                "status": 0,
                "closeTime": null,
                "startTime": "2021-01-14 12:02:00",
                "endTime": "2021-01-14 12:12:00",
		"deptId":1,
		"deptName":"XX项目部"
            }
        ],
        "total": 70,
        "size": 25,
        "current": 1,
        "searchCount": true,
        "pages": 3
    }
}
```
## 应用监控详情
<a id=应用监控详情> </a>
### 基本信息

**Path：** /app/monitor/config/detail

**Method：** GET

**接口描述：**


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |   |  配置主键id |

### 返回数据

```javascript
{
  "msg": "成功",
  "result": 1,
  "data": {
    "id": "1",
    "appName": "XX网关应用erp-gateway异常监控",
    "appOwner": "",
    "esIndex": "erp-gateway-*",
    "esParam": "{\"query\":{\"bool\":{\"filter\":[{\"term\":{\"message\":\"Internal Server Error\"}},{\"range\":{\"index_utc_date\":{\"gte\":\"{startTime}\",\"lt\":\"{endTime}\"}}}],\"must_not\":[{\"term\":{\"log.file.path\":\"info.log\"}}]}}}",
    "ddWebhookAccessToken": "d361cf7a46e47588395372602549149e243ac7fa8f1cc84e1e5eea3c339a7a47",
    "ddRobotMobile": "15338887312",
    "alarmThreshold": 1,
    "phoneAlarmThreshold":10,
    "lastScanTime": "2020-12-23 10:10:00",
    "executeCycle": 10,
    "deptId":1,
    "deptName":"XX项目部",
    "testerName":"测试",
    "testerPhone":"13888888888"
  }
}
```
## 应用监控负责人列表
<a id=应用监控负责人列表> </a>
### 基本信息

**Path：** /app/monitor/config/configOwner

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |   |   |
**Body**

| 参数名称  | 参数类型  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| deptId | text  |  否 |  1  |  应用归属项目部的ID |



### 返回数据

```javascript
{
  "msg": "成功",
  "result": 1,
  "data": [
    {
      "appOwner": "张三"
    },
    {
      "appOwner": "李四"
    }
  ]
}
```
## 应用监控配置列表
<a id=应用监控配置列表> </a>
### 基本信息

**Path：** /app/monitor/config/list

**Method：** POST

**接口描述：**
<pre><code>{
  "msg": "成功",
  "result": 1,
  "data": {    "records": [
      {
        "id": "1",
        "appName": "XX网关应用gateway异常监控",
        "appOwner": "",
        "esIndex": "gateway-*",
        "ddRobotMobile": "13888888888",
        "createTime": "2020-12-16 13:58:03",
        "createUserName": null,
        "updateTime": "2020-12-18 18:04:16",
        "updateUserName": null,
        "alarmThreshold":1,
        "phoneAlarmThreshold":10,
        "executeCycle": 10,
        "deptId":1,
        "deptName":"XX项目部",
        "testerName":"测试",
        "testerPhone":"13888888888"
      }    ],
    "total": 1,
    "size": 10,
    "current": 1,
    "searchCount": true,
    "pages": 1
  }}
</code></pre>


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/json | 是  |   |   |
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> configId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">监控项目ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> alarmMobile</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">告警手机号码</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> esIndex</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">ES索引</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pageNum</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">第几页</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pageSize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">每页大小</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>10</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> appOwner</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用负责人的名称</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>李四</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> deptId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用归属项目部的ＩＤ</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>1</span></p></td></tr>
               </tbody>
              </table>
            
### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
            
## 删除应用配置
<a id=删除应用配置> </a>
### 基本信息

**Path：** /app/monitor/config/delete

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |   |   |
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |   |  待删除的配置id |
**Body**

| 参数名称  | 参数类型  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| id | text  |  是 |    |  待删除的配置id |



### 返回数据

```javascript
{"type":"object","title":"empty object","properties":{}}
```
## 新增应用配置
<a id=新增应用配置> </a>
### 基本信息

**Path：** /app/monitor/config/save

**Method：** POST

**接口描述：**


### 请求参数
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
    "msg": "成功",
    "result": 1,
    "data": true
}
```
## 更新告警任务备注
<a id=更新告警任务备注> </a>
### 基本信息

**Path：** /app/monitor/data/updateRemark

**Method：** POST

**接口描述：**


### 请求参数
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
    "msg": "成功",
    "result": 1,
    "data": true
}
```
## 更新告警任务的状态
<a id=更新告警任务的状态> </a>
### 基本信息

**Path：** /app/monitor/data/updateStatus

**Method：** POST

**接口描述：**


### 请求参数
**Body**

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody"><tr key=0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> </span></td><td key=1><span></span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap"></span></td><td key=5></td></tr>
               </tbody>
              </table>
            
### 返回数据

```javascript
{
    "msg": "成功",
    "result": 1,
    "data": true
}
```
## 获取告警任务详情
<a id=获取告警任务详情> </a>
### 基本信息

**Path：** /app/monitor/data/detail

**Method：** GET

**接口描述：**


### 请求参数
**Query**

| 参数名称  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ |
| id | 是  |  1 |  告警任务的ID |

### 返回数据

<table>
  <thead class="ant-table-thead">
    <tr>
      <th key=name>名称</th><th key=type>类型</th><th key=required>是否必须</th><th key=default>默认值</th><th key=desc>备注</th><th key=sub>其他信息</th>
    </tr>
  </thead><tbody className="ant-table-tbody">
               </tbody>
              </table>
            
## 获取应用归属的项目部
<a id=获取应用归属的项目部> </a>
### 基本信息

**Path：** /app/monitor/dept/list

**Method：** POST

**接口描述：**


### 请求参数
**Headers**

| 参数名称  | 参数值  |  是否必须 | 示例  | 备注  |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| Content-Type  |  application/x-www-form-urlencoded | 是  |   |   |

### 返回数据

```javascript
{
    "msg": "成功",
    "result": 1,
    "data": [
        {
            "id": "1",
            "deptName": "XX项目部"
        },
        {
            "id": "2",
            "deptName": "ZZ项目部"
        },
        {
            "id": "3",
            "deptName": "YY项目部"
        }
    ]
}
```