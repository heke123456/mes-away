import request from '@/utils/request'

// 查询产品入库列表
export function listProductstorage(query) {
  return request({
    url: '/produce/productstorage/list',
    method: 'get',
    params: query
  })
}

// 查询产品入库详细
export function getProductstorage(id) {
  return request({
    url: '/produce/productstorage/' + id,
    method: 'get'
  })
}

// 新增产品入库
export function addProductstorage(data) {
  return request({
    url: '/produce/productstorage',
    method: 'post',
    data: data
  })
}

// 修改产品入库
export function updateProductstorage(data) {
  return request({
    url: '/produce/productstorage',
    method: 'put',
    data: data
  })
}

// 删除产品入库
export function delProductstorage(id) {
  return request({
    url: '/produce/productstorage/' + id,
    method: 'delete'
  })
}
