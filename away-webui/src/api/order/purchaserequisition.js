import request from '@/utils/request'

// 查询材料申购列表
export function listPurchaserequisition(query) {
  return request({
    url: '/order/purchaserequisition/list',
    method: 'get',
    params: query
  })
}

// 查询材料申购详细
export function getPurchaserequisition(subscribeID) {
  return request({
    url: '/order/purchaserequisition/' + subscribeID,
    method: 'get'
  })
}

// 新增材料申购
export function addPurchaserequisition(data) {
  return request({
    url: '/order/purchaserequisition',
    method: 'post',
    data: data
  })
}

// 修改材料申购
export function updatePurchaserequisition(data) {
  return request({
    url: '/order/purchaserequisition',
    method: 'put',
    data: data
  })
}

// 删除材料申购
export function delPurchaserequisition(subscribeID) {
  return request({
    url: '/order/purchaserequisition/' + subscribeID,
    method: 'delete'
  })
}
