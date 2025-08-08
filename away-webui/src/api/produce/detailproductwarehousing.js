import request from '@/utils/request'

// 查询产品入库详单列表
export function listDetailproductwarehousing(query) {
  return request({
    url: '/produce/detailproductwarehousing/list',
    method: 'get',
    params: query
  })
}

// 查询产品入库详单详细
export function getDetailproductwarehousing(id) {
  return request({
    url: '/produce/detailproductwarehousing/' + id,
    method: 'get'
  })
}

// 新增产品入库详单
export function addDetailproductwarehousing(data) {
  return request({
    url: '/produce/detailproductwarehousing',
    method: 'post',
    data: data
  })
}

// 修改产品入库详单
export function updateDetailproductwarehousing(data) {
  return request({
    url: '/produce/detailproductwarehousing',
    method: 'put',
    data: data
  })
}

// 删除产品入库详单
export function delDetailproductwarehousing(id) {
  return request({
    url: '/produce/detailproductwarehousing/' + id,
    method: 'delete'
  })
}
