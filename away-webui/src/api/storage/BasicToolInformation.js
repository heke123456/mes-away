import request from '@/utils/request'

// 查询BasicToolInformation列表
export function listBasicToolInformation(query) {
  return request({
    url: '/storage/BasicToolInformation/list',
    method: 'get',
    params: query
  })
}

// 查询BasicToolInformation详细
export function getBasicToolInformation(id) {
  return request({
    url: '/storage/BasicToolInformation/' + id,
    method: 'get'
  })
}

// 新增BasicToolInformation
export function addBasicToolInformation(data) {
  return request({
    url: '/storage/BasicToolInformation',
    method: 'post',
    data: data
  })
}

// 修改BasicToolInformation
export function updateBasicToolInformation(data) {
  return request({
    url: '/storage/BasicToolInformation',
    method: 'put',
    data: data
  })
}

// 删除BasicToolInformation
export function delBasicToolInformation(id) {
  return request({
    url: '/storage/BasicToolInformation/' + id,
    method: 'delete'
  })
}
