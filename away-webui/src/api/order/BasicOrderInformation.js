import request from '@/utils/request'

// 查询VIEW列表
export function listBasicOrderInformation(query) {
  return request({
    url: '/order/BasicOrderInformation/list',
    method: 'get',
    params: query
  })
}

// 查询VIEW详细
export function getBasicOrderInformation(id) {
  return request({
    url: '/order/BasicOrderInformation/' + id,
    method: 'get'
  })
}

// 新增VIEW
export function addBasicOrderInformation(data) {
  return request({
    url: '/order/BasicOrderInformation',
    method: 'post',
    data: data
  })
}

// 修改VIEW
export function updateBasicOrderInformation(data) {
  return request({
    url: '/order/BasicOrderInformation',
    method: 'put',
    data: data
  })
}

// 删除VIEW
export function delBasicOrderInformation(id) {
  return request({
    url: '/order/BasicOrderInformation/' + id,
    method: 'delete'
  })
}
