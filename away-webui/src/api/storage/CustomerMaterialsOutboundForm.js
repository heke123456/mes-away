import request from '@/utils/request'

// 查询客供材料出库单列表
export function listCustomerMaterialsOutboundForm(query) {
  return request({
    url: '/storage/CustomerMaterialsOutboundForm/list',
    method: 'get',
    params: query
  })
}

// 查询客供材料出库单详细
export function getCustomerMaterialsOutboundForm(deliveryNoteID) {
  return request({
    url: '/storage/CustomerMaterialsOutboundForm/' + deliveryNoteID,
    method: 'get'
  })
}

// 新增客供材料出库单
export function addCustomerMaterialsOutboundForm(data) {
  return request({
    url: '/storage/CustomerMaterialsOutboundForm',
    method: 'post',
    data: data
  })
}

// 修改客供材料出库单
export function updateCustomerMaterialsOutboundForm(data) {
  return request({
    url: '/storage/CustomerMaterialsOutboundForm',
    method: 'put',
    data: data
  })
}

// 删除客供材料出库单
export function delCustomerMaterialsOutboundForm(deliveryNoteID) {
  return request({
    url: '/storage/CustomerMaterialsOutboundForm/' + deliveryNoteID,
    method: 'delete'
  })
}
