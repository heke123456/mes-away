import request from '@/utils/request'

// 查询工时统计列表
export function listOrderhoursdetailed(query) {
  return request({
    url: '/produce/orderhoursdetailed/list',
    method: 'get',
    params: query
  })
}

// 查询工时统计详细
export function getOrderhoursdetailed(id) {
  return request({
    url: '/produce/orderhoursdetailed/' + id,
    method: 'get'
  })
}

// 新增工时统计
export function addOrderhoursdetailed(data) {
  return request({
    url: '/produce/orderhoursdetailed',
    method: 'post',
    data: data
  })
}

// 修改工时统计
export function updateOrderhoursdetailed(data) {
  return request({
    url: '/produce/orderhoursdetailed',
    method: 'put',
    data: data
  })
}

// 删除工时统计
export function delOrderhoursdetailed(id) {
  return request({
    url: '/produce/orderhoursdetailed/' + id,
    method: 'delete'
  })
}
