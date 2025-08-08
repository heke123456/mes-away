import request from '@/utils/request'

// 查询产品入库单列表
export function listProductreceipt(query) {
  return request({
    url: '/produce/productreceipt/list',
    method: 'get',
    params: query
  })
}

// 查询产品入库单详细
export function getProductreceipt(warehouseEntryID) {
  return request({
    url: '/produce/productreceipt/' + warehouseEntryID,
    method: 'get'
  })
}

// 新增产品入库单
export function addProductreceipt(data) {
  return request({
    url: '/produce/productreceipt',
    method: 'post',
    data: data
  })
}

// 修改产品入库单
export function updateProductreceipt(data) {
  return request({
    url: '/produce/productreceipt',
    method: 'put',
    data: data
  })
}

// 删除产品入库单
export function delProductreceipt(warehouseEntryID) {
  return request({
    url: '/produce/productreceipt/' + warehouseEntryID,
    method: 'delete'
  })
}
