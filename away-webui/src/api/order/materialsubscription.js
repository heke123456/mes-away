import request from '@/utils/request'

// 查询申购材料列表
export function listMaterialsubscription(query) {
  return request({
    url: '/order/materialsubscription/list',
    method: 'get',
    params: query
  })
}

// 查询申购材料详细
export function getMaterialsubscription(materialSubscription) {
  return request({
    url: '/order/materialsubscription/' + materialSubscription,
    method: 'get'
  })
}

// 新增申购材料
export function addMaterialsubscription(data) {
  return request({
    url: '/order/materialsubscription',
    method: 'post',
    data: data
  })
}

// 修改申购材料
export function updateMaterialsubscription(data) {
  return request({
    url: '/order/materialsubscription',
    method: 'put',
    data: data
  })
}

// 删除申购材料
export function delMaterialsubscription(materialSubscription) {
  return request({
    url: '/order/materialsubscription/' + materialSubscription,
    method: 'delete'
  })
}
