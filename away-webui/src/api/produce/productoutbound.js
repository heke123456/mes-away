import request from '@/utils/request'

// 查询产品出库列表
export function listProductoutbound(query) {
  return request({
    url: '/produce/productoutbound/list',
    method: 'get',
    params: query
  })
}

// 查询产品出库详细
export function getProductoutbound(id) {
  return request({
    url: '/produce/productoutbound/' + id,
    method: 'get'
  })
}

// 新增产品出库
export function addProductoutbound(data) {
  return request({
    url: '/produce/productoutbound',
    method: 'post',
    data: data
  })
}

// 修改产品出库
export function updateProductoutbound(data) {
  return request({
    url: '/produce/productoutbound',
    method: 'put',
    data: data
  })
}

// 删除产品出库
export function delProductoutbound(id) {
  return request({
    url: '/produce/productoutbound/' + id,
    method: 'delete'
  })
}
