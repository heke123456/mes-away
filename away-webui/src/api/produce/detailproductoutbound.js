import request from '@/utils/request'

// 查询产品出库详单列表
export function listDetailproductoutbound(query) {
  return request({
    url: '/produce/detailproductoutbound/list',
    method: 'get',
    params: query
  })
}

// 查询产品出库详单详细
export function getDetailproductoutbound(id) {
  return request({
    url: '/produce/detailproductoutbound/' + id,
    method: 'get'
  })
}

// 新增产品出库详单
export function addDetailproductoutbound(data) {
  return request({
    url: '/produce/detailproductoutbound',
    method: 'post',
    data: data
  })
}

// 修改产品出库详单
export function updateDetailproductoutbound(data) {
  return request({
    url: '/produce/detailproductoutbound',
    method: 'put',
    data: data
  })
}

// 删除产品出库详单
export function delDetailproductoutbound(id) {
  return request({
    url: '/produce/detailproductoutbound/' + id,
    method: 'delete'
  })
}
