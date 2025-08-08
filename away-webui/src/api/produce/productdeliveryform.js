import request from '@/utils/request'

// 查询产品出库单列表
export function listProductdeliveryform(query) {
  return request({
    url: '/produce/productdeliveryform/list',
    method: 'get',
    params: query
  })
}

// 查询产品出库单详细
export function getProductdeliveryform(deliveryNoteID) {
  return request({
    url: '/produce/productdeliveryform/' + deliveryNoteID,
    method: 'get'
  })
}

// 新增产品出库单
export function addProductdeliveryform(data) {
  return request({
    url: '/produce/productdeliveryform',
    method: 'post',
    data: data
  })
}

// 修改产品出库单
export function updateProductdeliveryform(data) {
  return request({
    url: '/produce/productdeliveryform',
    method: 'put',
    data: data
  })
}

// 删除产品出库单
export function delProductdeliveryform(deliveryNoteID) {
  return request({
    url: '/produce/productdeliveryform/' + deliveryNoteID,
    method: 'delete'
  })
}
