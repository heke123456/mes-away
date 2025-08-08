import request from '@/utils/request'

// 查询产品存储列表
export function listProduct(query) {
  return request({
    url: '/order/product/list',
    method: 'get',
    params: query
  })
}

// 查询产品存储详细
export function getProduct(id) {
  return request({
    url: '/order/product/' + id,
    method: 'get'
  })
}

// 新增产品存储
export function addProduct(data) {
  return request({
    url: '/order/product',
    method: 'post',
    data: data
  })
}

// 修改产品存储
export function updateProduct(data) {
  return request({
    url: '/order/product',
    method: 'put',
    data: data
  })
}

// 删除产品存储
export function delProduct(id) {
  return request({
    url: '/order/product/' + id,
    method: 'delete'
  })
}
