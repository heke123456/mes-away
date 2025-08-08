import request from '@/utils/request'

// 查询订单附加信息列表
export function listAdditional(query) {
  return request({
    url: '/order/additional/list',
    method: 'get',
    params: query
  })
}

// 查询订单附加信息详细
export function getAdditional(id) {
  return request({
    url: '/order/additional/' + id,
    method: 'get'
  })
}

// 新增订单附加信息
export function addAdditional(data) {
  return request({
    url: '/order/additional',
    method: 'post',
    data: data
  })
}

// 修改订单附加信息
export function updateAdditional(data) {
  return request({
    url: '/order/additional',
    method: 'put',
    data: data
  })
}

// 删除订单附加信息
export function delAdditional(id) {
  return request({
    url: '/order/additional/' + id,
    method: 'delete'
  })
}
