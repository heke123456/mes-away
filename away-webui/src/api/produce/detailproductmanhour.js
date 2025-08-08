import request from '@/utils/request'

// 查询工时统计详细列表
export function listDetailproductmanhour(query) {
  return request({
    url: '/produce/detailproductmanhour/list',
    method: 'get',
    params: query
  })
}

// 查询工时统计详细详细
export function getDetailproductmanhour(id) {
  return request({
    url: '/produce/detailproductmanhour/' + id,
    method: 'get'
  })
}

// 新增工时统计详细
export function addDetailproductmanhour(data) {
  return request({
    url: '/produce/detailproductmanhour',
    method: 'post',
    data: data
  })
}

// 修改工时统计详细
export function updateDetailproductmanhour(data) {
  return request({
    url: '/produce/detailproductmanhour',
    method: 'put',
    data: data
  })
}

// 删除工时统计详细
export function delDetailproductmanhour(id) {
  return request({
    url: '/produce/detailproductmanhour/' + id,
    method: 'delete'
  })
}
