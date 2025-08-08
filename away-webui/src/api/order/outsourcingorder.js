import request from '@/utils/request'

// 查询外协列表
export function listOutsourcingorder(query) {
  return request({
    url: '/order/outsourcingorder/list',
    method: 'get',
    params: query
  })
}

// 查询外协详细
export function getOutsourcingorder(outsourcingOrderID) {
  return request({
    url: '/order/outsourcingorder/' + outsourcingOrderID,
    method: 'get'
  })
}

// 新增外协
export function addOutsourcingorder(data) {
  return request({
    url: '/order/outsourcingorder',
    method: 'post',
    data: data
  })
}

// 修改外协
export function updateOutsourcingorder(data) {
  return request({
    url: '/order/outsourcingorder',
    method: 'put',
    data: data
  })
}

// 删除外协
export function delOutsourcingorder(outsourcingOrderID) {
  return request({
    url: '/order/outsourcingorder/' + outsourcingOrderID,
    method: 'delete'
  })
}
