import request from '@/utils/request'

// 查询刀具入库列表
export function listToolStorage(query) {
  return request({
    url: '/storage/toolStorage/list',
    method: 'get',
    params: query
  })
}

// 查询刀具入库详细
export function getToolStorage(id) {
  return request({
    url: '/storage/toolStorage/' + id,
    method: 'get'
  })
}

// 新增刀具入库
export function addToolStorage(data) {
  return request({
    url: '/storage/toolStorage',
    method: 'post',
    data: data
  })
}

// 修改刀具入库
export function updateToolStorage(data) {
  return request({
    url: '/storage/toolStorage',
    method: 'put',
    data: data
  })
}

// 删除刀具入库
export function delToolStorage(id) {
  return request({
    url: '/storage/toolStorage/' + id,
    method: 'delete'
  })
}
