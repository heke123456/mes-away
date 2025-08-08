import request from '@/utils/request'

// 查询申购材料详细列表
export function listDetailmaterialsubscription(query) {
  return request({
    url: '/order/detailmaterialsubscription/list',
    method: 'get',
    params: query
  })
}

// 查询申购材料详细详细
export function getDetailmaterialsubscription(materialSubscription) {
  return request({
    url: '/order/detailmaterialsubscription/' + materialSubscription,
    method: 'get'
  })
}

// 新增申购材料详细
export function addDetailmaterialsubscription(data) {
  return request({
    url: '/order/detailmaterialsubscription',
    method: 'post',
    data: data
  })
}

// 修改申购材料详细
export function updateDetailmaterialsubscription(data) {
  return request({
    url: '/order/detailmaterialsubscription',
    method: 'put',
    data: data
  })
}

// 删除申购材料详细
export function delDetailmaterialsubscription(materialSubscription) {
  return request({
    url: '/order/detailmaterialsubscription/' + materialSubscription,
    method: 'delete'
  })
}
