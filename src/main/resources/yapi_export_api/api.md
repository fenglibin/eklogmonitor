
 <h1 class="curproject-name"> ERP-METRICS </h1> 
 erp-metrics 雷神架构组项目


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
"雷神项目部": [
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"appId": "18",
"appName": "ld-erp-hr线上应用异常监控",
"createDate": "2021-01-10",
"times": 4,
"total": 21
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"appId": "18",
"appName": "ld-erp-hr线上应用异常监控",
"createDate": "2021-01-09",
"times": 3,
"total": 18
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"appId": "14",
"appName": "erp-gateway线上应用异常监控",
"createDate": "2021-01-08",
"times": 2,
"total": 30
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"appId": "16",
"appName": "erp-message-push线上应用异常监控",
"createDate": "2021-01-08",
"times": 1,
"total": 3
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"appId": "18",
"appName": "ld-erp-hr线上应用异常监控",
"createDate": "2021-01-08",
"times": 4,
"total": 28
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"appId": "44",
"appName": "erp-user线上应用异常监控",
"createDate": "2021-01-08",
"times": 1,
"total": 10
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"appId": "18",
"appName": "ld-erp-hr线上应用异常监控",
"createDate": "2021-01-07",
"times": 4,
"total": 21
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"appId": "18",
"appName": "ld-erp-hr线上应用异常监控",
"createDate": "2021-01-06",
"times": 1,
"total": 7
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
"雷神项目部": [
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"createDate": "2021-01-10",
"times": 4,
"total": 21
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"createDate": "2021-01-09",
"times": 3,
"total": 18
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"createDate": "2021-01-08",
"times": 8,
"total": 71
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
"createDate": "2021-01-07",
"times": 4,
"total": 21
},
{
"deptId": "1",
"deptName": "雷神项目部",
"appOwner": "江超",
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
"雷神项目部": [
{
"deptId": "1",
"deptName": "雷神项目部",
"createDate": "2021-01-10",
"times": 12,
"total": 32
},
{
"deptId": "1",
"deptName": "雷神项目部",
"createDate": "2021-01-09",
"times": 12,
"total": 32
},
{
"deptId": "1",
"deptName": "雷神项目部",
"createDate": "2021-01-08",
"times": 84,
"total": 395
},
{
"deptId": "1",
"deptName": "雷神项目部",
"createDate": "2021-01-07",
"times": 62,
"total": 207
},
{
"deptId": "1",
"deptName": "雷神项目部",
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
  "msg": "成功",
  "result": 1,
  "data": [    {
      "esIndex": "ld-message-platform*",
      "kibanaId": "ld-message-platform"
    },
    {      "esIndex": "ld-business-indoor-map-provider*",
      "kibanaId": "e061d050-36a2-11ea-a211-0f61ab3bcfa9"
    },
    {      "esIndex": "wmd-total-prod*",
      "kibanaId": "wmd-total-prod"
    },
    {      "esIndex": "cnt-cdt-api-adcrm*",
      "kibanaId": "cnt-cdt-api-adcrm"
    },
    {      "esIndex": "ld-op-merchant-job*",
      "kibanaId": "1e4e9c60-1c93-11ea-8920-cdda8e7f24f7"
    },
    {      "esIndex": "ld-user-point-provider*",
      "kibanaId": "fd2c8f90-b7f4-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ip-limiter*",
      "kibanaId": "204e5e8b-0122-4d51-981a-82bfadd93b5a"
    },
    {      "esIndex": "ld-ad-api-*",
      "kibanaId": "92960f40-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "nginx-error*",
      "kibanaId": "2395e240-aaa2-11e9-a1d6-6961342e7bb2"
    },
    {      "esIndex": "erp-job*",
      "kibanaId": "erp-job"
    },
    {      "esIndex": "erp-crm*",
      "kibanaId": "ff645200-cfac-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-zhuying-device-job-executor*",
      "kibanaId": "ld-zhuying-device-job-executor"
    },
    {      "esIndex": "ld-base-zhima-order-synchronizer*",
      "kibanaId": "490f3e10-b987-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "erp-dubbo-consumer*",
      "kibanaId": "f67befa0-ce25-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "erp-visit*",
      "kibanaId": "9935c320-ce25-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-api-terminal-upgrade*",
      "kibanaId": "ld-api-terminal-upgrade"
    },
    {      "esIndex": "ld-face-data-collect-provider*",
      "kibanaId": "156a4d3e-c60b-4988-bbb6-b2086311f2ed"
    },
    {      "esIndex": "ld-base-shop-provider*",
      "kibanaId": "a7e777c0-aebc-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-router-terminal-*",
      "kibanaId": "bd0c8840-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-business-circle-enterprise-web*",
      "kibanaId": "ld-business-circle-enterprise-web"
    },
    {      "esIndex": "*",
      "kibanaId": "18e52b80-b038-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-zhuying-job-simflow-executor*",
      "kibanaId": "418e4a40-fbb4-11e9-8361-fdedb88a9359"
    },
    {      "esIndex": "ld-security-risk-identification-provider*",
      "kibanaId": "ld-security-risk-identification-provider"
    },
    {      "esIndex": "ld-base-thirdparty-call-*",
      "kibanaId": "6f1d9ea0-fe12-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-base-sharding-order-provider-*",
      "kibanaId": "7f976380-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-ka-management-provider*",
      "kibanaId": "ld-ka-management-provider"
    },
    {      "esIndex": "wmd-total-test*",
      "kibanaId": "wmd-total-test"
    },
    {      "esIndex": "erp-front*",
      "kibanaId": "erp-front"
    },
    {      "esIndex": "ld-business-circle-web-*",
      "kibanaId": "5a0eede0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "erp-gateway*",
      "kibanaId": "erp-gateway"
    },
    {      "esIndex": "erp-time-attendance*",
      "kibanaId": "erp-time-attendance"
    },
    {      "esIndex": "erp-message-push*",
      "kibanaId": "erp-message-push"
    },
    {      "esIndex": "cnt-cdt-api-adcrm-*",
      "kibanaId": "bed98aa0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-mq-minor-*",
      "kibanaId": "dadef650-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-terminal-provider*",
      "kibanaId": "ld-terminal-provider"
    },
    {      "esIndex": "terminal-ad-api*",
      "kibanaId": "terminal-ad-api"
    },
    {      "esIndex": "ld-mp-promotion-provider*",
      "kibanaId": "683233e0-be5c-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-crm-data-*",
      "kibanaId": "40d67a50-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-cache-cdb-provider-*",
      "kibanaId": "511b5d40-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-base-device-ext-*",
      "kibanaId": "885cdf40-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-erp-hr*",
      "kibanaId": "ld-erp-hr"
    },
    {      "esIndex": "erp-es*",
      "kibanaId": "18361f30-ce26-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-user-point-web*",
      "kibanaId": "fdd7b0b0-b8c5-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-op-offline-web*",
      "kibanaId": "903829b0-ffa4-11e9-b969-efaee6dd7556"
    },
    {      "esIndex": "erp-file-center*",
      "kibanaId": "233a8b80-f493-11e9-a45b-9bdfce85d063"
    },
    {      "esIndex": "ld-business-circle-enterprise-web-*",
      "kibanaId": "6a820cc0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-base-payment-provider*",
      "kibanaId": "ld-base-payment-provider"
    },
    {      "esIndex": "ld-statistics-entrance-wmd*",
      "kibanaId": "6cd004b0-de76-11e9-bbd8-a5feac4704f6"
    },
    {      "esIndex": "ld-base-weixin-order-provider*",
      "kibanaId": "f0a8eeb0-b986-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "erp-mission*",
      "kibanaId": "erp-mission"
    },
    {      "esIndex": "ld-erp-cdt*",
      "kibanaId": "ld-erp-cdt"
    },
    {      "esIndex": "ld-base-aliauth-provider*",
      "kibanaId": "95fc92d0-9ef7-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-mq-minor*",
      "kibanaId": "ld-mq-minor"
    },
    {      "esIndex": "ld-dzb-api*",
      "kibanaId": "ld-dzb-api"
    },
    {      "esIndex": "ld-api-device*",
      "kibanaId": "e5904240-de74-11e9-bbd8-a5feac4704f6"
    },
    {      "esIndex": "ld-op-activity-web*",
      "kibanaId": "b30fde30-d847-11e9-bbd8-a5feac4704f6"
    },
    {      "esIndex": "ld-base-user*",
      "kibanaId": "ld-base-user"
    },
    {      "esIndex": "erp-eureka-*",
      "kibanaId": "ae28c680-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-business-circle-provider-*",
      "kibanaId": "6269c0f0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-cs-consumer*",
      "kibanaId": "ld-cs-consumer"
    },
    {      "esIndex": "ld-mq-high-provider-*",
      "kibanaId": "e4688560-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-devops-task*",
      "kibanaId": "ld-devops-task"
    },
    {      "esIndex": ".management-beats",
      "kibanaId": "faa07480-26e4-11ea-b0d4-3dbf786dec8f"
    },
    {      "esIndex": "ld-ka-management-2*",
      "kibanaId": "05ea18c0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "nginx-access*",
      "kibanaId": "43d33500-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-merchant-coupon-platform*",
      "kibanaId": "25ae0720-af74-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-base-taskcontrol*",
      "kibanaId": "28aefe20-addf-11e9-9336-cd701a609711"
    },
    {      "esIndex": "erp-devops*",
      "kibanaId": "78b42700-af8e-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-cdt-api*",
      "kibanaId": "c9ae66c0-aac5-11e9-9336-cd701a609711"
    },
    {      "esIndex": "erp-qyld*",
      "kibanaId": "81913330-c500-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "erp-config*",
      "kibanaId": "828b2660-ce25-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "crm-api*",
      "kibanaId": "crm-api"
    },
    {      "esIndex": "ld-hot-api*",
      "kibanaId": "ld-hot-api"
    },
    {      "esIndex": "ld-merchant-api*",
      "kibanaId": "44836fe0-aebc-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-web-user-operation*",
      "kibanaId": "eb4e7f85-1e2e-4dc0-938d-9d4ea9e3d723"
    },
    {      "esIndex": "erp-statistic*",
      "kibanaId": "b6499c20-ce25-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "erp-cdt*",
      "kibanaId": "e5b02970-ce25-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-base-wxauth*",
      "kibanaId": "aeed3cf0-ac5d-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-zookeeer-*",
      "kibanaId": "96293d90-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-base-vip-provider*",
      "kibanaId": "ld-base-vip-provider"
    },
    {      "esIndex": "ld-zhuying-lock-cbd-service*",
      "kibanaId": "838a0ef0-5d63-11ea-a211-0f61ab3bcfa9"
    },
    {      "esIndex": "devops-api*",
      "kibanaId": "devops-api"
    },
    {      "esIndex": "terminal-xjy-device*",
      "kibanaId": "b18c4530-aac5-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-web-inner*",
      "kibanaId": "ld-web-inner"
    },
    {      "esIndex": "ld-op-merchant-web*",
      "kibanaId": "117d2770-f495-11e9-a45b-9bdfce85d063"
    },
    {      "esIndex": "erp-user-*",
      "kibanaId": "9aa1b0e0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-crm-money*",
      "kibanaId": "92435ae0-a9f9-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "map-web*",
      "kibanaId": "0daad870-118e-11ea-bc34-0515dce398fa"
    },
    {      "esIndex": "terminal-ad-admin-api*",
      "kibanaId": "terminal-ad-admin-api"
    },
    {      "esIndex": "ld-wxpay-order-job*",
      "kibanaId": "60b53160-b40e-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-order-api*",
      "kibanaId": "ld-order-api"
    },
    {      "esIndex": "port-agent*",
      "kibanaId": "bad38b09-38e9-4a3f-84ac-271617f4317d"
    },
    {      "esIndex": "nginx-error-*",
      "kibanaId": "nginx-error-"
    },
    {      "esIndex": "ld-wxpay-order-provider*",
      "kibanaId": "a02d6fd0-ae80-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-devops-api*",
      "kibanaId": "ld-devops-api"
    },
    {      "esIndex": "erp-warm*",
      "kibanaId": "ce12ef50-ce25-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-ad-job-*",
      "kibanaId": "bace9c50-8090-11ea-b5bb-1fbac8943ddf"
    },
    {      "esIndex": "ld-crm-api*",
      "kibanaId": "ld-crm-api"
    },
    {      "esIndex": "ld-op-merchant-provider*",
      "kibanaId": "063ee380-f495-11e9-a45b-9bdfce85d063"
    },
    {      "esIndex": "ld-zhuying-job-main-executor*",
      "kibanaId": "ld-zhuying-job-main-executor"
    },
    {      "esIndex": "ld-xts-api*",
      "kibanaId": "ld-xts-api"
    },
    {      "esIndex": "ld-business-circle-app*",
      "kibanaId": "3866ec70-127e-11ea-8920-cdda8e7f24f7"
    },
    {      "esIndex": "ld-base-cache-device-provider*",
      "kibanaId": "42668be0-d854-11e9-bbd8-a5feac4704f6"
    },
    {      "esIndex": "ld-mq-db-provider*",
      "kibanaId": "ee95fca0-2162-11ea-8920-cdda8e7f24f7"
    },
    {      "esIndex": "ld-cache-cdb-provider*",
      "kibanaId": "ld-cache-cdb-provider"
    },
    {      "esIndex": "ld-biz-wxpay*",
      "kibanaId": "ld-biz-wxpay"
    },
    {      "esIndex": "ld-base-thirdparty-call*",
      "kibanaId": "ld-base-thirdparty-call"
    },
    {      "esIndex": "ld-base-user-operation*",
      "kibanaId": "2c505c4e-c5c7-4893-88b6-b244ee7e74b8"
    },
    {      "esIndex": "ld-erp-config*",
      "kibanaId": "ld-erp-config"
    },
    {      "esIndex": "ld-cache-db-provider-*",
      "kibanaId": "490fbba0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-cmb-payment-web*",
      "kibanaId": "b54210e0-11b5-11ea-bc34-0515dce398fa"
    },
    {      "esIndex": "ld-erp-es-provider*",
      "kibanaId": "ld-erp-es-provider"
    },
    {      "esIndex": "ld-ad-job*",
      "kibanaId": "ld-ad-job"
    },
    {      "esIndex": "ld-biz-user-provider*",
      "kibanaId": "ld-biz-user-provider"
    },
    {      "esIndex": "erp-eureka*",
      "kibanaId": "erp-eureka"
    },
    {      "esIndex": "ld-cs-api*",
      "kibanaId": "c8f70210-a0b4-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-cs-consumer-*",
      "kibanaId": "2e558a10-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-web-openapi*",
      "kibanaId": "82a39680-2e03-11ea-a211-0f61ab3bcfa9"
    },
    {      "esIndex": "ld-erp-push*",
      "kibanaId": "ld-erp-push"
    },
    {      "esIndex": "terminal-ad-job*",
      "kibanaId": "terminal-ad-job"
    },
    {      "esIndex": "ld-base-vip-provider-*",
      "kibanaId": "780fe600-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-android-device-server*",
      "kibanaId": "96b81e00-9f20-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-base-payment*",
      "kibanaId": "b7d847f0-ab8b-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-dzb-api-*",
      "kibanaId": "0ef290f0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-ka-management-provider-*",
      "kibanaId": "f77b0740-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-base-aliauth*",
      "kibanaId": "ld-base-aliauth"
    },
    {      "esIndex": "ld-sharding-influxdb*",
      "kibanaId": "ld-sharding-influxdb"
    },
    {      "esIndex": "ld-terminal-provider-*",
      "kibanaId": "b4afe070-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "flow-admin*",
      "kibanaId": "3a84f98c-f77d-49e0-b74a-fa5c8ccf12d5"
    },
    {      "esIndex": "platform-api*",
      "kibanaId": "149ffb20-941e-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-statisticss-server-wmd*",
      "kibanaId": "815b25ff-cf1a-4568-be6f-4e63cd20c0a2"
    },
    {      "esIndex": "map-admin*",
      "kibanaId": "e022a810-118d-11ea-bc34-0515dce398fa"
    },
    {      "esIndex": "*erp-*",
      "kibanaId": "44104a00-b46b-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-op-merchant-admin*",
      "kibanaId": "d3bd3d80-8913-11ea-b5bb-1fbac8943ddf"
    },
    {      "esIndex": "erp-dubbo-provider*",
      "kibanaId": "07c57150-ce26-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-base-gray*",
      "kibanaId": "49ca8500-c48e-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-terminal-upgrade-api*",
      "kibanaId": "9594a760-ba78-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-base-cache-device-ext-provider*",
      "kibanaId": "4e980970-d854-11e9-bbd8-a5feac4704f6"
    },
    {      "esIndex": "zhuying-error-log*",
      "kibanaId": "zhuying-error-log"
    },
    {      "esIndex": "ld-op-merchant-platform*",
      "kibanaId": "2ebfe680-1c93-11ea-8920-cdda8e7f24f7"
    },
    {      "esIndex": "ld-base-sharding-transaction-record-provider*",
      "kibanaId": "18c83cc0-31e1-11ea-a211-0f61ab3bcfa9"
    },
    {      "esIndex": "ld-base-sharding-order-provider*",
      "kibanaId": "ld-base-sharding-order-provider"
    },
    {      "esIndex": "ld-biz-user-operation*",
      "kibanaId": "69af4992-1592-4b4e-837d-963d1d48e129"
    },
    {      "esIndex": "ld-ticket-vip-web*",
      "kibanaId": "90aa23c0-d8f4-11e9-bbd8-a5feac4704f6"
    },
    {      "esIndex": "ld-erp-ka*",
      "kibanaId": "c3b87ce0-102a-11ea-bc34-0515dce398fa"
    },
    {      "esIndex": "ld-business-circle-ad*",
      "kibanaId": "ld-business-circle-ad"
    },
    {      "esIndex": "ld-cs-2*",
      "kibanaId": "3872cda0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-push-provider*",
      "kibanaId": "3df589e0-c48f-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-business-editor-map*",
      "kibanaId": "ld-business-editor-map"
    },
    {      "esIndex": "erp-workflow*",
      "kibanaId": "70bf0730-ce25-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-base-weixin-order-recent-synchronizer*",
      "kibanaId": "60aa59b0-1189-11ea-bc34-0515dce398fa"
    },
    {      "esIndex": "*crm-*",
      "kibanaId": "78b5eb70-b46b-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-base-ticket*",
      "kibanaId": "a6ae8370-2569-11ea-b0d4-3dbf786dec8f"
    },
    {      "esIndex": "ld-devops-task-*",
      "kibanaId": "1bab66f0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "xxl-job-admin*",
      "kibanaId": "xxl-job-admin"
    },
    {      "esIndex": "ld-erp-cdtwarm*",
      "kibanaId": "ld-erp-cdtwarm"
    },
    {      "esIndex": "terminal-ad-job-*",
      "kibanaId": "a0f5a300-8090-11ea-b5bb-1fbac8943ddf"
    },
    {      "esIndex": "ld-base-sharding-order-heterogeneous-data-sync*",
      "kibanaId": "5ee333d0-b019-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-base-cache-device-ext-persistent*",
      "kibanaId": "5d121860-3844-11ea-a211-0f61ab3bcfa9"
    },
    {      "esIndex": "ld-business-editor-map-provider*",
      "kibanaId": "ld-business-editor-map-provider"
    },
    {      "esIndex": "leishen-error-log*",
      "kibanaId": "leishen-error-log"
    },
    {      "esIndex": "ld-mq-high-provider*",
      "kibanaId": "ld-mq-high-provider"
    },
    {      "esIndex": "ld-order-api-*",
      "kibanaId": "cf94a470-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-erp-devops*",
      "kibanaId": "ld-erp-devops"
    },
    {      "esIndex": "ld-biz-user-provider-*",
      "kibanaId": "40327f80-7a13-11ea-b5bb-1fbac8943ddf"
    },
    {      "esIndex": "cnt-cdt-api*",
      "kibanaId": "cnt-cdt-api"
    },
    {      "esIndex": "ld-merchant-coupon-job*",
      "kibanaId": "c3fe0dd0-cdf1-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-base-task-*",
      "kibanaId": "cbe5a490-ab8b-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-shoppoint-store*",
      "kibanaId": "90b7a770-aea6-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-biz-rent*",
      "kibanaId": "db49eb80-ab8b-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-cmb-payment-provider*",
      "kibanaId": "c8098000-11b5-11ea-bc34-0515dce398fa"
    },
    {      "esIndex": "ld-base-device-ext*",
      "kibanaId": "ld-base-device-ext"
    },
    {      "esIndex": "ld-base-cache-device-persistent*",
      "kibanaId": "441b8fd0-3844-11ea-a211-0f61ab3bcfa9"
    },
    {      "esIndex": "jvm-gc-collection*",
      "kibanaId": "54f8d8d0-aac3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-enterprise-wechat-web*",
      "kibanaId": "ba5fe640-bd93-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-base-user-provider*",
      "kibanaId": "07ca7780-7a16-11ea-b5bb-1fbac8943ddf"
    },
    {      "esIndex": "ld-statistics-server-wmd*",
      "kibanaId": "7a3e9620-de76-11e9-bbd8-a5feac4704f6"
    },
    {      "esIndex": "ld-business-circle-web*",
      "kibanaId": "ld-business-circle-web"
    },
    {      "esIndex": "crm-api-*",
      "kibanaId": "b68d0f70-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-base-weixin-order-synchronizer*",
      "kibanaId": "1c31cca0-b987-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-devops-job*",
      "kibanaId": "ld-devops-job"
    },
    {      "esIndex": "ld-api-auth*",
      "kibanaId": "a15db600-ac5d-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-merchant-provider*",
      "kibanaId": "d9f46cf0-aebc-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-bi-management*",
      "kibanaId": "b32c1ba4-58ae-4b3e-8220-6fa7037baec1"
    },
    {      "esIndex": "port-admin*",
      "kibanaId": "port-admin"
    },
    {      "esIndex": "ld-base-device*",
      "kibanaId": "e6f35a1d-bbaa-4ebc-bd8f-4c251fc4beb6"
    },
    {      "esIndex": "erp-user*",
      "kibanaId": "erp-user"
    },
    {      "esIndex": "ld-push-dubbo*",
      "kibanaId": "ld-push-dubbo"
    },
    {      "esIndex": "base-device*",
      "kibanaId": "base-device"
    },
    {      "esIndex": "ld-zookeeer*",
      "kibanaId": "ld-zookeeer"
    },
    {      "esIndex": "ld-message-platform-*",
      "kibanaId": "ecaaee70-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "apm-*",
      "kibanaId": "apm-*"
    },
    {      "esIndex": "ld-ad-api*",
      "kibanaId": "ld-ad-api"
    },
    {      "esIndex": "ld-base-wxauth-provider-*",
      "kibanaId": "670ffdd0-7a13-11ea-b5bb-1fbac8943ddf"
    },
    {      "esIndex": "erp-ka*",
      "kibanaId": "erp-ka"
    },
    {      "esIndex": "ld-base-zhima-order-recent-synchronizer*",
      "kibanaId": "ee7378a0-118c-11ea-bc34-0515dce398fa"
    },
    {      "esIndex": "ld-devops-api-*",
      "kibanaId": "253236e0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-base-rent-ext*",
      "kibanaId": "ecf2a430-ab8b-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-erp-crm*",
      "kibanaId": "ld-erp-crm"
    },
    {      "esIndex": "base-device-*",
      "kibanaId": "d163a2a0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-enterprise-wechat-provider*",
      "kibanaId": "d4937820-bd92-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "ld-xts-api-*",
      "kibanaId": "9eab95d0-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "terminal-ad-api-*",
      "kibanaId": "7e98fbc0-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-biz-device*",
      "kibanaId": "ld-biz-device"
    },
    {      "esIndex": "ld-business-indoor-map-2*",
      "kibanaId": "046f17a0-36a3-11ea-a211-0f61ab3bcfa9"
    },
    {      "esIndex": "cnt-cdt-api-2*",
      "kibanaId": "c921d5d0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-erp-assist*",
      "kibanaId": "9f865460-bfd9-11e9-8f37-7d94feb35a2f"
    },
    {      "esIndex": "ld-business-circle-ad-*",
      "kibanaId": "71733db0-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-enterprise-web*",
      "kibanaId": "31a59ac0-ae89-11e9-9336-cd701a609711"
    },
    {      "esIndex": "wb-test-log*",
      "kibanaId": "98a19090-9050-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "terminal-ad-admin-api-*",
      "kibanaId": "87d7c630-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "erp-mission-job*",
      "kibanaId": "erp-mission-job"
    },
    {      "esIndex": "ld-business-circle-provider*",
      "kibanaId": "ld-business-circle-provider"
    },
    {      "esIndex": "crm-job*",
      "kibanaId": "c0cc6740-95b2-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-base-wxpay-provider*",
      "kibanaId": "ld-base-wxpay-provider"
    },
    {      "esIndex": "ld-base-zhima-order-provider*",
      "kibanaId": "37da7ce0-b987-11e9-b73d-f3db6edee820"
    },
    {      "esIndex": "cleaner-sync*",
      "kibanaId": "cleaner-sync"
    },
    {      "esIndex": "terminal-cdt-api*",
      "kibanaId": "be8b9a10-aac5-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-router-terminal*",
      "kibanaId": "ld-router-terminal"
    },
    {      "esIndex": "ld-indoor-map-data-provider*",
      "kibanaId": "ld-indoor-map-data-provider"
    },
    {      "esIndex": "ld-base-wxauth-provider*",
      "kibanaId": "ld-base-wxauth-provider"
    },
    {      "esIndex": "ld-base-device-20*",
      "kibanaId": "5a6c9670-3461-11eb-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-base-user-20*",
      "kibanaId": "e7764a40-9103-11ea-8e34-23aecccf7569"
    },
    {      "esIndex": "ld-base-ops-confirm-provider*",
      "kibanaId": "97429520-c4a2-11e9-9fc6-edda17168d94"
    },
    {      "esIndex": "ld-wxpay-order*",
      "kibanaId": "65c8df70-ac5d-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-web-zhuying*",
      "kibanaId": "3c6a7020-2602-11ea-b0d4-3dbf786dec8f"
    },
    {      "esIndex": "erp-gateway-*",
      "kibanaId": "a6940290-aad3-11e9-9336-cd701a609711"
    },
    {      "esIndex": "ld-mp-promotion-web*",
      "kibanaId": "bfac4b30-d84a-11e9-bbd8-a5feac4704f6"
    },
    {      "esIndex": "ld-zhuying-job-support-executor*",
      "kibanaId": "ld-zhuying-job-support-executor"
    },
    {      "esIndex": "ld-third-member*",
      "kibanaId": "ld-third-member"
    },
    {      "esIndex": "ld-biz-ticket*",
      "kibanaId": "97961290-2569-11ea-b0d4-3dbf786dec8f"
    },
    {      "esIndex": "ld-third-member-*",
      "kibanaId": "a54b4b60-aad2-11e9-9336-cd701a609711"
    },
    {      "esIndex": "cnt-cdt-api-backend*",
      "kibanaId": "fa071200-125c-11ea-bc34-0515dce398fa"
    },
    {      "esIndex": "ld-business-indoor-map*",
      "kibanaId": "ld-business-indoor-map"
    },
    {      "esIndex": "ld-base-task*",
      "kibanaId": "ld-base-task"
    }  ]
}
</code></pre>


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
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> configId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用配置的id</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> startTime</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">起始时间</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> endTime</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">起止时间</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pageNum</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">第几页</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pageSize</span></td><td key=1><span>string</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">每页大小</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>10</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> appOwner</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用配置负责人</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>冯立彬</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> deptId</span></td><td key=1><span>number</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用归属项目部ID</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>1</span></p></td></tr>
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
                "appOwner": "冯立彬",
                "errCount": 4,
                "kibanaUrl": "http://127.0.0.1:5601/app/kibana#/discover?_a=(columns:!(_source),filters:!(('$state':(store:appState),meta:(alias:!n,disabled:!f,index:'44104a00-b46b-11ea-8e34-23aecccf7569',key:query,negate:!f,type:custom,value:'{\"bool\":{\"must_not\":[{\"term\":{\"fields.service.keyword\":{\"value\":\"ld-erp-devops\"}}}],\"must\":[{\"wildcard\":{\"message\":{\"value\":\"*nullpointerexception*\"}}}]}}'),query:(bool:(must_not:!((term:(fields.service.keyword:(value:ld-erp-devops)))),must:!((wildcard:(message:(value:'*nullpointerexception*')))))))),index:'44104a00-b46b-11ea-8e34-23aecccf7569',interval:auto,query:(language:kuery,query:''),sort:!('@timestamp',desc))&_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:'2021-01-14T15:21:00',to:'2021-01-14T15:31:00'))",
                "remark": null,
                "status": 0,
                "closeTime": null,
                "startTime": "2021-01-14 15:21:00",
                "endTime": "2021-01-14 15:31:00",
		"deptId":1,
		"deptName":"雷神项目部"
            },
            {
                "id": "1616",
                "appName": "ERP表情符号异常监控",
                "appOwner": "冯立彬",
                "errCount": 2,
                "kibanaUrl": "http://127.0.0.1:5601/app/kibana#/discover?_a=(columns:!(_source),filters:!(('$state':(store:appState),meta:(alias:!n,disabled:!f,index:'44104a00-b46b-11ea-8e34-23aecccf7569',key:query,negate:!f,type:custom,value:'{\"bool\":{\"must\":[{\"wildcard\":{\"message\":{\"value\":\"*incorrect*\"}}},{\"wildcard\":{\"message\":{\"value\":\"*string*\"}}}]}}'),query:(bool:(must:!((wildcard:(message:(value:'*incorrect*'))),(wildcard:(message:(value:'*string*')))))))),index:'44104a00-b46b-11ea-8e34-23aecccf7569',interval:auto,query:(language:kuery,query:''),sort:!('@timestamp',desc))&_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:'2021-01-14T12:02:00',to:'2021-01-14T12:12:00'))",
                "remark": null,
                "status": 0,
                "closeTime": null,
                "startTime": "2021-01-14 12:02:00",
                "endTime": "2021-01-14 12:12:00",
		"deptId":1,
		"deptName":"雷神项目部"
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
    "appName": "雷神网关应用erp-gateway异常监控",
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
    "deptName":"雷神项目部",
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
	"data": [{
		"appOwner": "钦争艳"
	}, {
		"appOwner": "熊哲"
	}, {
		"appOwner": "胡云"
	}, {
		"appOwner": "江超"
	}, {
		"appOwner": "王国伟"
	}, {
		"appOwner": "姚宇明"
	}, {
		"appOwner": "郑韬"
	}, {
		"appOwner": "李坤保"
	}, {
		"appOwner": "罗玉华"
	}, {
		"appOwner": "黄兵"
	}, {
		"appOwner": "冯立彬"
	}]
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
        "appName": "雷神网关应用erp-gateway异常监控",
        "appOwner": "",
        "esIndex": "erp-gateway-*",
        "ddRobotMobile": "15338887312",
        "createTime": "2020-12-16 13:58:03",
        "createUserName": null,
        "updateTime": "2020-12-18 18:04:16",
        "updateUserName": null,
        "alarmThreshold":1,
        "phoneAlarmThreshold":10,
        "executeCycle": 10,
        "deptId":1,
        "deptName":"雷神项目部",
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
  </thead><tbody className="ant-table-tbody"><tr key=0-0><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> configId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">监控项目ID</span></td><td key=5></td></tr><tr key=0-1><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> alarmMobile</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">告警手机号码</span></td><td key=5></td></tr><tr key=0-2><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> esIndex</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">ES索引</span></td><td key=5></td></tr><tr key=0-3><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pageNum</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">第几页</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>1</span></p></td></tr><tr key=0-4><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> pageSize</span></td><td key=1><span>integer</span></td><td key=2>必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">每页大小</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>10</span></p></td></tr><tr key=0-5><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> appOwner</span></td><td key=1><span>string</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用负责人的名称</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>冯立彬</span></p></td></tr><tr key=0-6><td key=0><span style="padding-left: 0px"><span style="color: #8c8a8a"></span> deptId</span></td><td key=1><span>integer</span></td><td key=2>非必须</td><td key=3></td><td key=4><span style="white-space: pre-wrap">应用归属项目部的ＩＤ</span></td><td key=5><p key=5><span style="font-weight: '700'">mock: </span><span>1</span></p></td></tr>
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
            "deptName": "雷神项目部"
        },
        {
            "id": "2",
            "deptName": "客户项目部"
        },
        {
            "id": "3",
            "deptName": "财资项目部"
        }
    ]
}
```