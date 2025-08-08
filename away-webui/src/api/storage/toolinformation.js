import request from '@/utils/request'

// 查询刀具信息列表
export function listToolinformation(query) {
  return request({
    url: '/storage/toolinformation/enlist',
    method: 'get',
    params: query
  })
}

// 查询刀具信息详细
export function getToolinformation(id) {
  return request({
    url: '/storage/toolinformation/' + id,
    method: 'get'
  })
}

// 新增刀具信息
export function addToolinformation(data) {
  return request({
    url: '/storage/toolinformation',
    method: 'post',
    data: data
  })
}

// 修改刀具信息
export function updateToolinformation(data) {
  return request({
    url: '/storage/toolinformation',
    method: 'put',
    data: data
  })
}

// 删除刀具信息
export function delToolinformation(id) {
  return request({
    url: '/storage/toolinformation/' + id,
    method: 'delete'
  })
}
